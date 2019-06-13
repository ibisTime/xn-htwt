package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* gps
* @author: xieyj 
* @since: 2018-05-26 20:26:21
* @history:
*/
public class Gps extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // gps编号
    private String gpsDevNo;

    // gps类型
    private String gpsType;

    // 公司编号
    private String companyCode;

    // 申请单号
    private String applyCode;

    // 申请人
    private String applyUser;

    // 申请状态
    private String applyStatus;

    // 申请日期
    private Date applyDatetime;

    // 使用状态
    private String useStatus;

    // 使用日期
    private Date useDatetime;

    // 业务编号
    private String bizCode;

    // 客户姓名
    private String customerName;

    private String updater;

    private Date updateDatetime;

    /*****************/
    // 公司编号
    private String companyName;

    // 申请人姓名
    private String applyUserName;

    // 申请人角色
    private String applyUserRole;

    // 客户姓名
    private String customerNameQuery;

    // 预算单
    private BudgetOrder budgetOrder;

    // 业务
    private Cdbiz cdbiz;

    // gps编号模糊查
    private String gpsDevNoForQuery;

    public Cdbiz getCdbiz() {
        return cdbiz;
    }

    public void setCdbiz(Cdbiz cdbiz) {
        this.cdbiz = cdbiz;
    }

    public String getApplyUserRole() {
        return applyUserRole;
    }

    public void setApplyUserRole(String applyUserRole) {
        this.applyUserRole = applyUserRole;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getCustomerNameQuery() {
        return customerNameQuery;
    }

    public void setCustomerNameQuery(String customerNameQuery) {
        this.customerNameQuery = customerNameQuery;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BudgetOrder getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(BudgetOrder budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public String getGpsType() {
        return gpsType;
    }

    public void setGpsType(String gpsType) {
        this.gpsType = gpsType;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getGpsDevNo() {
        return gpsDevNo;
    }

    public void setGpsDevNo(String gpsDevNo) {
        this.gpsDevNo = gpsDevNo;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getUseDatetime() {
        return useDatetime;
    }

    public void setUseDatetime(Date useDatetime) {
        this.useDatetime = useDatetime;
    }

    public String getApplyCode() {
        return applyCode;
    }

    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getGpsDevNoForQuery() {
        return gpsDevNoForQuery;
    }

    public void setGpsDevNoForQuery(String gpsDevNoForQuery) {
        this.gpsDevNoForQuery = gpsDevNoForQuery;
    }

}
