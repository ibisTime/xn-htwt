package com.cdkj.loan.ao.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.ICreditUserExtBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632143Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
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

    @Autowired
    private IRepayBizBO repayBizBO;

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

        // 贷款信息
        repayBizBO.saveRepayBiz(req);

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

    @Transactional
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
        // 处理前待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
            cdbiz.getCode(), ENode.getMap().get(preCurrentNode));

        String status = cdbiz.getStatus();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            status = ECdbizStatus.A5.getCode();
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
        } else {
            status = ECdbizStatus.A3x.getCode();
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
        }
        ENode node = ENode.getMap().get(preCurrentNode);

        cdbizBO.refershCurNodeCode(cdbiz, preCurrentNode);

        // 状态更新
        cdbizBO.refreshStatus(cdbiz, status);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Override
    public void internalApprove(String code, String approveResult,
            String approveNote, String operator) {
        // TODO Auto-generated method stub

    }

    @Transactional
    @Override
    public void riskOneApprove(String code, String approveResult,
            String approveNote, String operator) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        if (!ECdbizStatus.A5.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "该业务当前状态不是风控一审状态，不能操作");
        }

        String preCurrentNode = cdbiz.getCurNodeCode();// 当前节点
        String status = cdbiz.getStatus();
        // 日志记录
        sysBizLogBO.recordCurOperate(code, EBizLogType.BUDGET_ORDER, code,
            preCurrentNode, approveNote, operator);
        // 完成待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(), code,
            ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A6.getCode();
        } else {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        cdbizBO.refershCurNodeCode(cdbiz, preCurrentNode);

        // 业务更新状态
        cdbizBO.refreshStatus(cdbiz, status);

        ENode node = ENode.getMap().get(preCurrentNode);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Transactional
    @Override
    public void riskTwoApprove(String code, String carPriceCheckReport,
            String housePicture, String approveResult, String approveNote,
            String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        if (!ECdbizStatus.A6.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控二审节点，不能操作");
        }

        String preCurrentNode = cdbiz.getCurNodeCode();// 当前节点
        String status = cdbiz.getStatus();
        // 日志记录
        sysBizLogBO.recordCurOperate(code, EBizLogType.BUDGET_ORDER, code,
            preCurrentNode, approveNote, operator);
        // 完成待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(), code,
            ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A7.getCode();
        } else {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        // 节点改变
        cdbizBO.refershCurNodeCode(cdbiz, preCurrentNode);

        if (StringUtils.isNotBlank(carPriceCheckReport)) {
            EAttachName attachName = EAttachName.car_check_reprot;
            attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), carPriceCheckReport);
        }
        if (StringUtils.isNotBlank(housePicture)) {
            EAttachName attachName = EAttachName.house_pic;
            attachmentBO.saveAttachment(cdbiz.getCode(), attachName.getCode(),
                attachName.getValue(), housePicture);
        }

        // 业务更新状态
        cdbizBO.refreshStatus(cdbiz, status);

        ENode node = ENode.getMap().get(preCurrentNode);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Transactional
    @Override
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        if (!ECdbizStatus.A7.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是风控终审节点，不能操作");
        }

        String preCurrentNode = cdbiz.getCurNodeCode();// 当前节点
        String status = cdbiz.getStatus();
        // 日志记录
        sysBizLogBO.recordCurOperate(code, EBizLogType.BUDGET_ORDER, code,
            preCurrentNode, approveNote, operator);
        // 完成待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(), code,
            ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A8.getCode();
        } else {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        cdbizBO.refershCurNodeCode(cdbiz, preCurrentNode);

        // 业务更新状态
        cdbizBO.refreshStatus(cdbiz, status, approveNote);

        ENode node = ENode.getMap().get(preCurrentNode);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Transactional
    @Override
    public void yBizChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ECdbizStatus.A8.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是业务总监审核节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status = cdbiz.getStatus();

        // 日志记录
        sysBizLogBO.recordCurOperate(code, EBizLogType.BUDGET_ORDER, code,
            preCurrentNode, approveNote, operator);
        // 完成待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(), code,
            ENode.getMap().get(preCurrentNode));

        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A9.getCode();

        } else {
            preCurrentNode = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        cdbizBO.refershCurNodeCode(cdbiz, preCurrentNode);
        cdbizBO.refreshStatus(cdbiz, status, approveNote);

        ENode node = ENode.getMap().get(preCurrentNode);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Override
    @Transactional
    public void financeAudit(XN632143Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        // 之前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status = cdbiz.getStatus();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        if (!ECdbizStatus.A9.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前节点不是财务审核节点，不能操作");
        }
        if (!ECdbizStatus.B03.getCode().equals(cdbiz.getMqStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "面签流程未走完，不能操作");
        }
        // 日志记录
        sysBizLogBO.recordCurOperate(req.getCode(), EBizLogType.BUDGET_ORDER,
            req.getCode(), preCurrentNode, req.getApproveNote(),
            req.getOperator());
        // 完成待办事项
        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
            req.getCode(), ENode.getMap().get(preCurrentNode));

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 主状态
            status = ECdbizStatus.A10.getCode();
            // 发保合gps状态
            String fbhgpsStatus = ECdbizStatus.C00.getCode();
            // 发保合节点
            ENode node = ENode.sure_dz;
            // 是否垫资
            if (EBoolean.NO.getCode().equals(cdbiz.getIsAdvanceFund())) {
                fbhgpsStatus = ECdbizStatus.C01.getCode();
                node = ENode.input_fbh;
            }
            // 待办事项
            bizTaskBO.saveBizTask(req.getCode(), EBizLogType.fbh,
                req.getCode(), node, null);
            // 发保合状态更新
            cdbizBO.refreshFbhgpsStatus(cdbiz, fbhgpsStatus);

            // 主节点
            preCurrentNode = ENode.submit_1.getCode();
            // 生成报告、返点、费用
            // lastApprove(budgetOrder, req.getOperator());
        } else {
            preCurrentNode = nodeFlow.getBackNode();
            status = ECdbizStatus.A3x.getCode();
            // 待办事项
            bizTaskBO.saveBizTask(req.getCode(), EBizLogType.BUDGET_ORDER,
                req.getCode(), ENode.getMap().get(preCurrentNode), null);
        }
        cdbizBO.refershCurNodeCode(cdbiz, preCurrentNode);

        cdbizBO.refreshStatus(cdbiz, status, req.getApproveNote());

    }

}
