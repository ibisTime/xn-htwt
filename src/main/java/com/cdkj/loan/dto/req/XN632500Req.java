package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新录入准入单
 * @author: taojian 
 * @since: 2019年4月28日 上午10:19:41 
 * @history:
 */
public class XN632500Req {
    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    // 处理类型(0 保存 1 发送)
    @NotBlank
    private String dealType;

    /***************贷款信息start**************/

    // 贷款期限
    @NotBlank
    private String loanPeriod;// repayBiz

    // 银行利率
    @NotBlank
    private String bankRate;

    // 贷款产品编号
    @NotBlank
    private String loanProductCode;// repayBiz

    // 年华费率
    @NotBlank
    private String yearRate;

    // GPS费用
    @NotBlank
    private String gpsFee;

    // 公证费用
    @NotBlank
    private String authFee;

    // 返点利率
    @NotBlank
    private String backRate;

    // 前置利率
    private double preRate;

    // 首付金额
    @NotBlank
    private String firstAmount;// repayBiz

    // 首付比例
    @NotBlank
    private String firstRate;// repayBiz

    // 首月月供
    @NotBlank
    private String firstRepayAmount;

    // 月供金额
    @NotBlank
    private String monthAmount;

    // 是否垫资
    @NotBlank
    private String isAdvanceFund;// cdbiz

    // 是否融资
    @NotBlank
    private String isFinancing;// cdbiz

    // 是否安装gps
    @NotBlank
    private String isAzGps;

    // 月供保证金
    @NotBlank
    private String monthDeposit;// carInfo

    // 团队服务费
    @NotBlank
    private String teamFee;// carInfo

    /****************贷款信息end***************/

    /***************车辆信息start**************/

    // 机动车销售公司
    @NotBlank
    private String vehicleCompanyName;// carInfo

    // 开票单位
    @NotBlank
    private String invoiceCompany;// carInfo

    // 开票价
    @NotBlank
    private String invoicePrice;// carInfo

    // 车辆类型
    @NotBlank
    private String carType;// carInfo

    // 品牌
    @NotBlank
    private String carBrand;// carInfo

    // 车系
    @NotBlank
    private String carSeries;// carInfo

    // 车型
    @NotBlank
    private String carModel;// carInfo

    // 车型名称
    @NotBlank
    private String carModelName;// carInfo

    // 颜色
    @NotBlank
    private String carColor;// carInfo

    // 车架号
    @NotBlank
    private String carFrameNo;// carInfo

    // 发动机号
    @NotBlank
    private String carEngineNo;// carInfo

    // 市场指导价
    @NotBlank
    private String originalPrice;// carInfo

    // 所属区域
    @NotBlank
    private String region;// carInfo

    // 厂家贴息
    private String carDealerSubsidy;

    // 油补公里数
    private String oilSubsidyKil;

    // 油补
    private String oilSubsidy;

    // 代理人
    @NotBlank
    private String pledgeUser;

    // 代理人身份证复印件
    private String pledgeUserIdCardCopy;

    // 抵押地点
    @NotBlank
    private String pledgeAddress;

    // 落户地点
    @NotBlank
    private String settleAddress;// carInfo

    // 车辆照片
    @NotBlank
    private String carPic;

    // 合格证
    @NotBlank
    private String carHgzPic;

    /****************车辆信息end***************/

    /***************客户信息start**************/
    // 性别
    @NotBlank
    private String gender;

    // 年龄
    @NotBlank
    private String age;

    // 民族
    @NotBlank
    private String nation;

    // 学历
    @NotBlank
    private String education;

    // 政治面貌
    @NotBlank
    private String political;

    // 职业
    private String workProfession;

    // 职称
    private String postTitle;

    // 有无驾照
    private String isDriceLicense;

    // 现有车辆
    private String carTypeNow;

    // 主要收入来源
    @NotBlank
    private String mainIncome;

    // 家庭紧急联系人信息1 姓名
    @NotBlank
    private String emergencyName1;

    // 家庭紧急联系人信息1 与申请人关系
    @NotBlank
    private String emergencyRelation1;

    // 家庭紧急联系人信息1 手机号码
    @NotBlank
    private String emergencyMobile1;

    // 家庭紧急联系人信息2 姓名
    private String emergencyName2;

    // 家庭紧急联系人信息2 与申请人关系
    private String emergencyRelation2;

    // 家庭紧急联系人信息2 手机号码
    private String emergencyMobile2;

    /****************客户信息end***************/

    /***************家庭情况start**************/

    // 婚姻状况
    @NotBlank
    private String marryState;

    // 家庭人口
    @NotBlank
    private String familyNumber;

    // 家庭电话
    @NotBlank
    private String familyPhone;

    // 家庭主要财产
    @NotBlank
    private String familyMainAsset;

    // 主要财产包括
    @NotBlank
    private String mainAssetInclude;

    // 户口所在地
    @NotBlank
    private String residenceAddress;

    // 户口所在地邮编2
    @NotBlank
    private String postCode2;

    // 现居住地址
    @NotBlank
    private String nowAddress;

    // 现居住地址邮编1
    @NotBlank
    private String postCode1;

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

    /***************工作情况start**************/

    // 是否自己单位
    private String isSelfCompany;

    // 所属行业
    private String workBelongIndustry;

    // 单位性质
    private String workCompanyProperty;

    // 工作单位名称
    @NotBlank
    private String workCompanyName;

    // 工作单位地址
    @NotBlank
    private String workCompanyAddress;

    // 工作单位电话
    private String workPhone;

    // 何时进入现单位工作
    private String workDatetime;

    // 职位
    private String position;

    // 月收入
    @NotBlank
    private String monthIncome;

    // 收入证明
    private String improvePdf;

    // 单位前台照片
    private String frontTablePic;

    // 单位场地照片
    private String workPlacePic;

    // 业务员与客户合影
    private String salerAndcustomer;

    /****************工作情况end***************/

    /***************共还人信息start**************/

    // 户籍地省市区
    private String mateBirthAddressProvince;

    private String mateBirthAddressCity;

    private String mateBirthAddressArea;

    // 户籍地地址
    private String mateBirthAddress;

    // 户籍地邮编
    private String matePostCode;

    // 配偶学历
    private String mateEducation;

    // 配偶工作单位名称
    private String mateCompanyName;

    // 配偶工作单位地址
    private String mateCompanyAddress;

    // 配偶工作单位联系电话
    private String mateCompanyContactNo;

    private String mateAssetPdf;

    /****************共还人信息end***************/

    /***************担保人信息start**************/

    // 户籍地省市区
    private String guaBirthAddressProvince;

    private String guaBirthAddressCity;

    private String guaBirthAddressArea;

    // 户籍地地址
    private String guaBirthAddress;

    // 户籍地邮编
    private String guaPostCode;

    // 配偶学历
    private String guaEducation;

    // 配偶工作单位名称
    private String guaCompanyName;

    // 配偶工作单位地址
    private String guaCompanyAddress;

    // 配偶工作单位联系电话
    private String guaCompanyContactNo;

    private String guaAssetPdf;

    /****************担保人信息end***************/

    /**************冗余字段*****************/
    // 工作描述及还款来源分析
    private String otherWorkNote;

    // 工作资料上传
    private String workAssetPdf;

    // 其他资料
    private String otherPdf;

    // 身份证资料
    private String idCardPdf;

    // 其他辅助资料
    private String otherPic;

    // 房屋照片
    private String housePicture;

    /*******************************/

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

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getIsFinancing() {
        return isFinancing;
    }

    public void setIsFinancing(String isFinancing) {
        this.isFinancing = isFinancing;
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

    public String getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(String monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public String getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(String gpsFee) {
        this.gpsFee = gpsFee;
    }

    public String getAuthFee() {
        return authFee;
    }

    public void setAuthFee(String authFee) {
        this.authFee = authFee;
    }

    public String getTeamFee() {
        return teamFee;
    }

    public void setTeamFee(String teamFee) {
        this.teamFee = teamFee;
    }

    public String getVehicleCompanyName() {
        return vehicleCompanyName;
    }

    public void setVehicleCompanyName(String vehicleCompanyName) {
        this.vehicleCompanyName = vehicleCompanyName;
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
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

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
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

    public String getSettleAddress() {
        return settleAddress;
    }

    public void setSettleAddress(String settleAddress) {
        this.settleAddress = settleAddress;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getCarHgzPic() {
        return carHgzPic;
    }

    public void setCarHgzPic(String carHgzPic) {
        this.carHgzPic = carHgzPic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(String familyNumber) {
        this.familyNumber = familyNumber;
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

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getOtherPic() {
        return otherPic;
    }

    public void setOtherPic(String otherPic) {
        this.otherPic = otherPic;
    }

    public String getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(String housePicture) {
        this.housePicture = housePicture;
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

    public String getPledgeUser() {
        return pledgeUser;
    }

    public void setPledgeUser(String pledgeUser) {
        this.pledgeUser = pledgeUser;
    }

    public String getPledgeUserIdCardCopy() {
        return pledgeUserIdCardCopy;
    }

    public void setPledgeUserIdCardCopy(String pledgeUserIdCardCopy) {
        this.pledgeUserIdCardCopy = pledgeUserIdCardCopy;
    }

    public String getPledgeAddress() {
        return pledgeAddress;
    }

    public void setPledgeAddress(String pledgeAddress) {
        this.pledgeAddress = pledgeAddress;
    }

    public String getHkBookPdf() {
        return hkBookPdf;
    }

    public void setHkBookPdf(String hkBookPdf) {
        this.hkBookPdf = hkBookPdf;
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

    public String getMainIncome() {
        return mainIncome;
    }

    public void setMainIncome(String mainIncome) {
        this.mainIncome = mainIncome;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
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

    public String getGuaEducation() {
        return guaEducation;
    }

    public void setGuaEducation(String guaEducation) {
        this.guaEducation = guaEducation;
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

    public String getGuaCompanyContactNo() {
        return guaCompanyContactNo;
    }

    public void setGuaCompanyContactNo(String guaCompanyContactNo) {
        this.guaCompanyContactNo = guaCompanyContactNo;
    }

    public String getMateAssetPdf() {
        return mateAssetPdf;
    }

    public void setMateAssetPdf(String mateAssetPdf) {
        this.mateAssetPdf = mateAssetPdf;
    }

    public String getGuaAssetPdf() {
        return guaAssetPdf;
    }

    public void setGuaAssetPdf(String guaAssetPdf) {
        this.guaAssetPdf = guaAssetPdf;
    }

    public String getBankRate() {
        return bankRate;
    }

    public void setBankRate(String bankRate) {
        this.bankRate = bankRate;
    }

    public String getYearRate() {
        return yearRate;
    }

    public void setYearRate(String yearRate) {
        this.yearRate = yearRate;
    }

    public String getBackRate() {
        return backRate;
    }

    public void setBackRate(String backRate) {
        this.backRate = backRate;
    }

    public double getPreRate() {
        return preRate;
    }

    public void setPreRate(double preRate) {
        this.preRate = preRate;
    }

    public String getFirstRepayAmount() {
        return firstRepayAmount;
    }

    public void setFirstRepayAmount(String firstRepayAmount) {
        this.firstRepayAmount = firstRepayAmount;
    }

    public String getMonthAmount() {
        return monthAmount;
    }

    public void setMonthAmount(String monthAmount) {
        this.monthAmount = monthAmount;
    }

    public String getIsAzGps() {
        return isAzGps;
    }

    public void setIsAzGps(String isAzGps) {
        this.isAzGps = isAzGps;
    }

    public String getCarDealerSubsidy() {
        return carDealerSubsidy;
    }

    public void setCarDealerSubsidy(String carDealerSubsidy) {
        this.carDealerSubsidy = carDealerSubsidy;
    }

    public String getOilSubsidyKil() {
        return oilSubsidyKil;
    }

    public void setOilSubsidyKil(String oilSubsidyKil) {
        this.oilSubsidyKil = oilSubsidyKil;
    }

    public String getOilSubsidy() {
        return oilSubsidy;
    }

    public void setOilSubsidy(String oilSubsidy) {
        this.oilSubsidy = oilSubsidy;
    }

    public String getIsDriceLicense() {
        return isDriceLicense;
    }

    public void setIsDriceLicense(String isDriceLicense) {
        this.isDriceLicense = isDriceLicense;
    }

    public String getCarTypeNow() {
        return carTypeNow;
    }

    public void setCarTypeNow(String carTypeNow) {
        this.carTypeNow = carTypeNow;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
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

    public String getIsSelfCompany() {
        return isSelfCompany;
    }

    public void setIsSelfCompany(String isSelfCompany) {
        this.isSelfCompany = isSelfCompany;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getImprovePdf() {
        return improvePdf;
    }

    public void setImprovePdf(String improvePdf) {
        this.improvePdf = improvePdf;
    }

    public String getFrontTablePic() {
        return frontTablePic;
    }

    public void setFrontTablePic(String frontTablePic) {
        this.frontTablePic = frontTablePic;
    }

    public String getWorkPlacePic() {
        return workPlacePic;
    }

    public void setWorkPlacePic(String workPlacePic) {
        this.workPlacePic = workPlacePic;
    }

    public String getSalerAndcustomer() {
        return salerAndcustomer;
    }

    public void setSalerAndcustomer(String salerAndcustomer) {
        this.salerAndcustomer = salerAndcustomer;
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

    public String getGuaBirthAddressProvince() {
        return guaBirthAddressProvince;
    }

    public void setGuaBirthAddressProvince(String guaBirthAddressProvince) {
        this.guaBirthAddressProvince = guaBirthAddressProvince;
    }

    public String getGuaBirthAddressCity() {
        return guaBirthAddressCity;
    }

    public void setGuaBirthAddressCity(String guaBirthAddressCity) {
        this.guaBirthAddressCity = guaBirthAddressCity;
    }

    public String getGuaBirthAddressArea() {
        return guaBirthAddressArea;
    }

    public void setGuaBirthAddressArea(String guaBirthAddressArea) {
        this.guaBirthAddressArea = guaBirthAddressArea;
    }

    public String getGuaBirthAddress() {
        return guaBirthAddress;
    }

    public void setGuaBirthAddress(String guaBirthAddress) {
        this.guaBirthAddress = guaBirthAddress;
    }

    public String getGuaPostCode() {
        return guaPostCode;
    }

    public void setGuaPostCode(String guaPostCode) {
        this.guaPostCode = guaPostCode;
    }

}
