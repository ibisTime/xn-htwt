package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.List;

/**
 * 征信人员
 *
 * @author: jiafr
 * @since: 2018年5月24日 下午9:32:23
 * @history:
 */
public class CreditUser extends ABaseDO {

    /** ************************ 征信结果信息 ************************** */

    /**
     * 征信人员编号
     */
    private String code;

    /**
     * 预算单编号
     */
    private String bizCode;

    /**
     * 征信人类型（主贷人/配偶/担保人）
     */
    private String relation;

    /**
     * 贷款角色
     */
    private String loanRole;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 证件类型
     */
    private String idKind;

    /**
     * 证件号码
     */
    private String idNo;

    /**
     * 信用卡占比
     */
    private Double creditCardOccupation;

    /**
     * 银行征信结果
     */
    private String bankCreditResult;

    /**
     * 银行征信结果说明
     */
    private String bankCreditResultRemark;

    /** ************************ 客户基本信息 ************************ */

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 政治面貌
     */
    private String political;

    /**
     * 民族
     */
    private String nation;

    /**
     * 学历
     */
    private String education;

    /**
     * 职业
     */
    private String workProfession;

    /**
     * 职称
     */
    private String postTitle;

    /**
     * 客户生日
     */
    private String customerBirth;

    /**
     * 现有车辆类型
     */
    private String carType;

    /**
     * 有无驾照
     */
    private String isDriceLicense;

    /**
     * 主要收入来源
     */
    private String mainIncome;

    /**
     * 其他收入说明
     */
    private String otherIncomeNote;

    /**
     * 房产证情况
     */
    private String isHouseProperty;

    /** *********************** 紧急联系人信息 ************************ */

    /**
     * 联系人1姓名
     */
    private String emergencyName1;

    /**
     * 联系人1与申请人关系
     */
    private String emergencyRelation1;

    /**
     * 联系人1手机号码
     */
    private String emergencyMobile1;

    /**
     * 联系人2姓名
     */
    private String emergencyName2;

    /**
     * 联系人2与申请人关系
     */
    private String emergencyRelation2;

    /**
     * 联系人2手机号码
     */
    private String emergencyMobile2;

    /** *********************** 工作信息 ************************ */

    /**
     * 所属行业
     */
    private String workBelongIndustry;

    /**
     * 单位性质
     */
    private String workCompanyProperty;

    /**
     * 工作单位名称
     */
    private String companyName;

    /**
     * 工作单位地址
     */
    private String companyAddress;

    /**
     * 工作单位联系电话
     */
    private String companyContactNo;

    /**
     * 何时进入现单位工作
     */
    private String workDatetime;

    /**
     * 职位
     */
    private String position;

    /**
     * 员工数量
     */
    private String employeeQuantity;

    /**
     * 企业月产值
     */
    private String enterpriseMonthOutput;

    /**
     * 月收入
     */
    private Long monthIncome;

    /**
     * 工作描述及还款来源分析（已确定）
     */
    private String otherWorkNote;

    /** ********************** 家庭信息 ************************ */

    /**
     * 婚姻状况
     */
    private String marryState;

    /**
     * 家庭人口
     */
    private Integer familyNumber;

    /**
     * 家庭电话
     */
    private String familyPhone;

    /**
     * 家庭主要财产
     */
    private String familyMainAsset;

    /**
     * 主要财产包括
     */
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

    /**
     * ******************* 辅助字段 ************************
     */

    // 征信人员列表
    private List<CreditUser> creditUserList;

    /**
     * 征信报告
     */
    private List<Attachment> attachments;

    /**
     * ************** 附件图片 ************************
     */
    private String idFront;

    private String idReverse;

    private String authPdf;

    private String interviewPic;

    private String dataCreditReport;

    private String BankCreditReport;

    private String driceLicense;

    private String marryPdf;

    private String otherPdf;

    private String workAssetPdf;

    private String singleProvePdf;

    private String incomeProvePdf;

    private String liveProvePdf;

    private String buildProvePdf;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkProfession() {
        return workProfession;
    }

    public void setWorkProfession(String workProfession) {
        this.workProfession = workProfession;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
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

    public String getIsHouseProperty() {
        return isHouseProperty;
    }

    public void setIsHouseProperty(String isHouseProperty) {
        this.isHouseProperty = isHouseProperty;
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

    public String getWorkBelongIndustry() {
        return workBelongIndustry;
    }

    public void setWorkBelongIndustry(String workBelongIndustry) {
        this.workBelongIndustry = workBelongIndustry;
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

    public Long getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(Long monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getOtherWorkNote() {
        return otherWorkNote;
    }

    public void setOtherWorkNote(String otherWorkNote) {
        this.otherWorkNote = otherWorkNote;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
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

    public List<CreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<CreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getIdFront() {
        return idFront;
    }

    public void setIdFront(String idFront) {
        this.idFront = idFront;
    }

    public String getIdReverse() {
        return idReverse;
    }

    public void setIdReverse(String idReverse) {
        this.idReverse = idReverse;
    }

    public String getAuthPdf() {
        return authPdf;
    }

    public void setAuthPdf(String authPdf) {
        this.authPdf = authPdf;
    }

    public String getInterviewPic() {
        return interviewPic;
    }

    public void setInterviewPic(String interviewPic) {
        this.interviewPic = interviewPic;
    }

    public String getDataCreditReport() {
        return dataCreditReport;
    }

    public void setDataCreditReport(String dataCreditReport) {
        this.dataCreditReport = dataCreditReport;
    }

    public String getBankCreditReport() {
        return BankCreditReport;
    }

    public void setBankCreditReport(String bankCreditReport) {
        BankCreditReport = bankCreditReport;
    }

    public String getDriceLicense() {
        return driceLicense;
    }

    public void setDriceLicense(String driceLicense) {
        this.driceLicense = driceLicense;
    }

    public String getMarryPdf() {
        return marryPdf;
    }

    public void setMarryPdf(String marryPdf) {
        this.marryPdf = marryPdf;
    }

    public String getOtherPdf() {
        return otherPdf;
    }

    public void setOtherPdf(String otherPdf) {
        this.otherPdf = otherPdf;
    }

    public String getWorkAssetPdf() {
        return workAssetPdf;
    }

    public void setWorkAssetPdf(String workAssetPdf) {
        this.workAssetPdf = workAssetPdf;
    }

    public String getSingleProvePdf() {
        return singleProvePdf;
    }

    public void setSingleProvePdf(String singleProvePdf) {
        this.singleProvePdf = singleProvePdf;
    }

    public String getIncomeProvePdf() {
        return incomeProvePdf;
    }

    public void setIncomeProvePdf(String incomeProvePdf) {
        this.incomeProvePdf = incomeProvePdf;
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

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
