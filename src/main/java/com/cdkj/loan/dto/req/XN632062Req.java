package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632062Req {

    @NotBlank
    private String code;// 编号

    @NotBlank
    private String fullName;// 全称

    @NotBlank
    private String abbrName;// 简称

    @NotBlank
    private String isSelfDevelop;// 是否自主开发

    @NotBlank
    private String address;// 地址

    @NotBlank
    private String carDealerType;// 车行经营性质

    @NotBlank
    private String mainContact;// 主要联系人

    @NotBlank
    private String contactPhone;// 联系人电话

    @NotBlank
    private String mainBrand;// 主营品牌

    @NotBlank
    private String parentGroup;// 所属集团

    @NotBlank
    private String agreementValidDateStart;// 合作协议有效期起

    @NotBlank
    private String agreementValidDateEnd;// 合作协议有效期止

    private String agreementStatus;// 协议状态(0下架1上架)

    @NotBlank
    private String agreementPic;// 车商合作协议

    @NotBlank
    private String settleWay;// 结算方式

    @NotBlank
    private String businessArea;// 业务区域

    @NotBlank
    private String belongBranchCompany;// 归属分公司

    private String policyNote;// 政策说明

    private String remark;// 备注

    private String updater;//修改人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public String getIsSelfDevelop() {
        return isSelfDevelop;
    }

    public void setIsSelfDevelop(String isSelfDevelop) {
        this.isSelfDevelop = isSelfDevelop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarDealerType() {
        return carDealerType;
    }

    public void setCarDealerType(String carDealerType) {
        this.carDealerType = carDealerType;
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getMainBrand() {
        return mainBrand;
    }

    public void setMainBrand(String mainBrand) {
        this.mainBrand = mainBrand;
    }

    public String getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(String parentGroup) {
        this.parentGroup = parentGroup;
    }

    public String getAgreementValidDateStart() {
        return agreementValidDateStart;
    }

    public void setAgreementValidDateStart(String agreementValidDateStart) {
        this.agreementValidDateStart = agreementValidDateStart;
    }

    public String getAgreementValidDateEnd() {
        return agreementValidDateEnd;
    }

    public void setAgreementValidDateEnd(String agreementValidDateEnd) {
        this.agreementValidDateEnd = agreementValidDateEnd;
    }

    public String getAgreementStatus() {
        return agreementStatus;
    }

    public void setAgreementStatus(String agreementStatus) {
        this.agreementStatus = agreementStatus;
    }

    public String getAgreementPic() {
        return agreementPic;
    }

    public void setAgreementPic(String agreementPic) {
        this.agreementPic = agreementPic;
    }

    public String getSettleWay() {
        return settleWay;
    }

    public void setSettleWay(String settleWay) {
        this.settleWay = settleWay;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getBelongBranchCompany() {
        return belongBranchCompany;
    }

    public void setBelongBranchCompany(String belongBranchCompany) {
        this.belongBranchCompany = belongBranchCompany;
    }

    public String getPolicyNote() {
        return policyNote;
    }

    public void setPolicyNote(String policyNote) {
        this.policyNote = policyNote;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
