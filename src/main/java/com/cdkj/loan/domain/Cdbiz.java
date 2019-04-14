package com.cdkj.loan.domain;

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

    // 主贷人
    private String mainLoaner;

    // 经办银行
    private String bankCode;

    // 业务类型（0新车1二手车）
    private String bizType;

    // 贷款金额
    private Long dkAmount;

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

    // 业务员
    private String ywyUser;

    // 团队编号
    private String teamCode;

    private SYSUser sysUser;

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

    public void setMainLoaner(String mainLoaner) {
        this.mainLoaner = mainLoaner;
    }

    public String getMainLoaner() {
        return mainLoaner;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setDkAmount(Long dkAmount) {
        this.dkAmount = dkAmount;
    }

    public Long getDkAmount() {
        return dkAmount;
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

    public void setYwyUser(String ywyUser) {
        this.ywyUser = ywyUser;
    }

    public String getYwyUser() {
        return ywyUser;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

}
