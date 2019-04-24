package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 征信人辅助资料
* @author: tao 
* @since: 2019-04-20 19:33:23
* @history:
*/
public class CreditUserExt extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 征信人编号
    private String creditUserCode;

    // 性别
    private String gender;

    // 年龄
    private Integer age;

    // 婚姻状况
    private String marryState;

    // 政治面貌
    private String political;

    // 民族
    private String nation;

    // 客户类型
    private String customerType;

    // 客户生日
    private String customerBirth;

    // 现住房屋类型
    private String nowHouseType;

    // 现住地址省
    private String nowAddressProvince;

    // 现住地址市
    private String nowAddressCity;

    // 现住地址区
    private String nowAddressArea;

    // 现居住地址
    private String nowAddress;

    // 现居住地址邮编
    private String postCode;

    // 是否卡邮寄地址
    private String isCardMailAddress;

    // 家庭人口
    private Integer familyNumber;

    // 家庭电话
    private String familyPhone;

    // 家庭主要财产
    private String familyMainAsset;

    // 主要财产包括
    private String mainAssetInclude;

    // 主要收入来源
    private String mainIncome;

    // 其他收入说明
    private String otherIncomeNote;

    // 购房合同
    private String houseContract;

    // 房产证情况
    private String isHouseProperty;

    // 房产证
    private String houseProperty;

    // 月收入
    private Integer monthIncome;

    // 单位性质
    private String workCompanyProperty;

    // 所属行业
    private String workBelongIndustry;

    // 职业
    private String workProfession;

    // 职位
    private String position;

    // 职称
    private String postTitle;

    // 何时进入现单位工作
    private String workDatetime;

    // 自营公司单位面积
    private String selfCompanyArea;

    // 员工数量
    private String employeeQuantity;

    // 企业月产值
    private String enterpriseMonthOutput;

    // 营业执照情况
    private String isLicense;

    // 营业执照
    private String license;

    // 组织机构代码证
    private String organizationCodeCard;

    // 代码证上的地址
    private String codeCardAddress;

    // 提供场地证明
    private String isSiteProve;

    // 场地证明
    private String siteProve;

    // 经营场地面积
    private String siteArea;

    // 联系人1姓名
    private String emergencyName1;

    // 联系人1与申请人关系
    private String emergencyRelation1;

    // 联系人1手机号码
    private String emergencyMobile1;

    // 联系人2姓名
    private String emergencyName2;

    // 联系人2与申请人关系
    private String emergencyRelation2;

    // 联系人2手机号码
    private String emergencyMobile2;

    // 现有车辆类型
    private String carType;

    // 有无驾照
    private String isDriceLicense;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreditUserCode() {
        return creditUserCode;
    }

    public void setCreditUserCode(String creditUserCode) {
        this.creditUserCode = creditUserCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getIsCardMailAddress() {
        return isCardMailAddress;
    }

    public void setIsCardMailAddress(String isCardMailAddress) {
        this.isCardMailAddress = isCardMailAddress;
    }

    public Integer getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(Integer familyNumber) {
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

    public String getMainIncome() {
        return mainIncome;
    }

    public void setMainIncome(String mainIncome) {
        this.mainIncome = mainIncome;
    }

    public String getOtherIncomeNote() {
        return otherIncomeNote;
    }

    public void setOtherIncomeNote(String otherIncomeNote) {
        this.otherIncomeNote = otherIncomeNote;
    }

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getIsHouseProperty() {
        return isHouseProperty;
    }

    public void setIsHouseProperty(String isHouseProperty) {
        this.isHouseProperty = isHouseProperty;
    }

    public String getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(String houseProperty) {
        this.houseProperty = houseProperty;
    }

    public Integer getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(Integer monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getWorkCompanyProperty() {
        return workCompanyProperty;
    }

    public void setWorkCompanyProperty(String workCompanyProperty) {
        this.workCompanyProperty = workCompanyProperty;
    }

    public String getWorkBelongIndustry() {
        return workBelongIndustry;
    }

    public void setWorkBelongIndustry(String workBelongIndustry) {
        this.workBelongIndustry = workBelongIndustry;
    }

    public String getWorkProfession() {
        return workProfession;
    }

    public void setWorkProfession(String workProfession) {
        this.workProfession = workProfession;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
    }

    public String getSelfCompanyArea() {
        return selfCompanyArea;
    }

    public void setSelfCompanyArea(String selfCompanyArea) {
        this.selfCompanyArea = selfCompanyArea;
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

    public String getIsLicense() {
        return isLicense;
    }

    public void setIsLicense(String isLicense) {
        this.isLicense = isLicense;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getOrganizationCodeCard() {
        return organizationCodeCard;
    }

    public void setOrganizationCodeCard(String organizationCodeCard) {
        this.organizationCodeCard = organizationCodeCard;
    }

    public String getCodeCardAddress() {
        return codeCardAddress;
    }

    public void setCodeCardAddress(String codeCardAddress) {
        this.codeCardAddress = codeCardAddress;
    }

    public String getIsSiteProve() {
        return isSiteProve;
    }

    public void setIsSiteProve(String isSiteProve) {
        this.isSiteProve = isSiteProve;
    }

    public String getSiteProve() {
        return siteProve;
    }

    public void setSiteProve(String siteProve) {
        this.siteProve = siteProve;
    }

    public String getSiteArea() {
        return siteArea;
    }

    public void setSiteArea(String siteArea) {
        this.siteArea = siteArea;
    }

    public String getEmergencyName1() {
        return emergencyName1;
    }

    public void setEmergencyName1(String emergencyName1) {
        this.emergencyName1 = emergencyName1;
    }

    public String getEmergencyRelation1() {
        return emergencyRelation1;
    }

    public void setEmergencyRelation1(String emergencyRelation1) {
        this.emergencyRelation1 = emergencyRelation1;
    }

    public String getEmergencyMobile1() {
        return emergencyMobile1;
    }

    public void setEmergencyMobile1(String emergencyMobile1) {
        this.emergencyMobile1 = emergencyMobile1;
    }

    public String getEmergencyName2() {
        return emergencyName2;
    }

    public void setEmergencyName2(String emergencyName2) {
        this.emergencyName2 = emergencyName2;
    }

    public String getEmergencyRelation2() {
        return emergencyRelation2;
    }

    public void setEmergencyRelation2(String emergencyRelation2) {
        this.emergencyRelation2 = emergencyRelation2;
    }

    public String getEmergencyMobile2() {
        return emergencyMobile2;
    }

    public void setEmergencyMobile2(String emergencyMobile2) {
        this.emergencyMobile2 = emergencyMobile2;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getIsDriceLicense() {
        return isDriceLicense;
    }

    public void setIsDriceLicense(String isDriceLicense) {
        this.isDriceLicense = isDriceLicense;
    }

}
