package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.bo.IAdvanceBO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IBizTaskBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IBudgetOrderFeeBO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.ICarPledgeBO;
import com.cdkj.loan.bo.ICdbizBO;
import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.ICreditUserExtBO;
import com.cdkj.loan.bo.ILoanProductBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.INodeBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSDictBO;
import com.cdkj.loan.bo.impl.InvestigateReportBOImpl;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.domain.SYSDict;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632143Req;
import com.cdkj.loan.dto.req.XN632500Req;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;
import com.cdkj.loan.dto.req.XN632537Req;
import com.cdkj.loan.dto.res.XN632537Res;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EAttachName;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.ECdbizStatus;
import com.cdkj.loan.enums.ECreditJourType;
import com.cdkj.loan.enums.ECreditUserLoanRole;
import com.cdkj.loan.enums.EDealType;
import com.cdkj.loan.enums.EInvestigateReportNode;
import com.cdkj.loan.enums.ELogisticsCurNodeType;
import com.cdkj.loan.enums.ELogisticsType;
import com.cdkj.loan.enums.ENode;
import com.cdkj.loan.enums.ERepointStatus;
import com.cdkj.loan.exception.BizException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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

    @Autowired
    private IBudgetOrderFeeBO budgetOrderFeeBO;

    @Autowired
    private ILoanProductBO loanProductBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private IRepointBO repointBO;

    @Autowired
    private IAdvanceBO advanceBO;

    @Autowired
    private ICarPledgeBO carPledgeBO;

    @Autowired
    private InvestigateReportBOImpl investigateReportBO;

    @Autowired
    private INodeBO nodeBO;

    @Autowired
    private ISYSDictBO sysDictBO;

    @Autowired
    private ILogisticsBO logisticsBO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inputBudgetOrder(XN632500Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A3.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A3x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务不处于录入准入单状态，无法录入");
        }
        // 业务信息更新
        cdbiz.setIsAdvanceFund(req.getIsAdvanceFund());
        cdbiz.setIsFinacing(req.getIsFinacing());
        cdbiz.setIsGpsAz(req.getIsAzGps());
        cdbizBO.refreshCdbiz(cdbiz);

        // 车辆信息录入
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        String carInfoCode = carInfo.getCode();
        EntityUtils.copyData(req, carInfo);
        carInfo.setCode(carInfoCode);
        carInfoBO.refreshCarInfo(carInfo);

        // 贷款信息
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(req.getCode());
        String code = repayBiz.getCode();
        EntityUtils.copyData(req, repayBiz);
        repayBiz.setCode(code);
        repayBizBO.refreshRepayBiz(repayBiz);

        // 征信人信息录入
        creditUserExtBO.removeBizUserExt(req.getCode());
        CreditUserExt creditUserExt = EntityUtils.copyData(req,
                CreditUserExt.class);
        creditUserExt.setMonthIncome(StringValidater.toLong(req
                .getMonthIncome()));
        creditUserExt.setIsSiteProve(req.getIsSelfCompany());
        creditUserExt.setCarType(req.getCarTypeNow());
        creditUserExtBO.saveCreditUserExt(creditUserExt, cdbiz.getCode());

        // 附件录入
        carInfoBO.saveAttachment(req);

        // 抵押
        carPledgeBO.removeCarpledge(req.getCode());
        carPledgeBO.saveCarPledge(req.getCode(), req.getPledgeUser(),
                req.getPledgeUserIdCard(), req.getPledgeAddress());

        // 征信人
        List<CreditUser> creditUsers = creditUserBO.queryCreditUserList(req
                .getCode());
        creditUserBO.refreshCreditUsers(creditUsers, req);

        String preNodeCode = cdbiz.getCurNodeCode(); // 当前节点
        String curNodeCode;
        if (EDealType.SEND.getCode().equals(req.getDealType())) {
            // 日志记录
            sysBizLogBO.recordCurOperate(req.getCode(),
                    EBizLogType.BUDGET_ORDER, req.getCode(), preNodeCode, null,
                    req.getOperator());
            // 下一个节点
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preNodeCode)
                    .getNextNode();

            cdbizBO.refreshCurNodeCode(cdbiz, curNodeCode);
            // 业务状态变化
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A4.getCode());
            // 处理待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER,
                    cdbiz.getCode(), cdbiz.getCode(), preNodeCode, curNodeCode,
                    req.getOperator());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int editCarInfo(XN632120Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A3.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A3x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务不处于录入准入单状态，无法录入");
        }
        // 业务信息更新
        cdbiz.setIsAdvanceFund(req.getIsAdvanceFund());
        cdbiz.setIsFinacing(req.getIsFinacing());
        cdbizBO.refreshCdbiz(cdbiz);
        // 车辆信息录入
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        String carInfoCode = carInfo.getCode();
        EntityUtils.copyData(req, carInfo);
        carInfo.setCode(carInfoCode);
        carInfoBO.refreshCarInfo(carInfo);

        // 征信人信息录入
        creditUserExtBO.removeBizUserExt(req.getCode());
        CreditUserExt creditUserExt = EntityUtils.copyData(req,
                CreditUserExt.class);

        creditUserExtBO.saveCreditUserExt(creditUserExt, cdbiz.getCode());
        // 流水录入
        creditJourBO.removeBizJour(req.getCode());
        creditJourBO.saveCreditJour(req);

        // 贷款信息
        repayBizBO.removeByBizCode(req.getCode());
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

            cdbizBO.refreshCurNodeCode(cdbiz, preNodeCode);
            // 业务状态变化
            cdbizBO.refreshStatus(cdbiz, ECdbizStatus.A4.getCode());
            // 处理待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER,
                    cdbiz.getCode(), cdbiz.getCode(), preNodeCode, preNodeCode,
                    req.getOperator());
        }
        ENode node = ENode.getMap().get(preNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.BUDGET_ORDER,
                req.getCode(), node, null);
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void areaApprove(String code, String approveResult,
            String approveNote, String operator) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);

        Node node = nodeBO.getNode(cdbiz.getCurNodeCode());

        if (!ENode.area_approve_budget.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是"
                    + node.getName() + "节点，不能操作");
        }

        // 当前节点
        String preCurrentNode = cdbiz.getCurNodeCode();

        String status;
        String curNodeCode;
        if (EApproveResult.PASS.getCode().equals(approveResult)) {

            if (!ECdbizStatus.B03.getCode().equals(cdbiz.getIntevStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "面签流程未走完，不能操作");
            }

            status = ECdbizStatus.A5.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getNextNode();
        } else {
            status = ECdbizStatus.A3x.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getBackNode();
        }

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(cdbiz.getBizCode(),
                EBizLogType.BUDGET_ORDER, code, preCurrentNode, approveNote,
                operator);

        // 处理前并产生后面的待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, code, code,
                preCurrentNode, curNodeCode, operator);

        // 状态更新节点
        cdbiz.setCurNodeCode(curNodeCode);
        cdbiz.setStatus(status);
        cdbizBO.refreshCurNodeStatus(cdbiz);

    }

    @Override
    public void internalApprove(String code, String approveResult,
            String approveNote, String operator) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void riskOneApprove(String code, String approveResult,
            String approveNote, String operator) {

        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        Node node = nodeBO.getNode(cdbiz.getCurNodeCode());
        if (!ENode.fk_fir_approve.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "该业务当前状态不是"
                    + node.getName() + "状态，不能操作");
        }

        // 当前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status;
        String curNodeCode;
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            status = ECdbizStatus.A6.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getNextNode();
        } else {
            status = ECdbizStatus.A3x.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getBackNode();
        }

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
                preCurrentNode, approveNote, operator);
        // 完成待办事项并产生下一条
        bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, code, code,
                preCurrentNode, curNodeCode, operator);

        // 业务更新状态节点
        cdbiz.setStatus(status);
        cdbiz.setCurNodeCode(curNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void riskTwoApprove(String code, String carPriceCheckReport,
            String housePicture, String approveResult, String approveNote,
            String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        Node node = nodeBO.getNode(cdbiz.getCurNodeCode());
        if (!ENode.fk_sec_approve.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是"
                    + node.getName() + "节点，不能操作");
        }

        // 当前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status;
        String curNodeCode;
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            status = ECdbizStatus.A7.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getNextNode();
        } else {
            status = ECdbizStatus.A3x.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getBackNode();
        }
        // 状态节点改变
        cdbiz.setStatus(status);
        cdbiz.setCurNodeCode(curNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

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

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
                preCurrentNode, approveNote, operator);
        // 完成待办事项
        bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, code, code,
                preCurrentNode, curNodeCode, operator);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        Node node = nodeBO.getNode(cdbiz.getCurNodeCode());
        if (!ENode.fk_finish_approve.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是"
                    + node.getName() + "节点，不能操作");
        }

        // 当前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status;
        String curNodeCode;
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            status = ECdbizStatus.A8.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getNextNode();
        } else {
            status = ECdbizStatus.A3x.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getBackNode();
        }

        cdbiz.setStatus(status);
        cdbiz.setCurNodeCode(curNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
                preCurrentNode, approveNote, operator);
        // 完成待办事项并产生下一条
        bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, code, code,
                preCurrentNode, curNodeCode, operator);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void yBizChargeApprove(String code, String operator,
            String approveResult, String approveNote) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        Node node = nodeBO.getNode(cdbiz.getCurNodeCode());
        if (!ENode.yw_approve_budget.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是"
                    + node.getName() + "节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status;
        String curNodeCode;
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            status = ECdbizStatus.A9.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getNextNode();

        } else {
            status = ECdbizStatus.A3x.getCode();
            curNodeCode = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode)
                    .getBackNode();
        }
        cdbiz.setStatus(status);
        cdbiz.setCurNodeCode(curNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
                preCurrentNode, approveNote, operator);
        // 完成待办并产生下一条
        bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, code, code,
                preCurrentNode, curNodeCode, operator);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void financeAudit(XN632143Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        Node curNode = nodeBO.getNode(cdbiz.getCurNodeCode());
        // 之前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status = null;
        String curNodeCode = null;
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurrentNode);
        if (!ENode.cw_approve_budget.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "当前节点不是"
                    + curNode.getName() + "节点，不能操作");
        }

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            if (!ECdbizStatus.H3.getCode().equals(cdbiz.getMakeCardStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "制卡流程未走完，不能操作");
            }
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
            } else {
                advanceBO.saveAdvance(req.getCode());
            }
            // 待办事项
            bizTaskBO.saveBizTaskNew(req.getCode(), EBizLogType.fbh,
                    req.getCode(), node.getCode());

            // 发保合状态节点更新
            cdbiz.setFbhgpsStatus(fbhgpsStatus);
            cdbiz.setFbhgpsNode(node.getCode());
            cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

            // 主节点
            curNodeCode = ENode.submit_1.getCode();
            // 生成报告、返点、费用
            lastApprove(cdbiz, req.getOperator());
        } else {
            curNodeCode = nodeFlow.getBackNode();
            status = ECdbizStatus.A3x.getCode();
            // 待办事项
            bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, req.getCode(),
                    req.getCode(), preCurrentNode, curNodeCode, req.getOperator());
        }

        cdbiz.setStatus(status);
        cdbiz.setCurNodeCode(curNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(req.getCode(), EBizLogType.BUDGET_ORDER,
                req.getCode(), preCurrentNode, req.getApproveNote(),
                req.getOperator());
        // 完成待办事项主流程待办
        bizTaskBO.handlePreAndAdd(EBizLogType.BUDGET_ORDER, req.getCode(),
                req.getCode(), preCurrentNode, curNodeCode, req.getOperator());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void headCompanyApprove(String code, String approveResult,
            String approveNote, String operator) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(code);
        if (!ENode.headCompanyApprove.getCode().equals(cdbiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是审核节点，不能操作");
        }
        // 之前节点
        String preCurrentNode = cdbiz.getCurNodeCode();
        String status = null;
        String curNodeCode = null;

        // 查找当前节点的最新待办
//        BizTask bizTask = bizTaskBO.queryLastBizTask(cdbiz.getCode(), null,
//                null, preCurrentNode);
//        bizTaskBO.handleBizTask(bizTask.getCode(), operator);
        bizTaskBO.handlePreBizTask(cdbiz.getCode(), EBizLogType.BUDGET_ORDER.getCode(),
                cdbiz.getCode(), preCurrentNode, operator);

        if (EApproveResult.PASS.getCode().equals(approveResult)) {

            if (!ECdbizStatus.B03.getCode().equals(cdbiz.getIntevStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "面签流程未走完，不能操作");
            }
            if (!ECdbizStatus.H3.getCode().equals(cdbiz.getMakeCardStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "制卡流程未走完，不能操作");
            }

            // 生成资料传递
            String logisticsCode = logisticsBO.saveLogistics(
                    ELogisticsType.BUDGET.getCode(),
                    ELogisticsCurNodeType.SALE_SEND_BANK_LOAN.getCode(),
                    cdbiz.getCode(), cdbiz.getSaleUserId(),
                    ENode.submit_1.getCode(), ENode.receive_approve_1.getCode(),
                    null);

            // 资料传递日志:银行放款第一步，用记录日志的开始方法
            sysBizLogBO.saveFirstSYSBizLog(code, EBizLogType.LOGISTICS,
                    logisticsCode, ENode.submit_1.getCode(),
                    ENode.receive_approve_1.getCode(), operator);
            // 资料传递待办
            bizTaskBO.saveBizTaskNew(code, EBizLogType.LOGISTICS,
                    logisticsCode, ENode.submit_1.getCode());

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
                bizTaskBO.saveBizTaskNew(code, EBizLogType.fbh, code, node.getCode());
            } else {
                advanceBO.saveAdvance(code);
                bizTaskBO.saveBizTaskNew(code, EBizLogType.fund, code, node.getCode());
            }
            // 待办事项

            // 发保合状态节点更新
            cdbiz.setFbhgpsStatus(fbhgpsStatus);
            cdbiz.setFbhgpsNode(node.getCode());
            cdbizBO.refreshFbhgpsNodeStatus(cdbiz);

            // 主节点
            curNodeCode = ENode.submit_1.getCode();
            // 生成报告、返点、费用
            lastApprove(cdbiz, operator);
        } else {
            curNodeCode = ENode.renew_budget.getCode();
            status = ECdbizStatus.A3x.getCode();
            // 待办事项
            bizTaskBO.saveBizTaskNew(code, EBizLogType.BUDGET_ORDER, code,
                    ENode.renew_budget.getCode());
        }

        cdbiz.setStatus(status);
        cdbiz.setCurNodeCode(curNodeCode);
        cdbizBO.refreshCurNodeStatus(cdbiz);

        // 日志记录
        sysBizLogBO.saveNewSYSBizLog(code, EBizLogType.BUDGET_ORDER, code,
                preCurrentNode, approveNote, operator);
    }

    @Override
    public void inputLoanInfo(XN632530Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A3.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A3x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务不处于录入准入单状态，无法录入");
        }

        // 判断主表对应的还款业务是否存在，存在则修改，不存在则新增
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(req.getCode());
        if (repayBiz == null) {
            repayBizBO.saveRepayBiz(req);
        } else {
            repayBizBO.refreshRepayBiz(repayBiz, req);
        }

        cdbiz.setLoanAmount(StringValidater.toLong(req.getLoanAmount()));
        cdbizBO.refreshCdbiz(cdbiz);

        // 公司服务费计算公式：
        // 1、前置产品：贷款额*前置利率；
        // 2、非前置产品：(贷款额*(年化利率*3-9)/100)/(1+前置利率)）
        // 公司服务费
        LoanProduct loanProduct = loanProductBO.getLoanProduct(req
                .getLoanProductCode());
        Long companyFee;
        if (EBoolean.YES.getCode().equals(loanProduct.getIsPre())) {
            companyFee = AmountUtil.mul(
                    StringValidater.toLong(req.getLoanAmount()),
                    loanProduct.getPreRate());
        } else {
            double rate = (loanProduct.getYearRate() * 100 * 3 - 9) / 100;
            companyFee = AmountUtil.div(AmountUtil.mul(
                    StringValidater.toLong(req.getLoanAmount()), rate), loanProduct
                    .getPreRate() + 1);
        }

        // 银行服务费=贷款金额 * 贷款产品前置利率/ (1 +贷款产品前置利率)；
        Long bankFee = AmountUtil.mul(cdbiz.getLoanAmount(),
                loanProduct.getPreRate() / (1.0 + loanProduct.getPreRate()));

        // 判断车辆信息是否存在，存在则修改，不存在则新增
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        if (carInfo == null) {
            CarInfo data = new CarInfo();
            data.setCompanyFee(companyFee);
            data.setBankFee(bankFee);
            carInfoBO.saveCarInfo(req, data);
        } else {
            carInfo.setCompanyFee(companyFee);
            carInfo.setBankFee(bankFee);
            carInfoBO.refreshCarInfo(carInfo, req);
        }

        cdbizBO.refreshCdbiz(cdbiz, req);

    }

    @Override
    public void inputCarInfo(XN632531Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        // 判断车辆信息是否存在，存在则修改，不存在则新增
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        if (carInfo == null) {
            carInfoBO.saveCarInfo(req);
        } else {
            carInfoBO.refreshCarInfo(carInfo, req);
        }

        attachmentBO.saveAttachment(req.getCode(),
                EAttachName.carPic.getCode(), EAttachName.carPic.getValue(),
                req.getCarPic());
        attachmentBO.saveAttachment(req.getCode(),
                EAttachName.carHgzPic.getCode(), EAttachName.carHgzPic.getValue(),
                req.getCarHgzPic());

        cdbizBO.refreshCdbiz(cdbiz, req);
    }

    @Override
    @Transactional
    public void inputJourInfo(XN632537Req req) {
        cdbizBO.getCdbiz(req.getCode());
        creditJourBO.removeBizJour(req.getCode());
        ArrayList<CreditJour> jourList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(req.getJourList())) {
            for (XN632537Res res : req.getJourList()) {
                res.setBizCode(req.getCode());
                CreditJour creditJour = new CreditJour();
                creditJour.setCode(OrderNoGenerater.generate("CJ"));
                EntityUtils.copyData(res, creditJour);
                creditJour.setDatetimeStart(DateUtil.strToDate(
                        res.getDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
                creditJour.setDatetimeEnd(DateUtil.strToDate(
                        res.getDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
                jourList.add(creditJour);
            }
            creditJourBO.saveCreditJourList(jourList);
        }
    }

    private void lastApprove(Cdbiz cdbiz, String operator) {
        /**************生成 手续费************/
        BudgetOrderFee budgetOrderFee = budgetOrderFeeBO
                .getBudgetOrderFeeByBudget(cdbiz.getCode());
        if (budgetOrderFee == null) {
            budgetOrderFeeBO.saveBudgetOrderFee(cdbiz, operator);
        }
        /**************生成 手续费************/

        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(cdbiz.getCode());
        LoanProduct loanProduct = loanProductBO.getLoanProduct(repayBiz
                .getLoanProductCode());
        if (StringUtils.isNotBlank(cdbiz.getTeamCode())) {
            /**************生成返点数据***************/
            Repoint repoint = new Repoint();
            // 应返金额=准入单的贷款金额*准入单的贷款产品的返点比例
            Long loanAmount = cdbiz.getLoanAmount();
            BizTeam bizTeam = bizTeamBO.getBizTeam(cdbiz.getTeamCode());
            repoint.setTeamCode(cdbiz.getTeamCode());
            repoint.setCaptain(bizTeam.getCaptain());
            repoint.setBizCode(cdbiz.getCode());
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
            report.setBudgetOrderCode(cdbiz.getCode());
            List<InvestigateReport> reportList = investigateReportBO
                    .queryInvestigateReportList(report);
            if (CollectionUtils.isEmpty(reportList)) {

                // 申请人
                CreditUser applyUser = creditUserBO.getCreditUserByBizCode(
                        cdbiz.getCode(), ECreditUserLoanRole.APPLY_USER);

                InvestigateReport investigateReport = new InvestigateReport();
                investigateReport.setBudgetOrderCode(cdbiz.getCode());
                investigateReport.setRepayBizCode(cdbiz.getRepayBizCode());
                investigateReport.setCompanyCode(cdbiz.getCompanyCode());
                investigateReport.setBizType(cdbiz.getBizType());
                investigateReport.setTeamCode(cdbiz.getTeamCode());
                investigateReport.setApplyUserName(applyUser.getUserName());
                investigateReport.setApplyDatetime(new Date());
                investigateReport.setLoanBank(cdbiz.getLoanBank());
                investigateReport.setLoanAmount(cdbiz.getLoanAmount());
                investigateReport.setLoanPeriod(repayBiz.getPeriods()
                        .toString());
                investigateReport.setIsAdvanceFund(cdbiz.getIsAdvanceFund());
                investigateReport.setSaleUserId(cdbiz.getSaleUserId());
                String gender = applyUser.getGender();
                // 学历
                String education;
                SYSDict educationDict = sysDictBO
                        .getSYSDictByParentKeyAndDkey("education", applyUser.getEducation());
                if (educationDict != null) {
                    education = educationDict.getDvalue();
                } else {
                    education = "无";
                }
                // 婚姻状况
                String marryState;
                SYSDict marryStateDict = sysDictBO
                        .getSYSDictByParentKeyAndDkey("marry_state", applyUser.getMarryState());
                if (educationDict != null) {
                    marryState = marryStateDict.getDvalue();
                } else {
                    marryState = "无";
                }
                // 政治面貌
                String politics;
                SYSDict politicsDict = sysDictBO
                        .getSYSDictByParentKeyAndDkey("politics", applyUser.getMarryState());
                if (politicsDict != null) {
                    politics = politicsDict.getDvalue();
                } else {
                    politics = "无";
                }
                String customerInformation = "借款人:" + applyUser.getUserName()
                        + ", " + applyUser.getAge() + "岁, " + marryState + ", "
                        + "性别：" + gender + ", " + "学历：" + education + ", "
                        + "民族：" + applyUser.getNation() + ", " + "身份证号："
                        + applyUser.getIdNo() + ", " + "政治面貌："
                        + politics + ", " + "户口所在地："
                        + applyUser.getBirthAddressProvince()
                        + applyUser.getBirthAddressCity()
                        + applyUser.getBirthAddressArea()
                        + applyUser.getBirthAddress() + ", " + "现在家庭住址："
                        + applyUser.getNowAddressProvince()
                        + applyUser.getNowAddressCity()
                        + applyUser.getNowAddressArea()
                        + applyUser.getNowAddress() + ", " + "联系电话："
                        + applyUser.getMobile() + ", " + "家有"
                        + applyUser.getFamilyNumber() + "口人，" + "邮编："
                        + applyUser.getNowPostCode() + ", " + "借款人无重大疾病，身体健康";
                investigateReport.setCustomerInformation(customerInformation);
                investigateReport.setBankCreditResultRemark(applyUser
                        .getBankCreditResultRemark());

                // 流水
                List<CreditJour> creditJourList = creditJourBO.getCreditJourByCondition(
                        cdbiz.getCode(), applyUser.getCode());

                if (!CollectionUtils.isEmpty(creditJourList)) {
                    for (CreditJour creditJour : creditJourList) {
                        if (ECreditJourType.wx.getCode().equals(creditJour.getType())) {
                            investigateReport.setWxJourDatetimeStart(creditJour
                                    .getDatetimeStart());
                            investigateReport.setWxJourDatetimeEnd(creditJour
                                    .getDatetimeEnd());

                            investigateReport.setWxJourInterest1(creditJour
                                    .getJourInterest1().toString());
                            investigateReport.setWxJourInterest2(creditJour
                                    .getJourInterest2().toString());
                            investigateReport.setWxInterest1(creditJour.getInterest1()
                                    .longValue());
                            investigateReport.setWxInterest2(creditJour.getInterest2()
                                    .longValue());

                            investigateReport.setWxJourIncome(creditJour.getIncome()
                                    .longValue());
                            investigateReport.setWxJourExpend(creditJour.getExpend()
                                    .longValue());
                            investigateReport.setWxJourBalance(creditJour.getBalance()
                                    .longValue());
                            investigateReport.setWxJourMonthIncome(creditJour
                                    .getMonthIncome().longValue());
                            investigateReport.setWxJourMonthExpend(creditJour
                                    .getMonthExpend().longValue());
                            investigateReport.setWxJourPic(creditJour.getPic());
                            investigateReport.setWxJourRemark(creditJour.getRemark());
                        } else if (ECreditJourType.zfb.getCode().equals(creditJour.getType())) {
                            investigateReport.setZfbJourDatetimeStart(creditJour
                                    .getDatetimeStart());
                            investigateReport.setZfbJourDatetimeEnd(creditJour
                                    .getDatetimeEnd());

                            investigateReport.setZfbJourInterest1(creditJour
                                    .getJourInterest1().toString());
                            investigateReport.setZfbJourInterest2(creditJour
                                    .getJourInterest2().toString());
                            investigateReport.setZfbInterest1(creditJour.getInterest1()
                                    .longValue());
                            investigateReport.setZfbInterest2(creditJour.getInterest2()
                                    .longValue());

                            investigateReport.setZfbJourIncome(creditJour.getIncome()
                                    .longValue());
                            investigateReport.setZfbJourExpend(creditJour.getExpend()
                                    .longValue());
                            investigateReport.setZfbJourBalance(creditJour.getBalance()
                                    .longValue());
                            investigateReport.setZfbJourMonthIncome(creditJour
                                    .getMonthIncome().longValue());
                            investigateReport.setZfbJourMonthExpend(creditJour
                                    .getMonthExpend().longValue());
                            investigateReport.setZfbJourPic(creditJour.getPic());
                            investigateReport.setZfbJourRemark(creditJour.getRemark());
                        } else {
                            investigateReport.setJourDatetimeStart(creditJour
                                    .getDatetimeStart());
                            investigateReport.setJourDatetimeEnd(creditJour
                                    .getDatetimeEnd());

                            investigateReport.setJourInterest1(creditJour
                                    .getJourInterest1().toString());
                            investigateReport.setJourInterest2(creditJour
                                    .getJourInterest2().toString());
                            investigateReport.setInterest1(creditJour.getInterest1()
                                    .longValue());
                            investigateReport.setInterest2(creditJour.getInterest2()
                                    .longValue());

                            investigateReport.setJourIncome(creditJour.getIncome()
                                    .longValue());
                            investigateReport.setJourExpend(creditJour.getExpend()
                                    .longValue());
                            investigateReport.setJourBalance(creditJour.getBalance()
                                    .longValue());
                            investigateReport.setJourMonthIncome(creditJour
                                    .getMonthIncome().longValue());
                            investigateReport.setJourMonthExpend(creditJour
                                    .getMonthExpend().longValue());
                            investigateReport.setJourPic(creditJour.getPic());
                            investigateReport.setJourRemark(creditJour.getRemark());

                        }
                    }
                }
                // 家纺照片
                Attachment housePicture = attachmentBO.getAttachment(
                        cdbiz.getCode(), "credit_user_ext", "house_picture_apply");
                if (housePicture != null) {
                    investigateReport.setHousePicture(housePicture.getUrl());
                }

                // 车辆信息
                CarInfo carInfo = carInfoBO
                        .getCarInfoByBizCode(cdbiz.getCode());

                String basicsInformation = "品牌：" + carInfo.getCarBrand()
                        + ", 车系：" + carInfo.getCarSeries() + ", 车型："
                        + carInfo.getCarModel() + ", 新手指导价:"
                        + StringValidater.toLong(carInfo.getOriginalPrice())
                        / 1000 + ", 落户地点：" + carInfo.getSettleAddress();
                investigateReport.setBasicsInformation(basicsInformation);
                investigateReport
                        .setCurNodeCode(EInvestigateReportNode.COMMIT_APPLY
                                .getCode());
                String irCode = investigateReportBO
                        .saveInvestigateReport(investigateReport);
                // 日志记录
                sysBizLogBO.saveFirstSYSBizLog(cdbiz.getCode(),
                        EBizLogType.INVESTIGATEREPORT, irCode,
                        investigateReport.getCurNodeCode(), null, operator);
            }
            /*************生成调查报告****************/
        }
    }

}
