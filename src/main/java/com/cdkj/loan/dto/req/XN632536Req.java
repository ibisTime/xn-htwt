package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-担保人信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632536Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /***************担保人信息start**************/

    // 户籍地省市区
    @NotBlank
    private String guaBirthAddressProvince;// creditUser

    @NotBlank
    private String guaBirthAddressCity;// creditUser

    @NotBlank
    private String guaBirthAddressArea;// creditUser

    // 户籍地地址
    @NotBlank
    private String guaBirthAddress;// creditUser

    // 户籍地邮编
    @NotBlank
    private String guaPostCode;// creditUser

    // 配偶学历
    @NotBlank
    private String guaEducation;// creditUser

    // 配偶工作单位名称
    @NotBlank
    private String guaCompanyName;// creditUser

    // 配偶工作单位地址
    @NotBlank
    private String guaCompanyAddress;// creditUser

    // 配偶工作单位联系电话
    @NotBlank
    private String guaCompanyContactNo;// creditUser

    private String guaAssetPdf;

    /****************担保人信息end***************/

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

    public String getGuaBirthAddressProvince() {
        return guaBirthAddressProvince;
    }

    public void setGuaBirthAddressProvince(String guaBirthAddressProvince) {
        this.guaBirthAddressProvince = guaBirthAddressProvince;
    }

    public String getGuaBirthAddressCity() {
        return guaBirthAddressCity;
    }

    public void setGuaBirthAddressCity(String guaBirthAddressCity) {
        this.guaBirthAddressCity = guaBirthAddressCity;
    }

    public String getGuaBirthAddressArea() {
        return guaBirthAddressArea;
    }

    public void setGuaBirthAddressArea(String guaBirthAddressArea) {
        this.guaBirthAddressArea = guaBirthAddressArea;
    }

    public String getGuaBirthAddress() {
        return guaBirthAddress;
    }

    public void setGuaBirthAddress(String guaBirthAddress) {
        this.guaBirthAddress = guaBirthAddress;
    }

    public String getGuaPostCode() {
        return guaPostCode;
    }

    public void setGuaPostCode(String guaPostCode) {
        this.guaPostCode = guaPostCode;
    }

    public String getGuaEducation() {
        return guaEducation;
    }

    public void setGuaEducation(String guaEducation) {
        this.guaEducation = guaEducation;
    }

    public String getGuaCompanyName() {
        return guaCompanyName;
    }

    public void setGuaCompanyName(String guaCompanyName) {
        this.guaCompanyName = guaCompanyName;
    }

    public String getGuaCompanyAddress() {
        return guaCompanyAddress;
    }

    public void setGuaCompanyAddress(String guaCompanyAddress) {
        this.guaCompanyAddress = guaCompanyAddress;
    }

    public String getGuaCompanyContactNo() {
        return guaCompanyContactNo;
    }

    public void setGuaCompanyContactNo(String guaCompanyContactNo) {
        this.guaCompanyContactNo = guaCompanyContactNo;
    }

    public String getGuaAssetPdf() {
        return guaAssetPdf;
    }

    public void setGuaAssetPdf(String guaAssetPdf) {
        this.guaAssetPdf = guaAssetPdf;
    }
}
