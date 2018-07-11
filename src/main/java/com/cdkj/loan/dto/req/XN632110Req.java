package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 征信新增
 * @author: jiafr 
 * @since: 2018年5月24日 下午8:57:22 
 * @history:
 */
public class XN632110Req {

    private String loanBankCode;

    private String loanAmount;

    private String bizType;

    private String secondCarReport;

    @NotBlank
    private String operator;

    @NotBlank
    private String buttonCode;

    // 征信说明
    private String note;

    private List<XN632110ReqCreditUser> creditUserList;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getLoanBankCode() {
        return loanBankCode;
    }

    public void setLoanBankCode(String loanBankCode) {
        this.loanBankCode = loanBankCode;
    }

    public String getSecondCarReport() {
        return secondCarReport;
    }

    public void setSecondCarReport(String secondCarReport) {
        this.secondCarReport = secondCarReport;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public List<XN632110ReqCreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<XN632110ReqCreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

}
