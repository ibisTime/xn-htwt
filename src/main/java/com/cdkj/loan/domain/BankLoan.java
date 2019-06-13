package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;
import org.hibernate.validator.constraints.NotBlank;

/**
* 银行放款
* @author: tao 
* @since: 2019-04-22 16:04:01
* @history:
*/
public class BankLoan extends ABaseDO {

    private static final long serialVersionUID = -8157236784139410365L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 状态
    private String status;

    // 当前节点编号
    private String curNodeCode;

    // 还款卡银行编号
    private String repayBankCode;

    // 还款卡银行名称
    private String repayBankName;

    // 还款卡开户支行
    private String repaySubbranch;

    // 还款卡银行卡号
    private String repayBankcardNumber;

    // 收款银行编号
    private String receiptBankCode;

    // 收款银行名称
    private String receiptBankName;

    // 收款银行支行
    private String receiptSubbranch;

    // 收款银行卡号
    private String receiptBankcardNumber;

    // 银行提交时间
    private Date bankCommitDatetime;

    // 银行提交说明
    private String bankCommitNote;

    // 银行放款时间
    private Date bankFkDatetime;

    // 银行账单日
    private Integer repayBillDate;

    // 银行还款日
    private Integer repayBankDate;

    // 公司还款日
    private Integer repayCompanyDate;

    // 收款凭证
    private String receiptPdf;

    // 收款备注
    private String receiptRemark;

    // 银行放款进件时间
    private Date bankFkSendDatetime;

    // 已放款名单
    private String hasLoanListPic;

    // 银行放款金额
    private Integer bankFkAmount;

    // 月还款额
    private Integer monthAmount;

    private String repayFirstMonthDatetime; // 首期还款日期

    private String repayFirstMonthAmount;// 首期月供金额

    private String repayMonthAmount;// 每期月供金额

    private String bankFkDate;// 放款日期


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getRepayBankCode() {
        return repayBankCode;
    }

    public void setRepayBankCode(String repayBankCode) {
        this.repayBankCode = repayBankCode;
    }

    public String getRepayBankName() {
        return repayBankName;
    }

    public void setRepayBankName(String repayBankName) {
        this.repayBankName = repayBankName;
    }

    public String getRepaySubbranch() {
        return repaySubbranch;
    }

    public void setRepaySubbranch(String repaySubbranch) {
        this.repaySubbranch = repaySubbranch;
    }

    public String getRepayBankcardNumber() {
        return repayBankcardNumber;
    }

    public void setRepayBankcardNumber(String repayBankcardNumber) {
        this.repayBankcardNumber = repayBankcardNumber;
    }

    public String getReceiptBankCode() {
        return receiptBankCode;
    }

    public void setReceiptBankCode(String receiptBankCode) {
        this.receiptBankCode = receiptBankCode;
    }

    public String getReceiptBankName() {
        return receiptBankName;
    }

    public void setReceiptBankName(String receiptBankName) {
        this.receiptBankName = receiptBankName;
    }

    public String getReceiptSubbranch() {
        return receiptSubbranch;
    }

    public void setReceiptSubbranch(String receiptSubbranch) {
        this.receiptSubbranch = receiptSubbranch;
    }

    public String getReceiptBankcardNumber() {
        return receiptBankcardNumber;
    }

    public void setReceiptBankcardNumber(String receiptBankcardNumber) {
        this.receiptBankcardNumber = receiptBankcardNumber;
    }

    public Date getBankCommitDatetime() {
        return bankCommitDatetime;
    }

    public void setBankCommitDatetime(Date bankCommitDatetime) {
        this.bankCommitDatetime = bankCommitDatetime;
    }

    public String getBankCommitNote() {
        return bankCommitNote;
    }

    public void setBankCommitNote(String bankCommitNote) {
        this.bankCommitNote = bankCommitNote;
    }

    public Date getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(Date bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public Integer getRepayBillDate() {
        return repayBillDate;
    }

    public void setRepayBillDate(Integer repayBillDate) {
        this.repayBillDate = repayBillDate;
    }

    public Integer getRepayBankDate() {
        return repayBankDate;
    }

    public void setRepayBankDate(Integer repayBankDate) {
        this.repayBankDate = repayBankDate;
    }

    public Integer getRepayCompanyDate() {
        return repayCompanyDate;
    }

    public void setRepayCompanyDate(Integer repayCompanyDate) {
        this.repayCompanyDate = repayCompanyDate;
    }

    public String getReceiptPdf() {
        return receiptPdf;
    }

    public void setReceiptPdf(String receiptPdf) {
        this.receiptPdf = receiptPdf;
    }

    public String getReceiptRemark() {
        return receiptRemark;
    }

    public void setReceiptRemark(String receiptRemark) {
        this.receiptRemark = receiptRemark;
    }

    public Date getBankFkSendDatetime() {
        return bankFkSendDatetime;
    }

    public void setBankFkSendDatetime(Date bankFkSendDatetime) {
        this.bankFkSendDatetime = bankFkSendDatetime;
    }

    public String getHasLoanListPic() {
        return hasLoanListPic;
    }

    public void setHasLoanListPic(String hasLoanListPic) {
        this.hasLoanListPic = hasLoanListPic;
    }

    public Integer getBankFkAmount() {
        return bankFkAmount;
    }

    public void setBankFkAmount(Integer bankFkAmount) {
        this.bankFkAmount = bankFkAmount;
    }

    public Integer getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(Integer monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getRepayFirstMonthDatetime() {
        return repayFirstMonthDatetime;
    }

    public void setRepayFirstMonthDatetime(String repayFirstMonthDatetime) {
        this.repayFirstMonthDatetime = repayFirstMonthDatetime;
    }

    public String getRepayFirstMonthAmount() {
        return repayFirstMonthAmount;
    }

    public void setRepayFirstMonthAmount(String repayFirstMonthAmount) {
        this.repayFirstMonthAmount = repayFirstMonthAmount;
    }

    public String getRepayMonthAmount() {
        return repayMonthAmount;
    }

    public void setRepayMonthAmount(String repayMonthAmount) {
        this.repayMonthAmount = repayMonthAmount;
    }

    public String getBankFkDate() {
        return bankFkDate;
    }

    public void setBankFkDate(String bankFkDate) {
        this.bankFkDate = bankFkDate;
    }
}
