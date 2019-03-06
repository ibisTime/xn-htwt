package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN805062Req {
    // userId（必填）
    @NotBlank
    private String userId;

    // 新登录密码(必填)
    @NotBlank
    private String newLoginPwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNewLoginPwd() {
        return newLoginPwd;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

}
