package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-共还人信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632535Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /** ************共还人信息start************* */

    /**
     * 户籍地省
     */
    private String birthAddressProvince;

    /**
     * 户籍地市
     */
    private String birthAddressCity;

    /**
     * 户籍地区
     */
    private String birthAddressArea;

    /**
     * 户籍地详细地址
     */
    private String birthAddress;

    /**
     * 户口所在地邮编
     */

    private String birthPostCode;

    // 学历
    private String education;

    // 工作单位名称
    private String companyName;

    // 工作单位地址
    private String companyAddress;

    // 工作单位电话
    private String companyContactNo;

    private String mateAssetPdf;

    /**
     * *********共还人信息end**************
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

    public String getBirthPostCode() {
        return birthPostCode;
    }

    public void setBirthPostCode(String birthPostCode) {
        this.birthPostCode = birthPostCode;
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

    public String getCompanyContactNo() {
        return companyContactNo;
    }

    public void setCompanyContactNo(String companyContactNo) {
        this.companyContactNo = companyContactNo;
    }

    public String getMateAssetPdf() {
        return mateAssetPdf;
    }

    public void setMateAssetPdf(String mateAssetPdf) {
        this.mateAssetPdf = mateAssetPdf;
    }
}
