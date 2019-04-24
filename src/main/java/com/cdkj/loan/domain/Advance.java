package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 财务垫资
* @author: tao 
* @since: 2019-04-24 16:31:04
* @history:
*/
public class Advance extends ABaseDO {

    private static final long serialVersionUID = 6981932577813061723L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 状态
    private String status;

    // 当前节点
    private String curNodeCode;

    // 1总公司业务 2分公司业务
    private String type;

    // 退客户垫资款状态
    private String backAdvanceStatus;

    // 收回垫资款类型（1客户作废2垫资款退回）
    private String backAdvanceFundType;

    // 垫资日期
    private Date advanceFundDatetime;

    // 垫资金额
    private Integer advanceFundAmount;

    // 垫资汇总单编号(分公司业务才有)
    private String totalAdvanceFundCode;

    // 水单
    private String billPdf;

    // 垫资说明
    private String advanceNote;

    // 退客户垫资款 退款金额
    private Integer backAdvanceAmount;

    // 退客户垫资款 收款账号
    private String backAdvanceAccount;

    // 退客户垫资款 开户行
    private String backAdvanceOpenBank;

    // 退客户垫资款 开户支行
    private String backAdvanceSubbranch;

    // 退客户垫资款 水单
    private String backAdvanceWaterBill;

    // 用款金额(应退按揭款)
    private Integer useAmount;

    // 金额来源(1财务部2预支款)
    private String fundSource;

    // 制单意见说明
    private String makeBillNote;

    // 撤销理由
    private String cancelReason;

    // 付款时间
    private Date payBackDatetime;

    // 付款银行
    private String payBackBankcardCode;

    // 付款凭证
    private String payBackBillPdf;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackAdvanceStatus() {
        return backAdvanceStatus;
    }

    public void setBackAdvanceStatus(String backAdvanceStatus) {
        this.backAdvanceStatus = backAdvanceStatus;
    }

    public String getBackAdvanceFundType() {
        return backAdvanceFundType;
    }

    public void setBackAdvanceFundType(String backAdvanceFundType) {
        this.backAdvanceFundType = backAdvanceFundType;
    }

    public Date getAdvanceFundDatetime() {
        return advanceFundDatetime;
    }

    public void setAdvanceFundDatetime(Date advanceFundDatetime) {
        this.advanceFundDatetime = advanceFundDatetime;
    }

    public Integer getAdvanceFundAmount() {
        return advanceFundAmount;
    }

    public void setAdvanceFundAmount(Integer advanceFundAmount) {
        this.advanceFundAmount = advanceFundAmount;
    }

    public String getTotalAdvanceFundCode() {
        return totalAdvanceFundCode;
    }

    public void setTotalAdvanceFundCode(String totalAdvanceFundCode) {
        this.totalAdvanceFundCode = totalAdvanceFundCode;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public String getAdvanceNote() {
        return advanceNote;
    }

    public void setAdvanceNote(String advanceNote) {
        this.advanceNote = advanceNote;
    }

    public Integer getBackAdvanceAmount() {
        return backAdvanceAmount;
    }

    public void setBackAdvanceAmount(Integer backAdvanceAmount) {
        this.backAdvanceAmount = backAdvanceAmount;
    }

    public String getBackAdvanceAccount() {
        return backAdvanceAccount;
    }

    public void setBackAdvanceAccount(String backAdvanceAccount) {
        this.backAdvanceAccount = backAdvanceAccount;
    }

    public String getBackAdvanceOpenBank() {
        return backAdvanceOpenBank;
    }

    public void setBackAdvanceOpenBank(String backAdvanceOpenBank) {
        this.backAdvanceOpenBank = backAdvanceOpenBank;
    }

    public String getBackAdvanceSubbranch() {
        return backAdvanceSubbranch;
    }

    public void setBackAdvanceSubbranch(String backAdvanceSubbranch) {
        this.backAdvanceSubbranch = backAdvanceSubbranch;
    }

    public String getBackAdvanceWaterBill() {
        return backAdvanceWaterBill;
    }

    public void setBackAdvanceWaterBill(String backAdvanceWaterBill) {
        this.backAdvanceWaterBill = backAdvanceWaterBill;
    }

    public Integer getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(Integer useAmount) {
        this.useAmount = useAmount;
    }

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    public String getMakeBillNote() {
        return makeBillNote;
    }

    public void setMakeBillNote(String makeBillNote) {
        this.makeBillNote = makeBillNote;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Date getPayBackDatetime() {
        return payBackDatetime;
    }

    public void setPayBackDatetime(Date payBackDatetime) {
        this.payBackDatetime = payBackDatetime;
    }

    public String getPayBackBankcardCode() {
        return payBackBankcardCode;
    }

    public void setPayBackBankcardCode(String payBackBankcardCode) {
        this.payBackBankcardCode = payBackBankcardCode;
    }

    public String getPayBackBillPdf() {
        return payBackBillPdf;
    }

    public void setPayBackBillPdf(String payBackBillPdf) {
        this.payBackBillPdf = payBackBillPdf;
    }

}
