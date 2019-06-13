package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.RepayPlan;
import com.cdkj.loan.dto.req.XN630530Req;
import com.cdkj.loan.dto.req.XN630532Req;
import com.cdkj.loan.dto.req.XN630537Req;
import com.cdkj.loan.dto.req.XN630544Req;
import com.cdkj.loan.dto.req.XN630545Req;
import java.util.List;

public interface IRepayPlanAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<RepayPlan> queryRepayPlanPage(int start, int limit,
            RepayPlan condition);

    public List<RepayPlan> queryRepayPlanList(RepayPlan condition);

    public RepayPlan getRepayPlan(String code);

    public Paginable<RepayPlan> queryRepayPlanPageByRoleCode(int start,
            int limit, RepayPlan condition);

    // 当月还款名单
    public Object queryCurrentMonthRepayPage(int start, int limit,
            RepayPlan condition);

    // 上传还款截图
    public void prepayPhoto(XN630544Req req);

    // 是否还款审核
    public void prepayPhotoApprove(XN630545Req req);

    // 获取未结清贷款
    public Long getUnsettledLoan();

    // 逾期处理
    public void overdueHandle(XN630532Req req);

    // 缴纳清收成本
    public void payFee(String code, List<String> costList, String payType,
            String operator);

    // 记黑名单
    public void transferBlackByProduct(String code);

    // 缴纳代偿金额
    public void chargeRepayAmount(String code, String operator, String payType);

    // 每天凌晨定时更新还款计划状态为已结清
    public void doSettleDaily();

    // 每天凌晨定时更新还款计划状态为已结清(商品)
    public void doSettleDailyProduct();

    /**
     * 人工确认还款
     */
    void alreadyRepay(XN630530Req req);

    /**
     * 人工确认逾期
     */
    void alreadyOverDue(XN630537Req req);
}
