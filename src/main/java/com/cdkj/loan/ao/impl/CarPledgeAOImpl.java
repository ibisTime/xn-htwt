package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICarPledgeAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.req.XN632144Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pledgeApply(XN632144Req req) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());

        if (!ENode.confirm_pledge_apply.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是抵押申请节点，不能操作");
        }

        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(cdbiz.getCurNodeCode()).getNextNode();

        // 添加车辆抵押信息
        String carPledgeCode = carPledgeBO.saveCarPledge(req.getCode(),
                req.getSupplementNote());

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.Pledge, carPledgeCode,
                ENode.matchCode(nextNodeCode), req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.bank_push,
                carPledgeCode, nextNodeCode, req.getSupplementNote(),
                req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saleManConfirm(XN632124Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());

        if (!ENode.confirm_pledge_apply.getCode()
                .equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是业务员确认抵押申请节点，不能操作");
        }

        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(req.getCode());
        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(carPledge.getCurNodeCode()).getNextNode();

        // 业务员确认抵押
        carPledgeBO.saleManConfirm(carPledge.getCode(), nextNodeCode, req);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.Pledge,
                carPledge.getCode(), ENode.matchCode(nextNodeCode),
                req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.bank_push,
                carPledge.getCode(), nextNodeCode, req.getApproveNote(),
                req.getOperator());

        // 生成资料传递
        String logisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.FK_SEND_CAR_PLEDGE.getCode(), cdbiz.getCode(),
                cdbiz.getSaleUserId(), ENode.submit_3.getCode(),
                ENode.receive_approve_3.getCode(), null);

        // 资料传递待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.ZHDY_LOGISTICS,
                logisticsCode, ENode.matchCode(nextNodeCode), req.getOperator());

        // 资料传递操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.ZHDY_LOGISTICS,
                logisticsCode, nextNodeCode, req.getApproveNote(),
                req.getOperator());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void entryPledgeInfo(XN632133Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());

        if (!ENode.input_dy_info.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是业务员录入抵押信息节点，不能操作");
        }

        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(req.getCode());
        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(carPledge.getCurNodeCode()).getNextNode();

        // 录入抵押信息
        carPledgeBO.entryPledgeInfo(carPledge.getCode(), nextNodeCode, req);

        // 添加附件
        attachmentBO.saveAttachment(cdbiz.getCode(), req);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.Pledge,
                carPledge.getCode(), ENode.matchCode(nextNodeCode),
                req.getOperator());

        // 操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.bank_push,
                carPledge.getCode(), nextNodeCode, null, req.getOperator());

        // 生成资料传递
        String logisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.SALE_SEND_CAR_PLEDGE.getCode(),
                cdbiz.getCode(), cdbiz.getSaleUserId(), ENode.submit_4.getCode(),
                ENode.receive_approve_4.getCode(), null);

        // 资料传递待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.ZHDY_LOGISTICS,
                logisticsCode, ENode.matchCode(nextNodeCode), req.getOperator());

        // 资料传递操作日志
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.ZHDY_LOGISTICS,
                logisticsCode, nextNodeCode, null, req.getOperator());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pledgeCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        if (!ENode.to_commit_bank.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是抵押提交节点，不能操作");
        }

        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(code);
        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(carPledge.getCurNodeCode()).getNextNode();

        // 抵押提交银行
        carPledgeBO.pledgeCommitBank(code, nextNodeCode, operator,
                pledgeBankCommitDatetime, pledgeBankCommitNote);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.Pledge, carPledge.getCode(),
                ENode.matchCode(nextNodeCode), operator);

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.bank_push,
                carPledge.getCode(), nextNodeCode, null, operator);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmDone(String code, String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        if (!ENode.dy_info_confirm_submit.getCode()
                .equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是抵押提交节点，不能操作");
        }
        if (!ECdbizStatus.E3.getCode().equals(cdbiz.getSeccundangStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "第二次存档未完成，不能操作");
        }

        CarPledge carPledge = carPledgeBO.getCarPledgeByBizCode(code);
        String nextNodeCode = nodeFlowBO
                .getNodeFlowByCurrentNode(carPledge.getCurNodeCode()).getNextNode();

        // 抵押确认完成
        carPledgeBO.confirmDone(code, nextNodeCode, operator);

        // 更新业务状态
        cdbizBO.refreshCurNodeCode(cdbiz, nextNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.Pledge, carPledge.getCode(),
                ENode.matchCode(nextNodeCode), operator);

        // 操作日志
        sysBizLogBO.recordCurOperate(code, EBizLogType.bank_push,
                carPledge.getCode(), nextNodeCode, null, operator);

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
