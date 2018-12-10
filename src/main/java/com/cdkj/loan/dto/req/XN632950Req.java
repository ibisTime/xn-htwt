package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632950Req {
    // 预算单编号
    @NotBlank
    private String budgetCode;

    // 房主id
    private String homeOwnerId;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getHomeOwnerId() {
        return homeOwnerId;
    }

    public void setHomeOwnerId(String homeOwnerId) {
        this.homeOwnerId = homeOwnerId;
    }
}
