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

    /**
     * **********家庭情况start*************
     */

    // 婚姻状况
    private String marryState;

    // 家庭人口
    private String familyNumber;

    // 家庭电话
    private String familyPhone;

    // 家庭主要财产
    private String familyMainAsset;

    // 主要财产包括
    private String mainAssetInclude;

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

    /**
     * 现住房屋类型
     */
    private String nowHouseType;

    /**
     * 现住地址省
     */
    private String nowAddressProvince;

    /**
     * 现住地址市
     */
    private String nowAddressCity;

    /**
     * 现住地址区
     */
    private String nowAddressArea;

    /**
     * 现居住地址
     */
    private String nowAddress;

    /**
     * 现居住地址邮编
     */
    private String nowPostCode;

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

    public String getNowHouseType() {
        return nowHouseType;
    }

    public void setNowHouseType(String nowHouseType) {
        this.nowHouseType = nowHouseType;
    }

    public String getNowAddressProvince() {
        return nowAddressProvince;
    }

    public void setNowAddressProvince(String nowAddressProvince) {
        this.nowAddressProvince = nowAddressProvince;
    }

    public String getNowAddressCity() {
        return nowAddressCity;
    }

    public void setNowAddressCity(String nowAddressCity) {
        this.nowAddressCity = nowAddressCity;
    }

    public String getNowAddressArea() {
        return nowAddressArea;
    }

    public void setNowAddressArea(String nowAddressArea) {
        this.nowAddressArea = nowAddressArea;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getNowPostCode() {
        return nowPostCode;
    }

    public void setNowPostCode(String nowPostCode) {
        this.nowPostCode = nowPostCode;
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
