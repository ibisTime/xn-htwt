package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632932Req {

    // 用户身份证号
    private String idNo;

    // 登陆类型
    @NotBlank
    private String loginType;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

}
