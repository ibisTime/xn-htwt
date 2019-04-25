package com.cdkj.loan.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.ICreditUserExtBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.exception.BizException;

//CHECK ��鲢��ע�� 
@Service
public class CarInfoAOImpl implements ICarInfoAO {

    @Autowired
    private ICarInfoBO carInfoBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private ICreditJourBO creditJourBO;

    @Autowired
    private ICreditUserExtBO creditUserExtBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Override
    public int editCarInfo(XN632120Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A3.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A3x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该业务不处于录入准入单状态，无法录入");
        }
        // 车辆信息录入
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        String carInfoCode = carInfo.getCode();
        EntityUtils.copyData(req, carInfo);
        carInfo.setCode(carInfoCode);
        carInfoBO.refreshCarInfo(carInfo);
        // 征信人信息录入
        CreditUserExt creditUserExt = EntityUtils.copyData(req,
            CreditUserExt.class);

        creditUserExtBO.saveCreditUserExt(creditUserExt, cdbiz.getCode());
        // 流水录入
        creditJourBO.saveCreditJour(req);

        // 附件录入
        carInfoBO.saveAttachment(req);

        String preNodeCode = cdbiz.getCurNodeCode(); // 当前节点

        if (EDealType.SEND.getCode().equals(req.getDealType())) {
            // 日志记录
            sysBizLogBO.recordCurOperate(req.getCode(),
                EBizLogType.BUDGET_ORDER, req.getCode(), preNodeCode, null,
                req.getOperator());
            // 下一个节点
            preNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
                .getNextNode();

            cdbizBO.refershCurNodeCode(cdbiz, preNodeCode);
            // 业务状态变化
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A4.getCode());
            // 处理待办事项
            bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
                req.getCode(), ENode.getMap().get(preNodeCode));
        }
        ENode node = ENode.getMap().get(preNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.BUDGET_ORDER,
            req.getCode(), node, null);
        return 0;
    }

    @Override
    public void areaApprove(String code, String approveResult,
            String approveNote, String operator) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        if (!ECdbizStatus.A4.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是区域经理审核节点，不能操作");
        }

        String preCurrentNode = cdbiz.getCurNodeCode();// 当前节点
        // 日志记录
        sysBizLogBO.recordCurOperate(cdbiz.getBizCode(),
            EBizLogType.BUDGET_ORDER, code, preCurrentNode, approveNote,
            operator);
        //
        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
            cdbiz.getCode(), ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();

            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
        } else {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
        }
        ENode node = ENode.getMap().get(preCurrentNode);

        cdbizBO.refershCurNodeCode(cdbiz, preCurrentNode);

        // 状态更新
        cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A5.getCode());

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Override
    public void internalApprove(String code, String approveResult,
            String approveNote, String operator) {
        // TODO Auto-generated method stub

    }

    @Override
    public void riskOneApprove(String code, String approveResult,
            String approveNote, String operator) {
        // TODO Auto-generated method stub

    }

    @Override
    public void riskTwoApprove(String code, String carPriceCheckReport,
            String housePicture, String approveResult, String approveNote,
            String operator) {
        // TODO Auto-generated method stub

    }

    @Override
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        // TODO Auto-generated method stub

    }

    @Override
    public void yBizChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        // TODO Auto-generated method stub

    }

}
