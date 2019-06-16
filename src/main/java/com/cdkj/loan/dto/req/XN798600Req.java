/**
 * @Title XN798601Req.java 
 * @Package com.std.certi.dto.req 
 * @Description 
 * @author taojian  
 * @date 2018年10月24日 下午5:15:13 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author: taojian 
 * @since: 2018年10月24日 下午5:15:13 
 * @history:
 */
public class XN798600Req {

    // 贷款日期（yyyy-MM-dd）
    private String loanDate;

    // 获客渠道
    private String customerChannel;

    // 户籍地址
    private String registeredAddress;

    // 进件渠道
    private String applyChannel;

    // 职业
    private String career;

    // 单位座机
    private String workPhone;

    // 第五联系人手机号
    private String contact5Mobile;

    // 第五联系人身份证号
    private String contact5IdNumber;

    // 第五联系人姓名
    private String contact5Name;

    // 第五联系人社会关系（1 同事，2 母亲，3 父亲，4 其他亲属，5 朋友，6 配偶，7 子女，8 其他）
    private String contact5Relation;

    private String contact4Mobile;

    private String contact4IdNumber;

    private String contact4Name;

    private String contact4Relation;

    private String contact3Mobile;

    private String contact3IdNumber;

    private String contact3Name;

    private String contact3Relation;

    private String contact2Mobile;

    private String contact2IdNumber;

    private String contact2Name;

    private String contact2Relation;

    private String contact1Mobile;

    private String contact1IdNumber;

    private String contact1Name;

    private String contact1Relation;

    // 借款人单位电话
    private String accountPhoneWork;

    // 借款人单位地址
    private String accountAddressWork;

    // 是否曾跨平台借款
    private String isCrossLoan;

    // 职位（1 初级、助理人员，2 基层管理人员，3 高层管理人员，4 其它，5 见习专员，6 中层管理人员，7 中级技术人员，8 普通员工，9
    // 高级资深人员）
    private String occupation;

    // 所属行业
    private String industry;

    // 家庭地址
    private String homeAddress;

    // 学历
    private String diploma;

    // 贷款期限
    private String loanTerm;

    // 贷款金额
    private String loanAmount;

    // 借款人QQ
    private String qqNumber;

    // 设备ID
    private String deviceId;

    // 借款人卡号
    private String cardNumber;

    // 借款人手机
    @NotBlank
    private String accountMobile;

    // 手机号加密
    private String bodyguardMobileEncrypt;

    // 借款人座机
    private String accountPhone;

    // 借款人姓名
    @NotBlank
    private String accountName;

    // 姓名加密
    private String bodyguardNameEncrypt;

    // ip
    private String ipAddress;

    // 工作单位地址
    private String organizationAddress;

    // 借款人身份证
    @NotBlank
    private String idNumber;

    // 身份证加密
    private String bodyguardIdEncrypt;

    // 借款人工作单位
    private String organization;

    // TokenId
    private String tokenId;

    // 借款公司名称
    private String lendCompany;

    // 共同借款人工作单位
    private String coborrowerCompany;

    // 共同借款人社会关系
    private String coborrowerRelation;

    // 手机号姓名核验结果
    private String mobileNameConsistence;

    // 担保人公司地址
    private String suretyCompanyAddress;

    // 担保人家庭地址
    private String suretyHomeAddress;

    // 担保人座机
    private String suretyPhone;

    // 担保人手机
    private String suretyMobile;

    // 担保人身份证
    private String suretyIdNumber;

    // 担保人姓名
    private String suretyName;

    // 共同借款人公司地址
    private String coborrowerCompanyAddress;

    // 共同借款人家庭地址
    private String coborrowerHomeAddress;

    // 共同借款人座机
    private String coborrowerPhone;

    // 共同借款人手机
    private String coborrowerMobile;

    // 共同借款人身份证
    private String coborrowerIdNumber;

    // 共同借款人姓名
    private String coborrowerName;

    // 通讯地址
    private String contactAddress;

    // 借款人邮箱
    private String accountEmail;

    // black_box
    private String blackBox;

    // 贷款期限单位
    private String loanTermUnit;

    // 房产类型
    private String houseType;

    // 年收入（1 100000-200000，2 200000以上，3 10000-50000，4 10000以下，5 50000-100000）
    private String annualIncome;

    // 进件省份
    private String applyProvince;

    // 房产情况
    private String houseProperty;

    // 月均收入
    private String monthlyIncome;

    // 工作时间（1 2年，2 3-4年，3 1年，4 8-9年，5 1年以下，6 5-7年，7 10年以上）
    private String workTime;

    // 公司性质
    private String companyType;

    // 人员类别
    private String applyerType;

    // 单位地址
    private String companyAddress;

    // 婚姻情况
    private String marriage;

    // 借款用途
    private String loanPurpose;

    // 事件时间
    private String eventOccurTime;

    // 归属地详情类型
    private String respDetailType;

    @NotBlank
    private String systemCode;

    @NotBlank
    private String companyCode;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    public String getCustomerChannel() {
        return customerChannel;
    }

    public void setCustomerChannel(String customerChannel) {
        this.customerChannel = customerChannel;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getApplyChannel() {
        return applyChannel;
    }

    public void setApplyChannel(String applyChannel) {
        this.applyChannel = applyChannel;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getContact5Mobile() {
        return contact5Mobile;
    }

    public void setContact5Mobile(String contact5Mobile) {
        this.contact5Mobile = contact5Mobile;
    }

    public String getContact5IdNumber() {
        return contact5IdNumber;
    }

    public void setContact5IdNumber(String contact5IdNumber) {
        this.contact5IdNumber = contact5IdNumber;
    }

    public String getContact5Name() {
        return contact5Name;
    }

    public void setContact5Name(String contact5Name) {
        this.contact5Name = contact5Name;
    }

    public String getContact5Relation() {
        return contact5Relation;
    }

    public void setContact5Relation(String contact5Relation) {
        this.contact5Relation = contact5Relation;
    }

    public String getContact4Mobile() {
        return contact4Mobile;
    }

    public void setContact4Mobile(String contact4Mobile) {
        this.contact4Mobile = contact4Mobile;
    }

    public String getContact4IdNumber() {
        return contact4IdNumber;
    }

    public void setContact4IdNumber(String contact4IdNumber) {
        this.contact4IdNumber = contact4IdNumber;
    }

    public String getContact4Name() {
        return contact4Name;
    }

    public void setContact4Name(String contact4Name) {
        this.contact4Name = contact4Name;
    }

    public String getContact4Relation() {
        return contact4Relation;
    }

    public void setContact4Relation(String contact4Relation) {
        this.contact4Relation = contact4Relation;
    }

    public String getContact3Mobile() {
        return contact3Mobile;
    }

    public void setContact3Mobile(String contact3Mobile) {
        this.contact3Mobile = contact3Mobile;
    }

    public String getContact3IdNumber() {
        return contact3IdNumber;
    }

    public void setContact3IdNumber(String contact3IdNumber) {
        this.contact3IdNumber = contact3IdNumber;
    }

    public String getContact3Name() {
        return contact3Name;
    }

    public void setContact3Name(String contact3Name) {
        this.contact3Name = contact3Name;
    }

    public String getContact3Relation() {
        return contact3Relation;
    }

    public void setContact3Relation(String contact3Relation) {
        this.contact3Relation = contact3Relation;
    }

    public String getContact2Mobile() {
        return contact2Mobile;
    }

    public void setContact2Mobile(String contact2Mobile) {
        this.contact2Mobile = contact2Mobile;
    }

    public String getContact2IdNumber() {
        return contact2IdNumber;
    }

    public void setContact2IdNumber(String contact2IdNumber) {
        this.contact2IdNumber = contact2IdNumber;
    }

    public String getContact2Name() {
        return contact2Name;
    }

    public void setContact2Name(String contact2Name) {
        this.contact2Name = contact2Name;
    }

    public String getContact2Relation() {
        return contact2Relation;
    }

    public void setContact2Relation(String contact2Relation) {
        this.contact2Relation = contact2Relation;
    }

    public String getContact1Mobile() {
        return contact1Mobile;
    }

    public void setContact1Mobile(String contact1Mobile) {
        this.contact1Mobile = contact1Mobile;
    }

    public String getContact1IdNumber() {
        return contact1IdNumber;
    }

    public void setContact1IdNumber(String contact1IdNumber) {
        this.contact1IdNumber = contact1IdNumber;
    }

    public String getContact1Name() {
        return contact1Name;
    }

    public void setContact1Name(String contact1Name) {
        this.contact1Name = contact1Name;
    }

    public String getContact1Relation() {
        return contact1Relation;
    }

    public void setContact1Relation(String contact1Relation) {
        this.contact1Relation = contact1Relation;
    }

    public String getAccountPhoneWork() {
        return accountPhoneWork;
    }

    public void setAccountPhoneWork(String accountPhoneWork) {
        this.accountPhoneWork = accountPhoneWork;
    }

    public String getAccountAddressWork() {
        return accountAddressWork;
    }

    public void setAccountAddressWork(String accountAddressWork) {
        this.accountAddressWork = accountAddressWork;
    }

    public String getIsCrossLoan() {
        return isCrossLoan;
    }

    public void setIsCrossLoan(String isCrossLoan) {
        this.isCrossLoan = isCrossLoan;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountMobile() {
        return accountMobile;
    }

    public void setAccountMobile(String accountMobile) {
        this.accountMobile = accountMobile;
    }

    public String getBodyguardMobileEncrypt() {
        return bodyguardMobileEncrypt;
    }

    public void setBodyguardMobileEncrypt(String bodyguardMobileEncrypt) {
        this.bodyguardMobileEncrypt = bodyguardMobileEncrypt;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBodyguardNameEncrypt() {
        return bodyguardNameEncrypt;
    }

    public void setBodyguardNameEncrypt(String bodyguardNameEncrypt) {
        this.bodyguardNameEncrypt = bodyguardNameEncrypt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getBodyguardIdEncrypt() {
        return bodyguardIdEncrypt;
    }

    public void setBodyguardIdEncrypt(String bodyguardIdEncrypt) {
        this.bodyguardIdEncrypt = bodyguardIdEncrypt;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getLendCompany() {
        return lendCompany;
    }

    public void setLendCompany(String lendCompany) {
        this.lendCompany = lendCompany;
    }

    public String getCoborrowerCompany() {
        return coborrowerCompany;
    }

    public void setCoborrowerCompany(String coborrowerCompany) {
        this.coborrowerCompany = coborrowerCompany;
    }

    public String getCoborrowerRelation() {
        return coborrowerRelation;
    }

    public void setCoborrowerRelation(String coborrowerRelation) {
        this.coborrowerRelation = coborrowerRelation;
    }

    public String getMobileNameConsistence() {
        return mobileNameConsistence;
    }

    public void setMobileNameConsistence(String mobileNameConsistence) {
        this.mobileNameConsistence = mobileNameConsistence;
    }

    public String getSuretyCompanyAddress() {
        return suretyCompanyAddress;
    }

    public void setSuretyCompanyAddress(String suretyCompanyAddress) {
        this.suretyCompanyAddress = suretyCompanyAddress;
    }

    public String getSuretyHomeAddress() {
        return suretyHomeAddress;
    }

    public void setSuretyHomeAddress(String suretyHomeAddress) {
        this.suretyHomeAddress = suretyHomeAddress;
    }

    public String getSuretyPhone() {
        return suretyPhone;
    }

    public void setSuretyPhone(String suretyPhone) {
        this.suretyPhone = suretyPhone;
    }

    public String getSuretyMobile() {
        return suretyMobile;
    }

    public void setSuretyMobile(String suretyMobile) {
        this.suretyMobile = suretyMobile;
    }

    public String getSuretyIdNumber() {
        return suretyIdNumber;
    }

    public void setSuretyIdNumber(String suretyIdNumber) {
        this.suretyIdNumber = suretyIdNumber;
    }

    public String getSuretyName() {
        return suretyName;
    }

    public void setSuretyName(String suretyName) {
        this.suretyName = suretyName;
    }

    public String getCoborrowerCompanyAddress() {
        return coborrowerCompanyAddress;
    }

    public void setCoborrowerCompanyAddress(String coborrowerCompanyAddress) {
        this.coborrowerCompanyAddress = coborrowerCompanyAddress;
    }

    public String getCoborrowerHomeAddress() {
        return coborrowerHomeAddress;
    }

    public void setCoborrowerHomeAddress(String coborrowerHomeAddress) {
        this.coborrowerHomeAddress = coborrowerHomeAddress;
    }

    public String getCoborrowerPhone() {
        return coborrowerPhone;
    }

    public void setCoborrowerPhone(String coborrowerPhone) {
        this.coborrowerPhone = coborrowerPhone;
    }

    public String getCoborrowerMobile() {
        return coborrowerMobile;
    }

    public void setCoborrowerMobile(String coborrowerMobile) {
        this.coborrowerMobile = coborrowerMobile;
    }

    public String getCoborrowerIdNumber() {
        return coborrowerIdNumber;
    }

    public void setCoborrowerIdNumber(String coborrowerIdNumber) {
        this.coborrowerIdNumber = coborrowerIdNumber;
    }

    public String getCoborrowerName() {
        return coborrowerName;
    }

    public void setCoborrowerName(String coborrowerName) {
        this.coborrowerName = coborrowerName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getBlackBox() {
        return blackBox;
    }

    public void setBlackBox(String blackBox) {
        this.blackBox = blackBox;
    }

    public String getLoanTermUnit() {
        return loanTermUnit;
    }

    public void setLoanTermUnit(String loanTermUnit) {
        this.loanTermUnit = loanTermUnit;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getApplyProvince() {
        return applyProvince;
    }

    public void setApplyProvince(String applyProvince) {
        this.applyProvince = applyProvince;
    }

    public String getHouseProperty() {
        return houseProperty;
    }

    public void setHouseProperty(String houseProperty) {
        this.houseProperty = houseProperty;
    }

    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getApplyerType() {
        return applyerType;
    }

    public void setApplyerType(String applyerType) {
        this.applyerType = applyerType;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public String getEventOccurTime() {
        return eventOccurTime;
    }

    public void setEventOccurTime(String eventOccurTime) {
        this.eventOccurTime = eventOccurTime;
    }

    public String getRespDetailType() {
        return respDetailType;
    }

    public void setRespDetailType(String respDetailType) {
        this.respDetailType = respDetailType;
    }
}
