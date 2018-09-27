package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632147Req {

    @NotBlank
    private String applyUserName;// 客户姓名

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

}
