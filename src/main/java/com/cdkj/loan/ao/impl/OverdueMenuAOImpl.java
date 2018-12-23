package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IOverdueMenuAO;
import com.cdkj.loan.bo.IBankBO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IOverdueMenuBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.OverdueMenu;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN632300ReqOverdue;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EOverdueMenuStatus;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.exception.BizException;

@Service
public class OverdueMenuAOImpl implements IOverdueMenuAO {

    @Autowired
    private IOverdueMenuBO overdueMenuBO;

    @Autowired
    private IBankBO bankBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IRepayBizBO repayBizBO;

    @Autowired
    private IRepayPlanBO repayPlanBO;

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Override
    @Transactional
    public void importOverdueMenu(String loanBankCode,
            List<XN632300ReqOverdue> list) {
        // 遍历循环导入
        for (XN632300ReqOverdue overdue : list) {
            // 当条数据判断是否匹配，匹配条件：姓名、证件号、贷款银行、贷款金额、总期数、放款日期查询准入单
            RepayBiz condition = new RepayBiz();
            condition.setRealName(overdue.getRealName());
            condition.setIdNo(overdue.getIdNo());
            String bankName = bankBO.getBank(loanBankCode).getBankName();
            condition.setLoanBank(loanBankCode);
            condition
                .setLoanAmount(StringValidater.toLong(overdue.getLoanAmount()));
            condition
                .setPeriods(StringValidater.toInteger(overdue.getPeriods()));
            condition.setBankFkDatetimeStart(
                DateUtil.getFrontDate(overdue.getFkDatetime(), false));
            condition.setBankFkDatetimeEnd(
                DateUtil.getFrontDate(overdue.getFkDatetime(), true));
            condition.setCurNodeCode(ERepayBizNode.TO_REPAY.getCode());
            List<RepayBiz> repayBizList = repayBizBO
                .queryRepayBizList(condition);
            OverdueMenu overdueMenu = new OverdueMenu();
            overdueMenu.setOverdueAmount(
                StringValidater.toLong(overdue.getOverdueAmount()));

            // 判断是否有准入单，没有，状态设置为待处理，原因是信息不匹配,
            if (CollectionUtils.isNotEmpty(repayBizList)) {
                // 有,状态设置为已处理,根据准入单查询还款业务表再查最新一条还款计划,设置还款计划状态为逾期名单
                RepayBiz repayBiz = repayBizList.get(0);
                RepayPlan overDueRepayPlan = repayPlanBO
                    .getRepayPlanCurMonth(repayBiz.getCode());
                String preCurNodeCode = overDueRepayPlan.getCurNodeCode();
                if (overDueRepayPlan != null
                        && overDueRepayPlan.getPeriods() == StringValidater
                            .toInteger(overdue.getPeriods())) {
                    overDueRepayPlan
                        .setCurNodeCode(ERepayPlanNode.OVERDUE.getCode());

                    // 更新逾期还款信息
                    refreshRepayInfo(overdueMenu, repayBiz, overDueRepayPlan,
                        preCurNodeCode);

                    overdueMenu.setStatus(EOverdueMenuStatus.YCL.getCode());
                    overdueMenu.setBudgetOrderCode(repayBiz.getRefCode());
                    overdueMenu
                        .setRepayBizCode(overDueRepayPlan.getRepayBizCode());

                    overdueMenu.setRepayPlanCode(overDueRepayPlan.getCode());
                    overdueMenu.setOverdueDatetime(
                        overDueRepayPlan.getRepayDatetime());
                }
            } else {
                overdueMenu.setStatus(EOverdueMenuStatus.DCL.getCode());
                overdueMenu.setImportNote("信息不匹配");
            }

            // 最后逾期数据填充入库
            overdueMenu.setRealName(overdue.getRealName());
            overdueMenu.setIdNo(overdue.getIdNo());
            overdueMenu
                .setLoanAmount(StringValidater.toLong(overdue.getLoanAmount()));
            overdueMenu.setFkDatetime(DateUtil.strToDate(
                overdue.getFkDatetime(), DateUtil.FRONT_DATE_FORMAT_STRING));
            overdueMenu
                .setPeriods(StringValidater.toInteger(overdue.getPeriods()));

            overdueMenu.setRemainAmount(
                StringValidater.toLong(overdue.getRemainAmount()));
            overdueMenu.setLoanBankCode(loanBankCode);
            overdueMenu.setLoanBankName(bankName);

            overdueMenu.setImportDatetime(new Date());
            overdueMenuBO.saveOverdueMenu(overdueMenu);
        }
    }

    // 更新还款业务和还款计划金额
    private void refreshRepayInfo(OverdueMenu overdueMenu, RepayBiz repayBiz,
            RepayPlan overDueRepayPlan, String preCurNodeCode) {
        Long preOverdueAmount = 0L;// 上一期逾期金额
        Long overdueAmount = 0L;// 本期逾期金额
        int i = 1;
        int j = 1;
        if (overdueMenu.getOverdueAmount() > overDueRepayPlan
            .getRepayAmount()) {
            j += 1;
            preOverdueAmount = overdueMenu.getOverdueAmount()
                    - overDueRepayPlan.getRepayAmount();
            overdueAmount = overDueRepayPlan.getRepayAmount();
            RepayPlan condition = new RepayPlan();
            condition.setRepayBizCode(repayBiz.getCode());
            condition.setCurPeriods(overDueRepayPlan.getCurPeriods() - i);
            if (overDueRepayPlan.getCurPeriods() - i == 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "逾期金额过大！");
            }
            List<RepayPlan> list = repayPlanBO.queryRepayPlanList(condition);
            RepayPlan preRepayPlan = list.get(0);
            if (preOverdueAmount > preRepayPlan.getRepayAmount()) {
                preRepayPlan.setOverdueAmount(preRepayPlan.getRepayAmount());
                preRepayPlan.setRealRepayAmount(0L);
                preRepayPlan.setOverplusAmount(preRepayPlan.getRepayAmount());
            } else {
                preRepayPlan.setOverdueAmount(preOverdueAmount);
                preRepayPlan.setOverplusAmount(preOverdueAmount);
                preRepayPlan.setRealRepayAmount(
                    preRepayPlan.getRepayAmount() - preOverdueAmount);
            }
            preRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE.getCode());
            repayPlanBO.refreshRepayPlanOverdue(preRepayPlan);// 更新上一期还款计划逾期金额
            while (preOverdueAmount > preRepayPlan.getRepayAmount()) {
                i++;
                j++;
                preOverdueAmount = preOverdueAmount
                        - preRepayPlan.getRepayAmount();
                overdueAmount = overDueRepayPlan.getRepayAmount();
                RepayPlan domain = new RepayPlan();
                domain.setRepayBizCode(repayBiz.getCode());
                domain.setCurPeriods(overDueRepayPlan.getCurPeriods() - i);
                if (overDueRepayPlan.getCurPeriods() - i == 0) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "逾期金额过大！");
                }
                List<RepayPlan> RepayPlanList = repayPlanBO
                    .queryRepayPlanList(domain);
                RepayPlan preRepayPlan2 = RepayPlanList.get(0);
                preRepayPlan2.setOverdueAmount(preOverdueAmount);
                preRepayPlan2.setCurNodeCode(ERepayPlanNode.OVERDUE.getCode());
                repayPlanBO.refreshRepayPlanOverdue(preRepayPlan2);// 更新上一期还款计划逾期金额
            }
        } else {
            preOverdueAmount = 0L;
            overdueAmount = overdueMenu.getOverdueAmount();
        }
        overDueRepayPlan.setOverdueAmount(overdueAmount);
        repayPlanBO.refreshRepayPlanOverdue(overDueRepayPlan);// 更新当月期的还款计划逾期金额

        // 更新还款业务逾期金额
        repayBiz.setOverdueAmount(
            repayBiz.getOverdueAmount() + overdueMenu.getOverdueAmount());
        Long restAmount = 0L;
        // 判断逾期金额是否有超出这一期
        if (overdueMenu.getOverdueAmount() > overDueRepayPlan
            .getRepayAmount()) {
            // 是：剩余欠款 = 剩余欠款+逾期金额
            restAmount = repayBiz.getRestAmount()
                    + overdueMenu.getOverdueAmount();
        } else {
            // 否：剩余欠款 = 剩余欠款+逾期金额-当月月供
            restAmount = repayBiz.getRestAmount()
                    + overdueMenu.getOverdueAmount()
                    + overDueRepayPlan.getRepayAmount();
        }
        repayBiz.setRestAmount(restAmount);
        // 总期数-当前期数+1 = 剩余期数 说明当月还款计划没逾过期（当前还款计划逾过期并处理过的不用加逾期次数）
        if (!ERepayPlanNode.OVERDUE.getCode().equals(preCurNodeCode)) {
            repayBiz.setTotalOverdueCount(repayBiz.getTotalOverdueCount() + j);
            repayBiz.setCurOverdueCount(repayBiz.getCurOverdueCount() + j);
        }
        repayBizBO.repayOverdue(repayBiz);
    }

    // 处理逻辑
    // 1、前提条件判断
    // 2、逾期名单状态更改为已处理
    // 3、还款计划更改为已逾期
    @Override
    @Transactional
    public void handleOverdueMenu(String code, String repayBizCode,
            String operator) {
        OverdueMenu overdueMenu = overdueMenuBO.getOverdueMenu(code);
        if (EOverdueMenuStatus.YCL.getCode().equals(overdueMenu.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前逾期名单已处理");
        }
        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayBizCode);
        RepayPlan overDueRepayPlan = repayPlanBO
            .getRepayPlanCurMonth(repayBiz.getCode());
        String preCurNodeCode = overDueRepayPlan.getCurNodeCode();
        // 如果当月已处理过，不能在处理
        if (!ERepayPlanNode.TO_REPAY.getCode()
            .equals(overDueRepayPlan.getCurNodeCode())
                && !ERepayPlanNode.OVERDUE.getCode()
                    .equals(overDueRepayPlan.getCurNodeCode())
                && !ERepayPlanNode.REPAY_YES.getCode()
                    .equals(overDueRepayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                repayBiz.getRealName() + "的当月还款计划已逾期处理，不能重复操作！");
        }

        // 还款计划状态是否更新
        overDueRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE.getCode());
        long totalRepayAmount = overDueRepayPlan.getRepayCapital()
                + overDueRepayPlan.getRepayInterest();
        if (totalRepayAmount < overdueMenu.getOverdueAmount()) {
            overDueRepayPlan.setOverdueAmount(totalRepayAmount);
            overDueRepayPlan.setRealRepayAmount(0L);
            overDueRepayPlan.setOverplusAmount(totalRepayAmount);
        } else {
            overDueRepayPlan.setOverdueAmount(overdueMenu.getOverdueAmount());
            overDueRepayPlan.setOverplusAmount(overdueMenu.getOverdueAmount());
            overDueRepayPlan
                .setRealRepayAmount(overDueRepayPlan.getRepayAmount()
                        - overdueMenu.getOverdueAmount());
        }
        repayPlanBO.refreshRepayPlanOverdue(overDueRepayPlan);
        // 更新逾期还款信息
        refreshRepayInfo(overdueMenu, repayBiz, overDueRepayPlan,
            preCurNodeCode);

        overdueMenu.setStatus(EOverdueMenuStatus.YCL.getCode());
        BudgetOrder budgetOrder = budgetOrderBO
            .getBudgetOrderByRepayBizCode(repayBizCode);
        overdueMenu.setBudgetOrderCode(budgetOrder.getCode());
        overdueMenu.setRepayBizCode(overDueRepayPlan.getRepayBizCode());
        overdueMenu.setRepayPlanCode(overDueRepayPlan.getCode());

        overdueMenu.setHandleDatetime(new Date());
        overdueMenuBO.refreshOverdueMenu(overdueMenu);
    }

    @Override
    public Paginable<OverdueMenu> queryOverdueMenuPage(int start, int limit,
            OverdueMenu condition) {
        return overdueMenuBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<OverdueMenu> queryOverdueMenuList(OverdueMenu condition) {
        return overdueMenuBO.queryOverdueMenuList(condition);
    }

    @Override
    public OverdueMenu getOverdueMenu(String code) {
        OverdueMenu data = overdueMenuBO.getOverdueMenu(code);
        if (StringUtils.isNotBlank(data.getRepayBizCode())) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getRepayBizCode());
            data.setRepayBiz(repayBiz);
        }
        return data;
    }

}
