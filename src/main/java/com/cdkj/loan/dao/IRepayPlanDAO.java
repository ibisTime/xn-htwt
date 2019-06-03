package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepayPlan;
import java.util.List;

public interface IRepayPlanDAO extends IBaseDAO<RepayPlan> {

    String NAMESPACE = IRepayPlanDAO.class.getName().concat(".");

    public void insertList(List<RepayPlan> dataList);

    public int repaySuccess(RepayPlan data);

    public int updateOverdue(RepayPlan repayPlan);

    public int overdueHandle(RepayPlan repayPlan);

    public int repayPartSuccess(RepayPlan repayPlan);

    public int applyTrailer(RepayPlan repayPlan);

    public int financialMoney(RepayPlan repayPlan);

    public int trailerEntry(RepayPlan repayPlan);

    public int judicialLitigationEntry(RepayPlan repayPlan);

    public int qkcsbRedeemApply(RepayPlan repayPlan);

    public int riskManagerCheck(RepayPlan repayPlan);

    public long selectTotalCountByRoleCode(RepayPlan condition);

    public List<RepayPlan> selectRepayPlanByRoleCode(RepayPlan condition,
            int start, int pageSize);

    public int financeApprove(RepayPlan repayPlan);

    public int payFee(RepayPlan repayPlan);

    public int repayAmount(RepayPlan repayPlan);

    public int updateSettleDaily(RepayPlan data);

    // 上传还款截图
    public void refreshPrepayPhoto(RepayPlan repayPlan);

    // 还款审核
    public void prepayPhotoApprove(RepayPlan repayPlan);

    /**
     * 人工确认还款
     */
    void updateRepayPlan(RepayPlan repayPlan);

    /**
     * 查询之前的还款计划
     */
    List<RepayPlan> selectBeforePlanList(RepayPlan condition);
}
