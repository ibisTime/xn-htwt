package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632120Req {

    // 编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    // 处理类型(0 保存 1 发送)
    @NotBlank
    private String dealType;

    // 贷款产品编号
    private String loanProductCode;

    // 所属区域
    private String region;

    // 公司手续费
    private String companyFee;

    // 团队服务费
    private String teamFee;

    // 是否垫资
    private String isAdvanceFund;

    // 征信单编号
    private String creditCode;

    // 业务种类
    private String bizType;

    // 贷款期限
    private String loanPeriod;

    // 机动车销售公司
    private String vehicleCompanyName;

    // 开票单位
    private String invoiceCompany;

    // 品牌
    private String carBrand;

    // 车系
    private String carSeries;

    // 车型
    private String carModel;

    // 车辆类型
    private String carType;

    // 车辆照片
    private String carPic;

    // 合格证
    private String carHgzPic;

    // 行驶证正面
    private String driveLicenseFront;

    // 行驶证反面
    private String driveLicenseReverse;

    // 评估栏
    private String evaluateColumn;

    // 车架号
    private String carFrameNo;

    // 发动机号
    private String carEngineNo;

    // 市场指导价
    private String originalPrice;

    // 开票价
    private String invoicePrice;

    // 颜色
    private String carColor;

    // 月供保证金
    private String monthDeposit;

    // 首付金额
    private String firstAmount;

    // 首付比例
    private String firstRate;

    // 贷款额
    private String loanAmount;

    // 落户地点
    private String settleAddress;

    // 申请人姓名
    private String applyUserName;

    // 性别
    private String gender;

    // 年龄
    private String age;

    // 婚姻状况
    private String marryState;

    // 政治面貌
    private String political;

    // 民族
    private String nation;

    // 学历
    private String education;

    // 身份证号
    private String idNo;

    // 家庭人口
    private String familyNumber;

    // 手机号
    private String mobile;

    // 现居住地址
    private String nowAddress;

    // 是否卡邮寄地址
    private String isCardMailAddress;

    // 邮编1
    private String postCode1;

    // 户口所在地
    private String residenceAddress;

    // 邮编2
    private String postCode2;

    // 家庭主要财产
    private String familyMainAsset;

    // 主要财产包括
    private String mainAssetInclude;

    // 主要收入来源
    private String mainIncome;

    // 工作单位名称
    private String workCompanyName;

    // 工作单位地址
    private String workCompanyAddress;

    // 是否卡邮寄地址
    private String workIsCardMailAddress;

    // 单位性质
    private String workCompanyProperty;

    // 所属行业
    private String workBelongIndustry;

    // 职业
    private String workProfession;

    // 何时进入现单位工作
    private String workDatetime;

    // 自营公司单位面积
    private String selfCompanyArea;

    // 其他工作描述
    private String otherWorkNote;

    // 工作资料上传
    private String workAssetPdf;

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

    // 配偶支付宝流水时间起
    private String mateZfbJourDatetimeStart;

    // 配偶支付宝流水时间止
    private String mateZfbJourDatetimeEnd;

    // 配偶支付宝流水结息
    private String mateZfbJourInterest1;

    // 配偶支付宝流水结息
    private String mateZfbJourInterest2;

    // 配偶支付宝流水结息
    private String mateZfbInterest1;

    // 配偶支付宝流水结息
    private String mateZfbInterest2;

    // 配偶支付宝收入
    private String mateZfbJourIncome;

    // 配偶支付宝支出
    private String mateZfbJourExpend;

    // 配偶支付宝帐户余额
    private String mateZfbJourBalance;

    // 配偶支付宝月均收入
    private String mateZfbJourMonthIncome;

    // 配偶支付宝月均支出
    private String mateZfbJourMonthExpend;

    // 配偶支付宝流水图片
    private String mateZfbJourPic;

    // 配偶支付宝流水备注
    private String mateZfbJourRemark;

    // 配偶微信流水时间起
    private String mateWxJourDatetimeStart;

    // 配偶微信流水时间止
    private String mateWxJourDatetimeEnd;

    // 配偶微信流水结息1
    private String mateWxJourInterest1;

    // 配偶微信流水结息2
    private String mateWxJourInterest2;

    // 配偶微信流水结息
    private String mateWxInterest1;

    // 配偶微信流水结息
    private String mateWxInterest2;

    // 配偶微信收入
    private String mateWxJourIncome;

    // 配偶微信支出
    private String mateWxJourExpend;

    // 配偶微信帐户余额
    private String mateWxJourBalance;

    // 配偶微信月均收入
    private String mateWxJourMonthIncome;

    // 配偶微信月均支出
    private String mateWxJourMonthExpend;

    // 配偶微信流水图片
    private String mateWxJourPic;

    // 配偶微信流水备注
    private String mateWxJourRemark;

    // 配偶流水时间起
    private String mateJourDatetimeStart;

    // 配偶流水时间止
    private String mateJourDatetimeEnd;

    // 配偶流水结息1
    private String mateJourInterest1;

    // 配偶流水结息2
    private String mateJourInterest2;

    // 配偶结息1
    private String mateInterest1;

    // 配偶结息2
    private String mateInterest2;

    // 配偶收入
    private String mateJourIncome;

    // 配偶支出
    private String mateJourExpend;

    // 配偶帐户余额
    private String mateJourBalance;

    // 配偶月均收入
    private String mateJourMonthIncome;

    // 配偶月均支出
    private String mateJourMonthExpend;

    // 配偶流水图片
    private String mateJourPic;

    // 配偶流水备注
    private String mateJourRemark;

    // 配偶资产资料pdf
    private String mateAssetPdf;

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

    // 担保人支付宝流水时间起
    private String guaZfbJourDatetimeStart;

    // 担保人支付宝流水时间止
    private String guaZfbJourDatetimeEnd;

    // 担保人支付宝流水结息1
    private String guaZfbJourInterest1;

    // 担保人支付宝流水结息2
    private String guaZfbJourInterest2;

    // 担保人支付宝流水结息
    private String guaZfbInterest1;

    // 担保人支付宝流水结息
    private String guaZfbInterest2;

    // 担保人支付宝收入
    private String guaZfbJourIncome;

    // 担保人支付宝支出
    private String guaZfbJourExpend;

    // 担保人支付宝帐户余额
    private String guaZfbJourBalance;

    // 担保人支付宝月均收入
    private String guaZfbJourMonthIncome;

    // 担保人支付宝月均支出
    private String guaZfbJourMonthExpend;

    // 担保人支付宝流水图片
    private String guaZfbJourPic;

    // 担保人支付宝流水备注
    private String guaZfbJourRemark;

    // 担保人微信流水时间起
    private String guaWxJourDatetimeStart;

    // 担保人微信流水时间止
    private String guaWxJourDatetimeEnd;

    // 担保人微信流水结息1
    private String guaWxJourInterest1;

    // 担保人微信流水结息2
    private String guaWxJourInterest2;

    // 担保人微信流水结息
    private String guaWxInterest1;

    // 担保人微信流水结息
    private String guaWxInterest2;

    // 担保人微信收入
    private String guaWxJourIncome;

    // 担保人微信支出
    private String guaWxJourExpend;

    // 担保人微信帐户余额
    private String guaWxJourBalance;

    // 担保人微信月均收入
    private String guaWxJourMonthIncome;

    // 担保人微信月均支出
    private String guaWxJourMonthExpend;

    // 担保人微信流水图片
    private String guaWxJourPic;

    // 担保人微信流水备注
    private String guaWxJourRemark;

    // 担保人流水时间起
    private String guaJourDatetimeStart;

    // 担保人流水时间止
    private String guaJourDatetimeEnd;

    // 担保人流水结息1
    private String guaJourInterest1;

    // 担保人流水结息2
    private String guaJourInterest2;

    // 担保人结息1
    private String guaInterest1;

    // 担保人结息2
    private String guaInterest2;

    // 担保人收入
    private String guaJourIncome;

    // 担保人支出
    private String guaJourExpend;

    // 担保人帐户余额
    private String guaJourBalance;

    // 担保人月均收入
    private String guaJourMonthIncome;

    // 担保人月均支出
    private String guaJourMonthExpend;

    // 担保人流水图片
    private String guaJourPic;

    // 担保人流水备注
    private String guaJourRemark;

    // 担保人资产资料pdf
    private String guaAssetPdf;

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

    // 支付宝流水时间起
    private String zfbJourDatetimeStart;

    // 支付宝流水时间止
    private String zfbJourDatetimeEnd;

    // 支付宝流水结息1
    private String zfbJourInterest1;

    // 支付宝流水结息2
    private String zfbJourInterest2;

    // 支付宝流水结息
    private String zfbInterest1;

    // 支付宝流水结息
    private String zfbInterest2;

    // 支付宝收入
    private String zfbJourIncome;

    // 支付宝支出
    private String zfbJourExpend;

    // 支付宝帐户余额
    private String zfbJourBalance;

    // 支付宝月均收入
    private String zfbJourMonthIncome;

    // 支付宝月均支出
    private String zfbJourMonthExpend;

    // 支付宝流水图片
    private String zfbJourPic;

    // 支付宝流水备注
    private String zfbJourRemark;

    // 微信流水时间起
    private String wxJourDatetimeStart;

    // 微信流水时间止
    private String wxJourDatetimeEnd;

    // 微信流水结息1
    private String wxJourInterest1;

    // 微信流水结息2
    private String wxJourInterest2;

    // 微信流水结息
    private String wxInterest1;

    // 微信流水结息
    private String wxInterest2;

    // 微信收入
    private String wxJourIncome;

    // 微信支出
    private String wxJourExpend;

    // 微信帐户余额
    private String wxJourBalance;

    // 微信月均收入
    private String wxJourMonthIncome;

    // 微信月均支出
    private String wxJourMonthExpend;

    // 微信流水图片
    private String wxJourPic;

    // 微信流水备注
    private String wxJourRemark;

    // 流水时间起
    private String jourDatetimeStart;

    // 流水时间止
    private String jourDatetimeEnd;

    // 流水结息1
    private String jourInterest1;

    // 流水结息2
    private String jourInterest2;

    // 结息1
    private String interest1;

    // 结息2
    private String interest2;

    // 收入
    private String jourIncome;

    // 支出
    private String jourExpend;

    // 帐户余额
    private String jourBalance;

    // 月均收入
    private String jourMonthIncome;

    // 月均支出
    private String jourMonthExpend;

    // 流水图片
    private String jourPic;

    // 流水备注
    private String jourRemark;

    // 资产资料pdf
    private String assetPdf;

    // 购房合同
    private String houseContract;

    // 房屋照片
    private String housePicture;

    // 户口本资料
    private String hkBookPdf;

    // 身份证资料
    private String idCardPdf;

    // 结婚证资料
    private String marryPdf;

    // 代理人
    private String pledgeUser;

    // 代理人身份证复印件
    private String pledgeUserIdCardCopy;

    // 抵押地点
    private String pledgeAddress;

    // 其他资料
    private String otherPdf;

    public String getHkBookPdf() {
        return hkBookPdf;
    }

    public void setHkBookPdf(String hkBookPdf) {
        this.hkBookPdf = hkBookPdf;
    }

    public String getPledgeUserIdCardCopy() {
        return pledgeUserIdCardCopy;
    }

    public void setPledgeUserIdCardCopy(String pledgeUserIdCardCopy) {
        this.pledgeUserIdCardCopy = pledgeUserIdCardCopy;
    }

    public String getPledgeUser() {
        return pledgeUser;
    }

    public void setPledgeUser(String pledgeUser) {
        this.pledgeUser = pledgeUser;
    }

    public String getPledgeAddress() {
        return pledgeAddress;
    }

    public void setPledgeAddress(String pledgeAddress) {
        this.pledgeAddress = pledgeAddress;
    }

    public String getIdCardPdf() {
        return idCardPdf;
    }

    public void setIdCardPdf(String idCardPdf) {
        this.idCardPdf = idCardPdf;
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

    public String getCompanyFee() {
        return companyFee;
    }

    public void setCompanyFee(String companyFee) {
        this.companyFee = companyFee;
    }

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

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public String getCarEngineNo() {
        return carEngineNo;
    }

    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo;
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

    public String getMateZfbJourDatetimeStart() {
        return mateZfbJourDatetimeStart;
    }

    public void setMateZfbJourDatetimeStart(String mateZfbJourDatetimeStart) {
        this.mateZfbJourDatetimeStart = mateZfbJourDatetimeStart;
    }

    public String getMateZfbJourDatetimeEnd() {
        return mateZfbJourDatetimeEnd;
    }

    public void setMateZfbJourDatetimeEnd(String mateZfbJourDatetimeEnd) {
        this.mateZfbJourDatetimeEnd = mateZfbJourDatetimeEnd;
    }

    public String getMateZfbJourIncome() {
        return mateZfbJourIncome;
    }

    public void setMateZfbJourIncome(String mateZfbJourIncome) {
        this.mateZfbJourIncome = mateZfbJourIncome;
    }

    public String getMateZfbJourExpend() {
        return mateZfbJourExpend;
    }

    public void setMateZfbJourExpend(String mateZfbJourExpend) {
        this.mateZfbJourExpend = mateZfbJourExpend;
    }

    public String getMateZfbJourBalance() {
        return mateZfbJourBalance;
    }

    public void setMateZfbJourBalance(String mateZfbJourBalance) {
        this.mateZfbJourBalance = mateZfbJourBalance;
    }

    public String getMateZfbJourMonthIncome() {
        return mateZfbJourMonthIncome;
    }

    public void setMateZfbJourMonthIncome(String mateZfbJourMonthIncome) {
        this.mateZfbJourMonthIncome = mateZfbJourMonthIncome;
    }

    public String getMateZfbJourMonthExpend() {
        return mateZfbJourMonthExpend;
    }

    public void setMateZfbJourMonthExpend(String mateZfbJourMonthExpend) {
        this.mateZfbJourMonthExpend = mateZfbJourMonthExpend;
    }

    public String getMateZfbJourPic() {
        return mateZfbJourPic;
    }

    public void setMateZfbJourPic(String mateZfbJourPic) {
        this.mateZfbJourPic = mateZfbJourPic;
    }

    public String getMateZfbJourRemark() {
        return mateZfbJourRemark;
    }

    public void setMateZfbJourRemark(String mateZfbJourRemark) {
        this.mateZfbJourRemark = mateZfbJourRemark;
    }

    public String getMateWxJourDatetimeStart() {
        return mateWxJourDatetimeStart;
    }

    public void setMateWxJourDatetimeStart(String mateWxJourDatetimeStart) {
        this.mateWxJourDatetimeStart = mateWxJourDatetimeStart;
    }

    public String getMateWxJourDatetimeEnd() {
        return mateWxJourDatetimeEnd;
    }

    public void setMateWxJourDatetimeEnd(String mateWxJourDatetimeEnd) {
        this.mateWxJourDatetimeEnd = mateWxJourDatetimeEnd;
    }

    public String getMateWxJourIncome() {
        return mateWxJourIncome;
    }

    public void setMateWxJourIncome(String mateWxJourIncome) {
        this.mateWxJourIncome = mateWxJourIncome;
    }

    public String getMateWxJourExpend() {
        return mateWxJourExpend;
    }

    public void setMateWxJourExpend(String mateWxJourExpend) {
        this.mateWxJourExpend = mateWxJourExpend;
    }

    public String getMateWxJourBalance() {
        return mateWxJourBalance;
    }

    public void setMateWxJourBalance(String mateWxJourBalance) {
        this.mateWxJourBalance = mateWxJourBalance;
    }

    public String getMateWxJourMonthIncome() {
        return mateWxJourMonthIncome;
    }

    public void setMateWxJourMonthIncome(String mateWxJourMonthIncome) {
        this.mateWxJourMonthIncome = mateWxJourMonthIncome;
    }

    public String getMateWxJourMonthExpend() {
        return mateWxJourMonthExpend;
    }

    public void setMateWxJourMonthExpend(String mateWxJourMonthExpend) {
        this.mateWxJourMonthExpend = mateWxJourMonthExpend;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMateWxJourPic() {
        return mateWxJourPic;
    }

    public void setMateWxJourPic(String mateWxJourPic) {
        this.mateWxJourPic = mateWxJourPic;
    }

    public String getMateWxJourRemark() {
        return mateWxJourRemark;
    }

    public void setMateWxJourRemark(String mateWxJourRemark) {
        this.mateWxJourRemark = mateWxJourRemark;
    }

    public String getMateJourDatetimeStart() {
        return mateJourDatetimeStart;
    }

    public void setMateJourDatetimeStart(String mateJourDatetimeStart) {
        this.mateJourDatetimeStart = mateJourDatetimeStart;
    }

    public String getMateJourDatetimeEnd() {
        return mateJourDatetimeEnd;
    }

    public void setMateJourDatetimeEnd(String mateJourDatetimeEnd) {
        this.mateJourDatetimeEnd = mateJourDatetimeEnd;
    }

    public String getMateJourIncome() {
        return mateJourIncome;
    }

    public String getMateZfbInterest1() {
        return mateZfbInterest1;
    }

    public void setMateZfbInterest1(String mateZfbInterest1) {
        this.mateZfbInterest1 = mateZfbInterest1;
    }

    public String getMateZfbInterest2() {
        return mateZfbInterest2;
    }

    public void setMateZfbInterest2(String mateZfbInterest2) {
        this.mateZfbInterest2 = mateZfbInterest2;
    }

    public String getMateWxInterest1() {
        return mateWxInterest1;
    }

    public void setMateWxInterest1(String mateWxInterest1) {
        this.mateWxInterest1 = mateWxInterest1;
    }

    public String getMateWxInterest2() {
        return mateWxInterest2;
    }

    public void setMateWxInterest2(String mateWxInterest2) {
        this.mateWxInterest2 = mateWxInterest2;
    }

    public String getGuaZfbInterest1() {
        return guaZfbInterest1;
    }

    public void setGuaZfbInterest1(String guaZfbInterest1) {
        this.guaZfbInterest1 = guaZfbInterest1;
    }

    public String getGuaZfbInterest2() {
        return guaZfbInterest2;
    }

    public void setGuaZfbInterest2(String guaZfbInterest2) {
        this.guaZfbInterest2 = guaZfbInterest2;
    }

    public String getGuaWxInterest1() {
        return guaWxInterest1;
    }

    public void setGuaWxInterest1(String guaWxInterest1) {
        this.guaWxInterest1 = guaWxInterest1;
    }

    public String getGuaWxInterest2() {
        return guaWxInterest2;
    }

    public void setGuaWxInterest2(String guaWxInterest2) {
        this.guaWxInterest2 = guaWxInterest2;
    }

    public String getZfbInterest1() {
        return zfbInterest1;
    }

    public void setZfbInterest1(String zfbInterest1) {
        this.zfbInterest1 = zfbInterest1;
    }

    public String getZfbInterest2() {
        return zfbInterest2;
    }

    public void setZfbInterest2(String zfbInterest2) {
        this.zfbInterest2 = zfbInterest2;
    }

    public String getWxInterest1() {
        return wxInterest1;
    }

    public void setWxInterest1(String wxInterest1) {
        this.wxInterest1 = wxInterest1;
    }

    public String getWxInterest2() {
        return wxInterest2;
    }

    public void setWxInterest2(String wxInterest2) {
        this.wxInterest2 = wxInterest2;
    }

    public void setMateJourIncome(String mateJourIncome) {
        this.mateJourIncome = mateJourIncome;
    }

    public String getMateJourExpend() {
        return mateJourExpend;
    }

    public void setMateJourExpend(String mateJourExpend) {
        this.mateJourExpend = mateJourExpend;
    }

    public String getMateJourBalance() {
        return mateJourBalance;
    }

    public void setMateJourBalance(String mateJourBalance) {
        this.mateJourBalance = mateJourBalance;
    }

    public String getMateJourMonthIncome() {
        return mateJourMonthIncome;
    }

    public void setMateJourMonthIncome(String mateJourMonthIncome) {
        this.mateJourMonthIncome = mateJourMonthIncome;
    }

    public String getMateJourMonthExpend() {
        return mateJourMonthExpend;
    }

    public void setMateJourMonthExpend(String mateJourMonthExpend) {
        this.mateJourMonthExpend = mateJourMonthExpend;
    }

    public String getMateJourPic() {
        return mateJourPic;
    }

    public void setMateJourPic(String mateJourPic) {
        this.mateJourPic = mateJourPic;
    }

    public String getMateInterest1() {
        return mateInterest1;
    }

    public void setMateInterest1(String mateInterest1) {
        this.mateInterest1 = mateInterest1;
    }

    public String getMateInterest2() {
        return mateInterest2;
    }

    public void setMateInterest2(String mateInterest2) {
        this.mateInterest2 = mateInterest2;
    }

    public String getGuaInterest1() {
        return guaInterest1;
    }

    public void setGuaInterest1(String guaInterest1) {
        this.guaInterest1 = guaInterest1;
    }

    public String getGuaInterest2() {
        return guaInterest2;
    }

    public void setGuaInterest2(String guaInterest2) {
        this.guaInterest2 = guaInterest2;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public void setInterest2(String interest2) {
        this.interest2 = interest2;
    }

    public String getMateJourRemark() {
        return mateJourRemark;
    }

    public void setMateJourRemark(String mateJourRemark) {
        this.mateJourRemark = mateJourRemark;
    }

    public String getMateAssetPdf() {
        return mateAssetPdf;
    }

    public void setMateAssetPdf(String mateAssetPdf) {
        this.mateAssetPdf = mateAssetPdf;
    }

    public String getIsCardMailAddress() {
        return isCardMailAddress;
    }

    public void setIsCardMailAddress(String isCardMailAddress) {
        this.isCardMailAddress = isCardMailAddress;
    }

    public String getGuaZfbJourDatetimeStart() {
        return guaZfbJourDatetimeStart;
    }

    public void setGuaZfbJourDatetimeStart(String guaZfbJourDatetimeStart) {
        this.guaZfbJourDatetimeStart = guaZfbJourDatetimeStart;
    }

    public String getGuaZfbJourDatetimeEnd() {
        return guaZfbJourDatetimeEnd;
    }

    public void setGuaZfbJourDatetimeEnd(String guaZfbJourDatetimeEnd) {
        this.guaZfbJourDatetimeEnd = guaZfbJourDatetimeEnd;
    }

    public String getGuaZfbJourIncome() {
        return guaZfbJourIncome;
    }

    public void setGuaZfbJourIncome(String guaZfbJourIncome) {
        this.guaZfbJourIncome = guaZfbJourIncome;
    }

    public String getGuaZfbJourExpend() {
        return guaZfbJourExpend;
    }

    public void setGuaZfbJourExpend(String guaZfbJourExpend) {
        this.guaZfbJourExpend = guaZfbJourExpend;
    }

    public String getGuaZfbJourBalance() {
        return guaZfbJourBalance;
    }

    public String getWorkIsCardMailAddress() {
        return workIsCardMailAddress;
    }

    public void setWorkIsCardMailAddress(String workIsCardMailAddress) {
        this.workIsCardMailAddress = workIsCardMailAddress;
    }

    public void setGuaZfbJourBalance(String guaZfbJourBalance) {
        this.guaZfbJourBalance = guaZfbJourBalance;
    }

    public String getGuaZfbJourMonthIncome() {
        return guaZfbJourMonthIncome;
    }

    public void setGuaZfbJourMonthIncome(String guaZfbJourMonthIncome) {
        this.guaZfbJourMonthIncome = guaZfbJourMonthIncome;
    }

    public String getGuaZfbJourMonthExpend() {
        return guaZfbJourMonthExpend;
    }

    public void setGuaZfbJourMonthExpend(String guaZfbJourMonthExpend) {
        this.guaZfbJourMonthExpend = guaZfbJourMonthExpend;
    }

    public String getGuaZfbJourPic() {
        return guaZfbJourPic;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setGuaZfbJourPic(String guaZfbJourPic) {
        this.guaZfbJourPic = guaZfbJourPic;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGuaZfbJourRemark() {
        return guaZfbJourRemark;
    }

    public void setGuaZfbJourRemark(String guaZfbJourRemark) {
        this.guaZfbJourRemark = guaZfbJourRemark;
    }

    public String getGuaWxJourDatetimeStart() {
        return guaWxJourDatetimeStart;
    }

    public void setGuaWxJourDatetimeStart(String guaWxJourDatetimeStart) {
        this.guaWxJourDatetimeStart = guaWxJourDatetimeStart;
    }

    public String getGuaWxJourDatetimeEnd() {
        return guaWxJourDatetimeEnd;
    }

    public void setGuaWxJourDatetimeEnd(String guaWxJourDatetimeEnd) {
        this.guaWxJourDatetimeEnd = guaWxJourDatetimeEnd;
    }

    public String getGuaWxJourIncome() {
        return guaWxJourIncome;
    }

    public void setGuaWxJourIncome(String guaWxJourIncome) {
        this.guaWxJourIncome = guaWxJourIncome;
    }

    public String getGuaWxJourExpend() {
        return guaWxJourExpend;
    }

    public void setGuaWxJourExpend(String guaWxJourExpend) {
        this.guaWxJourExpend = guaWxJourExpend;
    }

    public String getGuaWxJourBalance() {
        return guaWxJourBalance;
    }

    public String getTeamFee() {
        return teamFee;
    }

    public void setTeamFee(String teamFee) {
        this.teamFee = teamFee;
    }

    public void setGuaWxJourBalance(String guaWxJourBalance) {
        this.guaWxJourBalance = guaWxJourBalance;
    }

    public String getGuaWxJourMonthIncome() {
        return guaWxJourMonthIncome;
    }

    public void setGuaWxJourMonthIncome(String guaWxJourMonthIncome) {
        this.guaWxJourMonthIncome = guaWxJourMonthIncome;
    }

    public String getGuaWxJourMonthExpend() {
        return guaWxJourMonthExpend;
    }

    public void setGuaWxJourMonthExpend(String guaWxJourMonthExpend) {
        this.guaWxJourMonthExpend = guaWxJourMonthExpend;
    }

    public String getGuaWxJourPic() {
        return guaWxJourPic;
    }

    public void setGuaWxJourPic(String guaWxJourPic) {
        this.guaWxJourPic = guaWxJourPic;
    }

    public String getGuaWxJourRemark() {
        return guaWxJourRemark;
    }

    public void setGuaWxJourRemark(String guaWxJourRemark) {
        this.guaWxJourRemark = guaWxJourRemark;
    }

    public String getGuaJourDatetimeStart() {
        return guaJourDatetimeStart;
    }

    public void setGuaJourDatetimeStart(String guaJourDatetimeStart) {
        this.guaJourDatetimeStart = guaJourDatetimeStart;
    }

    public String getGuaJourDatetimeEnd() {
        return guaJourDatetimeEnd;
    }

    public void setGuaJourDatetimeEnd(String guaJourDatetimeEnd) {
        this.guaJourDatetimeEnd = guaJourDatetimeEnd;
    }

    public String getGuaJourIncome() {
        return guaJourIncome;
    }

    public void setGuaJourIncome(String guaJourIncome) {
        this.guaJourIncome = guaJourIncome;
    }

    public String getGuaJourExpend() {
        return guaJourExpend;
    }

    public void setGuaJourExpend(String guaJourExpend) {
        this.guaJourExpend = guaJourExpend;
    }

    public String getGuaJourBalance() {
        return guaJourBalance;
    }

    public void setGuaJourBalance(String guaJourBalance) {
        this.guaJourBalance = guaJourBalance;
    }

    public String getGuaJourMonthIncome() {
        return guaJourMonthIncome;
    }

    public void setGuaJourMonthIncome(String guaJourMonthIncome) {
        this.guaJourMonthIncome = guaJourMonthIncome;
    }

    public String getGuaJourMonthExpend() {
        return guaJourMonthExpend;
    }

    public void setGuaJourMonthExpend(String guaJourMonthExpend) {
        this.guaJourMonthExpend = guaJourMonthExpend;
    }

    public String getVehicleCompanyName() {
        return vehicleCompanyName;
    }

    public void setVehicleCompanyName(String vehicleCompanyName) {
        this.vehicleCompanyName = vehicleCompanyName;
    }

    public String getGuaJourPic() {
        return guaJourPic;
    }

    public void setGuaJourPic(String guaJourPic) {
        this.guaJourPic = guaJourPic;
    }

    public String getGuaJourRemark() {
        return guaJourRemark;
    }

    public void setGuaJourRemark(String guaJourRemark) {
        this.guaJourRemark = guaJourRemark;
    }

    public String getGuaAssetPdf() {
        return guaAssetPdf;
    }

    public void setGuaAssetPdf(String guaAssetPdf) {
        this.guaAssetPdf = guaAssetPdf;
    }

    public String getZfbJourDatetimeStart() {
        return zfbJourDatetimeStart;
    }

    public void setZfbJourDatetimeStart(String zfbJourDatetimeStart) {
        this.zfbJourDatetimeStart = zfbJourDatetimeStart;
    }

    public String getCarHgzPic() {
        return carHgzPic;
    }

    public void setCarHgzPic(String carHgzPic) {
        this.carHgzPic = carHgzPic;
    }

    public String getZfbJourDatetimeEnd() {
        return zfbJourDatetimeEnd;
    }

    public void setZfbJourDatetimeEnd(String zfbJourDatetimeEnd) {
        this.zfbJourDatetimeEnd = zfbJourDatetimeEnd;
    }

    public String getZfbJourIncome() {
        return zfbJourIncome;
    }

    public void setZfbJourIncome(String zfbJourIncome) {
        this.zfbJourIncome = zfbJourIncome;
    }

    public String getZfbJourExpend() {
        return zfbJourExpend;
    }

    public void setZfbJourExpend(String zfbJourExpend) {
        this.zfbJourExpend = zfbJourExpend;
    }

    public String getZfbJourBalance() {
        return zfbJourBalance;
    }

    public void setZfbJourBalance(String zfbJourBalance) {
        this.zfbJourBalance = zfbJourBalance;
    }

    public String getZfbJourMonthIncome() {
        return zfbJourMonthIncome;
    }

    public void setZfbJourMonthIncome(String zfbJourMonthIncome) {
        this.zfbJourMonthIncome = zfbJourMonthIncome;
    }

    public String getZfbJourMonthExpend() {
        return zfbJourMonthExpend;
    }

    public void setZfbJourMonthExpend(String zfbJourMonthExpend) {
        this.zfbJourMonthExpend = zfbJourMonthExpend;
    }

    public String getZfbJourPic() {
        return zfbJourPic;
    }

    public void setZfbJourPic(String zfbJourPic) {
        this.zfbJourPic = zfbJourPic;
    }

    public String getZfbJourRemark() {
        return zfbJourRemark;
    }

    public void setZfbJourRemark(String zfbJourRemark) {
        this.zfbJourRemark = zfbJourRemark;
    }

    public String getOtherWorkNote() {
        return otherWorkNote;
    }

    public void setOtherWorkNote(String otherWorkNote) {
        this.otherWorkNote = otherWorkNote;
    }

    public String getWorkAssetPdf() {
        return workAssetPdf;
    }

    public void setWorkAssetPdf(String workAssetPdf) {
        this.workAssetPdf = workAssetPdf;
    }

    public String getWxJourDatetimeStart() {
        return wxJourDatetimeStart;
    }

    public void setWxJourDatetimeStart(String wxJourDatetimeStart) {
        this.wxJourDatetimeStart = wxJourDatetimeStart;
    }

    public String getDriveLicenseFront() {
        return driveLicenseFront;
    }

    public void setDriveLicenseFront(String driveLicenseFront) {
        this.driveLicenseFront = driveLicenseFront;
    }

    public String getDriveLicenseReverse() {
        return driveLicenseReverse;
    }

    public void setDriveLicenseReverse(String driveLicenseReverse) {
        this.driveLicenseReverse = driveLicenseReverse;
    }

    public String getEvaluateColumn() {
        return evaluateColumn;
    }

    public void setEvaluateColumn(String evaluateColumn) {
        this.evaluateColumn = evaluateColumn;
    }

    public String getWxJourDatetimeEnd() {
        return wxJourDatetimeEnd;
    }

    public void setWxJourDatetimeEnd(String wxJourDatetimeEnd) {
        this.wxJourDatetimeEnd = wxJourDatetimeEnd;
    }

    public String getWxJourIncome() {
        return wxJourIncome;
    }

    public String getMateZfbJourInterest1() {
        return mateZfbJourInterest1;
    }

    public void setMateZfbJourInterest1(String mateZfbJourInterest1) {
        this.mateZfbJourInterest1 = mateZfbJourInterest1;
    }

    public String getMateZfbJourInterest2() {
        return mateZfbJourInterest2;
    }

    public void setMateZfbJourInterest2(String mateZfbJourInterest2) {
        this.mateZfbJourInterest2 = mateZfbJourInterest2;
    }

    public String getMateWxJourInterest1() {
        return mateWxJourInterest1;
    }

    public void setMateWxJourInterest1(String mateWxJourInterest1) {
        this.mateWxJourInterest1 = mateWxJourInterest1;
    }

    public String getMateWxJourInterest2() {
        return mateWxJourInterest2;
    }

    public void setMateWxJourInterest2(String mateWxJourInterest2) {
        this.mateWxJourInterest2 = mateWxJourInterest2;
    }

    public String getMateJourInterest1() {
        return mateJourInterest1;
    }

    public void setMateJourInterest1(String mateJourInterest1) {
        this.mateJourInterest1 = mateJourInterest1;
    }

    public String getMateJourInterest2() {
        return mateJourInterest2;
    }

    public void setMateJourInterest2(String mateJourInterest2) {
        this.mateJourInterest2 = mateJourInterest2;
    }

    public String getGuaZfbJourInterest1() {
        return guaZfbJourInterest1;
    }

    public void setGuaZfbJourInterest1(String guaZfbJourInterest1) {
        this.guaZfbJourInterest1 = guaZfbJourInterest1;
    }

    public String getGuaZfbJourInterest2() {
        return guaZfbJourInterest2;
    }

    public void setGuaZfbJourInterest2(String guaZfbJourInterest2) {
        this.guaZfbJourInterest2 = guaZfbJourInterest2;
    }

    public String getGuaWxJourInterest1() {
        return guaWxJourInterest1;
    }

    public void setGuaWxJourInterest1(String guaWxJourInterest1) {
        this.guaWxJourInterest1 = guaWxJourInterest1;
    }

    public String getGuaWxJourInterest2() {
        return guaWxJourInterest2;
    }

    public void setGuaWxJourInterest2(String guaWxJourInterest2) {
        this.guaWxJourInterest2 = guaWxJourInterest2;
    }

    public String getGuaJourInterest1() {
        return guaJourInterest1;
    }

    public void setGuaJourInterest1(String guaJourInterest1) {
        this.guaJourInterest1 = guaJourInterest1;
    }

    public String getGuaJourInterest2() {
        return guaJourInterest2;
    }

    public void setGuaJourInterest2(String guaJourInterest2) {
        this.guaJourInterest2 = guaJourInterest2;
    }

    public String getZfbJourInterest1() {
        return zfbJourInterest1;
    }

    public void setZfbJourInterest1(String zfbJourInterest1) {
        this.zfbJourInterest1 = zfbJourInterest1;
    }

    public String getZfbJourInterest2() {
        return zfbJourInterest2;
    }

    public void setZfbJourInterest2(String zfbJourInterest2) {
        this.zfbJourInterest2 = zfbJourInterest2;
    }

    public String getWxJourInterest1() {
        return wxJourInterest1;
    }

    public void setWxJourInterest1(String wxJourInterest1) {
        this.wxJourInterest1 = wxJourInterest1;
    }

    public String getWxJourInterest2() {
        return wxJourInterest2;
    }

    public void setWxJourInterest2(String wxJourInterest2) {
        this.wxJourInterest2 = wxJourInterest2;
    }

    public String getJourInterest1() {
        return jourInterest1;
    }

    public void setJourInterest1(String jourInterest1) {
        this.jourInterest1 = jourInterest1;
    }

    public String getJourInterest2() {
        return jourInterest2;
    }

    public void setJourInterest2(String jourInterest2) {
        this.jourInterest2 = jourInterest2;
    }

    public void setWxJourIncome(String wxJourIncome) {
        this.wxJourIncome = wxJourIncome;
    }

    public String getWxJourExpend() {
        return wxJourExpend;
    }

    public void setWxJourExpend(String wxJourExpend) {
        this.wxJourExpend = wxJourExpend;
    }

    public String getWxJourBalance() {
        return wxJourBalance;
    }

    public void setWxJourBalance(String wxJourBalance) {
        this.wxJourBalance = wxJourBalance;
    }

    public String getWxJourMonthIncome() {
        return wxJourMonthIncome;
    }

    public void setWxJourMonthIncome(String wxJourMonthIncome) {
        this.wxJourMonthIncome = wxJourMonthIncome;
    }

    public String getWxJourMonthExpend() {
        return wxJourMonthExpend;
    }

    public void setWxJourMonthExpend(String wxJourMonthExpend) {
        this.wxJourMonthExpend = wxJourMonthExpend;
    }

    public String getWxJourPic() {
        return wxJourPic;
    }

    public void setWxJourPic(String wxJourPic) {
        this.wxJourPic = wxJourPic;
    }

    public String getWxJourRemark() {
        return wxJourRemark;
    }

    public void setWxJourRemark(String wxJourRemark) {
        this.wxJourRemark = wxJourRemark;
    }

    public String getJourPic() {
        return jourPic;
    }

    public void setJourPic(String jourPic) {
        this.jourPic = jourPic;
    }

    public String getAssetPdf() {
        return assetPdf;
    }

    public void setAssetPdf(String assetPdf) {
        this.assetPdf = assetPdf;
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

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
    }

}
