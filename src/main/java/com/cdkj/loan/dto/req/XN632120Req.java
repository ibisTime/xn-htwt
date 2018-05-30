package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632120Req {

    // 操作人
    @NotBlank
    private String operator;

    // 处理类型(0 保存 1 发送)
    @NotBlank
    private String dealType;

    // 贷款产品编号
    @NotBlank
    private String loanProductCode;

    // 是否垫资
    @NotBlank
    private String isAdvanceFund;

    // 征信单编号
    @NotBlank
    private String creditCode;

    // 业务种类
    @NotBlank
    private String bizType;

    // 贷款期限
    @NotBlank
    private String loanPeriod;

    // 开票单位
    @NotBlank
    private String invoiceCompany;

    // 品牌
    @NotBlank
    private String carBrand;

    // 市场指导价
    @NotBlank
    private String originalPrice;

    // 开票价
    @NotBlank
    private String invoicePrice;

    // 颜色
    @NotBlank
    private String carColor;

    // 月供保证金
    @NotBlank
    private String monthDeposit;

    // 首付金额
    @NotBlank
    private String firstAmount;

    // 首付比例
    @NotBlank
    private String firstRate;

    // 贷款额
    @NotBlank
    private String loanAmount;

    // 落户地点
    @NotBlank
    private String settleAddress;

    // 申请人姓名
    @NotBlank
    private String applyUserName;

    // 性别
    @NotBlank
    private String gender;

    // 婚姻状况
    @NotBlank
    private String marryState;

    // 民族
    @NotBlank
    private String nation;

    // 学历
    @NotBlank
    private String education;

    // 身份证号
    @NotBlank
    private String idNo;

    // 家庭人口
    @NotBlank
    private String familyNumber;

    // 手机号
    @NotBlank
    private String mobile;

    // 现居住地址
    @NotBlank
    private String nowAddress;

    // 邮编1
    @NotBlank
    private String postCode1;

    // 户口所在地
    @NotBlank
    private String residenceAddress;

    // 邮编2
    @NotBlank
    private String postCode2;

    // 家庭主要财产
    @NotBlank
    private String familyMainAsset;

    // 主要财产包括
    @NotBlank
    private String mainAssetInclude;

    // 主要收入来源
    @NotBlank
    private String mainIncome;

    // 工作单位名称
    @NotBlank
    private String workCompanyName;

    // 工作单位地址
    @NotBlank
    private String workCompanyAddress;

    // 自营公司单位面积
    private String selfCompanyArea;

    // 员工数量
    private String employeeQuantity;

    // 企业月产值
    private String enterpriseMonthOutput;

    // 职位
    private String position;

    // 职称
    private String postTitle;

    // 月收入
    private String monthIncome;

    // 配偶姓名
    private String mateName;

    // 配偶手机号
    private String mateMobile;

    // 配偶身份证号
    private String mateIdNo;

    // 配偶学历
    private String mateEducation;

    // 配偶工作单位名称
    private String mateCompanyName;

    // 配偶工作单位地址
    private String mateCompanyAddress;

    // 配偶工作单位联系电话
    private String mateCompanyContactNo;

    // 担保人姓名
    private String guaName;

    // 担保人手机号
    private String guaMobile;

    // 担保人身份证号
    private String guaIdNo;

    // 担保人固定电话
    private String guaPhone;

    // 担保人工作单位名称
    private String guaCompanyName;

    // 担保人工作单位地址
    private String guaCompanyAddress;

    // 担保人房产地址
    private String guaHouseAssetAddress;

    // 家庭紧急联系人信息1 姓名
    private String emergencyName1;

    // 家庭紧急联系人信息1 与申请人关系
    private String emergencyRelation1;

    // 家庭紧急联系人信息1 手机号码
    private String emergencyMobile1;

    // 家庭紧急联系人信息2 姓名
    private String emergencyName2;

    // 家庭紧急联系人信息2 与申请人关系
    private String emergencyRelation2;

    // 家庭紧急联系人信息2 手机号码
    private String emergencyMobile2;

    // 流水时间起
    @NotBlank
    private String jourDatetimeStart;

    // 流水时间止
    @NotBlank
    private String jourDatetimeEnd;

    // 收入
    @NotBlank
    private String jourIncome;

    // 支出
    @NotBlank
    private String jourExpend;

    // 帐户余额
    @NotBlank
    private String jourBalance;

    // 月均收入
    @NotBlank
    private String jourMonthIncome;

    // 月均支出
    @NotBlank
    private String jourMonthExpend;

    // 流水备注
    @NotBlank
    private String jourRemark;

    // 购房合同
    private String houseContract;

    // 房屋照片
    private String housePicture;

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

    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(String monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public String getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(String firstAmount) {
        this.firstAmount = firstAmount;
    }

    public String getFirstRate() {
        return firstRate;
    }

    public void setFirstRate(String firstRate) {
        this.firstRate = firstRate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getSettleAddress() {
        return settleAddress;
    }

    public void setSettleAddress(String settleAddress) {
        this.settleAddress = settleAddress;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(String familyNumber) {
        this.familyNumber = familyNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getPostCode1() {
        return postCode1;
    }

    public void setPostCode1(String postCode1) {
        this.postCode1 = postCode1;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getPostCode2() {
        return postCode2;
    }

    public void setPostCode2(String postCode2) {
        this.postCode2 = postCode2;
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

    public String getWorkCompanyName() {
        return workCompanyName;
    }

    public void setWorkCompanyName(String workCompanyName) {
        this.workCompanyName = workCompanyName;
    }

    public String getWorkCompanyAddress() {
        return workCompanyAddress;
    }

    public void setWorkCompanyAddress(String workCompanyAddress) {
        this.workCompanyAddress = workCompanyAddress;
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

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMateMobile() {
        return mateMobile;
    }

    public void setMateMobile(String mateMobile) {
        this.mateMobile = mateMobile;
    }

    public String getMateIdNo() {
        return mateIdNo;
    }

    public void setMateIdNo(String mateIdNo) {
        this.mateIdNo = mateIdNo;
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

    public String getGuaName() {
        return guaName;
    }

    public void setGuaName(String guaName) {
        this.guaName = guaName;
    }

    public String getGuaMobile() {
        return guaMobile;
    }

    public void setGuaMobile(String guaMobile) {
        this.guaMobile = guaMobile;
    }

    public String getGuaIdNo() {
        return guaIdNo;
    }

    public void setGuaIdNo(String guaIdNo) {
        this.guaIdNo = guaIdNo;
    }

    public String getGuaPhone() {
        return guaPhone;
    }

    public void setGuaPhone(String guaPhone) {
        this.guaPhone = guaPhone;
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

    public String getGuaHouseAssetAddress() {
        return guaHouseAssetAddress;
    }

    public void setGuaHouseAssetAddress(String guaHouseAssetAddress) {
        this.guaHouseAssetAddress = guaHouseAssetAddress;
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

    public String getJourDatetimeStart() {
        return jourDatetimeStart;
    }

    public void setJourDatetimeStart(String jourDatetimeStart) {
        this.jourDatetimeStart = jourDatetimeStart;
    }

    public String getJourDatetimeEnd() {
        return jourDatetimeEnd;
    }

    public void setJourDatetimeEnd(String jourDatetimeEnd) {
        this.jourDatetimeEnd = jourDatetimeEnd;
    }

    public String getJourIncome() {
        return jourIncome;
    }

    public void setJourIncome(String jourIncome) {
        this.jourIncome = jourIncome;
    }

    public String getJourExpend() {
        return jourExpend;
    }

    public void setJourExpend(String jourExpend) {
        this.jourExpend = jourExpend;
    }

    public String getJourBalance() {
        return jourBalance;
    }

    public void setJourBalance(String jourBalance) {
        this.jourBalance = jourBalance;
    }

    public String getJourMonthIncome() {
        return jourMonthIncome;
    }

    public void setJourMonthIncome(String jourMonthIncome) {
        this.jourMonthIncome = jourMonthIncome;
    }

    public String getJourMonthExpend() {
        return jourMonthExpend;
    }

    public void setJourMonthExpend(String jourMonthExpend) {
        this.jourMonthExpend = jourMonthExpend;
    }

    public String getJourRemark() {
        return jourRemark;
    }

    public void setJourRemark(String jourRemark) {
        this.jourRemark = jourRemark;
    }

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(String housePicture) {
        this.housePicture = housePicture;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }
}
