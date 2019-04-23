package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICarPledgeAO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632144Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;

@Service
public class CarPledgeAOImpl implements ICarPledgeAO {

    @Autowired
    private ICarPledgeBO carPledgeBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    @Transactional
    public void pledgeApply(XN632144Req req) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());

        if (!ENode.bank_receipt.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前不是抵押申请节点，不能操作");
        }

        String nextNodeCode = nodeFlowBO
            .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getNextNode();

        // 添加车辆抵押信息
        String carPledgeCode = carPledgeBO.saveCarPledge(req.getCode(),
            req.getSupplementNote());

        // 更新业务状态
        cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.Pledge, carPledgeCode,
            ENode.matchCode(nextNodeCode), req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.bank_push,
            carPledgeCode, nextNodeCode, req.getSupplementNote(),
            req.getOperator());
    }

    @Override
    public void saleManConfirm(XN632124Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());

        if (!ENode.confirm_pledge_apply.getCode()
            .equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前不是业务员确认抵押申请节点，不能操作");
        }

        CarPledge carPledge = carPledgeBO.getCarPledge(req.getCode());
        String nextNodeCode = nodeFlowBO
            .getNodeFlowByCurrentNode(carPledge.getCurNodeCode()).getNextNode();

        // 业务员确认抵押
        carPledgeBO.saleManConfirm(nextNodeCode, req);

        // 更新业务状态
        cdbizBO.refershCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.Pledge,
            carPledge.getCode(), ENode.matchCode(nextNodeCode),
            req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.bank_push,
            carPledge.getCode(), nextNodeCode, req.getApproveNote(),
            req.getOperator());
    }

    @Override
    public Paginable<CarPledge> queryCarPledgePage(int start, int limit,
            CarPledge condition) {
        return carPledgeBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CarPledge> queryCarPledgeList(CarPledge condition) {
        return carPledgeBO.queryCarPledgeList(condition);
    }

    @Override
    public CarPledge getCarPledge(String code) {
        return carPledgeBO.getCarPledge(code);
    }

}
