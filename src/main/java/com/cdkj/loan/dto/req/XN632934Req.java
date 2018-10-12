package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632934Req {
    // 身份证号
    @NotBlank
    private String identityCardNo;

    // 姓名
    @NotBlank
    private String identityName;

    // 银行卡号
    @NotBlank
    private String bankcard;

    // 账号
    @NotBlank
    private String username;

    // 密码
    @NotBlank
    private String password;

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getBankcard() {
        return bankcard;
    }

    public void setBankcard(String bankcard) {
        this.bankcard = bankcard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
