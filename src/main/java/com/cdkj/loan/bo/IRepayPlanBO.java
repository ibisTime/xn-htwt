package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.enums.ERepayPlanNode;
import java.util.List;

public interface IRepayPlanBO extends IPaginableBO<RepayPlan> {

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlanCurMonth(String repayBizCode);

    public List<RepayPlan> queryRepayPlanListByRepayBizCode(
            String repayBizCode);

    public List<RepayPlan> queryRepayPlanListByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode);

    public RepayPlan getRepayPlanListByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode);

    public RepayPlan getRepayPlanByRepayBizCode(String repayBizCode,
            ERepayPlanNode repayPlanNode);

    public RepayPlan getRepayPlan(String code);

    // 产生还款计划
    public void genereateNewRepayPlan(RepayBiz repayBiz);

    // 支付成功更新
    public void repaySuccess(RepayPlan repayPlan, Long realWithholdAmount);

    // 上传还款截图
    public void refreshPrepayPhoto(RepayPlan repayPlan);

    // 还款审核
    public void prepayPhotoApprove(RepayPlan repayPlan);

    // 进入逾期
    public void refreshRepayPlanOverdue(RepayPlan repayPlan);

    // 逾期后处理
    public void refreshRepayPlanOverdueHandle(RepayPlan repayPlan);

    // 进入绿名单
    public void refreshToGreen(RepayPlan repayPlan);

    // 产品进入黑名单
    public void refreshToBlackProduct(RepayPlan repayPlan);

    // 部分支付方法
    public void repayPartSuccess(RepayPlan repayPlan, Long realWithholdAmount);

    // 拖车申请
    public void applyTrailer(RepayPlan repayPlan);

    // 财务打款
    public void financialMoney(RepayPlan repayPlan);

    // 清欠催收部拖车录入
    public void trailerEntry(RepayPlan repayPlan);

    // 司法诉讼结果录入
    public void judicialLitigationEntry(RepayPlan repayPlan);

    // 清欠催收部申请赎回
    public void qkcsbRedeemApply(RepayPlan repayPlan);

    // 风险控经理审核
    public void riskManagerCheck(RepayPlan repayPlan);

    public Paginable<RepayPlan> getPaginableByRoleCode(int start, int limit,
            RepayPlan condition);

    public void refreshRepayPlanCurNodeCode(RepayPlan repayPlan);

    // 财务经理审核
    public void financeApprove(RepayPlan repayPlan);

    public int getTotalCount(String repayBizCode, ERepayPlanNode repayPlanNode);

    // 缴纳清收成本
    public void payFee(RepayPlan repayPlan);

    // 缴纳代偿金额
    public void repayAmount(RepayPlan repayPlan);

    // 还款计划结清
    public void refreshSettleDaily(RepayPlan data, Long repayAmount);

    /**
     * 人工确认还款
     */
    void alreadyRepay(RepayPlan repayPlan);

    /**
     * 查询之前的还款计划
     */
    List<RepayPlan> queryBeforePlanList(RepayPlan condition);
}
