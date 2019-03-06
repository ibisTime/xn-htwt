package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * GPS申领
 * @author: silver 
 * @since: 2018年5月30日 下午11:46:36 
 * @history:
 */
public class XN632710Req {
    // 类型(1 有线 2 无线)
    private String type;

    // 申请类型(1 本部 2 分部)
    private String applyType;

    // 申请人
    @NotBlank
    private String applyUser;

    // 申请有线个数
    private String applyWiredCount;

    // 申请无线个数
    private String applyWirelessCount;

    // 预算单编号
    private String budgetOrderCode;

    // 客户姓名
    private String customerName;

    // 手机号
    private String mobile;

    // 车架号
    private String carFrameNo;

    // 团队编号
    private String teamCode;

    // 申请原因
    private String applyReason;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getBudgetOrderCode() {
        return budgetOrderCode;
    }

    public void setBudgetOrderCode(String budgetOrderCode) {
        this.budgetOrderCode = budgetOrderCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyWiredCount() {
        return applyWiredCount;
    }

    public void setApplyWiredCount(String applyWiredCount) {
        this.applyWiredCount = applyWiredCount;
    }

    public String getApplyWirelessCount() {
        return applyWirelessCount;
    }

    public void setApplyWirelessCount(String applyWirelessCount) {
        this.applyWirelessCount = applyWirelessCount;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

}
