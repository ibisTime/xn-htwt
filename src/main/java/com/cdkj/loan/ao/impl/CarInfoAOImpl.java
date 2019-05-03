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
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepointBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.BudgetOrderFee;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.domain.LoanProduct;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.Repoint;
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
import com.cdkj.loan.enums.EDealType;
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

    @Transactional
    @Override
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
        repayBizBO.removeByBizCode(req.getCode());
        repayBizBO.saveRepayBiz(req);

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
                req.getPledgeUserIdCardCopy(), req.getPledgeAddress());

        // 征信人
        List<CreditUser> creditUsers = creditUserBO.queryCreditUserList(req
                .getCode());
        creditUserBO.refreshCreditUsers(creditUsers, req);

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
            bizTaskBO.handlePreBizTask(EBizLogType.BUDGET_ORDER.getCode(),
                    req.getCode(), ENode.getMap().get(preNodeCode));
        }
        ENode node = ENode.getMap().get(preNodeCode);

        // 待办事项
        bizTaskBO.saveBizTask(req.getCode(), EBizLogType.BUDGET_ORDER,
                req.getCode(), node, null);
    }

    @Transactional
    @Override
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

        cdbizBO.refreshCurNodeCode(cdbiz, preCurrentNode);

        // 状态更新
        cdbizBO.refreshStatus(cdbiz, status);

        // 待办事项
        bizTaskBO.saveBizTask(code, EBizLogType.BUDGET_ORDER, code, node, null);

    }

    @Override
    public void internalApprove(String code, String approveResult,
            String approveNote, String operator) {

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
        cdbizBO.refreshCurNodeCode(cdbiz, preCurrentNode);

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
        cdbizBO.refreshCurNodeCode(cdbiz, preCurrentNode);

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
        cdbizBO.refreshCurNodeCode(cdbiz, preCurrentNode);

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
        cdbizBO.refreshCurNodeCode(cdbiz, preCurrentNode);
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
        if (!ECdbizStatus.H3.getCode().equals(cdbiz.getMakeCardStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "制卡流程未走完，不能操作");
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
            } else {
                advanceBO.saveAdvance(req.getCode());
            }
            // 待办事项
            bizTaskBO.saveBizTask(req.getCode(), EBizLogType.fbh,
                    req.getCode(), node, null);
            // 发保合状态更新
            cdbizBO.refreshFbhgpsStatus(cdbiz, fbhgpsStatus);

            // 主节点
            preCurrentNode = ENode.submit_1.getCode();
            // 生成报告、返点、费用
            lastApprove(cdbiz, req.getOperator());
        } else {
            preCurrentNode = nodeFlow.getBackNode();
            status = ECdbizStatus.A3x.getCode();
            // 待办事项
            bizTaskBO.saveBizTask(req.getCode(), EBizLogType.BUDGET_ORDER,
                    req.getCode(), ENode.getMap().get(preCurrentNode), null);
        }
        cdbizBO.refreshCurNodeCode(cdbiz, preCurrentNode);

        cdbizBO.refreshStatus(cdbiz, status, req.getApproveNote());

    }

    @Override
    public void inputLoanInfo(XN632530Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        if (!ECdbizStatus.A3.getCode().equals(cdbiz.getStatus())
                && !ECdbizStatus.A3x.getCode().equals(cdbiz.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该业务不处于录入准入单状态，无法录入");
        }

        //判断主表对应的还款业务是否存在，存在则修改，不存在则新增
        RepayBiz repayBiz = repayBizBO.getRepayBizByBizCode(req.getCode());
        if (repayBiz == null) {
            repayBizBO.saveRepayBiz(req);
        } else {
            repayBizBO.refreshRepayBiz(repayBiz, req);
        }

        //判断车辆信息是否存在，存在则修改，不存在则新增
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        if (carInfo == null) {
            carInfoBO.saveCarInfo(req);
        } else {
            carInfoBO.refreshCarInfo(carInfo, req);
        }

        cdbizBO.refreshCdbiz(cdbiz, req);

    }

    @Override
    public void inputCarInfo(XN632531Req req) {
        Cdbiz cdbiz = cdbizBO.getCdbiz(req.getCode());
        //判断车辆信息是否存在，存在则修改，不存在则新增
        CarInfo carInfo = carInfoBO.getCarInfoByBizCode(req.getCode());
        if (carInfo == null) {
            carInfoBO.saveCarInfo(req);
        } else {
            carInfoBO.refreshCarInfo(carInfo, req);
        }

        attachmentBO.removeByKname(req.getCode(), EAttachName.carPic.getCode());
        attachmentBO.saveAttachment(req.getCode(), EAttachName.carPic.getCode(),
                EAttachName.carPic.getValue(), req.getCarPic());
        attachmentBO.removeByKname(req.getCode(), EAttachName.otherPdf.getCode());
        attachmentBO.saveAttachment(req.getCode(), EAttachName.otherPdf.getCode(),
                EAttachName.otherPdf.getValue(), req.getCarHgzPic());

        cdbizBO.refreshCdbiz(cdbiz, req);
    }

    @Override
    public void inputJourInfo(XN632537Req req) {
        creditJourBO.removeBizJour(req.getCode());
        ArrayList<CreditJour> jourList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(req.getJourList())) {
            for (XN632537Res res : req.getJourList()) {
                res.setBizCode(req.getCode());
                CreditJour creditJour = new CreditJour();
                EntityUtils.copyData(res, creditJour);
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
        // // 征信单回写准入单编号
        // Credit credit = creditBO.getCredit(budgetOrder.getCreditCode());
        // credit.setBudgetCode(budgetOrder.getCode());
        // creditBO.refreshCredit(credit);

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
            double backRate = loanProduct.getBackRate();
            long shouldAmount = AmountUtil.mul(loanAmount, backRate);
            repoint.setShouldAmount(shouldAmount);

            repoint.setStatus(ERepointStatus.TODO.getCode());
            repoint.setUpdater(operator);
            repoint.setUpdateDatetime(new Date());
            repointBO.saveRepoint(repoint);
            /**************生成返点数据***************/

            // /*************生成调查报告****************/
            // InvestigateReport report = new InvestigateReport();
            // report.setBudgetOrderCode(budgetOrder.getCode());
            // List<InvestigateReport> reportList = investigateReportBO
            // .queryInvestigateReportList(report);
            // if (CollectionUtils.isEmpty(reportList)) {
            // InvestigateReport investigateReport = new InvestigateReport();
            // investigateReport.setBudgetOrderCode(budgetOrder.getCode());
            // investigateReport
            // .setRepayBizCode(budgetOrder.getRepayBizCode());
            // investigateReport.setCompanyCode(budgetOrder.getCompanyCode());
            // investigateReport.setBizType(budgetOrder.getBizType());
            // investigateReport.setTeamCode(budgetOrder.getTeamCode());
            // investigateReport.setApplyUserName(budgetOrder
            // .getApplyUserName());
            // investigateReport.setApplyDatetime(new Date());
            // investigateReport.setLoanBank(budgetOrder.getLoanBank());
            // investigateReport.setLoanAmount(budgetOrder.getLoanAmount());
            // investigateReport.setLoanPeriod(budgetOrder.getLoanPeriod());
            // investigateReport.setIsAdvanceFund(budgetOrder
            // .getIsAdvanceFund());
            // investigateReport.setSaleUserId(budgetOrder.getSaleUserId());
            // String gender = budgetOrder.getGender();
            // if (gender == "1") {
            // gender = "男";
            // } else {
            // gender = "女";
            // }
            // String education = budgetOrder.getEducation();
            // if (education == "1") {
            // education = "博士及以上";
            // } else if (education == "2") {
            // education = "硕士";
            // } else if (education == "3") {
            // education = "大学本科";
            // } else if (education == "4") {
            // education = "大学专科";
            // } else {
            // education = "高中及以下";
            // }
            // String marryState = budgetOrder.getMarryState();
            // if (marryState == "1") {
            // marryState = "未婚";
            // } else if (marryState == "2") {
            // marryState = "已婚";
            // } else if (marryState == "3") {
            // marryState = "离异";
            // } else {
            // marryState = "丧偶";
            // }
            // String customerInformation = "借款人:"
            // + budgetOrder.getApplyUserName() + ", "
            // + budgetOrder.getAge() + "岁, " + marryState + ", "
            // + "性别：" + gender + ", " + "学历：" + education + ", "
            // + "民族：" + budgetOrder.getNation() + ", " + "身份证号："
            // + budgetOrder.getIdNo() + ", " + "政治面貌："
            // + budgetOrder.getPolitical() + ", " + "户口所在地："
            // + budgetOrder.getResidenceAddress() + ", " + "现在家庭住址："
            // + budgetOrder.getNowAddress() + ", " + "联系电话："
            // + budgetOrder.getMobile() + ", " + "家有"
            // + budgetOrder.getFamilyNumber() + "口人，" + "邮编："
            // + budgetOrder.getPostCode1() + ", " + "借款人无重大疾病，身体健康";
            // investigateReport.setCustomerInformation(customerInformation);
            // CreditUser domain = creditUserBO.getCreditUserByCreditCode(
            // budgetOrder.getCreditCode(), ECreditUserLoanRole.APPLY_USER);
            // investigateReport.setBankCreditResultRemark(domain
            // .getBankCreditResultRemark());
            // investigateReport.setJourDatetimeStart(budgetOrder
            // .getJourDatetimeStart());
            // investigateReport.setZfbJourDatetimeEnd(budgetOrder
            // .getZfbJourDatetimeEnd());
            //
            // investigateReport.setZfbJourInterest1(budgetOrder
            // .getZfbJourInterest1());
            // investigateReport.setZfbJourInterest2(budgetOrder
            // .getZfbJourInterest2());
            // investigateReport
            // .setZfbInterest1(budgetOrder.getZfbInterest1());
            // investigateReport
            // .setZfbInterest2(budgetOrder.getZfbInterest2());
            //
            // investigateReport.setZfbJourIncome(budgetOrder
            // .getZfbJourIncome());
            // investigateReport.setZfbJourExpend(budgetOrder
            // .getZfbJourExpend());
            // investigateReport.setZfbJourBalance(budgetOrder
            // .getZfbJourBalance());
            // investigateReport.setZfbJourMonthIncome(budgetOrder
            // .getZfbJourMonthIncome());
            // investigateReport.setZfbJourMonthExpend(budgetOrder
            // .getZfbJourMonthExpend());
            // investigateReport.setZfbJourPic(budgetOrder.getZfbJourPic());
            // investigateReport.setZfbJourRemark(budgetOrder
            // .getZfbJourRemark());
            //
            // investigateReport.setWxJourDatetimeStart(budgetOrder
            // .getWxJourDatetimeStart());
            // investigateReport.setWxJourDatetimeEnd(budgetOrder
            // .getWxJourDatetimeEnd());
            // investigateReport.setWxJourInterest1(budgetOrder
            // .getWxJourInterest1());
            // investigateReport.setWxJourInterest2(budgetOrder
            // .getWxJourInterest2());
            // investigateReport.setWxInterest1(budgetOrder.getWxInterest1());
            // investigateReport.setWxInterest2(budgetOrder.getWxInterest2());
            //
            // investigateReport
            // .setWxJourIncome(budgetOrder.getWxJourIncome());
            // investigateReport
            // .setWxJourExpend(budgetOrder.getWxJourExpend());
            // investigateReport.setWxJourBalance(budgetOrder
            // .getWxJourBalance());
            // investigateReport.setWxJourMonthIncome(budgetOrder
            // .getWxJourMonthIncome());
            // investigateReport.setWxJourMonthExpend(budgetOrder
            // .getWxJourMonthExpend());
            // investigateReport.setWxJourPic(budgetOrder.getWxJourPic());
            // investigateReport
            // .setWxJourRemark(budgetOrder.getWxJourRemark());
            //
            // investigateReport.setJourDatetimeStart(budgetOrder
            // .getJourDatetimeStart());
            // investigateReport.setJourDatetimeEnd(budgetOrder
            // .getJourDatetimeEnd());
            // investigateReport.setJourInterest1(budgetOrder
            // .getJourInterest1());
            // investigateReport.setJourInterest2(budgetOrder
            // .getJourInterest2());
            // investigateReport.setInterest1(budgetOrder.getInterest1());
            // investigateReport.setInterest2(budgetOrder.getInterest2());
            //
            // investigateReport.setJourIncome(budgetOrder.getJourIncome());
            // investigateReport.setJourExpend(budgetOrder.getJourExpend());
            // investigateReport.setJourBalance(budgetOrder.getJourBalance());
            // investigateReport.setJourMonthIncome(budgetOrder
            // .getJourMonthIncome());
            // investigateReport.setJourMonthExpend(budgetOrder
            // .getJourMonthExpend());
            // investigateReport.setJourPic(budgetOrder.getJourPic());
            // investigateReport.setJourRemark(budgetOrder.getJourRemark());
            //
            // investigateReport.setHouseContract(budgetOrder
            // .getHouseContract());
            // investigateReport
            // .setHousePicture(budgetOrder.getHousePicture());
            // String basicsInformation = "品牌：" + budgetOrder.getCarBrand()
            // + "," + "车型：" + budgetOrder.getCarModel() + ","
            // + "新手指导价" + budgetOrder.getOriginalPrice() / 1000 + ","
            // + "落户地点：" + budgetOrder.getSettleAddress();
            // investigateReport.setBasicsInformation(basicsInformation);
            // investigateReport
            // .setCurNodeCode(EInvestigateReportNode.COMMIT_APPLY
            // .getCode());
            // String irCode = investigateReportBO
            // .saveInvestigateReport(investigateReport);
            // // 日志记录
            // sysBizLogBO.saveSYSBizLog(budgetOrder.getCode(),
            // EBizLogType.INVESTIGATEREPORT, irCode,
            // investigateReport.getCurNodeCode());
            // }
            // /*************生成调查报告****************/
        }
    }

}