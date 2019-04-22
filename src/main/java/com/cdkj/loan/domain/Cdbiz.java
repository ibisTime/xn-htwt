package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 车贷业务
* @author: tao 
* @since: 2019-04-02 16:54:29
* @history:
*/
public class Cdbiz extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 业务类型（0新车1二手车）
    private String type;

    private String bizType;

    private String repayBizType;

    private String companyCode;

    // 团队编号
    private String teamCode;

    private String captainCode;

    private String saleUserId;

    private String insideJob;

    private String loanBank;

    private Long loanAmount;

    private String enterLocation;

    private Date enterDatetime;

    private String enterFilelist;

    // 主线状态
    private String status;

    // 面签状态
    private String mqStatus;

    // 发保合GPS状态
    private String fbhgpsStatus;

    // 第一次存档状态
    private String fircundangStatus;

    // 第二次存档状态
    private String seccundangStatus;

    // 作废状态
    private String zfStatus;

    private String curNodeCode;

    private String intevCurNodeCode;

    private String makeCardNode;

    private String fbhgpsNode;

    private String cancelNodeCode;

    private String isGpsAz;

    private String isFinacing;

    private String isAdvanceFund;

    private String isPlatInsure;

    private Long shouldFeeAmount;

    private Long realFeeAmount;

    private String guaMode;

    private String creditNote;

    private Date applyDatetime;

    private String remark;

    private SYSUser sysUser;

    private Credit credit;

    private BudgetOrder budgetOrder;

    private List<Attachment> attachments;

    private List<BizTask> bizTasks;

    private List<SYSBizLog> bizLogs;

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<BizTask> getBizTasks() {
        return bizTasks;
    }

    public void setBizTasks(List<BizTask> bizTasks) {
        this.bizTasks = bizTasks;
    }

    public List<SYSBizLog> getBizLogs() {
        return bizLogs;
    }

    public void setBizLogs(List<SYSBizLog> bizLogs) {
        this.bizLogs = bizLogs;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public BudgetOrder getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(BudgetOrder budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public SYSUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SYSUser sysUser) {
        this.sysUser = sysUser;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMqStatus(String mqStatus) {
        this.mqStatus = mqStatus;
    }

    public String getMqStatus() {
        return mqStatus;
    }

    public void setFbhgpsStatus(String fbhgpsStatus) {
        this.fbhgpsStatus = fbhgpsStatus;
    }

    public String getFbhgpsStatus() {
        return fbhgpsStatus;
    }

    public void setFircundangStatus(String fircundangStatus) {
        this.fircundangStatus = fircundangStatus;
    }

    public String getFircundangStatus() {
        return fircundangStatus;
    }

    public void setSeccundangStatus(String seccundangStatus) {
        this.seccundangStatus = seccundangStatus;
    }

    public String getSeccundangStatus() {
        return seccundangStatus;
    }

    public void setZfStatus(String zfStatus) {
        this.zfStatus = zfStatus;
    }

    public String getZfStatus() {
        return zfStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getRepayBizType() {
        return repayBizType;
    }

    public void setRepayBizType(String repayBizType) {
        this.repayBizType = repayBizType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCaptainCode() {
        return captainCode;
    }

    public void setCaptainCode(String captainCode) {
        this.captainCode = captainCode;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getInsideJob() {
        return insideJob;
    }

    public void setInsideJob(String insideJob) {
        this.insideJob = insideJob;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getEnterLocation() {
        return enterLocation;
    }

    public void setEnterLocation(String enterLocation) {
        this.enterLocation = enterLocation;
    }

    public Date getEnterDatetime() {
        return enterDatetime;
    }

    public void setEnterDatetime(Date enterDatetime) {
        this.enterDatetime = enterDatetime;
    }

    public String getEnterFilelist() {
        return enterFilelist;
    }

    public void setEnterFilelist(String enterFilelist) {
        this.enterFilelist = enterFilelist;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getIntevCurNodeCode() {
        return intevCurNodeCode;
    }

    public void setIntevCurNodeCode(String intevCurNodeCode) {
        this.intevCurNodeCode = intevCurNodeCode;
    }

    public String getMakeCardNode() {
        return makeCardNode;
    }

    public void setMakeCardNode(String makeCardNode) {
        this.makeCardNode = makeCardNode;
    }

    public String getFbhgpsNode() {
        return fbhgpsNode;
    }

    public void setFbhgpsNode(String fbhgpsNode) {
        this.fbhgpsNode = fbhgpsNode;
    }

    public String getCancelNodeCode() {
        return cancelNodeCode;
    }

    public void setCancelNodeCode(String cancelNodeCode) {
        this.cancelNodeCode = cancelNodeCode;
    }

    public String getIsGpsAz() {
        return isGpsAz;
    }

    public void setIsGpsAz(String isGpsAz) {
        this.isGpsAz = isGpsAz;
    }

    public String getIsFinacing() {
        return isFinacing;
    }

    public void setIsFinacing(String isFinacing) {
        this.isFinacing = isFinacing;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getIsPlatInsure() {
        return isPlatInsure;
    }

    public void setIsPlatInsure(String isPlatInsure) {
        this.isPlatInsure = isPlatInsure;
    }

    public Long getShouldFeeAmount() {
        return shouldFeeAmount;
    }

    public void setShouldFeeAmount(Long shouldFeeAmount) {
        this.shouldFeeAmount = shouldFeeAmount;
    }

    public Long getRealFeeAmount() {
        return realFeeAmount;
    }

    public void setRealFeeAmount(Long realFeeAmount) {
        this.realFeeAmount = realFeeAmount;
    }

    public String getGuaMode() {
        return guaMode;
    }

    public void setGuaMode(String guaMode) {
        this.guaMode = guaMode;
    }

    public String getCreditNote() {
        return creditNote;
    }

    public void setCreditNote(String creditNote) {
        this.creditNote = creditNote;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

}
