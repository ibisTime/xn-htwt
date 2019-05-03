package com.cdkj.loan.dto.req;

import java.util.List;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 征信新增
 * @author: jiafr 
 * @since: 2018年5月24日 下午8:57:22 
 * @history:
 */
public class XN632110Req {

    @NotBlank
    private String loanBankCode;

    @NotBlank
    private String loanAmount;

    // 业务种类（0新车1二手车）
    @NotBlank
    private String bizType;

    // 二手车报告
    private String secondCarReport;

    // 行驶证正面
    private String xszFront;

    // 行驶证反面
    private String xszReverse;

    @NotBlank
    private String operator;

    // 0保存 1发送
    @NotBlank
    private String buttonCode;

    // 征信说明
    private String note;

    // 征信人员列表
    @NotEmpty
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

    public String getXszFront() {
        return xszFront;
    }

    public void setXszFront(String xszFront) {
        this.xszFront = xszFront;
    }

    public String getXszReverse() {
        return xszReverse;
    }

    public void setXszReverse(String xszReverse) {
        this.xszReverse = xszReverse;
    }

}
