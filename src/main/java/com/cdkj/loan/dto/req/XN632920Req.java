package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632920Req {

    // 身份证号
    @NotBlank
    private String identityNo;

    // 姓名
    @NotBlank
    private String name;

    // 用户id（App端填写）
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
