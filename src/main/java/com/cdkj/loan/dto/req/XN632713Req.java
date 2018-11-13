package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * GPS重新申领
 * @author: CYL 
 * @since: 2018年11月2日 上午10:22:49 
 * @history:
 */
public class XN632713Req {
    // gps申领编号
    private String code;

    // 类型(1 有线 2 无线)
    private String type;

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

    // 申请原因
    private String applyReason;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
