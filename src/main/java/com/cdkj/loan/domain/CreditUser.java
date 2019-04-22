package com.cdkj.loan.domain;

import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 征信人员
 * @author: jiafr 
 * @since: 2018年5月24日 下午9:32:23 
 * @history:
 */
public class CreditUser extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    private String bizCode;

    // 与借款人关系
    private String relation;

    // 贷款角色
    private String loanRole;

    // 姓名
    private String userName;

    // 手机号
    private String mobile;

    // 身份证类型
    private String idKind;

    // 证件号码
    private String idNo;

    // 信用卡占比
    private Double creditCardOccupation;

    // 银行征信结果
    private String bankCreditResult;

    // 银行征信结果说明
    private String bankCreditResultRemark;

    private String birthAddressProvince;

    private String birthAddressCity;

    private String birthAddressArea;

    private String birthAddress;

    private String postCode;

    private String education;

    private String companyName;

    private String companyAddress;

    private String companyContactTo;

    private String houseAssetAddress;

    // 征信人员列表
    private List<CreditUser> creditUserList;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLoanRole() {
        return loanRole;
    }

    public void setLoanRole(String loanRole) {
        this.loanRole = loanRole;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public Double getCreditCardOccupation() {
        return creditCardOccupation;
    }

    public void setCreditCardOccupation(Double creditCardOccupation) {
        this.creditCardOccupation = creditCardOccupation;
    }

    public String getBankCreditResult() {
        return bankCreditResult;
    }

    public void setBankCreditResult(String bankCreditResult) {
        this.bankCreditResult = bankCreditResult;
    }

    public String getBankCreditResultRemark() {
        return bankCreditResultRemark;
    }

    public void setBankCreditResultRemark(String bankCreditResultRemark) {
        this.bankCreditResultRemark = bankCreditResultRemark;
    }

    public List<CreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<CreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getBirthAddressProvince() {
        return birthAddressProvince;
    }

    public void setBirthAddressProvince(String birthAddressProvince) {
        this.birthAddressProvince = birthAddressProvince;
    }

    public String getBirthAddressCity() {
        return birthAddressCity;
    }

    public void setBirthAddressCity(String birthAddressCity) {
        this.birthAddressCity = birthAddressCity;
    }

    public String getBirthAddressArea() {
        return birthAddressArea;
    }

    public void setBirthAddressArea(String birthAddressArea) {
        this.birthAddressArea = birthAddressArea;
    }

    public String getBirthAddress() {
        return birthAddress;
    }

    public void setBirthAddress(String birthAddress) {
        this.birthAddress = birthAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyContactTo() {
        return companyContactTo;
    }

    public void setCompanyContactTo(String companyContactTo) {
        this.companyContactTo = companyContactTo;
    }

    public String getHouseAssetAddress() {
        return houseAssetAddress;
    }

    public void setHouseAssetAddress(String houseAssetAddress) {
        this.houseAssetAddress = houseAssetAddress;
    }

}
