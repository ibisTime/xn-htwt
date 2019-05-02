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

    @NotBlank
    // 处理类型(0 保存 1 发送)
    private String dealType;

    /***************共还人信息start**************/

    // 户籍地省市区
    @NotBlank
    private String mateBirthAddressProvince;// creditUser

    @NotBlank
    private String mateBirthAddressCity;// creditUser

    @NotBlank
    private String mateBirthAddressArea;// creditUser

    // 户籍地地址
    @NotBlank
    private String mateBirthAddress;// creditUser

    // 户籍地邮编
    @NotBlank
    private String matePostCode;// creditUser

    // 配偶学历
    @NotBlank
    private String mateEducation;// creditUser

    // 配偶工作单位名称
    @NotBlank
    private String mateCompanyName;// creditUser

    // 配偶工作单位地址
    @NotBlank
    private String mateCompanyAddress;// creditUser

    // 配偶工作单位联系电话
    @NotBlank
    private String mateCompanyContactNo;// creditUser

    private String mateAssetPdf;

    /****************共还人信息end***************/

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

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getMateBirthAddressProvince() {
        return mateBirthAddressProvince;
    }

    public void setMateBirthAddressProvince(String mateBirthAddressProvince) {
        this.mateBirthAddressProvince = mateBirthAddressProvince;
    }

    public String getMateBirthAddressCity() {
        return mateBirthAddressCity;
    }

    public void setMateBirthAddressCity(String mateBirthAddressCity) {
        this.mateBirthAddressCity = mateBirthAddressCity;
    }

    public String getMateBirthAddressArea() {
        return mateBirthAddressArea;
    }

    public void setMateBirthAddressArea(String mateBirthAddressArea) {
        this.mateBirthAddressArea = mateBirthAddressArea;
    }

    public String getMateBirthAddress() {
        return mateBirthAddress;
    }

    public void setMateBirthAddress(String mateBirthAddress) {
        this.mateBirthAddress = mateBirthAddress;
    }

    public String getMatePostCode() {
        return matePostCode;
    }

    public void setMatePostCode(String matePostCode) {
        this.matePostCode = matePostCode;
    }

    public String getMateEducation() {
        return mateEducation;
    }

    public void setMateEducation(String mateEducation) {
        this.mateEducation = mateEducation;
    }

    public String getMateCompanyName() {
        return mateCompanyName;
    }

    public void setMateCompanyName(String mateCompanyName) {
        this.mateCompanyName = mateCompanyName;
    }

    public String getMateCompanyAddress() {
        return mateCompanyAddress;
    }

    public void setMateCompanyAddress(String mateCompanyAddress) {
        this.mateCompanyAddress = mateCompanyAddress;
    }

    public String getMateCompanyContactNo() {
        return mateCompanyContactNo;
    }

    public void setMateCompanyContactNo(String mateCompanyContactNo) {
        this.mateCompanyContactNo = mateCompanyContactNo;
    }

    public String getMateAssetPdf() {
        return mateAssetPdf;
    }

    public void setMateAssetPdf(String mateAssetPdf) {
        this.mateAssetPdf = mateAssetPdf;
    }
}
