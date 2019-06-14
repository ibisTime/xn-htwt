package com.cdkj.loan.ao.impl;

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
import com.cdkj.loan.domain.Bank;
import com.cdkj.loan.domain.OverdueMenu;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN632300ReqOverdue;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EOverdueMenuStatus;
import com.cdkj.loan.enums.ERepayBizNode;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public void importOverdueMenu(String loanBankCode,
            List<XN632300ReqOverdue> list) {
        // 遍历循环导入
        for (XN632300ReqOverdue overdue : list) {
            // 当条数据判断是否匹配，匹配条件：姓名、证件号、贷款银行、贷款金额、总期数、放款日期查询准入单
            RepayBiz condition = new RepayBiz();
            condition.setRealName(overdue.getRealName());
            condition.setIdNo(overdue.getIdNo());
            Bank bank = bankBO.getBank(loanBankCode);
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
                RepayPlan curMonthRepayPlan = repayPlanBO
                        .getRepayPlanCurMonth(repayBiz.getCode());

                if (curMonthRepayPlan != null
                        && curMonthRepayPlan.getPeriods() == StringValidater
                        .toInteger(overdue.getPeriods())) {

                    // 查询还款计划并更新
                    renewRepayPlan(overdueMenu, repayBiz, curMonthRepayPlan);

                    overdueMenu.setStatus(EOverdueMenuStatus.YCL.getCode());
                    overdueMenu.setBudgetOrderCode(repayBiz.getRefCode());
                    overdueMenu
                            .setRepayBizCode(curMonthRepayPlan.getRepayBizCode());

                    overdueMenu.setRepayPlanCode(curMonthRepayPlan.getCode());
                    overdueMenu.setOverdueDatetime(
                            curMonthRepayPlan.getRepayDatetime());
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
            overdueMenu.setLoanBankName(bank.getBankName());

            overdueMenu.setCreateDatetime(DateUtil.strToDate(overdue.getCreateDatetime(),
                    DateUtil.FRONT_DATE_FORMAT_STRING));
            overdueMenu.setImportDatetime(new Date());
            overdueMenuBO.saveOverdueMenu(overdueMenu);
        }

    }


    // 处理逻辑
    // 1、前提条件判断
    // 2、逾期名单状态更改为已处理
    // 3、还款计划更改为已逾期
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void handleOverdueMenu(String code, String repayBizCode,
            String operator) {
        OverdueMenu overdueMenu = overdueMenuBO.getOverdueMenu(code);
        if (EOverdueMenuStatus.YCL.getCode().equals(overdueMenu.getStatus())
                || EOverdueMenuStatus.YSDCL.getCode().equals(overdueMenu.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前逾期名单已处理");
        }
        RepayBiz repayBiz = repayBizBO.getRepayBiz(repayBizCode);
        RepayPlan curMonthRepayPlan = repayPlanBO
                .getRepayPlanCurMonth(repayBiz.getCode());

        // 查询还款计划并更新
        renewRepayPlan(overdueMenu, repayBiz, curMonthRepayPlan);

        overdueMenu.setStatus(EOverdueMenuStatus.YSDCL.getCode());
        overdueMenu.setRepayBizCode(curMonthRepayPlan.getRepayBizCode());
        overdueMenu.setRepayPlanCode(curMonthRepayPlan.getCode());
        overdueMenu.setHandleDatetime(new Date());
        overdueMenuBO.refreshOverdueMenu(overdueMenu);
    }

    private void renewRepayPlan(OverdueMenu overdueMenu, RepayBiz repayBiz,
            RepayPlan curMonthRepayPlan) {
        // 如果当月已处理过，不能在处理
        if (!ERepayPlanNode.TO_REPAY.getCode()
                .equals(curMonthRepayPlan.getCurNodeCode())
                && !ERepayPlanNode.OVERDUE.getCode()
                .equals(curMonthRepayPlan.getCurNodeCode())
                && !ERepayPlanNode.OVERDUE_TO_TRUE.getCode()
                .equals(curMonthRepayPlan.getCurNodeCode())
                && !ERepayPlanNode.REPAY_YES.getCode()
                .equals(curMonthRepayPlan.getCurNodeCode())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    repayBiz.getRealName() + "的当月还款计划已逾期处理，不能重复操作！");
        }

        //如果当月还款计划是已逾期，说明是多次导入逾期名单，逾期往上加
        if (ERepayPlanNode.OVERDUE.getCode().equals(curMonthRepayPlan.getCurNodeCode())
                || ERepayPlanNode.OVERDUE_TO_TRUE.getCode()
                .equals(curMonthRepayPlan.getCurNodeCode())) {
            RepayPlan condition = new RepayPlan();
            condition.setRepayBizCode(curMonthRepayPlan.getRepayBizCode());
            condition.setCurPeriods(curMonthRepayPlan.getCurPeriods());
            condition.setOrder("cur_periods", "desc");
            List<RepayPlan> repayPlanList = repayPlanBO.queryBeforePlanList(condition);
            if (CollectionUtils.isNotEmpty(repayPlanList)) {
                RepayPlan firstPlan = repayPlanList.get(0);
                // 判断逾期金额是否大于当期的已还金额
                if (overdueMenu.getOverdueAmount() > firstPlan.getRealRepayAmount()) {
                    overdueMenu.setOverdueAmount(
                            overdueMenu.getOverdueAmount() - firstPlan.getRealRepayAmount());
                    firstPlan.setRealRepayAmount(0L);
                    firstPlan.setOverplusAmount(firstPlan.getRepayCapital());
                    firstPlan.setOverdueAmount(firstPlan.getRepayCapital());
                    firstPlan.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
                    repayPlanBO.refreshRepayPlanOverdue(firstPlan);
                    // 更新逾期还款信息
                    refreshRepayInfo(overdueMenu, firstPlan);
                } else {
                    firstPlan.setRealRepayAmount(
                            firstPlan.getRealRepayAmount() - overdueMenu.getOverdueAmount());
                    firstPlan.setOverplusAmount(
                            firstPlan.getOverplusAmount() + overdueMenu.getOverdueAmount());
                    firstPlan.setOverdueAmount(
                            firstPlan.getOverdueAmount() + overdueMenu.getOverdueAmount());
                    firstPlan.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
                    repayPlanBO.refreshRepayPlanOverdue(firstPlan);
                }
            }
        } else {

            // 还款计划状态是否更新
            curMonthRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
            long totalRepayAmount = curMonthRepayPlan.getRepayCapital()
                    + curMonthRepayPlan.getRepayInterest();
            if (totalRepayAmount < overdueMenu.getOverdueAmount()) {
                curMonthRepayPlan.setOverdueAmount(totalRepayAmount);
                curMonthRepayPlan.setRealRepayAmount(0L);
                curMonthRepayPlan.setOverplusAmount(totalRepayAmount);
                repayPlanBO.refreshRepayPlanOverdue(curMonthRepayPlan);

                overdueMenu.setOverdueAmount(overdueMenu.getOverdueAmount() - totalRepayAmount);
                // 更新逾期还款信息
                refreshRepayInfo(overdueMenu, curMonthRepayPlan);
            } else {
                curMonthRepayPlan.setOverdueAmount(overdueMenu.getOverdueAmount());
                curMonthRepayPlan.setOverplusAmount(overdueMenu.getOverdueAmount());
                curMonthRepayPlan
                        .setRealRepayAmount(curMonthRepayPlan.getRepayAmount()
                                - overdueMenu.getOverdueAmount());
                repayPlanBO.refreshRepayPlanOverdue(curMonthRepayPlan);
            }
        }
    }

    // 更新还款业务和还款计划金额
    private void refreshRepayInfo(OverdueMenu overdueMenu, RepayPlan curMonthRepayPlan) {
        // 上一期逾期金额
        Long preOverdueAmount = overdueMenu.getOverdueAmount();
        // 本期逾期金额
        Long overdueAmount;
        int i = 1;

        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(curMonthRepayPlan.getRepayBizCode());
        //查询上一期还款计划
        condition.setCurPeriods(curMonthRepayPlan.getCurPeriods() - i);
        if (curMonthRepayPlan.getCurPeriods() - i == 0) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "逾期金额过大！");
        }
        List<RepayPlan> list = repayPlanBO.queryRepayPlanList(condition);
        RepayPlan preRepayPlan = list.get(0);

        while (preOverdueAmount > preRepayPlan.getRepayAmount()) {
            // 更新逾期金额
            preOverdueAmount = preOverdueAmount - preRepayPlan.getRepayAmount();

            // 更新上一期还款计划逾期金额
            preRepayPlan.setOverdueAmount(preRepayPlan.getRepayAmount());
            preRepayPlan.setRealRepayAmount(0L);
            preRepayPlan.setOverplusAmount(preRepayPlan.getRepayAmount());
            preRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
            repayPlanBO.refreshRepayPlanOverdue(preRepayPlan);

            i++;
            //查询上一期还款计划
            condition.setCurPeriods(curMonthRepayPlan.getCurPeriods() - i);
            if (curMonthRepayPlan.getCurPeriods() - i == 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "逾期金额过大！");
            }
            List<RepayPlan> planList = repayPlanBO.queryRepayPlanList(condition);
            preRepayPlan = planList.get(0);
        }

        if (preOverdueAmount <= preRepayPlan.getRepayAmount()) {
            preRepayPlan.setOverdueAmount(preOverdueAmount);
            preRepayPlan.setRealRepayAmount(preRepayPlan.getRepayAmount() - preOverdueAmount);
            preRepayPlan.setOverplusAmount(preOverdueAmount);
            preRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
            repayPlanBO.refreshRepayPlanOverdue(preRepayPlan);
        }
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
