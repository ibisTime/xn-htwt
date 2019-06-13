package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.bo.IAccountBO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.IBudgetOrderGpsBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.IInvestigateReportBO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSDictBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.BudgetOrderGps;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSDict;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.domain.User;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632125Req;
import com.cdkj.loan.dto.req.XN632126ReqGps;
import com.cdkj.loan.dto.req.XN632128Req;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.req.XN632131Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.req.XN632135Req;
import com.cdkj.loan.dto.req.XN632141Req;
import com.cdkj.loan.dto.req.XN632143Req;
import com.cdkj.loan.dto.req.XN632144Req;
import com.cdkj.loan.dto.req.XN632149Req;
import com.cdkj.loan.dto.req.XN632180Req;
import com.cdkj.loan.dto.req.XN632190Req;
import com.cdkj.loan.dto.req.XN632191Req;
import com.cdkj.loan.dto.req.XN632192Req;
import com.cdkj.loan.dto.req.XN632913Req;
import com.cdkj.loan.dto.req.XN632914Req;
import com.cdkj.loan.enums.EAccountType;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBackAdvanceNode;
import com.cdkj.loan.enums.EBackAdvanceStatus;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EBudgetFrozenStatus;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.ECurrency;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.EInvestigateReportNode;
import com.cdkj.loan.enums.EIsAdvanceFund;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsStatus;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENewBizType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.enums.ERepointStatus;
import com.cdkj.loan.enums.ESysRole;
import com.cdkj.loan.enums.EUserKind;
import com.cdkj.loan.exception.BizException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BudgetOrderAOImpl implements IBudgetOrderAO {

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBudgetOrderGpsBO budgetOrderGpsBO;

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Autowired
    private ILoanProductBO loanProductBO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IAccountBO accountBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private ICreditUserBO creditUserBO;

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private IInvestigateReportBO investigateReportBO;

    @Autowired
    private ISYSDictBO sysDictBO;

    @Autowired
    private ICdbizBO cdbizBO;

    @Autowired
    private IBizTaskBO bizTaskBO;

    @Autowired
    private IAttachmentBO attachmentBO;

    @Autowired
    private ICreditAO creditAO;

    @Override
    @Transactional
    public void editBudgetOrder(XN632120Req req) {
        BudgetOrder data = budgetOrderBO.getBudgetOrder(req.getCode());
        Cdbiz cdbiz = cdbizBO.getCdbiz(data.getBizCode());
        if (!ECdbizStatus.A3.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A3x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务不处于录入准入单状态，无法录入");
        }
        budgetOrderBO.refreshBudgetOrder(data, req);
        Credit credit = creditBO.getCreditByBizCode(data.getBizCode());
        if (credit != null) {
            if (ENewBizType.second_hand.getCode().equals(req.getBizType())) {
                if (req.getSecondCarReport() == null) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                            "征信二手车评估报告未上传");
                } else {
                    // 修改附件
                    EAttachName attachName = EAttachName.second_car_report;
                    attachmentBO.saveAttachment(data.getBizCode(),
                            attachName.getCode(), attachName.getValue(),
                            req.getSecondCarReport());

                }
            }
        }

        String preNodeCode = data.getCurNodeCode(); // 当前节点

        if (EDealType.SEND.getCode().equals(req.getDealType())) {
            // 日志记录
            sysBizLogBO.recordCurOperate(data.getBizCode(),
                    EBizLogType.BUDGET_ORDER, data.getCode(), preNodeCode, null,
                    req.getOperator());
            // 下一个节点
            preNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
                    .getNextNode();
            // 业务状态变化
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A4.getCode());
            // 处理待办事项
//            bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
//                    data.getCode(), ENode.getMap().get(preNodeCode));
        }
        ENode node = ENode.getMap().get(preNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(data.getBizCode(), EBizLogType.BUDGET_ORDER,
                data.getCode(), node, null);

    }

    @Override
    @Transactional
    public void areaApprove(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());

        if (!ECdbizStatus.A4.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是区域经理审核节点，不能操作");
        }

        String preCurrentNode = budgetOrder.getCurNodeCode();// 当前节点
        // 日志记录
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, preCurrentNode, approveNote,
                operator);
        //
//        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();

            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                    preCurrentNode).getNextNode());
        } else {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                    preCurrentNode).getBackNode());
        }
        ENode node = ENode.getMap().get(preCurrentNode);

        budgetOrder.setCurNodeCode(preCurrentNode);
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshAreaApprove(budgetOrder);

        // 状态更新
        cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A5.getCode());

        // 待办事项
        bizTaskBO.saveBizTask(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, node, null);
    }

    @Override
    @Transactional
    public void internalApprove(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!EBudgetOrderNode.INTERNAL_APPROVE.getCode().equals(
                budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是内勤主管审核节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                    preCurrentNode).getNextNode());
        } else {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                    preCurrentNode).getBackNode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshAreaApprove(budgetOrder);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getCurNodeCode(), approveNote, operator);
    }

    @Override
    @Transactional
    public void riskOneApprove(String code, String approveResult,
            String approveNote, String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);

        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());

        if (!ECdbizStatus.A5.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务当前状态不是风控一审状态，不能操作");
        }

        String preCurrentNode = budgetOrder.getCurNodeCode();// 当前节点
        String status = cdbiz.getStatus();
        // 日志记录
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, preCurrentNode, approveNote,
                operator);
        // 完成待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A6.getCode();
        } else {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        budgetOrder.setCurNodeCode(preCurrentNode);
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshriskApprove(budgetOrder);

        // 业务更新状态
        cdbizBO.refreshStatus(cdbiz, status);

        ENode node = ENode.getMap().get(preCurrentNode);

        // 待办事项
        bizTaskBO.saveBizTask(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Override
    @Transactional
    public void riskTwoApprove(String code, String carPriceCheckReport,
            String housePicture, String approveResult, String approveNote,
            String operator) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());

        if (!ECdbizStatus.A6.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是风控二审节点，不能操作");
        }

        String preCurrentNode = budgetOrder.getCurNodeCode();// 当前节点
        String status = cdbiz.getStatus();
        // 日志记录
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, preCurrentNode, approveNote,
                operator);
        // 完成待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A7.getCode();
        } else {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        budgetOrder.setCurNodeCode(preCurrentNode);
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshriskApprove(budgetOrder);

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
        bizTaskBO.saveBizTask(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, node, null);
    }

    @Override
    @Transactional
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());

        if (!ECdbizStatus.A7.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是风控终审节点，不能操作");
        }

        String preCurrentNode = budgetOrder.getCurNodeCode();// 当前节点
        String status = cdbiz.getStatus();
        // 日志记录
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, preCurrentNode, approveNote,
                operator);
        // 完成待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A8.getCode();
        } else {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        budgetOrder.setCurNodeCode(preCurrentNode);
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshriskApprove(budgetOrder);

        // 业务更新状态
        cdbizBO.refreshStatus(cdbiz, status);

        ENode node = ENode.getMap().get(preCurrentNode);

        // 待办事项
        bizTaskBO.saveBizTask(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, node, null);
    }

    @Override
    @Transactional
    public void yBizChargeApprove(String code, String operator,
            String approveResult, String approveNote) {

        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());
        if (!ECdbizStatus.A8.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是业务总监审核节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        String status = cdbiz.getStatus();

        // 日志记录
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, preCurrentNode, approveNote,
                operator);
        // 完成待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));

        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getNextNode();
            status = ECdbizStatus.A9.getCode();

        } else {
            preCurrentNode = nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getBackNode();
            status = ECdbizStatus.A3x.getCode();
        }
        budgetOrder.setCurNodeCode(preCurrentNode);
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshbizChargeApprove(budgetOrder);

        cdbizBO.refreshStatus(cdbiz, status);

        ENode node = ENode.getMap().get(preCurrentNode);

        // 待办事项
        bizTaskBO.saveBizTask(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, node, null);
    }

    @Override
    @Transactional
    public void interview(XN632123Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());

        String preCurrentNode = budgetOrder.getIntevCurNodeCode();
        if (!ENode.input_interview.getCode().equals(preCurrentNode)
                && !ENode.reinput_interview.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是新录/重录面签节点，不能操作");
        }

        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);

        if (EBoolean.YES.getCode().equals(req.getIsSend())) {
            budgetOrder.setIntevCurNodeCode(nodeFlow.getNextNode());
        }

        budgetOrderBO.interview(budgetOrder, req);

        // 更新业务面签状态
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());
        cdbizBO.refreshMqStatus(cdbiz, ECdbizStatus.B01.getCode());

        // 操作日志
        ENode node = ENode.getMap().get(preCurrentNode);
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.INTERVIEW, budgetOrder.getCode(), node.getCode(),
                node.getValue(), req.getOperator());

        // 添加待办事项
        bizTaskBO.saveBizTask(budgetOrder.getBizCode(), EBizLogType.INTERVIEW,
                budgetOrder.getCode(), ENode.approve_interview, req.getOperator());
        // 处理之前的待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.INTERVIEW.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));
    }

    @Override
    @Transactional
    public void residentMortgageApply(XN632144Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 当前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (!EBudgetOrderNode.RESIDENT_MORTGAGE_APPLY.getCode().equals(
                preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是驻行抵押申请节点，不能操作");
        }
        budgetOrder.setSupplementNote(req.getSupplementNote());
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        budgetOrderBO.residentMortgageApply(budgetOrder);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getCurNodeCode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void insidejobConfirm(XN632124Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 当前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (!EBudgetOrderNode.INSIDEJOB_CONFIRM.getCode()
                .equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是内勤确认节点，不能操作");
        }
        budgetOrder.setPledgeUser(req.getPledgeUser());
//        budgetOrder.setPledgeUserIdCardCopy(req.getPledgeUserIdCardCopy());
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        budgetOrder
                .setCurNodeCode(EBudgetOrderNode.INSIDEJOB_RECEIVE.getCode());
        budgetOrderBO.insidejobConfirm(budgetOrder);

        // 生成资料传递
        String logisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.CAR_MORTGAGE.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                EBudgetOrderNode.RESIDENT_SEND_MORTGAGE.getCode(),
                EBudgetOrderNode.INSIDEJOB_RECEIVE.getCode(), null);
        // 产生物流单后改变状态为物流传递中
        // budgetOrder.setIsLogistics(EBoolean.YES.getCode());
        // budgetOrderBO.updateIsLogistics(budgetOrder);

        // 资料传递日志
        sysBizLogBO.saveSYSBizLog(req.getCode(), EBizLogType.LOGISTICS,
                logisticsCode, EBudgetOrderNode.INSIDEJOB_RECEIVE.getCode());

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                nodeFlow.getNextNode(), null, req.getOperator());
    }

    // @Override
    // @Transactional
    // public void bizChargeApprove(String code, String operator,
    // String approveResult, String approveNote) {
    // BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
    // if (!EBudgetOrderNode.BIZ_CHARGE_APPROVE.getCode()
    // .equals(budgetOrder.getCurNodeCode())) {
    // throw new BizException(EBizErrorCode.DEFAULT.getCode(),
    // "当前节点不是业务总监审核节点，不能操作");
    // }
    // // 之前节点
    // String preCurrentNode = budgetOrder.getCurNodeCode();
    // if (EApproveResult.PASS.getCode().equals(approveResult)) {
    // if (EBoolean.NO.getCode().equals(budgetOrder.getIsAdvanceFund())) {//
    // 不垫资，直接跳到gps
    // budgetOrder.setCurNodeCode(EBudgetOrderNode.GPSAZ.getCode());
    // } else {
    // budgetOrder.setCurNodeCode(nodeFlowBO
    // .getNodeFlowByCurrentNode(preCurrentNode).getNextNode());
    // }
    // } else {
    // budgetOrder.setCurNodeCode(nodeFlowBO
    // .getNodeFlowByCurrentNode(preCurrentNode).getBackNode());
    // }
    //
    // budgetOrder.setRemark(approveNote);
    // budgetOrderBO.refreshbizChargeApprove(budgetOrder);
    //
    // // 日志记录
    // sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
    // EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
    // budgetOrder.getCurNodeCode(), approveNote, operator,
    // budgetOrder.getTeamCode());
    // }

    @Override
    @Transactional
    public void interviewInternalApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        if (!ENode.approve_interview.getCode().equals(
                budgetOrder.getIntevCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是内勤主管审核节点，不能操作");
        }

        String preCurrentNode = budgetOrder.getIntevCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);

        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setIntevCurNodeCode(nodeFlow.getNextNode());
            // 生成资料传递
            String logisticsCode = logisticsBO.saveLogistics(
                    ELogisticsType.BUDGET.getCode(),
                    ELogisticsCurNodeType.BANK_LOAN.getCode(),
                    budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                    preCurrentNode, nodeFlow.getNextNode(), null);
            // 产生物流单后改变状态为物流传递中
            // budgetOrder.setIsLogistics(EBoolean.YES.getCode());
            // budgetOrderBO.updateIsLogistics(budgetOrder);

            // 资料传递日志
            sysBizLogBO.saveSYSBizLog(code, EBizLogType.LOGISTICS,
                    logisticsCode, budgetOrder.getIntevCurNodeCode());
            budgetOrder.setIsInterview(EBoolean.YES.getCode());

            // 更新面签业务状态
            Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());
            cdbizBO.refreshMqStatus(cdbiz, ECdbizStatus.B03.getCode());

            // 如果主流程节点在中间节点，往后走一步
            // if (EBudgetOrderNode.BUDFINSH_INTEVUNDONE.getCode()
            // .equals(budgetOrder.getCurNodeCode())) {
            // budgetOrder
            // .setCurNodeCode(EBudgetOrderNode.FINANCEAUDIT.getCode());
            // budgetOrderBO.refreshBudgetOrderCurNode(budgetOrder);
            //
            // // 生成下一步日志
            // sysBizLogBO.saveSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
            // EBudgetOrderNode.FINANCEAUDIT.getCode());
            // }
        } else {
            budgetOrder.setIntevCurNodeCode(nodeFlow.getBackNode());

            // 更新面签业务状态
            Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());
            cdbizBO.refreshMqStatus(cdbiz, ECdbizStatus.B02.getCode());

            // 添加待办事项
            bizTaskBO.saveBizTask(budgetOrder.getBizCode(),
                    EBizLogType.INTERVIEW, budgetOrder.getCode(),
                    ENode.reinput_interview, operator);
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshInterviewInternal(budgetOrder);

        // 操作日志
        ENode node = ENode.getMap().get(preCurrentNode);
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.INTERVIEW, budgetOrder.getCode(), node.getCode(),
                node.getValue(), operator);
        // 处理前待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.INTERVIEW.getCode(),
//                budgetOrder.getCode(), node);

    }

    @Override
    @Transactional
    public void financeAudit(XN632143Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        String status = cdbiz.getStatus();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        if (!ECdbizStatus.A9.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是财务审核节点，不能操作");
        }
        if (!ECdbizStatus.B03.getCode().equals(cdbiz.getIntevStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "面签流程未走完，不能操作");
        }
        // 日志记录
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.BUDGET_ORDER, req.getCode(), preCurrentNode,
                req.getApproveNote(), req.getOperator());
        // 完成待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 主状态
            status = ECdbizStatus.A10.getCode();
            // 发保合gps状态
            String fbhgpsStatus = ECdbizStatus.C00.getCode();
            // 发保合节点
            ENode node = ENode.sure_dz;
            // 是否垫资
            if (EBoolean.NO.getCode().equals(budgetOrder.getIsAdvanceFund())) {
                fbhgpsStatus = ECdbizStatus.C01.getCode();
                node = ENode.input_fbh;
            }
            // 待办事项
            bizTaskBO.saveBizTask(budgetOrder.getBizCode(), EBizLogType.fbh,
                    budgetOrder.getCode(), node, null);
            // 发保合状态更新
            cdbizBO.refreshFbhgpsStatus(cdbiz, fbhgpsStatus);

            // 主节点
            preCurrentNode = ENode.submit_1.getCode();
            // 生成报告、返点、费用
            lastApprove(budgetOrder, req.getOperator());
        } else {
            preCurrentNode = nodeFlow.getBackNode();
            status = ECdbizStatus.A3x.getCode();
            // 待办事项
            bizTaskBO.saveBizTask(budgetOrder.getBizCode(),
                    EBizLogType.BUDGET_ORDER, req.getCode(),
                    ENode.getMap().get(preCurrentNode), null);
        }
        budgetOrder.setCurNodeCode(preCurrentNode);
        budgetOrder.setRemark(req.getApproveNote());
        budgetOrderBO.refreshAreaApprove(budgetOrder);

        cdbizBO.refreshStatus(cdbiz, status);

    }

    @Override
    @Transactional
    public void advanceFund(XN632125Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (ECdbizStatus.C00.getCode().equals(cdbiz.getFbhgpsStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是财务垫资，不能操作");
        }
        // 更新发保合gps状态
        String fbhgpsStatus = cdbiz.getFbhgpsStatus();
        cdbizBO.refreshFbhgpsStatus(cdbiz, fbhgpsStatus);
        // 更新垫资信息
        budgetOrderBO.advancefund(budgetOrder, DateUtil.strToDate(
                req.getAdvanceFundDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING),
                StringValidater.toLong(req.getAdvanceFundAmount()), req
                        .getBillPdf(), req.getAdvanceNote());

        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        // 主流程日志记录
        sysBizLogBO.recordCurOperate(budgetOrder.getBizCode(),
                EBizLogType.fund, budgetOrder.getCode(), nodeFlow.getNextNode(),
                req.getAdvanceNote(), req.getOperator());
        ENode node = ENode.getMap().get(nodeFlow.getNextNode());
        // 发保合待办事项
        bizTaskBO.saveBizTask(budgetOrder.getBizCode(), EBizLogType.fbh,
                budgetOrder.getCode(), node, req.getOperator());
        // 处理前待办事项
//        bizTaskBO.handlePreBizTask(EBizLogType.fund.getCode(),
//                budgetOrder.getCode(), ENode.getMap().get(preCurrentNode));
    }

    @Override
    @Transactional
    public void installGps(String code, String operator,
            List<XN632126ReqGps> gpsAzList) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        String preCurrentNode = budgetOrder.getAdvanfCurNodeCode();// 之前节点
        if (!EBudgetOrderNode.GPSAZ.getCode().equals(preCurrentNode)
                && !EBudgetOrderNode.AGAINGPSAZ.getCode()
                .equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前不是业务团队安装GPS节点，不能操作");
        }
        // 删除
        budgetOrderGpsBO.removeBudgetOrderGpsList(code);
        // 添加
        budgetOrderGpsBO.saveBudgetOrderGpsList(code, gpsAzList);

        // 下个节点设置
        budgetOrder.setAdvanfCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preCurrentNode).getNextNode());
        budgetOrder.setIsGpsAz(EBoolean.YES.getCode());
        budgetOrderBO.installGps(budgetOrder);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getAdvanfCurNodeCode(), null, operator);
    }

    @Override
    @Transactional
    public void gpsManagerApprove(String code, String operator,
            String approveResult, String approveNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        // 之前节点
        String preCurrentNode = budgetOrder.getAdvanfCurNodeCode();
        if (!EBudgetOrderNode.GPSMANAGERAPPROVE.getCode()
                .equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是GPS管理员审核节点，不能操作");
        }
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            budgetOrder.setAdvanfCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getNextNode());

        } else {
            budgetOrder.setAdvanfCurNodeCode(nodeFlowBO
                    .getNodeFlowByCurrentNode(preCurrentNode).getBackNode());
            List<BudgetOrderGps> list = budgetOrderGpsBO
                    .queryBudgetOrderGpsList(code);
            // gps使用状态改为未使用
            for (BudgetOrderGps budgetOrderGps : list) {
                gpsBO
                        .refreshUseGps(budgetOrderGps.getCode(), null, EBoolean.NO);
            }
            budgetOrderGpsBO.removeBudgetOrderGpsList(code);
            budgetOrder.setIsGpsAz(EBoolean.NO.getCode());
        }
        budgetOrder.setRemark(approveNote);
        budgetOrderBO.refreshGpsManagerApprove(budgetOrder);

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.BUDGET_ORDER.getCode(),
                budgetOrder.getCode(), preCurrentNode, approveNote, operator);
    }

    @Override
    @Transactional
    public void carSettle(XN632128Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (!EBudgetOrderNode.CARSETTLE.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是业务团队车辆落户节点，不能操作");
        }
        budgetOrder.setCarSettleDatetime(DateUtil.strToDate(
                req.getCarSettleDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setCarInvoice(req.getCarInvoice());
        budgetOrder.setCarJqx(req.getCarJqx());
        budgetOrder.setCarSyx(req.getCarSyx());
        budgetOrder.setPolicyDatetime(DateUtil.strToDate(
                req.getPolicyDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setPolicyDueDate(DateUtil.strToDate(req.getPolicyDueDate(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setCarSettleOtherPdf(req.getCarSettleOtherPdf());

        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());

        // 车辆信息落户
        budgetOrderBO.carSettle(budgetOrder);
        // 生成资料传递
        // String logisticsCode = logisticsBO.saveLogistics(
        // ELogisticsType.BUDGET.getCode(), budgetOrder.getCode(),
        // budgetOrder.getSaleUserId(), EBudgetOrderNode.CARSETTLE.getCode(),
        // nodeFlow.getNextNode(), null);
        // 产生物流单后改变状态为物流传递中
        // budgetOrder.setIsLogistics(EBoolean.YES.getCode());
        // budgetOrderBO.updateIsLogistics(budgetOrder);

        // 资料传递日志
        // sysBizLogBO.saveSYSBizLog(req.getCode(), EBizLogType.LOGISTICS,
        // logisticsCode, budgetOrder.getCurNodeCode(),
        // budgetOrder.getTeamCode());

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getCurNodeCode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void commitBank(String code, String operator,
            String bankCommitDatetime, String bankCommitNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        // 之前节点
        String preCurrentNode = budgetOrder.getIntevCurNodeCode();
        if (!EBudgetOrderNode.COMMITBANK.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是确认提交银行节点，不能操作");
        }
        if (EBudgetFrozenStatus.FROZEN.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前预算单已被冻结，不能操作");
        }

        budgetOrder.setIntevCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preCurrentNode).getNextNode());
        budgetOrder.setBankCommitDatetime(DateUtil.strToDate(
                bankCommitDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setRemark(bankCommitNote);
        budgetOrderBO.refreshCommitBank(budgetOrder);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getIntevCurNodeCode(), bankCommitNote, operator);
    }

    @Override
    @Transactional
    public void confirmLoan(XN632130Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getIntevCurNodeCode();
        if (!EBudgetOrderNode.CONFIRMLOAN.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是确认放款节点，不能操作");
        }
        budgetOrder.setReceiptBankCode(req.getReceiptBankCode());
        budgetOrder.setReceiptBankName(req.getReceiptBankName());
        budgetOrder.setReceiptBankcardNumber(req.getReceiptBankcardNumber());
        budgetOrder.setReceiptPdf(req.getReceiptPdf());
        budgetOrder.setReceiptRemark(req.getReceiptRemark());
        budgetOrder.setIntevCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preCurrentNode).getNextNode());
        budgetOrderBO.refreshConfirmReceipt(budgetOrder);

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.BUDGET_ORDER.getCode(),
                budgetOrder.getCode(), preCurrentNode, req.getReceiptRemark(),
                req.getOperator());

        // 银行已放款待财务退款 生成退客户垫资款数据
        if (EIsAdvanceFund.YES.getCode().equals(budgetOrder.getIsAdvanceFund())) {
            budgetOrder.setBackAdvanceStatus(EBackAdvanceStatus.NONEED_BACK
                    .getCode());
        }
        if (EIsAdvanceFund.NO.getCode().equals(budgetOrder.getIsAdvanceFund())) {
            budgetOrder.setBackAdvanceStatus(EBackAdvanceStatus.TODO_BACK
                    .getCode());
            // 日志记录
            sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                    EBizLogType.BACK_ADVANCE_FUND, budgetOrder.getCode(),
                    EBackAdvanceNode.FINANCE_REFUND.getCode());
        }
        budgetOrderBO.saveBackAdvanceFund(budgetOrder);
    }

    @Override
    @Transactional
    public void entryFk(XN632135Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getIntevCurNodeCode();
        if (!EBudgetOrderNode.ENTRYLOAN.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是录入放款信息节点，不能操作");
        }
        budgetOrder.setRepayBankcardNumber(req.getRepayBankcardNumber());
        budgetOrder.setRepayBillDate(StringValidater.toInteger(req
                .getRepayBillDate()));
        budgetOrder.setRepayBankDate(StringValidater.toInteger(req
                .getRepayBankDate()));
        budgetOrder.setRepayCompanyDate(StringValidater.toInteger(req
                .getRepayCompanyDate()));
        budgetOrder
                .setRepayFirstMonthDatetime(DateUtil.strToDate(
                        req.getRepayFirstMonthDatetime(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));

        Date tomorrowDate = DateUtil.getTomorrowStart(new Date());
        if (tomorrowDate.compareTo(budgetOrder.getRepayFirstMonthDatetime()) > 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "首次还款日期请从明天开始算起");
        }

        budgetOrder.setRepayFirstMonthAmount(StringValidater.toLong(req
                .getRepayFirstMonthAmount()));
        budgetOrder.setRepayMonthAmount(StringValidater.toLong(req
                .getRepayMonthAmount()));

        budgetOrder.setBankFkDatetime(DateUtil.strToDate(req.getBankFkDate(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setIntevCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preCurrentNode).getNextNode());
        budgetOrderBO.refreshEntryFk(budgetOrder);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getIntevCurNodeCode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void entryMortgage(XN632131Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getAdvanfCurNodeCode();
        if (!EBudgetOrderNode.ENTRYMORTGAGE.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是内勤录入发保合节点，不能操作");
        }

        NodeFlow currentNodeFlow = nodeFlowBO
                .getNodeFlowByCurrentNode(preCurrentNode);
        budgetOrder.setAdvanfCurNodeCode(currentNodeFlow.getNextNode());
        budgetOrder.setGreenBigSmj(req.getGreenBigSmj());
        budgetOrder.setIsEntryMortgage(EBoolean.YES.getCode());

        budgetOrder.setCarInvoice(req.getCarInvoice());
        budgetOrder.setCarJqx(req.getCarJqx());
        budgetOrder.setCarSyx(req.getCarSyx());
        budgetOrder.setPolicyDatetime(DateUtil.strToDate(
                req.getPolicyDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setPolicyDueDate(DateUtil.strToDate(req.getPolicyDueDate(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setCarSettleOtherPdf(req.getCarSettleOtherPdf());

        budgetOrderBO.entryMortgage(budgetOrder);

        // 获取参考材料
        // String logisticsCode = logisticsBO.saveLogistics(
        // ELogisticsType.BUDGET.getCode(), budgetOrder.getCode(),
        // req.getOperator(), preCurrentNode, currentNodeFlow.getNextNode(),
        // null);
        // 产生物流单后改变状态为物流传递中
        // budgetOrder.setIsLogistics(EBoolean.YES.getCode());
        // budgetOrderBO.updateIsLogistics(budgetOrder);

        // 资料传递日志
        // sysBizLogBO.saveSYSBizLog(req.getCode(), EBizLogType.LOGISTICS,
        // logisticsCode, budgetOrder.getAdvanfCurNodeCode(),
        // budgetOrder.getTeamCode());
        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getAdvanfCurNodeCode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void mortgageCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (!EBudgetOrderNode.ENTRYCOMMITBANK.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是抵押提交银行节点，不能操作");
        }
        budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                preCurrentNode).getNextNode());
        budgetOrder.setPledgeBankCommitDatetime(DateUtil.strToDate(
                pledgeBankCommitDatetime, DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setBankCommitNote(pledgeBankCommitNote);

        // 获取所有物流单的材料清单，去重
        Logistics logistics = new Logistics();
        logistics.setBizCode(code);
        List<Logistics> logisticsList = logisticsBO
                .queryLogisticsList(logistics);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (Logistics data : logisticsList) {
            String filelist = data.getFilelist();
            if (filelist != null) {
                String[] split = filelist.split(",");
                for (String string : split) {
                    arrayList.add(string);
                }
            }
        }
        String res = "";
        Set<String> set = new HashSet<String>();
        for (String str : arrayList) {
            if (set.add(str)) {
                res += str + ",";
            }
        }
        String substring = res.substring(0, res.length() - 1);
        budgetOrder.setEnterFileList(substring);
        budgetOrder.setIsMortgage(EBoolean.YES.getCode());
        budgetOrderBO.refreshMortgageCommitBank(budgetOrder);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getCurNodeCode(), pledgeBankCommitNote, operator);
    }

    @Override
    @Transactional
    public void mortgageCommitbank(XN632149Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (!EBudgetOrderNode.MORTGAGECOMMITBANK.getCode().equals(
                budgetOrder.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是驻行人员审核抵押材料节点，不能操作");
        }

        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        } else {
            budgetOrder.setCurNodeCode(nodeFlow.getBackNode());
        }
        budgetOrder.setRemark(req.getApproveNote());
        budgetOrderBO.refreshAreaApprove(budgetOrder);

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getIntevCurNodeCode(), req.getApproveNote(),
                req.getOperator());
    }

    @Override
    @Transactional
    public String mortgageFinish(XN632133Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        if (!EBudgetOrderNode.MORTGAGEFINISH.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是内勤录入抵押信息节点，不能操作");
        }
        String result = EBoolean.NO.getCode();

        budgetOrder.setCurNodeCode(nodeFlow.getNextNode());
        budgetOrder.setCarNumber(req.getCarNumber());
        budgetOrder.setCarRegcerti(req.getCarRegcerti());
        budgetOrder.setCarPd(req.getCarPd());
        budgetOrder.setCarKey(req.getCarKey());
        budgetOrder.setCarBigSmj(req.getCarBigSmj());
        budgetOrder.setCarXszSmj(req.getCarXszSmj());
        budgetOrder.setDutyPaidProveSmj(req.getDutyPaidProveSmj());
        budgetOrder.setPledgeDatetime(DateUtil.strToDate(
                req.getPledgeDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setCarSettleDatetime(DateUtil.strToDate(
                req.getCarSettleDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setPledgeStatus(EBoolean.YES.getCode());

        budgetOrderBO.refreshMortgageFinish(budgetOrder);

        // 资料传递
        String logisticsCode = logisticsBO.saveLogistics(
                ELogisticsType.BUDGET.getCode(),
                ELogisticsCurNodeType.CAR_MORTGAGE.getCode(),
                budgetOrder.getCode(), budgetOrder.getSaleUserId(),
                EBudgetOrderNode.INSIDEJOB_SEND.getCode(),
                EBudgetOrderNode.YWDH_APPROVE.getCode(), null);
        // 产生物流单后改变状态为物流传递中
        // budgetOrder.setIsLogistics(EBoolean.YES.getCode());
        // budgetOrderBO.updateIsLogistics(budgetOrder);
        result = EBoolean.YES.getCode();

        // 资料传递日志
        sysBizLogBO.saveSYSBizLog(req.getCode(), EBizLogType.LOGISTICS,
                logisticsCode, budgetOrder.getCurNodeCode());

        // 日志记录
        sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_ORDER, budgetOrder.getCode(), preCurrentNode,
                budgetOrder.getCurNodeCode(), null, req.getOperator());

        return result;
    }

    @Override
    @Transactional
    public void archive(String code, String operator, String enterLocation) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        // 之前节点
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (!EBudgetOrderNode.ARCHIVE.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是入档节点，不能操作");
        }
        if (!EBudgetOrderNode.BANK_ALREADY_LOAN.getCode().equals(
                budgetOrder.getIntevCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "财务未确认银行放款，不能操作");
        }
        if (!EBudgetOrderNode.GPS_APPROVE_PASS.getCode().equals(
                budgetOrder.getAdvanfCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "gps管理员审核未通过，不能操作");
        }
        // 归档
        /****** 生成还款业务 ******/
        // 检查用户是否已经注册过
        User user = userBO.getUser(budgetOrder.getMobile(),
                EUserKind.Customer.getCode());
        String userId = null;
        if (user == null) {
            // 用户代注册并实名认证
            userId = userBO.doRegisterAndIdentify(EBoolean.YES.getCode(),
                    budgetOrder.getMobile(), budgetOrder.getIdKind(),
                    budgetOrder.getApplyUserName(), budgetOrder.getIdNo());
            distributeAccount(userId, budgetOrder.getMobile(),
                    EUserKind.Customer.getCode());
        } else {
            userId = user.getUserId();
        }

        Bank bank = bankBO.getBank(budgetOrder.getRepayBankCode());

        // 绑定用户银行卡
        String bankcardCode = bankcardBO.bind(userId,
                budgetOrder.getApplyUserName(),
                budgetOrder.getRepayBankcardNumber(), bank.getBankCode(),
                budgetOrder.getRepayBankName(), budgetOrder.getRepaySubbranch());

        // 自动生成还款业务
        RepayBiz repayBiz = repayBizBO.generateCarLoanRepayBiz(budgetOrder,
                userId, bankcardCode, operator);

        // 自动生成还款计划
        repayPlanBO.genereateNewRepayPlan(repayBiz);
        /****** 生成还款业务 ******/

        // 归档完成，更新预算单信息
        String repayBizCode = repayBiz.getCode();
        budgetOrder.setCurNodeCode(EBudgetOrderNode.ARCHIVE_END.getCode());
        budgetOrder.setEnterLocation(enterLocation);
        budgetOrder.setEnterDatetime(new Date());
        budgetOrderBO.archiveSuccess(budgetOrder, repayBizCode, userId);

        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.BUDGET_ORDER.getCode(),
                budgetOrder.getCode(), preCurrentNode, null, operator);
    }

    // 分配账号
    private void distributeAccount(String userId, String mobile, String kind) {
        List<String> currencyList = new ArrayList<String>();
        currencyList.add(ECurrency.CNY.getCode());
        currencyList.add(ECurrency.JF.getCode());
        currencyList.add(ECurrency.XYF.getCode());

        for (String currency : currencyList) {
            accountBO.distributeAccount(userId, mobile,
                    EAccountType.getAccountType(kind), currency);
        }
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPage(int start, int limit,
            BudgetOrder condition) {
        Paginable<BudgetOrder> page = budgetOrderBO.getPaginable(start, limit,
                condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (BudgetOrder budgetOrder : page.getList()) {
                initBudgetOrder(budgetOrder);
            }
        }
        return page;
    }

    // 初始化预算单数据，包含公司名称
    private void initBudgetOrder(BudgetOrder budgetOrder) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrder.getBizCode());
        budgetOrder.setCdbiz(cdbiz);
        if (StringUtils.isNotBlank(budgetOrder.getBizCode())) {
            Credit credit = creditBO.getCreditByBizCode(budgetOrder
                    .getBizCode());
            creditAO.initCredit(credit);
            budgetOrder.setCredit(credit);
            CreditUser creditUser = credit.getCreditUser();
            budgetOrder.setApplyUserName(creditUser.getUserName());
            budgetOrder.setMobile(creditUser.getMobile());
            budgetOrder.setIdNo(creditUser.getIdNo());
        }

        // 业务公司名称
        if (StringUtils.isNotBlank(budgetOrder.getCompanyCode())) {
            Department department = departmentBO.getDepartment(budgetOrder
                    .getCompanyCode());
            budgetOrder.setCompanyName(department.getName());
        }

        // 业务员姓名
        if (StringUtils.isNotBlank(budgetOrder.getSaleUserId())) {
            SYSUser sysUser = sysUserBO.getUser(budgetOrder.getSaleUserId());
            budgetOrder.setSaleUserName(sysUser.getRealName());
        }

        // 区域经理名称
        SYSBizLog sysBizLog = new SYSBizLog();
        sysBizLog.setBizCode(budgetOrder.getCode());
        sysBizLog.setDealNode(ENode.area_approve_budget.getCode());
        List<SYSBizLog> bizLogList = sysBizLogBO.querySYSBizLogList(sysBizLog);
        if (CollectionUtils.isNotEmpty(bizLogList)) {
            SYSBizLog bizLog = bizLogList.get(bizLogList.size() - 1);
            budgetOrder.setAreaName(bizLog.getOperatorName());
            budgetOrder.setAreaMobile(bizLog.getOperatorMobile());
        }

        // 贷款银行
        if (StringUtils.isNotBlank(budgetOrder.getLoanBank())) {
            Bank loanBank = bankBO.getBank(budgetOrder.getLoanBank());
            budgetOrder.setLoanBankName(loanBank.getBankName());
        }

        // 当时团队
        if (StringUtils.isNotBlank(cdbiz.getTeamCode())) {
            BizTeam bizTeam = bizTeamBO.getBizTeam(cdbiz.getTeamCode());
            budgetOrder.setTeamName(bizTeam.getName());
        }

        // 内勤
        if (StringUtils.isNotBlank(budgetOrder.getInsideJob())) {
            SYSUser InsideJob = sysUserBO.getUser(budgetOrder.getInsideJob());
            budgetOrder.setInsideJobName(InsideJob.getRealName());
        }
        // SYSBizLog bizLog = sysBizLogBO.getApplyBudgetOrderOperator(
        // budgetOrder.getCode(),
        // EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode());
        // if (null != bizLog && StringUtils.isNotBlank(bizLog.getOperator())) {
        // SYSUser operator = sysUserBO.getUser(bizLog.getOperator());
        // budgetOrder.setInsideJob(operator.getRealName());//
        // 内勤（使用这个业务单在日志表的最新操作人）
        // }

        // 附件池
        // List<Attachment> attachments = attachmentBO
        // .queryBizAttachments(budgetOrder.getBizCode());
        // budgetOrder.setAttachments(attachments);

        // 资料快递 通过类型，预算单号，收件节点，物流状态查找物流单
        Logistics logistics = new Logistics();
        logistics.setType(ELogisticsType.BUDGET.getCode());
        logistics.setBizCode(budgetOrder.getCode());
        // logistics.setFromNodeCode(
        // EBudgetOrderNode.INTERVIEW_INTERNAL_APPROVE.getCode());
        logistics.setToNodeCode(EBudgetOrderNode.DHAPPROVEDATA.getCode());
        logistics.setStatus(ELogisticsStatus.RECEIVED.getCode());
        List<Logistics> logisticsList = logisticsBO
                .queryLogisticsList(logistics);
        if (CollectionUtils.isNotEmpty(logisticsList)) {
            Logistics domain = logisticsList.get(logisticsList.size() - 1);
            String companyName = "";
            if (StringUtils.isNotBlank(domain.getLogisticsCompany())) {
                SYSDict dict = sysDictBO.getSYSDictByParentKeyAndDkey(
                        "kd_company", domain.getLogisticsCompany());// 根据父key和Dkey查数据字典的Dvalue
                if (dict != null) {
                    companyName = dict.getDvalue();
                }
            } else {
                companyName = "-";
            }
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(domain.getReceiptDatetime());// 转换收件时间的格式
            String dh = "";
            if (StringUtils.isNotBlank(domain.getLogisticsCode())) {
                dh = domain.getLogisticsCode();
            } else {
                dh = "-";
            }
            String informationExpress = "单号：" + dh + "  时间：" + date
                    + "   快递公司：" + companyName;
            budgetOrder.setInformationExpress(informationExpress);
        }
        // 收件时间
        logistics.setFromNodeCode(null);
        logistics.setToNodeCode(EBudgetOrderNode.COMMITBANK3.getCode());
        logisticsList = logisticsBO.queryLogisticsList(logistics);
        if (CollectionUtils.isNotEmpty(logisticsList)) {
            Logistics domain = logisticsList.get(logisticsList.size() - 1);
            budgetOrder.setReceiptDatetime(domain.getReceiptDatetime());
        }

    }

    @Override
    public BudgetOrder getBudgetOrder(String code) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        initBudgetOrder(budgetOrder);
        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
                .queryBudgetOrderGpsList(code);
        budgetOrder.setBudgetOrderGpsList(budgetOrderGpsList);
        return budgetOrder;
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageByRoleCode(int start,
            int limit, BudgetOrder condition, String userId) {
        if (ESysRole.LEADER.getCode().equals(condition.getRoleCode())) {
            SYSUser user = sysUserBO.getUser(userId);
            if (user.getTeamCode() != null) {
                condition.setTeamCode(user.getTeamCode());
            }
        }
        if (ESysRole.SALE.getCode().equals(condition.getRoleCode())) {
            condition.setSaleUserId(userId);
        }
        if (ESysRole.YWNQ.getCode().equals(condition.getRoleCode())) {
            condition.setInsideJob(userId);
        }

        Paginable<BudgetOrder> page = budgetOrderBO.getPaginableByRoleCode(
                start, limit, condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (BudgetOrder budgetOrder : page.getList()) {
                initBudgetOrder(budgetOrder);
            }
        }
        return page;
    }

    @Override
    public BudgetOrder getMoreBudget(String code) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(code);
        initBudgetOrder(budgetOrder);

        List<BudgetOrderGps> budgetOrderGpsList = budgetOrderGpsBO
                .queryBudgetOrderGpsList(code);
        budgetOrder.setBudgetOrderGpsList(budgetOrderGpsList);

        Credit credit = creditBO.getCredit(budgetOrder.getCreditCode());
        CreditUser creditUser = new CreditUser();
        //****待处理*****
//        creditUser.setCreditCode(credit.getCode());
        List<CreditUser> queryCreditUserList = creditUserBO
                .queryCreditUserList(creditUser);
        credit.setCreditUserList(queryCreditUserList);

        SYSUser user = sysUserBO.getUser(budgetOrder.getSaleUserId());
        budgetOrder.setRoleCode(user.getRoleCode());
        budgetOrder.setCredit(credit);

        // 区域经理名称
        SYSBizLog sysBizLog = new SYSBizLog();
        sysBizLog.setBizCode(code);
        sysBizLog.setDealNode(EBudgetOrderNode.AREA_APPROVE.getCode());
        List<SYSBizLog> bizLogList = sysBizLogBO.querySYSBizLogList(sysBizLog);
        if (CollectionUtils.isNotEmpty(bizLogList)) {
            SYSBizLog bizLog = bizLogList.get(bizLogList.size() - 1);
            budgetOrder.setAreaName(bizLog.getOperatorName());
            budgetOrder.setAreaMobile(bizLog.getOperatorMobile());
        }
        return budgetOrder;
    }

    @Override
    @Transactional
    public void confirmBackAdvanceFund(XN632180Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (!EBackAdvanceStatus.TODO_BACK.getCode().equals(
                budgetOrder.getBackAdvanceStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前业务不是待财务退客户垫资款状态，不能操作！");
        }
        budgetOrder.setBackAdvanceAmount(req.getBackAdvanceAmount());
        budgetOrder.setBackAdvanceAccount(req.getBackAdvanceAccount());
        budgetOrder.setBackAdvanceOpenBank(req.getBackAdvanceOpenBank());
        budgetOrder.setBackAdvanceSubbranch(req.getBackAdvanceSubbranch());
        budgetOrder.setBackAdvanceWaterBill(req.getBackAdvanceWaterBill());
        budgetOrder.setBackAdvanceStatus(EBackAdvanceStatus.HANDLED_BACK
                .getCode());
        budgetOrderBO.confirmBackAdvanceFund(budgetOrder);
        // 日志
        sysBizLogBO.refreshPreSYSBizLog(
                EBizLogType.BACK_ADVANCE_FUND.getCode(), budgetOrder.getCode(),
                EBackAdvanceNode.FINANCE_REFUND.getCode(), null, req.getOperator());
    }

    @Override
    @Transactional
    public void applyCancel(XN632190Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (EBudgetOrderNode.COMMITBANK.getCode().compareTo(
                budgetOrder.getCurNodeCode()) <= 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前业务已经过提交银行节点，不能申请作废！");
        }
        budgetOrder.setRemark(req.getRemark());
        budgetOrder.setFrozenStatus(EBudgetFrozenStatus.FROZEN.getCode());
        budgetOrder.setCancelNodeCode(budgetOrder.getCurNodeCode());
        budgetOrder.setCurNodeCode(EBudgetOrderNode.CANCEL_BIZ_AUDIT.getCode());// 节点
        budgetOrderBO.applyCancel(budgetOrder);
        // 日志
        sysBizLogBO.recordCurOperate(budgetOrder.getCode(),
                EBizLogType.BUDGET_CANCEL, budgetOrder.getCode(),
                EBudgetOrderNode.CANCEL_START.getCode(), req.getRemark(),
                req.getOperator());
        sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                EBizLogType.BUDGET_CANCEL, budgetOrder.getCode(),
                budgetOrder.getCurNodeCode());
    }

    @Override
    @Transactional
    public void cancelBizAudit(XN632191Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (!EBudgetOrderNode.CANCEL_BIZ_AUDIT.getCode().equals(preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是作废流程业务总监审核节点，不能操作");
        }
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 判断是否已垫资 如果已经垫资 下一个节点是财务审核节点 未垫资 下一个节点是废流程结束节点
            if (null == budgetOrder.getAdvanceFundAmount()
                    && null == budgetOrder.getAdvanceFundDatetime()) {// 没垫资情况
                budgetOrder.setCurNodeCode(EBudgetOrderNode.CANCEL_END
                        .getCode());
                // 日志
                sysBizLogBO.refreshPreSYSBizLog(
                        EBizLogType.BUDGET_CANCEL.getCode(), budgetOrder.getCode(),
                        preCurrentNode, req.getApproveNote(), req.getOperator());
            } else {// 垫资情况
                budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                        preCurrentNode).getNextNode());
                // 日志
                sysBizLogBO.saveNewAndPreEndSYSBizLog(budgetOrder.getCode(),
                        EBizLogType.BUDGET_CANCEL, budgetOrder.getCode(),
                        preCurrentNode, budgetOrder.getCurNodeCode(),
                        req.getApproveNote(), req.getOperator());
            }
        } else {
            budgetOrder.setCurNodeCode(budgetOrder.getCancelNodeCode());
            budgetOrder.setFrozenStatus(EBudgetFrozenStatus.NORMAL.getCode());
            budgetOrder.setCancelNodeCode(null);
            // 日志
            sysBizLogBO.refreshPreSYSBizLog(
                    EBizLogType.BUDGET_CANCEL.getCode(), budgetOrder.getCode(),
                    preCurrentNode, req.getApproveNote(), req.getOperator());
        }
        budgetOrderBO.cancelBizAudit(budgetOrder);
    }

    @Override
    @Transactional
    public void cancelFinanceAudit(XN632192Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        String preCurrentNode = budgetOrder.getCurNodeCode();
        if (!EBudgetOrderNode.CANCEL_FINANCE_AUDIT.getCode().equals(
                preCurrentNode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是作废流程财务总监审核节点，不能操作");
        }
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            budgetOrder.setCurNodeCode(nodeFlowBO.getNodeFlowByCurrentNode(
                    preCurrentNode).getNextNode());
            budgetOrder.setFrozenStatus(EBudgetFrozenStatus.NORMAL.getCode());
        } else {
            budgetOrder.setCurNodeCode(budgetOrder.getCancelNodeCode());
            budgetOrder.setFrozenStatus(EBudgetFrozenStatus.NORMAL.getCode());
            budgetOrder.setCancelNodeCode(null);
        }
        budgetOrderBO.cancelFinanceAudit(budgetOrder);
        // 日志记录
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.BUDGET_CANCEL.getCode(),
                budgetOrder.getCode(), preCurrentNode, req.getApproveNote(),
                req.getOperator());
    }

    @Override
    public ArrayList<BudgetOrder> queryBudgetOrderPageByDz(BudgetOrder condition) {
        List<BudgetOrder> budgetOrderList = budgetOrderBO
                .getPaginableByDz(condition);
        ArrayList<BudgetOrder> list = new ArrayList<BudgetOrder>();
        for (BudgetOrder budgetOrder : budgetOrderList) {

            // 业务员姓名
            if (StringUtils.isNotBlank(budgetOrder.getSaleUserId())) {
                SYSUser sysUser = sysUserBO
                        .getUser(budgetOrder.getSaleUserId());
                budgetOrder.setSaleUserName(sysUser.getRealName());
            }
            // 贷款银行
            if (StringUtils.isNotBlank(budgetOrder.getLoanBank())) {
                Bank loanBank = bankBO.getBank(budgetOrder.getLoanBank());
                budgetOrder.setLoanBankName(loanBank.getBankName());
            }
            // 内勤
            if (StringUtils.isNotBlank(budgetOrder.getInsideJob())) {
                SYSUser user = sysUserBO.getUser(budgetOrder.getInsideJob());
                budgetOrder.setInsideJobName(user.getRealName());
            }
            // SYSBizLog bizLog = sysBizLogBO.getApplyBudgetOrderOperator(
            // budgetOrder.getCode(),
            // EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode());
            // if (null != bizLog
            // && StringUtils.isNotBlank(bizLog.getOperator())) {
            // SYSUser operator = sysUserBO.getUser(bizLog.getOperator());
            // budgetOrder.setInsideJob(operator.getRealName());//
            // 内勤（使用这个业务单在预算单申请时日志表的最新操作人）
            // }

            // 业务公司名称
            if (StringUtils.isNotBlank(budgetOrder.getCompanyCode())) {
                Department company = departmentBO.getDepartment(budgetOrder
                        .getCompanyCode());
                budgetOrder.setCompanyName(company.getName());
            }

            // 垫资天数
            Calendar cal = Calendar.getInstance();
            if (budgetOrder.getAdvanceFundDatetime() == null) {
                continue;
            }
            cal.setTime(budgetOrder.getAdvanceFundDatetime());
            long time1 = cal.getTimeInMillis();
            cal.setTime(new Date());
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            int days = Integer.parseInt(String.valueOf(between_days));
            budgetOrder.setAdvanceDays(days);
            if (days >= 1) {
                list.add(budgetOrder);
            }
        }
        return list;
    }

    @Override
    @Transactional
    public void doSmsInterviewInform(String budgetOrderCode, String roomId) {
//        BudgetOrder data = budgetOrderBO.getBudgetOrder(budgetOrderCode);
        Cdbiz cdbiz = cdbizBO.getCdbiz(budgetOrderCode);
        CreditUser applyUser = creditUserBO
                .getCreditUserByBizCode(cdbiz.getCode(), ECreditUserLoanRole.APPLY_USER);
        if (!ENode.input_interview.getCode().equals(cdbiz.getIntevCurNodeCode())
                && !ENode.reinput_interview.getCode().equals(cdbiz.getIntevCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是面签节点");
        }
        // String roomCode = data.getCode().substring(data.getCode().length() -
        // 7);
        smsOutBO.sendSmsOut(applyUser.getMobile(),
                "您的车贷准入申请单正在面签，请您现在打开APP，点击\"我的\"->\"开始面签\"，输入房间号[" + roomId
                        + "]，进入房间并完成面签。");
    }

    @Override
    @Transactional
    public void dataSupplement(XN632141Req req) {
        BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(req.getCode());
        if (!EBudgetOrderNode.DHAPPROVEDATA.getCode().equals(
                budgetOrder.getIntevCurNodeCode())
                && !EBudgetOrderNode.COMMITBANK3.getCode().equals(
                budgetOrder.getIntevCurNodeCode())
                && !EBudgetOrderNode.COMMITBANK.getCode().equals(
                budgetOrder.getIntevCurNodeCode())
                && !EBudgetOrderNode.ENTRYLOAN.getCode().equals(
                budgetOrder.getIntevCurNodeCode())
                && !EBudgetOrderNode.CONFIRMLOAN.getCode().equals(
                budgetOrder.getIntevCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不能资料补录！");
        }

        budgetOrder.setMateName(req.getMateName());
        budgetOrder.setMateMobile(req.getMateMobile());
        budgetOrder.setMateIdNo(req.getMateIdNo());
        budgetOrder.setMateEducation(req.getMateEducation());
        budgetOrder.setMateCompanyName(req.getMateCompanyName());

        budgetOrder.setMateCompanyAddress(req.getMateCompanyAddress());
        budgetOrder.setMateCompanyContactNo(req.getMateCompanyContactNo());
        budgetOrder.setMateZfbJourDatetimeStart(DateUtil.strToDate(
                req.getMateZfbJourDatetimeStart(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder
                .setMateZfbJourDatetimeEnd(DateUtil.strToDate(
                        req.getMateZfbJourDatetimeEnd(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setMateZfbJourInterest1(req.getMateZfbJourInterest1());
        budgetOrder.setMateZfbJourInterest2(req.getMateZfbJourInterest2());

        budgetOrder.setMateZfbInterest1(StringValidater.toLong(req
                .getMateZfbInterest1()));
        budgetOrder.setMateZfbInterest2(StringValidater.toLong(req
                .getMateZfbInterest2()));
        budgetOrder.setMateZfbJourIncome(StringValidater.toLong(req
                .getMateZfbJourIncome()));
        budgetOrder.setMateZfbJourExpend(StringValidater.toLong(req
                .getMateZfbJourExpend()));
        budgetOrder.setMateZfbJourBalance(StringValidater.toLong(req
                .getMateZfbJourBalance()));

        budgetOrder.setMateZfbJourMonthIncome(StringValidater.toLong(req
                .getMateZfbJourMonthIncome()));
        budgetOrder.setMateZfbJourMonthExpend(StringValidater.toLong(req
                .getMateZfbJourMonthExpend()));
        budgetOrder.setMateZfbJourPic(req.getMateZfbJourPic());
        budgetOrder.setMateZfbJourRemark(req.getMateZfbJourRemark());
        budgetOrder
                .setMateWxJourDatetimeStart(DateUtil.strToDate(
                        req.getMateWxJourDatetimeStart(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));

        budgetOrder.setMateWxJourDatetimeEnd(DateUtil.strToDate(
                req.getMateWxJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setMateWxJourInterest1(req.getMateWxJourInterest1());
        budgetOrder.setMateWxJourInterest2(req.getMateWxJourInterest2());
        budgetOrder.setMateWxInterest1(StringValidater.toLong(req
                .getMateWxInterest1()));
        budgetOrder.setMateWxInterest2(StringValidater.toLong(req
                .getMateWxInterest2()));
        budgetOrder.setMateWxJourIncome(StringValidater.toLong(req
                .getMateWxJourIncome()));

        budgetOrder.setMateWxJourExpend(StringValidater.toLong(req
                .getMateWxJourExpend()));
        budgetOrder.setMateWxJourBalance(StringValidater.toLong(req
                .getMateWxJourBalance()));
        budgetOrder.setMateWxJourMonthIncome(StringValidater.toLong(req
                .getMateWxJourMonthIncome()));
        budgetOrder.setMateWxJourMonthExpend(StringValidater.toLong(req
                .getMateWxJourMonthExpend()));
        budgetOrder.setMateWxJourPic(req.getMateWxJourPic());

        budgetOrder.setMateWxJourRemark(req.getMateWxJourRemark());
        budgetOrder.setMateJourDatetimeStart(DateUtil.strToDate(
                req.getMateJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setMateJourDatetimeEnd(DateUtil.strToDate(
                req.getMateJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setMateJourInterest1(req.getMateJourInterest1());
        budgetOrder.setMateJourInterest2(req.getMateJourInterest2());
        budgetOrder.setMateInterest1(StringValidater.toLong(req
                .getMateInterest1()));

        budgetOrder.setMateInterest2(StringValidater.toLong(req
                .getMateInterest2()));
        budgetOrder.setMateJourIncome(StringValidater.toLong(req
                .getMateJourIncome()));
        budgetOrder.setMateJourExpend(StringValidater.toLong(req
                .getMateJourExpend()));
        budgetOrder.setMateJourBalance(StringValidater.toLong(req
                .getMateJourBalance()));
        budgetOrder.setMateJourMonthIncome(StringValidater.toLong(req
                .getMateJourMonthIncome()));

        budgetOrder.setMateJourMonthExpend(StringValidater.toLong(req
                .getMateJourMonthExpend()));
        budgetOrder.setMateJourPic(req.getMateJourPic());
        budgetOrder.setMateJourRemark(req.getMateJourRemark());
        budgetOrder.setMateAssetPdf(req.getMateAssetPdf());
        budgetOrder.setGuaName(req.getGuaName());

        budgetOrder.setGuaMobile(req.getGuaMobile());
        budgetOrder.setGuaIdNo(req.getGuaIdNo());
        budgetOrder.setGuaPhone(req.getGuaPhone());
        budgetOrder.setGuaCompanyName(req.getGuaCompanyName());
        budgetOrder.setGuaCompanyAddress(req.getGuaCompanyAddress());

        budgetOrder.setGuaHouseAssetAddress(req.getGuaHouseAssetAddress());
        budgetOrder
                .setGuaZfbJourDatetimeStart(DateUtil.strToDate(
                        req.getGuaZfbJourDatetimeStart(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setGuaZfbJourDatetimeEnd(DateUtil.strToDate(
                req.getGuaZfbJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setGuaZfbJourInterest1(req.getGuaZfbJourInterest1());
        budgetOrder.setGuaZfbJourInterest2(req.getGuaZfbJourInterest2());
        budgetOrder.setGuaZfbInterest1(StringValidater.toLong(req
                .getGuaZfbInterest1()));

        budgetOrder.setGuaZfbInterest2(StringValidater.toLong(req
                .getGuaZfbInterest2()));
        budgetOrder.setGuaZfbJourIncome(StringValidater.toLong(req
                .getGuaZfbJourIncome()));
        budgetOrder.setGuaZfbJourExpend(StringValidater.toLong(req
                .getGuaZfbJourExpend()));
        budgetOrder.setGuaZfbJourBalance(StringValidater.toLong(req
                .getGuaZfbJourBalance()));
        budgetOrder.setGuaZfbJourMonthIncome(StringValidater.toLong(req
                .getGuaZfbJourMonthIncome()));

        budgetOrder.setGuaZfbJourMonthExpend(StringValidater.toLong(req
                .getGuaZfbJourMonthExpend()));
        budgetOrder.setGuaZfbJourPic(req.getGuaZfbJourPic());
        budgetOrder.setGuaZfbJourRemark(req.getGuaZfbJourRemark());
        budgetOrder
                .setGuaWxJourDatetimeStart(DateUtil.strToDate(
                        req.getGuaWxJourDatetimeStart(),
                        DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setGuaWxJourDatetimeEnd(DateUtil.strToDate(
                req.getGuaWxJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        budgetOrder.setGuaWxJourInterest1(req.getGuaWxJourInterest1());
        budgetOrder.setGuaWxJourInterest2(req.getGuaWxJourInterest2());
        budgetOrder.setGuaWxInterest1(StringValidater.toLong(req
                .getGuaWxInterest1()));
        budgetOrder.setGuaWxInterest2(StringValidater.toLong(req
                .getGuaWxInterest2()));
        budgetOrder.setGuaWxJourIncome(StringValidater.toLong(req
                .getGuaWxJourIncome()));
        budgetOrder.setGuaWxJourExpend(StringValidater.toLong(req
                .getGuaWxJourExpend()));

        budgetOrder.setGuaWxJourBalance(StringValidater.toLong(req
                .getGuaWxJourBalance()));
        budgetOrder.setGuaWxJourMonthIncome(StringValidater.toLong(req
                .getGuaWxJourMonthIncome()));
        budgetOrder.setGuaWxJourMonthExpend(StringValidater.toLong(req
                .getGuaWxJourMonthExpend()));
        budgetOrder.setGuaWxJourPic(req.getGuaWxJourPic());
        budgetOrder.setGuaWxJourRemark(req.getGuaWxJourRemark());

        budgetOrder.setGuaJourDatetimeStart(DateUtil.strToDate(
                req.getGuaJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setGuaJourDatetimeEnd(DateUtil.strToDate(
                req.getGuaJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setGuaJourInterest1(req.getGuaJourInterest1());
        budgetOrder.setGuaJourInterest2(req.getGuaJourInterest2());
        budgetOrder.setGuaInterest1(StringValidater.toLong(req
                .getGuaInterest1()));
        budgetOrder.setGuaInterest2(StringValidater.toLong(req
                .getGuaInterest2()));

        budgetOrder.setGuaJourIncome(StringValidater.toLong(req
                .getGuaJourIncome()));
        budgetOrder.setGuaJourExpend(StringValidater.toLong(req
                .getGuaJourExpend()));
        budgetOrder.setGuaJourBalance(StringValidater.toLong(req
                .getGuaJourBalance()));
        budgetOrder.setGuaJourMonthIncome(StringValidater.toLong(req
                .getGuaJourMonthIncome()));
        budgetOrder.setGuaJourMonthExpend(StringValidater.toLong(req
                .getGuaJourMonthExpend()));

        budgetOrder.setGuaJourPic(req.getGuaJourPic());
        budgetOrder.setGuaJourRemark(req.getGuaJourRemark());
        budgetOrder.setGuaAssetPdf(req.getGuaAssetPdf());
        budgetOrder.setZfbJourDatetimeStart(DateUtil.strToDate(
                req.getZfbJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setZfbJourDatetimeEnd(DateUtil.strToDate(
                req.getZfbJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        budgetOrder.setZfbJourInterest1(req.getZfbJourInterest1());
        budgetOrder.setZfbJourInterest2(req.getZfbJourInterest2());
        budgetOrder.setZfbInterest1(StringValidater.toLong(req
                .getZfbInterest1()));
        budgetOrder.setZfbInterest2(StringValidater.toLong(req
                .getZfbInterest2()));
        budgetOrder.setZfbJourPic(req.getZfbJourPic());
        budgetOrder.setZfbJourRemark(req.getZfbJourRemark());

        budgetOrder.setWxJourDatetimeStart(DateUtil.strToDate(
                req.getWxJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setWxJourDatetimeEnd(DateUtil.strToDate(
                req.getWxJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setWxJourInterest1(req.getWxJourInterest1());
        budgetOrder.setWxJourInterest2(req.getWxJourInterest2());
        budgetOrder
                .setWxInterest1(StringValidater.toLong(req.getWxInterest1()));
        budgetOrder
                .setWxInterest2(StringValidater.toLong(req.getWxInterest2()));

        budgetOrder.setWxJourPic(req.getWxJourPic());
        budgetOrder.setWxJourRemark(req.getWxJourRemark());
        budgetOrder.setJourDatetimeStart(DateUtil.strToDate(
                req.getJourDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setJourDatetimeEnd(DateUtil.strToDate(
                req.getJourDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        budgetOrder.setJourInterest1(req.getJourInterest1());
        budgetOrder.setJourInterest2(req.getJourInterest2());

        budgetOrder.setInterest1(StringValidater.toLong(req.getInterest1()));
        budgetOrder.setInterest2(StringValidater.toLong(req.getInterest2()));
        budgetOrder.setJourPic(req.getJourPic());
        budgetOrder.setJourRemark(req.getJourRemark());
        budgetOrderBO.dataSupplement(budgetOrder);
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageByTeamCode(int start,
            int limit, BudgetOrder condition, String userId) {
        // 记得有这需求，联否
        // if (!"RO201800000000000001".equals(roleCode)
        // && condition.getTeamCode() == null) {
        // condition.setTeamCode("000000000000000");// 意为空
        // }
        // if ("RO201800000000000001".equals(roleCode)) {
        // condition.setTeamCode(null);
        // }
        SYSUser user = sysUserBO.getUser(userId);
        if (ESysRole.SALE.getCode().equals(user.getRoleCode())) {
            condition.setSaleUserId(userId);
        } else if (ESysRole.YWNQ.getCode().equals(user.getRoleCode())) {
            condition.setInsideJob(userId);
        } else if (ESysRole.LEADER.getCode().equals(user.getRoleCode())) {
            condition.setTeamCode(user.getTeamCode());
        }
        Paginable<BudgetOrder> page = budgetOrderBO.getPaginableByTeamCode(
                start, limit, condition);
        List<BudgetOrder> list = page.getList();
        for (BudgetOrder budgetOrder : list) {
            initTeamReport(budgetOrder);
        }
        return page;
    }

    private BudgetOrder initTeamReport(BudgetOrder budgetOrder) {
        CreditUser user = null;
        //****待处理*****
        //creditUserBO.getCreditUserByCreditCode(
        //budgetOrder.getCreditCode(), ECreditUserLoanRole.APPLY_USER);
        budgetOrder.setContactNo(user.getMobile());// 联系电话
        SYSUser saleUser = sysUserBO.getUser(budgetOrder.getSaleUserId());
        budgetOrder.setSaleUserName(saleUser.getRealName());// 信贷专员
        if (StringUtils.isNotBlank(budgetOrder.getInsideJob())) {
            SYSUser InsideJob = sysUserBO.getUser(budgetOrder.getInsideJob());
            budgetOrder.setInsideJobName(InsideJob.getRealName());
        }
        // SYSBizLog bizLog = sysBizLogBO.getApplyBudgetOrderOperator(
        // budgetOrder.getCode(),
        // EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode());
        // if (null != bizLog && StringUtils.isNotBlank(bizLog.getOperator())) {
        // SYSUser operator = sysUserBO.getUser(bizLog.getOperator());
        // budgetOrder.setInsideJob(operator.getRealName());//
        // 内勤（使用这个业务单在日志表的最新操作人）
        // }
        return budgetOrder;
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageForBizReport(int start,
            int limit, BudgetOrder condition, String userId) {
        SYSUser user = sysUserBO.getUser(userId);
        if (ESysRole.SALE.getCode().equals(user.getRoleCode())) {
            condition.setSaleUserId(userId);
        } else if (ESysRole.YWNQ.getCode().equals(user.getRoleCode())) {
            condition.setInsideJob(userId);
        }
        Paginable<BudgetOrder> paginable = budgetOrderBO.getPaginable(start,
                limit, condition);
        List<BudgetOrder> list = paginable.getList();
        for (BudgetOrder budgetOrder : list) {
            initBizReport(budgetOrder);
        }
        return paginable;
    }

    private BudgetOrder initBizReport(BudgetOrder budgetOrder) {
        SYSUser saleUser = sysUserBO.getUser(budgetOrder.getSaleUserId());
        budgetOrder.setSaleUserName(saleUser.getRealName());// 信贷专员
        if (StringUtils.isNotBlank(budgetOrder.getInsideJob())) {
            SYSUser InsideJob = sysUserBO.getUser(budgetOrder.getInsideJob());
            budgetOrder.setInsideJobName(InsideJob.getRealName());
        }
        // SYSBizLog bizLog = sysBizLogBO.getApplyBudgetOrderOperator(
        // budgetOrder.getCode(),
        // EBudgetOrderNode.WRITE_BUDGET_ORDER.getCode());
        // if (null != bizLog && StringUtils.isNotBlank(bizLog.getOperator())) {
        // SYSUser operator = sysUserBO.getUser(bizLog.getOperator());
        // budgetOrder.setInsideJob(operator.getRealName());//
        // 内勤（使用这个业务单在日志表的最新操作人）
        // }
        CreditUser user = null;
        //****待处理*****
        //creditUserBO.getCreditUserByCreditCode(
        //budgetOrder.getCreditCode(), ECreditUserLoanRole.APPLY_USER);
        budgetOrder.setContactNo(user.getMobile());// 联系电话
        long cardTotalFee = 0;
        long bankFee = 0;
        long teamFee = 0;
        long companyFee = 0;
        if (null != budgetOrder.getBankFee()) {
            bankFee = budgetOrder.getBankFee();
        }
        if (null != budgetOrder.getTeamFee()) {
            teamFee = budgetOrder.getTeamFee();
        }
        if (null != budgetOrder.getCompanyFee()) {
            companyFee = budgetOrder.getCompanyFee();
        }
        cardTotalFee = bankFee + teamFee + companyFee;// 刷卡总手续费=团队服务费+银行服务费+公司服务费
        budgetOrder.setCardTotalFee(String.valueOf(cardTotalFee));
        // 刷卡总金额 = 贷款金额+刷卡总手续费
        long loanAmount = 0;
        if (null != budgetOrder.getLoanAmount()) {
            loanAmount = budgetOrder.getLoanAmount();
        }
        Long cardTotalAmount = loanAmount + cardTotalFee;
        budgetOrder.setCardTotalAmount(String.valueOf(cardTotalAmount));
        return budgetOrder;
    }

    @Override
    public Object queryBudgetOrderPageForProgress(XN632913Req req) {
        BudgetOrder condition = new BudgetOrder();
        condition.setApplyUserNameForQuery(req.getApplyUserName());
        if (StringUtils.isNotBlank(req.getEnterStatus())) {
            if (req.getEnterStatus().equals(EBoolean.YES.getCode())) {
                // 已入档
                condition
                        .setCurNodeCode(EBudgetOrderNode.ARCHIVE_END.getCode());
            } else {
                // 未入档
                condition.setCurNodeCodeNoEnter(EBudgetOrderNode.ARCHIVE_END
                        .getCode());
            }
        }

        SYSUser user = sysUserBO.getUser(req.getUserId());
        if (user.getRoleCode().equals(ESysRole.SALE.getCode())) {
            condition.setSaleUserId(req.getUserId());
        }
        if (user.getRoleCode().equals(ESysRole.YWNQ.getCode())
                || user.getRoleCode().equals(ESysRole.LEADER.getCode())) {
            condition.setTeamCode(user.getTeamCode());
        }

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        Paginable<BudgetOrder> page = budgetOrderBO.getPaginable(start, limit,
                condition);
        if (page != null && CollectionUtils.isNotEmpty(page.getList())) {
            for (BudgetOrder budgetOrder : page.getList()) {
                if (EBudgetOrderNode.ARCHIVE_END.getCode().equals(
                        budgetOrder.getCurNodeCode())) {
                    budgetOrder.setEnterStatus(EBoolean.YES.getCode());
                } else {
                    budgetOrder.setEnterStatus(EBoolean.NO.getCode());
                }
                initBudgetOrder(budgetOrder);
            }
        }
        return page;
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageForLoanLater(
            XN632914Req req) {
        BudgetOrder condition = new BudgetOrder();
        condition.setApplyUserNameForQuery(req.getApplyUserName());
        condition.setRegion(req.getRegion());
        condition.setLoanBank(req.getLoanBank());
        condition.setPledgeStatus(req.getPledgeStatus());
        condition.setCurNodeCode(req.getCurNodeCode());
        condition.setRepayBizCodeNotNull("贷后业务单");
        if (StringUtils.isNotBlank(req.getIsCancel())) {
            if (EBoolean.YES.getCode().equals(req.getIsCancel())) {
                // 作废
                condition.setCurNodeCode(EBudgetOrderNode.CANCEL_END.getCode());
            } else {
                condition.setCurNodeCodeNoCancel(EBudgetOrderNode.CANCEL_END
                        .getCode());
            }
        }
        if (StringUtils.isNotBlank(req.getEnterStatus())) {
            // 归档
            if (EBoolean.YES.getCode().equals(req.getEnterStatus())) {
                ArrayList<String> arrayList = new ArrayList<String>();
                if (StringUtils.isNotBlank(condition.getCurNodeCode())) {
                    arrayList.add(condition.getCurNodeCode());
                }
                arrayList.add(EBudgetOrderNode.ARCHIVE_END.getCode());
                condition.setCurNodeCodeList(arrayList);
            } else {
                condition.setCurNodeCodeNoEnter(EBudgetOrderNode.ARCHIVE_END
                        .getCode());
            }
        }

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        Paginable<BudgetOrder> page = budgetOrderBO.getPaginable(start, limit,
                condition);
        List<BudgetOrder> list = page.getList();
        for (BudgetOrder budgetOrder : list) {
            if (EBudgetOrderNode.CANCEL_END.getCode().equals(
                    budgetOrder.getCurNodeCode())) {
                budgetOrder.setIsCancel(EBoolean.YES.getCode());// 是
            } else {
                budgetOrder.setIsCancel(EBoolean.NO.getCode());// 否
            }
            if (EBudgetOrderNode.ARCHIVE_END.getCode().equals(
                    budgetOrder.getCurNodeCode())) {
                budgetOrder.setEnterStatus(EBoolean.YES.getCode());
            } else {
                budgetOrder.setEnterStatus(EBoolean.NO.getCode());
            }
            initBudgetOrder(budgetOrder);
        }
        return page;
    }

    @Override
    public List<BudgetOrder> queryBudgetOrderByApplyUserName(
            BudgetOrder condition) {
        return budgetOrderBO.queryBudgetOrderByApplyUserName(condition);
    }

    @Override
    public Paginable<BudgetOrder> queryBudgetOrderPageByUserId(int start,
            int limit, BudgetOrder condition) {
        return budgetOrderBO.queryBudgetOrderPageByUserId(start, limit,
                condition);
    }

    private void lastApprove(BudgetOrder budgetOrder, String operator) {
        /**************生成 手续费************/
        BudgetOrderFee budgetOrderFee = budgetOrderFeeBO
                .getBudgetOrderFeeByBudget(budgetOrder.getCode());
        if (budgetOrderFee == null) {
            budgetOrderFeeBO.saveBudgetOrderFee(budgetOrder, operator);
        }
        /**************生成 手续费************/
        // // 征信单回写准入单编号
        // Credit credit = creditBO.getCredit(budgetOrder.getCreditCode());
        // credit.setBudgetCode(budgetOrder.getCode());
        // creditBO.refreshCredit(credit);

        LoanProduct loanProduct = loanProductBO.getLoanProduct(budgetOrder
                .getLoanProductCode());
        if (StringUtils.isNotBlank(budgetOrder.getTeamCode())) {
            /**************生成返点数据***************/
            Repoint repoint = new Repoint();
            // 应返金额=准入单的贷款金额*准入单的贷款产品的返点比例
            Long loanAmount = budgetOrder.getLoanAmount();
            BizTeam bizTeam = bizTeamBO.getBizTeam(budgetOrder.getTeamCode());
            repoint.setTeamCode(budgetOrder.getTeamCode());
            repoint.setCaptain(bizTeam.getCaptain());
            repoint.setBizCode(budgetOrder.getCode());
            repoint.setAccountNo(bizTeam.getAccountNo());

            repoint.setBank(bizTeam.getBank());
            repoint.setSubbranch(bizTeam.getSubbranch());
            double backRate = loanProduct.getReturnPointRate();
            long shouldAmount = AmountUtil.mul(loanAmount, backRate);
            repoint.setShouldAmount(shouldAmount);

            repoint.setStatus(ERepointStatus.TODO.getCode());
            repoint.setUpdater(operator);
            repoint.setUpdateDatetime(new Date());
            repointBO.saveRepoint(repoint);
            /**************生成返点数据***************/

            /*************生成调查报告****************/
            InvestigateReport report = new InvestigateReport();
            report.setBudgetOrderCode(budgetOrder.getCode());
            List<InvestigateReport> reportList = investigateReportBO
                    .queryInvestigateReportList(report);
            if (CollectionUtils.isEmpty(reportList)) {
                InvestigateReport investigateReport = new InvestigateReport();
                investigateReport.setBudgetOrderCode(budgetOrder.getCode());
                investigateReport
                        .setRepayBizCode(budgetOrder.getRepayBizCode());
                investigateReport.setCompanyCode(budgetOrder.getCompanyCode());
                investigateReport.setBizType(budgetOrder.getBizType());
                investigateReport.setTeamCode(budgetOrder.getTeamCode());
                investigateReport.setApplyUserName(budgetOrder
                        .getApplyUserName());
                investigateReport.setApplyDatetime(new Date());
                investigateReport.setLoanBank(budgetOrder.getLoanBank());
                investigateReport.setLoanAmount(budgetOrder.getLoanAmount());
                investigateReport.setLoanPeriod(budgetOrder.getLoanPeriod());
                investigateReport.setIsAdvanceFund(budgetOrder
                        .getIsAdvanceFund());
                investigateReport.setSaleUserId(budgetOrder.getSaleUserId());
                String gender = budgetOrder.getGender();
                if (gender == "1") {
                    gender = "男";
                } else {
                    gender = "女";
                }
                String education = budgetOrder.getEducation();
                if (education == "1") {
                    education = "博士及以上";
                } else if (education == "2") {
                    education = "硕士";
                } else if (education == "3") {
                    education = "大学本科";
                } else if (education == "4") {
                    education = "大学专科";
                } else {
                    education = "高中及以下";
                }
                String marryState = budgetOrder.getMarryState();
                if (marryState == "1") {
                    marryState = "未婚";
                } else if (marryState == "2") {
                    marryState = "已婚";
                } else if (marryState == "3") {
                    marryState = "离异";
                } else {
                    marryState = "丧偶";
                }
                String customerInformation = "借款人:"
                        + budgetOrder.getApplyUserName() + ", "
                        + budgetOrder.getAge() + "岁, " + marryState + ", "
                        + "性别：" + gender + ", " + "学历：" + education + ", "
                        + "民族：" + budgetOrder.getNation() + ", " + "身份证号："
                        + budgetOrder.getIdNo() + ", " + "政治面貌："
                        + budgetOrder.getPolitical() + ", " + "户口所在地："
                        + budgetOrder.getResidenceAddress() + ", " + "现在家庭住址："
                        + budgetOrder.getNowAddress() + ", " + "联系电话："
                        + budgetOrder.getMobile() + ", " + "家有"
                        + budgetOrder.getFamilyNumber() + "口人，" + "邮编："
                        + budgetOrder.getPostCode1() + ",   " + "借款人无重大疾病，身体健康";
                investigateReport.setCustomerInformation(customerInformation);
                CreditUser domain = null;
                //****待处理*****
                //creditUserBO.getCreditUserByCreditCode(
                //budgetOrder.getCreditCode(), ECreditUserLoanRole.APPLY_USER);
                investigateReport.setBankCreditResultRemark(domain
                        .getBankCreditResultRemark());
                investigateReport.setJourDatetimeStart(budgetOrder
                        .getJourDatetimeStart());
                investigateReport.setZfbJourDatetimeEnd(budgetOrder
                        .getZfbJourDatetimeEnd());

                investigateReport.setZfbJourInterest1(budgetOrder
                        .getZfbJourInterest1());
                investigateReport.setZfbJourInterest2(budgetOrder
                        .getZfbJourInterest2());
                investigateReport
                        .setZfbInterest1(budgetOrder.getZfbInterest1());
                investigateReport
                        .setZfbInterest2(budgetOrder.getZfbInterest2());

                investigateReport.setZfbJourIncome(budgetOrder
                        .getZfbJourIncome());
                investigateReport.setZfbJourExpend(budgetOrder
                        .getZfbJourExpend());
                investigateReport.setZfbJourBalance(budgetOrder
                        .getZfbJourBalance());
                investigateReport.setZfbJourMonthIncome(budgetOrder
                        .getZfbJourMonthIncome());
                investigateReport.setZfbJourMonthExpend(budgetOrder
                        .getZfbJourMonthExpend());
                investigateReport.setZfbJourPic(budgetOrder.getZfbJourPic());
                investigateReport.setZfbJourRemark(budgetOrder
                        .getZfbJourRemark());

                investigateReport.setWxJourDatetimeStart(budgetOrder
                        .getWxJourDatetimeStart());
                investigateReport.setWxJourDatetimeEnd(budgetOrder
                        .getWxJourDatetimeEnd());
                investigateReport.setWxJourInterest1(budgetOrder
                        .getWxJourInterest1());
                investigateReport.setWxJourInterest2(budgetOrder
                        .getWxJourInterest2());
                investigateReport.setWxInterest1(budgetOrder.getWxInterest1());
                investigateReport.setWxInterest2(budgetOrder.getWxInterest2());

                investigateReport
                        .setWxJourIncome(budgetOrder.getWxJourIncome());
                investigateReport
                        .setWxJourExpend(budgetOrder.getWxJourExpend());
                investigateReport.setWxJourBalance(budgetOrder
                        .getWxJourBalance());
                investigateReport.setWxJourMonthIncome(budgetOrder
                        .getWxJourMonthIncome());
                investigateReport.setWxJourMonthExpend(budgetOrder
                        .getWxJourMonthExpend());
                investigateReport.setWxJourPic(budgetOrder.getWxJourPic());
                investigateReport
                        .setWxJourRemark(budgetOrder.getWxJourRemark());

                investigateReport.setJourDatetimeStart(budgetOrder
                        .getJourDatetimeStart());
                investigateReport.setJourDatetimeEnd(budgetOrder
                        .getJourDatetimeEnd());
                investigateReport.setJourInterest1(budgetOrder
                        .getJourInterest1());
                investigateReport.setJourInterest2(budgetOrder
                        .getJourInterest2());
                investigateReport.setInterest1(budgetOrder.getInterest1());
                investigateReport.setInterest2(budgetOrder.getInterest2());

                investigateReport.setJourIncome(budgetOrder.getJourIncome());
                investigateReport.setJourExpend(budgetOrder.getJourExpend());
                investigateReport.setJourBalance(budgetOrder.getJourBalance());
                investigateReport.setJourMonthIncome(budgetOrder
                        .getJourMonthIncome());
                investigateReport.setJourMonthExpend(budgetOrder
                        .getJourMonthExpend());
                investigateReport.setJourPic(budgetOrder.getJourPic());
                investigateReport.setJourRemark(budgetOrder.getJourRemark());

                investigateReport.setHouseContract(budgetOrder
                        .getHouseContract());
                investigateReport
                        .setHousePicture(budgetOrder.getHousePicture());
                String basicsInformation = "品牌：" + budgetOrder.getCarBrand()
                        + "," + "车型：" + budgetOrder.getCarModel() + ","
                        + "新手指导价" + budgetOrder.getOriginalPrice() / 1000 + ","
                        + "落户地点：" + budgetOrder.getSettleAddress();
                investigateReport.setBasicsInformation(basicsInformation);
                investigateReport
                        .setCurNodeCode(EInvestigateReportNode.COMMIT_APPLY
                                .getCode());
                String irCode = investigateReportBO
                        .saveInvestigateReport(investigateReport);
                // 日志记录
                sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
                        EBizLogType.INVESTIGATEREPORT, irCode,
                        investigateReport.getCurNodeCode());
            }
            /*************生成调查报告****************/
        }
    }

}
