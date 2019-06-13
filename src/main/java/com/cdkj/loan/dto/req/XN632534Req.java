package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-工作情况
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632534Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /**
     * ***********工作情况start*************
     */

    // 所属行业
    private String workBelongIndustry; // creditUserExt

    // 单位性质
    private String workCompanyProperty; // creditUserExt

    // 工作单位名称
    private String companyName; // creditUser

    // 工作单位地址省
    private String companyProvince;

    // 工作单位地址市
    private String companyCity;

    // 工作单位地址区
    private String companyArea;

    // 工作单位地址
    private String companyAddress; // creditUser

    // 工作单位电话
    private String companyContactNo; // creditUser

    // 何时进入现单位工作
    private String workDatetime; // creditUserExt

    // 职位
    private String position; // creditUserExt

    // 月收入
    private String monthIncome; // creditUserExt

    /**
     * 员工数量
     */
    private String employeeQuantity;

    /**
     * 企业月产值
     */
    private String enterpriseMonthOutput;

    // 收入证明
    private String improvePdf;

    // 单位前台照片
    private String frontTablePic;

    // 单位场地照片
    private String workPlacePic;

    // 业务员与客户合影
    private String salerAndcustomer;

    // 工作描述及还款来源分析
    private String otherWorkNote;

    /**
     * ************工作情况end**************
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getWorkBelongIndustry() {
        return workBelongIndustry;
    }

    public void setWorkBelongIndustry(String workBelongIndustry) {
        this.workBelongIndustry = workBelongIndustry;
    }

    public String getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(String employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public String getEnterpriseMonthOutput() {
        return enterpriseMonthOutput;
    }

    public void setEnterpriseMonthOutput(String enterpriseMonthOutput) {
        this.enterpriseMonthOutput = enterpriseMonthOutput;
    }

    public String getWorkCompanyProperty() {
        return workCompanyProperty;
    }

    public void setWorkCompanyProperty(String workCompanyProperty) {
        this.workCompanyProperty = workCompanyProperty;
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

    public String getCompanyContactNo() {
        return companyContactNo;
    }

    public void setCompanyContactNo(String companyContactNo) {
        this.companyContactNo = companyContactNo;
    }

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getImprovePdf() {
        return improvePdf;
    }

    public void setImprovePdf(String improvePdf) {
        this.improvePdf = improvePdf;
    }

    public String getFrontTablePic() {
        return frontTablePic;
    }

    public void setFrontTablePic(String frontTablePic) {
        this.frontTablePic = frontTablePic;
    }

    public String getWorkPlacePic() {
        return workPlacePic;
    }

    public void setWorkPlacePic(String workPlacePic) {
        this.workPlacePic = workPlacePic;
    }

    public String getSalerAndcustomer() {
        return salerAndcustomer;
    }

    public void setSalerAndcustomer(String salerAndcustomer) {
        this.salerAndcustomer = salerAndcustomer;
    }

    public String getOtherWorkNote() {
        return otherWorkNote;
    }

    public void setOtherWorkNote(String otherWorkNote) {
        this.otherWorkNote = otherWorkNote;
    }

    public String getCompanyProvince() {
        return companyProvince;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(String companyArea) {
        this.companyArea = companyArea;
    }
}
