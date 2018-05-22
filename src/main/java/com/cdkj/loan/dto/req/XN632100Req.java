package com.cdkj.loan.dto.req;

import org.springframework.beans.factory.annotation.Autowired;

public class XN632100Req {
    @Autowired
    private String userId;// 用户编号

    @Autowired
    private String receiptBank;// 收款银行

    @Autowired
    private String receiptAccount;// 收款账号

    @Autowired
    private String budgetAmount;// 预算金额

    @Autowired
    private String useDatetime;// 用款日期

    @Autowired
    private String operator;// 操作人

    @Autowired
    private String buttonCode;// 按钮标识

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiptBank() {
        return receiptBank;
    }

    public void setReceiptBank(String receiptBank) {
        this.receiptBank = receiptBank;
    }

    public String getReceiptAccount() {
        return receiptAccount;
    }

    public void setReceiptAccount(String receiptAccount) {
        this.receiptAccount = receiptAccount;
    }

    public String getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(String budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getUseDatetime() {
        return useDatetime;
    }

    public void setUseDatetime(String useDatetime) {
        this.useDatetime = useDatetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

}
