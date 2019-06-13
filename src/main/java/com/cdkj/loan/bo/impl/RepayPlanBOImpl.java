package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IRepayPlanBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IRepayPlanDAO;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.ERepayBizType;
import com.cdkj.loan.enums.ERepayPlanNode;
import com.cdkj.loan.exception.BizException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepayPlanBOImpl extends PaginableBOImpl<RepayPlan>
        implements IRepayPlanBO {

    @Autowired
    private IRepayPlanDAO repayPlanDAO;

    @Override
    public List<RepayPlan> queryRepayPlanList(RepayPlan condition) {
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public List<RepayPlan> queryRepayPlanListByRepayBizCode(
            String repayBizCode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setOrder("cur_periods", true);
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public List<RepayPlan> queryRepayPlanListByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setCurNodeCode(repayPlanNode.getCode());
        return repayPlanDAO.selectList(condition);
    }

    @Override
    public RepayPlan getRepayPlanListByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setCurNodeCode(repayPlanNode.getCode());
        List<RepayPlan> list = repayPlanDAO.selectList(condition);
        RepayPlan data = null;
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        } else {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "当前还款业务没有" + repayPlanNode.getValue() + "的记录");
        }
        return data;
    }

    @Override
    public RepayPlan getRepayPlanByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setCurNodeCode(repayPlanNode.getCode());
        List<RepayPlan> list = repayPlanDAO.selectList(condition);
        RepayPlan data = null;
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        }
        return data;
    }

    // 当月
    @Override
    public RepayPlan getRepayPlanCurMonth(String repayBizCode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setRepayStartDatetime(DateUtil.getFirstDay());
        condition.setRepayEndDatetime(DateUtil.getLastDay());
        RepayPlan data = null;
        List<RepayPlan> list = repayPlanDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            data = list.get(0);
        }
        return data;
    }

    @Override
    public RepayPlan getRepayPlan(String code) {
        RepayPlan data = null;
        if (StringUtils.isNotBlank(code)) {
            RepayPlan condition = new RepayPlan();
            condition.setCode(code);
            data = repayPlanDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "还款计划不存在");
            }
        }
        return data;
    }

    @Override
    public void genereateNewRepayPlan(RepayBiz repayBiz) {

        List<RepayPlan> repayPlanList = new ArrayList<RepayPlan>();

        for (int i = 0; i < repayBiz.getPeriods(); i++) {

            RepayPlan repayPlan = new RepayPlan();

            int curPeriod = i + 1;

            String code = OrderNoGenerater
                    .generate(EGeneratePrefix.REPAY_PLAN.getCode()) + curPeriod;

            Long repayCapital = repayBiz.getMonthAmount();
            if (i == 0) {
                repayCapital = repayBiz.getFirstRepayAmount();
            }

            Date repayDatetime = getRepayDatetime(
                    repayBiz.getFirstRepayDatetime(), repayBiz.getMonthDatetime(),
                    curPeriod);

            repayPlan.setCode(code);
            repayPlan.setRefType(repayBiz.getRefType());
            repayPlan.setRepayBizCode(repayBiz.getCode());
            repayPlan.setUserId(repayBiz.getUserId());
            repayPlan.setPeriods(repayBiz.getPeriods());
            repayPlan.setCurPeriods(curPeriod);

            repayPlan.setRepayDatetime(repayDatetime);
            repayPlan.setRepayCapital(repayCapital);
            repayPlan.setRepayInterest(0L);
            repayPlan.setRepayAmount(
                    repayPlan.getRepayCapital() + repayPlan.getRepayInterest());
            repayPlan.setPayedAmount(0L);

            // 每期应还金额
            long shouldRepayAmount = repayPlan.getRepayCapital()
                    + repayPlan.getRepayInterest();
            repayPlan.setOverplusAmount(shouldRepayAmount);

            repayPlan.setOverdueAmount(0L);
            if (ERepayBizType.CAR.getCode().equals(repayBiz.getRefType())) {
                repayPlan.setCurNodeCode(ERepayPlanNode.TO_REPAY.getCode());
            } else if (ERepayBizType.PRODUCT.getCode()
                    .equals(repayBiz.getRefType())) {
                repayPlan.setCurNodeCode(ERepayPlanNode.PRD_TO_REPAY.getCode());
            }
            repayPlan.setTotalFee(0L);
            repayPlan.setPayedFee(0L);

            repayPlan.setOverdueDeposit(0L);
            repayPlan.setShouldDeposit(0L);
            repayPlan.setRemindCount(0);
            repayPlan.setIsRepay(EBoolean.NO.getCode());
            repayPlanList.add(repayPlan);
        }

        repayPlanDAO.insertList(repayPlanList);
    }

    @Override
    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount) {

        repayPlan
                .setPayedAmount(repayPlan.getPayedAmount() + realWithholdAmount);

        repayPlan.setOverplusAmount(
                repayPlan.getOverplusAmount() - realWithholdAmount);

        repayPlan.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());

        repayPlanDAO.repaySuccess(repayPlan);
    }

    @Override
    public void refreshPrepayPhoto(RepayPlan repayPlan) {
        repayPlanDAO.refreshPrepayPhoto(repayPlan);
    }

    @Override
    public void prepayPhotoApprove(RepayPlan repayPlan) {
        repayPlanDAO.prepayPhotoApprove(repayPlan);
    }

    @Override
    public void repayPartSuccess(RepayPlan repayPlan, Long realWithholdAmount) {

        repayPlan
                .setPayedAmount(repayPlan.getPayedAmount() + realWithholdAmount);

        repayPlan.setOverplusAmount(
                repayPlan.getOverplusAmount() - realWithholdAmount);

        repayPlanDAO.repayPartSuccess(repayPlan);
    }

    @Override
    public void refreshRepayPlanOverdue(RepayPlan repayPlan) {
        repayPlanDAO.updateOverdue(repayPlan);
    }

    private Date getRepayDatetime(Date firstRepayDatetime, int monthDatetime,
            int curPeriod) {
        Date repayDatetime = null;
        if (curPeriod < 1) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "计算每月还款日期发送错误，还款期数必须大于0");
        }
        if (curPeriod == 1) {
            repayDatetime = firstRepayDatetime;
        } else {
            repayDatetime = DateUtil.getIntervalDate(firstRepayDatetime,
                    curPeriod - 1, monthDatetime);
        }
        return repayDatetime;
    }

    @Override
    public void refreshRepayPlanOverdueHandle(RepayPlan repayPlan) {
        repayPlanDAO.overdueHandle(repayPlan);
    }

    @Override
    public void refreshToGreen(RepayPlan repayPlan) {
        repayPlanDAO.overdueHandle(repayPlan);
    }

    @Override
    public void refreshToBlackProduct(RepayPlan repayPlan) {
        repayPlanDAO.overdueHandle(repayPlan);
    }

    @Override
    public void applyTrailer(RepayPlan repayPlan) {
        repayPlanDAO.applyTrailer(repayPlan);
    }

    @Override
    public void financialMoney(RepayPlan repayPlan) {
        repayPlanDAO.financialMoney(repayPlan);
    }

    @Override
    public void trailerEntry(RepayPlan repayPlan) {
        repayPlanDAO.trailerEntry(repayPlan);
    }

    @Override
    public void judicialLitigationEntry(RepayPlan repayPlan) {
        repayPlanDAO.judicialLitigationEntry(repayPlan);
    }

    @Override
    public void qkcsbRedeemApply(RepayPlan repayPlan) {
        repayPlanDAO.qkcsbRedeemApply(repayPlan);
    }

    @Override
    public void riskManagerCheck(RepayPlan repayPlan) {
        repayPlanDAO.riskManagerCheck(repayPlan);
    }

    @Override
    public Paginable<RepayPlan> getPaginableByRoleCode(int start, int limit,
            RepayPlan condition) {
        prepare(condition);
        long totalCount = repayPlanDAO.selectTotalCountByRoleCode(condition);
        Page<RepayPlan> page = new Page<RepayPlan>(start, limit, totalCount);
        List<RepayPlan> dataList = repayPlanDAO.selectRepayPlanByRoleCode(
                condition, page.getStart(), page.getPageSize());
        page.setList(dataList);
        return page;
    }

    @Override
    public void refreshRepayPlanCurNodeCode(RepayPlan repayPlan) {
    }

    @Override
    public void financeApprove(RepayPlan repayPlan) {
        repayPlanDAO.financeApprove(repayPlan);
    }

    @Override
    public int getTotalCount(String repayBizCode, ERepayPlanNode curNodeCode) {
        RepayPlan condition = new RepayPlan();
        condition.setRepayBizCode(repayBizCode);
        condition.setCurNodeCode(curNodeCode.getCode());
        return (int) repayPlanDAO.selectTotalCount(condition);
    }

    @Override
    public void payFee(RepayPlan repayPlan) {
        repayPlanDAO.payFee(repayPlan);
    }

    @Override
    public void repayAmount(RepayPlan repayPlan) {
        repayPlanDAO.repayAmount(repayPlan);
    }

    @Override
    public void refreshSettleDaily(RepayPlan data, Long repayAmount) {
        data.setRealRepayAmount(repayAmount);
        data.setOverplusAmount(0L);
        data.setCurNodeCode(ERepayPlanNode.REPAY_YES.getCode());
        repayPlanDAO.updateSettleDaily(data);
    }

    @Override
    public void alreadyRepay(RepayPlan repayPlan) {
        repayPlanDAO.updateRepayPlan(repayPlan);
    }

    @Override
    public List<RepayPlan> queryBeforePlanList(RepayPlan condition) {
        return repayPlanDAO.selectBeforePlanList(condition);
    }

}
