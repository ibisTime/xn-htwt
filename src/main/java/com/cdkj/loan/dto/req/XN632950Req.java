package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632950Req {

    @NotBlank
    private String budgetCode;// 预算单编号

    // 房主id
    private String homeOwnerId;

    public String getHomeOwnerId() {
        return homeOwnerId;
    }

    public void setHomeOwnerId(String homeOwnerId) {
        this.homeOwnerId = homeOwnerId;
    }

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

}
