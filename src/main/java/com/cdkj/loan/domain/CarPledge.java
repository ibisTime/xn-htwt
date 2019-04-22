package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 车辆抵押
* @author: tao 
* @since: 2019-04-22 16:47:56
* @history:
*/
public class CarPledge extends ABaseDO {

    private static final long serialVersionUID = 7359106558695265787L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 状态
    private String status;

    // 当前节点
    private String curNodeCode;

    // 代理人
    private String pledgeUser;

    // 代理人身份证复印件
    private String pledgeUserIdCardCopy;

    // 抵押地点
    private String pledgeAddress;

    // 抵押日期
    private Date pledgeDatetime;

    // 抵押提交银行时间
    private Date pledgeBankCommitDatetime;

    // 抵押提交说明
    private String pledgeBankCommitNote;

    // 车辆抵押补充说明
    private String pledgeSupplementNote;

    // 抵押合同编号
    private String pledgeContractCode;

    // 抵押套打模板
    private String pledgePrintTemplateId;

    // 抵押打印人
    private String pledgePrintUser;

    // 抵押打印日期
    private Date pledgePrintDatetime;

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

    public String getPledgeUser() {
        return pledgeUser;
    }

    public void setPledgeUser(String pledgeUser) {
        this.pledgeUser = pledgeUser;
    }

    public String getPledgeUserIdCardCopy() {
        return pledgeUserIdCardCopy;
    }

    public void setPledgeUserIdCardCopy(String pledgeUserIdCardCopy) {
        this.pledgeUserIdCardCopy = pledgeUserIdCardCopy;
    }

    public String getPledgeAddress() {
        return pledgeAddress;
    }

    public void setPledgeAddress(String pledgeAddress) {
        this.pledgeAddress = pledgeAddress;
    }

    public Date getPledgeDatetime() {
        return pledgeDatetime;
    }

    public void setPledgeDatetime(Date pledgeDatetime) {
        this.pledgeDatetime = pledgeDatetime;
    }

    public Date getPledgeBankCommitDatetime() {
        return pledgeBankCommitDatetime;
    }

    public void setPledgeBankCommitDatetime(Date pledgeBankCommitDatetime) {
        this.pledgeBankCommitDatetime = pledgeBankCommitDatetime;
    }

    public String getPledgeBankCommitNote() {
        return pledgeBankCommitNote;
    }

    public void setPledgeBankCommitNote(String pledgeBankCommitNote) {
        this.pledgeBankCommitNote = pledgeBankCommitNote;
    }

    public String getPledgeSupplementNote() {
        return pledgeSupplementNote;
    }

    public void setPledgeSupplementNote(String pledgeSupplementNote) {
        this.pledgeSupplementNote = pledgeSupplementNote;
    }

    public String getPledgeContractCode() {
        return pledgeContractCode;
    }

    public void setPledgeContractCode(String pledgeContractCode) {
        this.pledgeContractCode = pledgeContractCode;
    }

    public String getPledgePrintTemplateId() {
        return pledgePrintTemplateId;
    }

    public void setPledgePrintTemplateId(String pledgePrintTemplateId) {
        this.pledgePrintTemplateId = pledgePrintTemplateId;
    }

    public String getPledgePrintUser() {
        return pledgePrintUser;
    }

    public void setPledgePrintUser(String pledgePrintUser) {
        this.pledgePrintUser = pledgePrintUser;
    }

    public Date getPledgePrintDatetime() {
        return pledgePrintDatetime;
    }

    public void setPledgePrintDatetime(Date pledgePrintDatetime) {
        this.pledgePrintDatetime = pledgePrintDatetime;
    }

}
