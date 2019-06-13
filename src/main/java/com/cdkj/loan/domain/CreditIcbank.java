package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 工行征信结果
* @author: CYunlai 
* @since: 2018-11-28 19:18:12
* @history:
*/
public class CreditIcbank extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 申请人名称
    private String custName;

    // 证件类型
    private String idType;

    // 证件编号
    private String idNo;

    // 关系
    private String relation;

    // 风险预筛查结果
    private String result;

    // 贷款逾期记录
    private String loanCrdt;

    // 信用卡逾期记录
    private String cardCrdt;

    // 我行专项卡分期笔数
    private String leftNum;

    // 未结清余额
    private String leftAmount;

    // 状态
    private String status;

    // 创建时间
    private Date creditDatetime;

    // 备注系统编号
    private String note;

    //工行制卡退回说明
    private String backNote;

    // 系统编号
    private String systemCode;

    // 公司编号
    private String companyCode;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setLoanCrdt(String loanCrdt) {
        this.loanCrdt = loanCrdt;
    }

    public String getLoanCrdt() {
        return loanCrdt;
    }

    public void setCardCrdt(String cardCrdt) {
        this.cardCrdt = cardCrdt;
    }

    public String getCardCrdt() {
        return cardCrdt;
    }

    public void setLeftNum(String leftNum) {
        this.leftNum = leftNum;
    }

    public String getLeftNum() {
        return leftNum;
    }

    public void setLeftAmount(String leftAmount) {
        this.leftAmount = leftAmount;
    }

    public String getLeftAmount() {
        return leftAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreditDatetime() {
        return creditDatetime;
    }

    public void setCreditDatetime(Date creditDatetime) {
        this.creditDatetime = creditDatetime;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBackNote() {
        return backNote;
    }

    public void setBackNote(String backNote) {
        this.backNote = backNote;
    }
}
