package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IOrderAO;
import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBankcardBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IChannelBankBO;
import com.cdkj.loan.bo.INodeFlowBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSConfigBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.SysConstants;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bankcard;
import com.cdkj.loan.domain.BizTeam;
import com.cdkj.loan.domain.NodeFlow;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630510Req;
import com.cdkj.loan.dto.req.XN630511Req;
import com.cdkj.loan.dto.req.XN630513Req;
import com.cdkj.loan.dto.req.XN630515Req;
import com.cdkj.loan.dto.req.XN630516Req;
import com.cdkj.loan.dto.req.XN630551Req;
import com.cdkj.loan.dto.req.XN630555Req;
import com.cdkj.loan.dto.req.XN630557Req;
import com.cdkj.loan.dto.req.XN630561Req;
import com.cdkj.loan.dto.req.XN630562Req;
import com.cdkj.loan.dto.req.XN630563Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EJudicialLitigationEntryWay;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.enums.ERepayPlanSuggest;
import com.cdkj.loan.enums.ESysRole;
import com.cdkj.loan.enums.EtrailerManageResult;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepayBizAOImpl implements IRepayBizAO {

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private IBankcardBO bankcardBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IOrderAO orderAO;

    @Autowired
    private ISYSConfigBO sysConfigBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IChannelBankBO channelBankBO;

    @Autowired
    private INodeFlowBO nodeFlowBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    // 变更银行卡
    @Override
    public void editBankcardNew(XN630510Req req) {
        String code = bankcardBO.saveBankcardBiz(req);
        repayBizBO.refreshBankcardNew(req.getCode(), code, req.getUpdater(),
                req.getRemark());
    }

    // 变更银行卡
    @Override
    public void editBankcardModify(XN630511Req req) {
        bankcardBO.getBankcard(req.getCode());
        repayBizBO.refreshBankcardModify(req.getCode(), req.getBankcardCode(),
                req.getUpdater(), req.getRemark());
    }

    private void setRefInfo(RepayBiz repayBiz) {
        repayBiz.setUser(userBO.getUser(repayBiz.getUserId()));

        //还款计划
        RepayPlan condition = new RepayPlan();
        condition.setOrder("cur_periods", true);
        condition.setRepayBizCode(repayBiz.getCode());
        List<RepayPlan> repayPlanList = repayPlanBO
                .queryRepayPlanList(condition);
        repayBiz.setRepayPlanList(repayPlanList);

//        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
//            repayBiz.setBudgetOrder(
//                    budgetOrderAO.getBudgetOrder(repayBiz.getRefCode()));
//        } else {
//            repayBiz.setMallOrder(orderAO.getOrder(repayBiz.getRefCode()));
//        }

//        Long deposit = repayBiz.getLyDeposit() - repayBiz.getCutLyDeposit();
        Long amount = 0L;
        Long retreatDeposit = repayBiz.getLyDeposit();
        for (RepayPlan repayPlan : repayPlanList) {
            // 实际退款金额
            Long shouldDeposit = repayPlan.getShouldDeposit();
//            deposit = deposit + shouldDeposit;
            // 借款余额
            Long overplusAmount = repayPlan.getOverplusAmount();
            amount = amount + overplusAmount;

            // 可退押金金额
            retreatDeposit += repayPlan.getOverdueDeposit();
        }
        repayBiz.setRetreatDeposit(retreatDeposit);
//        repayBiz.setActualRefunds(deposit);
        repayBiz.setLoanBalance(amount);

        RepayPlan overdueRepayPlan = repayPlanBO.getRepayPlanByRepayBizCode(
                repayBiz.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayBiz.setOverdueRepayPlan(overdueRepayPlan);
        if (null != repayBiz.getTeamCode() && "" != repayBiz.getTeamCode()) {
            BizTeam bizTeam = bizTeamBO.getBizTeam(repayBiz.getTeamCode());
            repayBiz.setBizTeam(bizTeam);
            SYSUser sysUser = sysUserBO.getUser(bizTeam.getCaptain());
            repayBiz.setLeadUser(sysUser);
        }
    }

    // 提前还款
    @Override
    @Transactional
    public void advanceRepay(String code, String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
            advanceRepayCarLoan(code, repayBiz);
        } else {
            advanceRepayProductLoan(code, repayBiz);
        }
    }

    @Override
    @Transactional
    public void prepaymentApply(XN630515Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.TO_REPAY.getCode()
                .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于还款中");
        }
        // 判断还款计划中是否含有催收失败，进红名单处理，红名单处理中的状态，有则有逾期
        List<RepayPlan> planList = repayPlanBO
                .queryRepayPlanListByRepayBizCode(req.getCode());
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.HANDLER_TO_RED.getCode()
                    .equals(repayPlan.getCurNodeCode())
                    || ERepayPlanNode.QKCSB_APPLY_TC.getCode()
                    .equals(repayPlan.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "当前有逾期未处理完成的还款计划，不能提前还款！");
            }
        }
        // 当前节点
        String preCurNodeCode = repayBiz.getCurNodeCode();
        repayBiz.setCurNodeCode(ERepayBizNode.PREPAYMENT_APPROVE.getCode());
        repayBiz.setIsAdvanceSettled(EBoolean.YES.getCode());
        repayBiz.setPaperPhoto(req.getPaperPhoto());
        repayBiz.setUpdater(req.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.prepaymentApply(repayBiz);

        // 日志记录
        sysBizLogBO.recordCurOperate(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, req.getCode(), preCurNodeCode,
                req.getRemark(), req.getUpdater());
        sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(), EBizLogType.REPAY_BIZ,
                req.getCode(), repayBiz.getCurNodeCode());
    }

    @Override
    @Transactional
    public void prepaymentApprove(XN630516Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.PREPAYMENT_APPROVE.getCode()
                .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处提前还款审核节点，不能操作！");
        }
        // 当前节点
        String preCurNodeCode = repayBiz.getCurNodeCode();
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(preCurNodeCode);
        if (EBoolean.YES.getCode().equals(req.getApproveResult())) {
            repayBiz.setCurNodeCode(nodeFlow.getNextNode());
        } else {
            repayBiz.setCurNodeCode(nodeFlow.getBackNode());
            repayBiz.setIsAdvanceSettled(EBoolean.NO.getCode());
        }
        repayBiz.setUpdater(req.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(req.getApproveNote());
        repayBizBO.prepaymentApprove(repayBiz);

        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, req.getCode(), preCurNodeCode,
                repayBiz.getCurNodeCode(), req.getApproveNote(), req.getUpdater());
    }

    // 车贷订单提前还款
    private void advanceRepayCarLoan(String code, RepayBiz repayBiz) {
        if (!ERepayBizNode.TO_REPAY.getCode()
                .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于还款中");
        }

        // 判断还款计划中是否含有催收失败，进红名单处理，红名单处理中的状态，有则有逾期
        List<RepayPlan> planList = repayPlanBO
                .queryRepayPlanListByRepayBizCode(code);
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.HANDLER_TO_RED.getCode()
                    .equals(repayPlan.getCurNodeCode())
                    || ERepayPlanNode.QKCSB_APPLY_TC.getCode()
                    .equals(repayPlan.getCurNodeCode())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "当前有逾期未处理完成的还款计划，不能提前还款！");
            }
        }

        // 提前还款服务费
        Long fwAmount = sysConfigBO.getLongValue(SysConstants.TQ_SERVICE);
        // 代扣总金额
        Long allAmount = repayBiz.getRestAmount() + fwAmount;
        // 代扣银行卡
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());
        // 必须扣全部，要么扣成功，要么扣失败，不能扣部分金额
        Long realWithholdAmount = baofuWithhold(bankcard, allAmount);
        // 更新还款业务
        repayBizBO.refreshAdvanceRepayCarLoan(repayBiz, realWithholdAmount);
        // 改变还款计划状态
        for (RepayPlan repayPlan : planList) {
            if (ERepayPlanNode.TO_REPAY.getCode()
                    .equals(repayPlan.getCurNodeCode())) {
                // 更新还款计划
                repayPlanBO.repaySuccess(repayPlan, repayPlan.getRepayAmount());
            }
        }
    }

    // 产品订单提前还款
    private void advanceRepayProductLoan(String code, RepayBiz repayBiz) {
        if (!ERepayBizNode.PRO_TO_REPAY.getCode()
                .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于还款中");
        }

        int count = repayPlanBO.getTotalCount(repayBiz.getCode(),
                ERepayPlanNode.PRD_TO_REPAY);
        if (count <= 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务已还完！");
        }

        // 提前还款服务费
        Long fwAmount = sysConfigBO.getLongValue(SysConstants.TQ_SERVICE);
        // 代扣总金额
        Long allAmount = repayBiz.getRestAmount() + fwAmount;
        // 代扣银行卡
        Bankcard bankcard = bankcardBO.getBankcard(repayBiz.getBankcardCode());
        // 必须扣全部，要么扣成功，要么扣失败，不能扣部分金额
        Long realWithholdAmount = baofuWithhold(bankcard, allAmount);
        // 更新还款业务
        repayBizBO.refreshRepayAllProduct(code, realWithholdAmount);
        // 改变还款计划状态
        RepayPlan rpCondition = new RepayPlan();
        rpCondition.setCurNodeCode(ERepayPlanNode.TO_REPAY.getCode());
        rpCondition.setRepayBizCode(repayBiz.getCode());
        List<RepayPlan> rpList = repayPlanBO.queryRepayPlanList(rpCondition);
        if (CollectionUtils.isNotEmpty(rpList)) {
            for (RepayPlan repayPlan : rpList) {
                if (ERepayPlanNode.TO_REPAY.getCode()
                        .equals(repayPlan.getCurNodeCode())) {
                    repayPlan
                            .setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());
                    repayPlanBO.refreshRepayPlanCurNodeCode(repayPlan);
                }
            }
        }
    }

    private Long baofuWithhold(Bankcard bankcard, Long amount) {
        Long successAmount = 0L;
        // TODO 宝付代扣逻辑
        successAmount = amount;
        return successAmount;
    }

    @Override
    public void enterBlackListProduct(String code, String blackHandleNote,
            String updater, String remark) {
        // TODO 验证还款业务状态，以及业务类型是否是产品
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        repayBiz.setBlackHandleNote(blackHandleNote);
        repayBiz.setCurNodeCode(ERepayBizNode.PRO_BAD_DEBT.getCode());
        repayBiz.setUpdater(updater);
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(remark);
        repayBizBO.refreshEnterBlackList(repayBiz);

        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(code);
        List<RepayPlan> planList = repayPlanBO.queryRepayPlanList(condition);
        for (RepayPlan repayPlan : planList) {
            repayPlan
                    .setCurNodeCode(ERepayPlanNode.PRD_HANDLER_TO_BLACK.getCode());
            repayPlanBO.refreshToBlackProduct(repayPlan);
        }
    }

    @Override
    @Transactional
    public void confirmSettledProduct(XN630513Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        if (!ERepayBizNode.PRO_SETTLED.getCode()
                .equals(repayBiz.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前产品状态不是已还款，不能确认结清！");
        }

        // 更新还款业务
        repayBiz.setCurNodeCode(ERepayBizNode.PRO_CONFIRM_SETTLE.getCode());
        repayBiz.setCutLyDeposit(StringValidater.toLong(req.getCutLyDeposit()));
        repayBiz.setUpdater(req.getUpdater());
        repayBiz.setUpdateDatetime(new Date());
        repayBiz.setRemark(req.getRemark());
        repayBizBO.confirmSettledProduct(repayBiz);
    }

    @Override
    @Transactional
    public void approveByQkcsDepartment(String code, Long cutLyDeposit,
            String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();// 当前节点
        if (!ERepayBizNode.QKCS_DEPART_CHECK.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于清欠催收部审核中");
        }

        String nextNodeCode = getNextNodeCode(preCurNodeCode,
                EBoolean.YES.getCode());

        repayBizBO.approveByQkcsDepartment(repayBiz, nextNodeCode, cutLyDeposit,
                updater, remark);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                nextNodeCode, remark, updater);

    }

    @Override
    public void approveByBankCheck(XN630551Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.BANK_CHECK.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于驻行人员审核中");
        }

        String nextNodeCode = getNextNodeCode(preCurNodeCode,
                req.getApproveResult());

        repayBizBO.approveByBankCheck(req.getCode(), nextNodeCode,
                DateUtil.strToDate(req.getSettleDatetime(),
                        DateUtil.FRONT_DATE_FORMAT_STRING),
                req.getSettleAttach(), req.getOperator(), req.getRemark());
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                nextNodeCode, req.getRemark(), req.getOperator());
    }

    @Override
    public void approveByManager(String code, String approveResult,
            String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.MANAGER_CHECK.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于总经理审核中");
        }

        String nextNodeCode = getNextNodeCode(preCurNodeCode, approveResult);
        repayBizBO.approveByManager(code, nextNodeCode, updater, remark);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                nextNodeCode, remark, updater);
    }

    @Override
    public void approveByFinance(String code, String approveResult,
            String updater, String remark) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.FINANCE_CHECK.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于财务审核中");
        }

        String nextNodeCode = getNextNodeCode(preCurNodeCode, approveResult);
        repayBizBO.approveByFinance(code, nextNodeCode, updater, remark);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                nextNodeCode, remark, updater);
    }

    @Override
    public void releaseMortgage(String code, Date releaseDatetime,
            String updater) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.RELEASE_MORTGAGE.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务不处于解除抵押中");
        }

        String nextNodeCode = getNextNodeCode(preCurNodeCode,
                EBoolean.YES.getCode());
        repayBizBO.releaseMortgage(code, nextNodeCode, releaseDatetime,
                updater);
        // 日志
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ.getCode(),
                repayBiz.getCode(), preCurNodeCode, null, updater);

    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPage(int start, int limit,
            RepayBiz condition) {
        Paginable<RepayBiz> results = repayBizBO.getPaginable(start, limit,
                condition);
        for (RepayBiz repayBiz : results.getList()) {
            setRefInfo(repayBiz);
        }
        return results;
    }

    @Override
    public Paginable<RepayBiz> queryRepayBizPageByRoleCode(int start, int limit,
            RepayBiz condition, String userId) {
        SYSUser user = sysUserBO.getUser(userId);
        BizTeam bizTeam = bizTeamBO.getBizTeam(user.getTeamCode());
        if (bizTeam != null) {
            //判断是否是团队长（团队只有业务员）
            if (ESysRole.SALE.getCode().equals(user.getRoleCode())) {
                if (user.getUserId().equals(bizTeam.getCaptain())) {
                    condition.setTeamCode(user.getTeamCode());
                } else {
                    condition.setSaleUserId(condition.getUserId());
                }
            }
        }
        if (ESysRole.YWNQ.getCode().equals(user.getRoleCode())) {
            condition.setInsideJob(condition.getUserId());
        }
        condition.setRoleCode(user.getRoleCode());

        Paginable<RepayBiz> paginable = repayBizBO.getPaginableByRoleCode(start,
                limit, condition);
        for (RepayBiz repayBiz : paginable.getList()) {
            setRefInfo(repayBiz);
        }
        return paginable;
    }

    @Override
    public List<RepayBiz> queryRepayBizList(RepayBiz condition) {
        return repayBizBO.queryRepayBizList(condition);
    }

    @Override
    public RepayBiz getRepayBiz(String code) {
        // 查询实际退款金额
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        setRefInfo(repayBiz);
        return repayBiz;
    }

    // 申请拖车逻辑：
    // 1、前提条件：还款计划是“催收失败，进红名单处理”；再更改还款业务状态
    @Override
    @Transactional
    public void applyTrailer(XN630555Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = repayBiz.getCurNodeCode();// 划款业务当前节点

        RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
                req.getCode(), ERepayPlanNode.HANDLER_TO_RED);
        if (repayPlan == null) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "还款业务中没有进红名单处理的还款计划！");
        }

        repayPlan.setCurNodeCode(ERepayPlanNode.QKCSB_APPLY_TC.getCode());
        repayPlan.setTsCarAmount(StringValidater.toLong(req.getTsCarAmount()));
        repayPlan.setTsBankcardNumber(req.getTsBankcardNumber());
        repayPlan.setTsBankName(req.getTsBankName());

        repayPlan.setTsSubbranch(req.getTsSubbranch());
        repayPlan.setTcApplyNote(req.getTcApplyNote());
        repayPlanBO.applyTrailer(repayPlan);

        repayBiz.setCurNodeCode(ERepayBizNode.FINANCE_REMIT.getCode());
        repayBiz.setUpdater(req.getOperator());
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.applyTrailer(repayBiz);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                repayBiz.getCurNodeCode(), req.getTcApplyNote(), req.getOperator());
    }

    @Override
    public void financialMoney(String code, String operator, String remitAmount,
            String remitPdf) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.FINANCE_REMIT.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是财务打款节点，不能操作！");
        }
        RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(code,
                ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlan.setRemitAmount(StringValidater.toLong(remitAmount));
        repayPlan.setRemitBillPdf(remitPdf);
        repayPlanBO.financialMoney(repayPlan);

        repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_TOTC.getCode());
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.financialMoney(repayBiz);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                repayBiz.getCurNodeCode(), null, operator);
    }

    @Override
    public void trailerEntry(XN630557Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.QKCSB_TOTC.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是清欠催收部拖车结果待录入节点，不能操作！");
        }
        RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
                req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlan.setTakeCarAddress(req.getTakeCarAddress());
        repayPlan.setTakeDatetime(DateUtil.strToDate(req.getTakeDatetime(),
                DateUtil.FRONT_DATE_FORMAT_STRING));
        repayPlan.setTakeLocation(req.getTakeLocation());
        repayPlan.setTakeName(req.getTakeName());
        repayPlan.setTakeNote(req.getTakeNote());
        repayPlanBO.trailerEntry(repayPlan);

        repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_TC_INPUT.getCode());
        repayBiz.setUpdater(req.getOperator());
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.trailerEntry(repayBiz);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                repayBiz.getCurNodeCode(), req.getTakeNote(), req.getOperator());
    }

    @Override
    public void trailerManage(String code, String appoveResult,
            String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.QKCSB_TC_INPUT.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是清欠催收部拖车结果已录入节点，不能操作！");
        }
        if (EtrailerManageResult.USER_REDEEM.getCode().equals(appoveResult)) {
            repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_REDEEM_APPLY.getCode());
        } else {
            repayBiz.setCurNodeCode(ERepayBizNode.JUDICIAL_LAWSUIT.getCode());
        }
        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.trailerManage(repayBiz);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                repayBiz.getCurNodeCode(), null, operator);
    }

    @Override
    public void judicialLitigationEntry(String code, String buyOutAmount,
            String way, String operator) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(code);
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.JUDICIAL_LAWSUIT.getCode().equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是司法诉讼节点，不能操作！");
        }
        RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(code,
                ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlan.setBuyOutAmount(StringValidater.toLong(buyOutAmount));
        if (EJudicialLitigationEntryWay.BAD_DEBT.getCode().equals(way)) {
            repayPlan.setCurNodeCode(ERepayPlanNode.BAD_DEBT.getCode());
            repayBiz.setCurNodeCode(ERepayBizNode.BAD_DEBT.getCode());
        } else if (EJudicialLitigationEntryWay.TEAN_BUY_OUT.getCode()
                .equals(way)) {
            repayPlan.setCurNodeCode(ERepayPlanNode.TEAN_BUY_OUT.getCode());
            repayBiz.setCurNodeCode(ERepayBizNode.TEAN_BUY_OUT.getCode());
        } else {
            repayPlan.setCurNodeCode(ERepayPlanNode.TEAM_RENT.getCode());
            repayBiz.setCurNodeCode(ERepayBizNode.TEAM_RENT.getCode());
        }
        repayPlanBO.judicialLitigationEntry(repayPlan);

        repayBiz.setUpdater(operator);
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.judicialLitigationEntry(repayBiz);
        // 日志
        sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ.getCode(),
                repayBiz.getCode(), preCurNodeCode, null, operator);
    }

    @Override
    public void qkcsbRedeemApply(XN630561Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.QKCSB_REDEEM_APPLY.getCode()
                .equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是清欠催收部申请赎回节点，不能操作！");
        }
        RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
                req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlan.setJourPdf(req.getJourPdf());
        repayPlan.setGuaNote(req.getGuaNote());
        repayPlan.setGuaName(req.getGuaName());
        repayPlan.setGuaMobile(req.getGuaMobile());
        repayPlan.setGuaIdNo(req.getGuaIdNo());
        repayPlan.setGuaNowAddress(req.getGuaNowAddress());
        repayPlan.setHousePdf(req.getHousePdf());
        repayPlanBO.qkcsbRedeemApply(repayPlan);

        repayBiz.setCurNodeCode(ERepayBizNode.RISK_MANAGER_CHECK.getCode());
        repayBiz.setUpdater(req.getOperator());
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.qkcsbRedeemApply(repayBiz);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                repayBiz.getCurNodeCode(), req.getGuaNote(), req.getOperator());
    }

    @Override
    public void riskManagerCheck(XN630563Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.RISK_MANAGER_CHECK.getCode()
                .equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是风控主管审核节点，不能操作！");
        }
        RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
                req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        repayPlan.setSuggest(req.getSuggest());
        repayPlan.setSuggestNote(req.getSuggestNote());
        repayPlanBO.riskManagerCheck(repayPlan);

        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            repayBiz
                    .setCurNodeCode(ERepayBizNode.FINANCE_MANAGER_CHECK.getCode());
        } else {
            repayBiz.setCurNodeCode(ERepayBizNode.QKCSB_REDEEM_APPLY.getCode());
        }
        repayBiz.setUpdater(req.getOperator());
        repayBiz.setUpdateDatetime(new Date());
        repayBizBO.riskManagerCheck(repayBiz);
        // 日志
        sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                repayBiz.getCurNodeCode(), req.getSuggestNote(), req.getOperator());
    }

    @Override
    @Transactional
    public void financeApprove(XN630562Req req) {
        RepayBiz repayBiz = repayBizBO.getRepayBiz(req.getCode());
        String preCurNodeCode = repayBiz.getCurNodeCode();
        if (!ERepayBizNode.FINANCE_MANAGER_CHECK.getCode()
                .equals(preCurNodeCode)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前节点不是财务经理审核节点，不能操作！");
        }

        RepayPlan repayPlan = repayPlanBO.getRepayPlanListByRepayBizCode(
                req.getCode(), ERepayPlanNode.QKCSB_APPLY_TC);
        if (EApproveResult.PASS.getCode().equals(req.getApproveResult())) {
            // 日志记录本次操作
            sysBizLogBO.refreshPreSYSBizLog(EBizLogType.REPAY_BIZ.getCode(),
                    repayBiz.getCode(), preCurNodeCode, null, req.getOperator());
            if (ERepayPlanSuggest.SIX_SAFEGUARDS.getCode()
                    .equals(repayPlan.getSuggest())) {
                // 还款计划处理
                repayPlan.setOverdueAmount(0L);
                repayPlan.setOverplusAmount(0L);
                repayPlan.setRealRepayAmount(repayPlan.getRepayAmount());
                repayPlan.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());
                repayPlanBO.financeApprove(repayPlan);

                // 还款业务处理
                if (repayPlan.getCurPeriods() == repayPlan.getPeriods()) {
                    repayBiz.setCurNodeCode(
                            ERepayBizNode.QKCS_DEPART_CHECK.getCode());
                    // 日志
                    sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(),
                            EBizLogType.REPAY_BIZ, repayBiz.getCode(),
                            repayBiz.getCurNodeCode());
                } else {
                    repayBiz.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());
                }
                repayBiz.setCurOverdueCount(repayBiz.getCurOverdueCount() - 1);

                repayBiz.setRestAmount(
                        repayBiz.getRestAmount() - repayPlan.getRepayAmount());
                repayBiz.setOverdueAmount(
                        repayBiz.getOverdueAmount() - repayPlan.getOverdueAmount());
                repayBiz.setUpdater(req.getOperator());
                repayBiz.setUpdateDatetime(new Date());
                repayBizBO.financeApprove(repayBiz);
            } else {
                // 还款计划处理
                repayPlan.setOverdueAmount(0L);
                repayPlan.setOverplusAmount(0L);
                repayPlan.setRealRepayAmount(repayPlan.getRepayAmount());
                repayPlan.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());
                repayPlanBO.financeApprove(repayPlan);

                // 剩下还款计划还清
                List<RepayPlan> repayPlanList = repayPlanBO
                        .queryRepayPlanListByRepayBizCode(repayBiz.getCode(),
                                ERepayPlanNode.TO_REPAY);
                for (RepayPlan domain : repayPlanList) {
                    repayPlanBO.refreshSettleDaily(domain,
                            domain.getRepayAmount());
                }

                // 还款业务处理
                repayBiz
                        .setCurNodeCode(ERepayBizNode.RELEASE_MORTGAGE.getCode());
                repayBiz.setCurOverdueCount(0);
                repayBiz.setRestAmount(0L);
                repayBiz.setOverdueAmount(0L);
                repayBiz.setUpdater(req.getOperator());
                repayBiz.setUpdateDatetime(new Date());
                repayBizBO.financeApprove(repayBiz);
                // 日志
                sysBizLogBO.saveSYSBizLog(repayBiz.getRefCode(),
                        EBizLogType.REPAY_BIZ, repayBiz.getCode(),
                        repayBiz.getCurNodeCode());
            }
        } else {
            repayBiz.setCurNodeCode(ERepayBizNode.RISK_MANAGER_CHECK.getCode());
            repayBiz.setUpdater(req.getOperator());
            repayBiz.setUpdateDatetime(new Date());
            repayBizBO.financeApprove(repayBiz);
            // 日志
            sysBizLogBO.saveNewAndPreEndSYSBizLog(repayBiz.getRefCode(),
                    EBizLogType.REPAY_BIZ, repayBiz.getCode(), preCurNodeCode,
                    repayBiz.getCurNodeCode(), null, req.getOperator());
        }

    }

    private String getNextNodeCode(String curNodeCode, String approveResult) {
        NodeFlow nodeFlow = nodeFlowBO.getNodeFlowByCurrentNode(curNodeCode);
        String nextNodeCode = null;
        if (EBoolean.YES.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlow.getNextNode();
        } else if (EBoolean.NO.getCode().equals(approveResult)) {
            nextNodeCode = nodeFlow.getBackNode();
        }
        return nextNodeCode;
    }

}
