package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN805061Req {

    // userId
    @NotBlank
    private String userId;

    // 新手机号
    @NotBlank
    private String newMobile;

    @NotBlank
    private String newCaptcha;

    @NotBlank
    private String oldMobile;

    @NotBlank
    private String oldCaptcha;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNewMobile() {
        return newMobile;
    }

    public void setNewMobile(String newMobile) {
        this.newMobile = newMobile;
    }

    public String getNewCaptcha() {
        return newCaptcha;
    }

    public void setNewCaptcha(String newCaptcha) {
        this.newCaptcha = newCaptcha;
    }

    public String getOldMobile() {
        return oldMobile;
    }

    public void setOldMobile(String oldMobile) {
        this.oldMobile = oldMobile;
    }

    public String getOldCaptcha() {
        return oldCaptcha;
    }

    public void setOldCaptcha(String oldCaptcha) {
        this.oldCaptcha = oldCaptcha;
    }

}
