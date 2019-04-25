package com.cdkj.loan.ao;

import org.springframework.stereotype.Component;

import com.cdkj.loan.dto.req.XN632120Req;

//CHECK ��鲢��ע�� 
@Component
public interface ICarInfoAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

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

}
