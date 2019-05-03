package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-家庭情况
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632533Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /***************家庭情况start**************/

    // 婚姻状况
    @NotBlank
    private String marryState;// creditUser

    // 家庭人口
    @NotBlank
    private String familyNumber;// creditUser

    // 家庭电话
    @NotBlank
    private String familyPhone;// creditUser

    // 家庭主要财产
    @NotBlank
    private String familyMainAsset;// creditUser

    // 主要财产包括
    @NotBlank
    private String mainAssetInclude;// creditUser

    // 户口所在地
    @NotBlank
    private String residenceAddress;// creditUser

    // 户口所在地邮编2
    @NotBlank
    private String postCode2;// creditUser

    // 现居住地址
    @NotBlank
    private String nowAddress;// creditUser

    /**
     * 现住房屋类型
     */
    @NotBlank
    private String nowHouseType;

    // 现居住地址邮编1
    @NotBlank
    private String postCode;// creditUser

    // 户口本资料
    private String hkBookPdf;

    // 结婚证资料
    private String marryPdf;

    // 购房合同
    private String houseContract;

    // 购房发票
    private String houseInvoice;

    // 居住证明
    private String liveProvePdf;

    // 自建房证明
    private String buildProvePdf;

    // 家访照片
    private String housePictureApply;

    /****************家庭情况end***************/

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

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(String familyNumber) {
        this.familyNumber = familyNumber;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public String getFamilyMainAsset() {
        return familyMainAsset;
    }

    public void setFamilyMainAsset(String familyMainAsset) {
        this.familyMainAsset = familyMainAsset;
    }

    public String getMainAssetInclude() {
        return mainAssetInclude;
    }

    public void setMainAssetInclude(String mainAssetInclude) {
        this.mainAssetInclude = mainAssetInclude;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getNowHouseType() {
        return nowHouseType;
    }

    public void setNowHouseType(String nowHouseType) {
        this.nowHouseType = nowHouseType;
    }

    public String getPostCode2() {
        return postCode2;
    }

    public void setPostCode2(String postCode2) {
        this.postCode2 = postCode2;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getHkBookPdf() {
        return hkBookPdf;
    }

    public void setHkBookPdf(String hkBookPdf) {
        this.hkBookPdf = hkBookPdf;
    }

    public String getMarryPdf() {
        return marryPdf;
    }

    public void setMarryPdf(String marryPdf) {
        this.marryPdf = marryPdf;
    }

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getHouseInvoice() {
        return houseInvoice;
    }

    public void setHouseInvoice(String houseInvoice) {
        this.houseInvoice = houseInvoice;
    }

    public String getLiveProvePdf() {
        return liveProvePdf;
    }

    public void setLiveProvePdf(String liveProvePdf) {
        this.liveProvePdf = liveProvePdf;
    }

    public String getBuildProvePdf() {
        return buildProvePdf;
    }

    public void setBuildProvePdf(String buildProvePdf) {
        this.buildProvePdf = buildProvePdf;
    }

    public String getHousePictureApply() {
        return housePictureApply;
    }

    public void setHousePictureApply(String housePictureApply) {
        this.housePictureApply = housePictureApply;
    }
}
