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
import java.util.ArrayList;
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
                String preCurNodeCode = curMonthRepayPlan.getCurNodeCode();
                if (curMonthRepayPlan != null
                        && curMonthRepayPlan.getPeriods() == StringValidater
                        .toInteger(overdue.getPeriods())) {
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
                    curMonthRepayPlan
                            .setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());

                    // 本期应还金额
                    long totalRepayAmount = curMonthRepayPlan.getRepayCapital()
                            + curMonthRepayPlan.getRepayInterest();
                    // 逾期金额大于本期应还金额，为逾期多期
                    if (totalRepayAmount < overdueMenu.getOverdueAmount()) {
                        curMonthRepayPlan.setOverdueAmount(totalRepayAmount);
                        curMonthRepayPlan.setRealRepayAmount(0L);
                        curMonthRepayPlan.setOverplusAmount(totalRepayAmount);
                    } else {
                        // 逾期金额小于本期应还金额，为逾期一期
                        curMonthRepayPlan
                                .setOverdueAmount(overdueMenu.getOverdueAmount());
                        curMonthRepayPlan
                                .setOverplusAmount(overdueMenu.getOverdueAmount());
                        curMonthRepayPlan.setRealRepayAmount(
                                curMonthRepayPlan.getRepayAmount()
                                        - overdueMenu.getOverdueAmount());
                    }
                    // 更新当月还款计划
                    repayPlanBO.refreshRepayPlanOverdue(curMonthRepayPlan);

                    // 更新逾期还款信息
                    refreshRepayInfo(overdueMenu, repayBiz, curMonthRepayPlan);

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

            overdueMenu.setImportDatetime(new Date());
            overdueMenuBO.saveOverdueMenu(overdueMenu);
        }

    }

    // 更新还款业务和还款计划金额
    private void refreshRepayInfo(OverdueMenu overdueMenu, RepayBiz repayBiz,
            RepayPlan curMonthRepayPlan) {
        // 上一期逾期金额
        Long preOverdueAmount;
        // 本期逾期金额
        Long overdueAmount;
        int i = 1;
        int j = 1;
        //逾期金额大于还款金额
        if (overdueMenu.getOverdueAmount() > curMonthRepayPlan
                .getRepayAmount()) {
            j += 1;
            preOverdueAmount = overdueMenu.getOverdueAmount()
                    - curMonthRepayPlan.getRepayAmount();
            overdueAmount = curMonthRepayPlan.getRepayAmount();
            RepayPlan condition = new RepayPlan();
            condition.setRepayBizCode(repayBiz.getCode());
            //查询上一期还款计划
            condition.setCurPeriods(curMonthRepayPlan.getCurPeriods() - i);
            if (curMonthRepayPlan.getCurPeriods() - i == 0) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                        "逾期金额过大！");
            }
            List<RepayPlan> list = repayPlanBO.queryRepayPlanList(condition);
            RepayPlan preRepayPlan = list.get(0);
            // 上一期逾期金额大于上一期的还款金额
            if (preOverdueAmount > preRepayPlan.getRepayAmount()) {
                preRepayPlan.setOverdueAmount(preRepayPlan.getRepayAmount());
                preRepayPlan.setRealRepayAmount(0L);
                preRepayPlan.setOverplusAmount(preRepayPlan.getRepayAmount());
            } else {
                // 上一期逾期金额小于等于上一期的还款金额
                preRepayPlan.setOverdueAmount(preOverdueAmount);
                preRepayPlan.setOverplusAmount(preOverdueAmount);
                preRepayPlan.setRealRepayAmount(
                        preRepayPlan.getRepayAmount() - preOverdueAmount);
            }
            preRepayPlan.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
            repayPlanBO.refreshRepayPlanOverdue(preRepayPlan);// 更新上一期还款计划逾期金额
            while (preOverdueAmount > preRepayPlan.getRepayAmount()) {
                i++;
                j++;
                preOverdueAmount = preOverdueAmount
                        - preRepayPlan.getRepayAmount();
                overdueAmount = curMonthRepayPlan.getRepayAmount();
                RepayPlan domain = new RepayPlan();
                domain.setRepayBizCode(repayBiz.getCode());
                domain.setCurPeriods(curMonthRepayPlan.getCurPeriods() - i);
                if (curMonthRepayPlan.getCurPeriods() - i == 0) {
                    throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                            "逾期金额过大！");
                }
                List<RepayPlan> RepayPlanList = repayPlanBO
                        .queryRepayPlanList(domain);
                RepayPlan preRepayPlan2 = RepayPlanList.get(0);
                preRepayPlan2.setOverdueAmount(preOverdueAmount);
                preRepayPlan2.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
                repayPlanBO.refreshRepayPlanOverdue(preRepayPlan2);// 更新上一期还款计划逾期金额
            }
        } else {
            overdueAmount = overdueMenu.getOverdueAmount();
        }
        curMonthRepayPlan.setOverdueAmount(overdueAmount);
        repayPlanBO.refreshRepayPlanOverdue(curMonthRepayPlan);// 更新当月期的还款计划逾期金额
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
        String preCurNodeCode = curMonthRepayPlan.getCurNodeCode();
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
            List<String> nodeList = new ArrayList<>();
            nodeList.add(ERepayPlanNode.REPAY_YES.getCode());
            nodeList.add(ERepayPlanNode.OVERDUE.getCode());
            nodeList.add(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
            nodeList.add(ERepayPlanNode.HANDLER_TO_GREEN.getCode());
            nodeList.add(ERepayPlanNode.HANDLER_TO_YELLOW.getCode());
            condition.setCurNodeCodeList(nodeList);
            condition.setRepayBizCode(repayBizCode);
            condition.setOrder("cur_periods", "desc");
            RepayPlan firstPlan = null;
            List<RepayPlan> repayPlanList = repayPlanBO.queryRepayPlanList(condition);
            if (CollectionUtils.isNotEmpty(repayPlanList)) {
                for (RepayPlan repayPlan : repayPlanList) {
                    if (!repayPlan.getRepayCapital().equals(repayPlan.getOverdueAmount())) {
                        firstPlan = repayPlan;
                        break;
                    }
                }
            }
            if (firstPlan != null) {
                if (overdueMenu.getOverdueAmount() > firstPlan.getRealRepayAmount()) {
                    overdueMenu.setOverdueAmount(
                            overdueMenu.getOverdueAmount() - firstPlan.getRealRepayAmount());
                    firstPlan.setRealRepayAmount(0L);
                    firstPlan.setOverplusAmount(firstPlan.getRepayCapital());
                    firstPlan.setOverdueAmount(firstPlan.getRepayCapital());
                    firstPlan.setCurNodeCode(ERepayPlanNode.OVERDUE_TO_TRUE.getCode());
                    repayPlanBO.refreshRepayPlanOverdue(firstPlan);
                    // 更新逾期还款信息
                    refreshRepayInfo(overdueMenu, repayBiz, firstPlan);
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
            } else {
                curMonthRepayPlan.setOverdueAmount(overdueMenu.getOverdueAmount());
                curMonthRepayPlan.setOverplusAmount(overdueMenu.getOverdueAmount());
                curMonthRepayPlan
                        .setRealRepayAmount(curMonthRepayPlan.getRepayAmount()
                                - overdueMenu.getOverdueAmount());
            }
            repayPlanBO.refreshRepayPlanOverdue(curMonthRepayPlan);
            // 更新逾期还款信息
            refreshRepayInfo(overdueMenu, repayBiz, curMonthRepayPlan);
        }
        overdueMenu.setStatus(EOverdueMenuStatus.YSDCL.getCode());
        overdueMenu.setRepayBizCode(curMonthRepayPlan.getRepayBizCode());
        overdueMenu.setRepayPlanCode(curMonthRepayPlan.getCode());

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
