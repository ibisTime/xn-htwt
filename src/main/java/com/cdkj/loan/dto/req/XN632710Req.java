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

    // 申请人
    @NotBlank
    private String applyUser;

    // 申请有线个数
    @NotBlank
    private String applyWiredCount;

    // 申请无线个数
    @NotBlank
    private String applyWirelessCount;

    // 申请原因
    private String applyReason;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
