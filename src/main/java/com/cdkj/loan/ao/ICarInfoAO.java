package com.cdkj.loan.ao;

import org.springframework.stereotype.Component;

import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632143Req;
import com.cdkj.loan.dto.req.XN632500Req;
import com.cdkj.loan.dto.req.XN632530Req;
import com.cdkj.loan.dto.req.XN632531Req;
import com.cdkj.loan.dto.req.XN632537Req;

//CHECK ��鲢��ע�� 
@Component
public interface ICarInfoAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    // 录入准入单
    public void inputBudgetOrder(XN632500Req req);

    public int editCarInfo(XN632120Req req);

    // 区域经理审核
    public void areaApprove(String code, String approveResult,
            String approveNote, String operator);

    // 准入单内勤主管审核
    public void internalApprove(String code, String approveResult,
            String approveNote, String operator);

    // 风控一审
    public void riskOneApprove(String code, String approveResult,
            String approveNote, String operator);

    // 风控二审
    public void riskTwoApprove(String code, String carPriceCheckReport,
            String housePicture, String approveResult, String approveNote,
            String operator);

    // 风控主管审核
    public void riskChargeApprove(String code, String operator,
            String approveResult, String approveNote);

    // 业务总监审核
    void yBizChargeApprove(String code, String operator, String approveResult,
            String approveNote);

    public void financeAudit(XN632143Req req);

    public void headCompanyApprove(String code, String approveResult,
            String approveNote, String operator);

    /**
     * 准入单-贷款信息
     */
    void inputLoanInfo(XN632530Req req);

    /**
     * 修改入准入单-车辆信息
     */
    void inputCarInfo(XN632531Req req);

    /**
     * 修改入准入单-流水
     */
    void inputJourInfo(XN632537Req req);
}
