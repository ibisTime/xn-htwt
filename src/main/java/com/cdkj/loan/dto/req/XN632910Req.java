package com.cdkj.loan.dto.req;

public class XN632910Req extends APageReq {

    private static final long serialVersionUID = 1209667947927798356L;

    // 业务编号
    private String budgetCode;

    // 客户姓名
    private String applyUserName;

    // 贷款银行编号（支行编号）
    private String loanBank;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

}
