package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 车辆信息
 *
 * @author: tao
 * @since: 2019-04-24 09:37:43
 * @history:
 */
public class CarInfo extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 品牌
    private String carBrand;

    // 车系
    private String carSeries;

    // 车型
    private String carModel;

    // 车型名称
    private String carModelName;

    // 车辆类型
    private String carType;

    // 颜色
    private String carColor;

    // 车架号
    private String carFrameNo;

    // 发动机号
    private String carEngineNo;

    // 市场指导价
    private String originalPrice;

    // 开票价
    private String invoicePrice;

    // 机动车销售公司
    private String vehicleCompanyName;

    // 开票单位
    private String invoiceCompany;

    // 所属区域
    private String region;

    // 评估栏
    private String evaluateColumn;

    // 所属区域
    private String settleAddress;

    // 保单日期
    private String policyDatetime;

    // 保单到期日
    private String policyDueDate;

    // 汽车经销商编号
    private String carDealerCode;

    // 汽车经销商名称（外单）
    private String outCarDealerName;

    // 购车途径
    private String shopWay;

    // 商业险合计
    private String commerceInsurance;

    // 担保合同编号
    private String guaranteeContractCode;

    // 银行合同编号
    private String bankContractCode;

    // 合同签订日
    private String contractSignDate;

    // 登记证书号
    private String regCertificateCode;

    // 里程表
    private String secondOdometer;

    // 核准链接
    private String checkApproveLink;

    // 核准软件
    private String checkApproveSoftware;

    // 信息源
    private String informationSource;

    // 评估价
    private String valuation;

    // 车行168车价
    private String car168Price;

    // 铭牌
    private String secondNumber;

    // 发票是否正确
    private String isRightInvoice;

    // 现发票价
    private String currentInvoicePrice;

    // 绿大本编号
    private String greenBigCode;

    // 车牌号
    private String carNumber;

    // 车辆落户日期
    private String carSettleDatetime;

    // 汽车经销商厂家贴息
    private String carDealerSubsidy;

    // 油补
    private String oilSubsidy;

    // 油补公里数
    private String oilSubsidyKil;

    // GPS提成
    private String gpsDeduct;

    // GPS收费方式（1转账2按揭款3返点4不收费）
    private String gpsFeeWay;

    // GPS费用
    private long gpsFee;

    // 公证费
    private long authFee;

    // 其他费用
    private long otherFee;

    // 公司手续费
    private long companyFee;

    // 团队服务费
    private long teamFee;

    // 月供保证金
    private long monthDeposit;

    /****DB Properties****/

    // 绿大本扫描件
    private String greenBigSmj;

    // 发票
    private String carInvoice;

    // 交强险
    private String carJqx;

    // 商业险
    private String carSyx;

    public long getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(long monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo;
    }

    public String getCarEngineNo() {
        return carEngineNo;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setVehicleCompanyName(String vehicleCompanyName) {
        this.vehicleCompanyName = vehicleCompanyName;
    }

    public String getVehicleCompanyName() {
        return vehicleCompanyName;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setEvaluateColumn(String evaluateColumn) {
        this.evaluateColumn = evaluateColumn;
    }

    public String getEvaluateColumn() {
        return evaluateColumn;
    }

    public void setSettleAddress(String settleAddress) {
        this.settleAddress = settleAddress;
    }

    public String getSettleAddress() {
        return settleAddress;
    }

    public void setPolicyDatetime(String policyDatetime) {
        this.policyDatetime = policyDatetime;
    }

    public String getPolicyDatetime() {
        return policyDatetime;
    }

    public void setPolicyDueDate(String policyDueDate) {
        this.policyDueDate = policyDueDate;
    }

    public String getPolicyDueDate() {
        return policyDueDate;
    }

    public void setCarDealerCode(String carDealerCode) {
        this.carDealerCode = carDealerCode;
    }

    public String getCarDealerCode() {
        return carDealerCode;
    }

    public void setOutCarDealerName(String outCarDealerName) {
        this.outCarDealerName = outCarDealerName;
    }

    public String getOutCarDealerName() {
        return outCarDealerName;
    }

    public void setShopWay(String shopWay) {
        this.shopWay = shopWay;
    }

    public String getShopWay() {
        return shopWay;
    }

    public void setCommerceInsurance(String commerceInsurance) {
        this.commerceInsurance = commerceInsurance;
    }

    public String getCommerceInsurance() {
        return commerceInsurance;
    }

    public void setGuaranteeContractCode(String guaranteeContractCode) {
        this.guaranteeContractCode = guaranteeContractCode;
    }

    public String getGuaranteeContractCode() {
        return guaranteeContractCode;
    }

    public void setBankContractCode(String bankContractCode) {
        this.bankContractCode = bankContractCode;
    }

    public String getBankContractCode() {
        return bankContractCode;
    }

    public void setContractSignDate(String contractSignDate) {
        this.contractSignDate = contractSignDate;
    }

    public String getContractSignDate() {
        return contractSignDate;
    }

    public void setRegCertificateCode(String regCertificateCode) {
        this.regCertificateCode = regCertificateCode;
    }

    public String getRegCertificateCode() {
        return regCertificateCode;
    }

    public void setSecondOdometer(String secondOdometer) {
        this.secondOdometer = secondOdometer;
    }

    public String getSecondOdometer() {
        return secondOdometer;
    }

    public void setCheckApproveLink(String checkApproveLink) {
        this.checkApproveLink = checkApproveLink;
    }

    public String getCheckApproveLink() {
        return checkApproveLink;
    }

    public void setCheckApproveSoftware(String checkApproveSoftware) {
        this.checkApproveSoftware = checkApproveSoftware;
    }

    public String getCheckApproveSoftware() {
        return checkApproveSoftware;
    }

    public void setInformationSource(String informationSource) {
        this.informationSource = informationSource;
    }

    public String getInformationSource() {
        return informationSource;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public String getValuation() {
        return valuation;
    }

    public void setCar168Price(String car168Price) {
        this.car168Price = car168Price;
    }

    public String getCar168Price() {
        return car168Price;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setIsRightInvoice(String isRightInvoice) {
        this.isRightInvoice = isRightInvoice;
    }

    public String getIsRightInvoice() {
        return isRightInvoice;
    }

    public void setCurrentInvoicePrice(String currentInvoicePrice) {
        this.currentInvoicePrice = currentInvoicePrice;
    }

    public String getCurrentInvoicePrice() {
        return currentInvoicePrice;
    }

    public void setGreenBigCode(String greenBigCode) {
        this.greenBigCode = greenBigCode;
    }

    public String getGreenBigCode() {
        return greenBigCode;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarSettleDatetime(String carSettleDatetime) {
        this.carSettleDatetime = carSettleDatetime;
    }

    public String getCarSettleDatetime() {
        return carSettleDatetime;
    }

    public void setCarDealerSubsidy(String carDealerSubsidy) {
        this.carDealerSubsidy = carDealerSubsidy;
    }

    public String getCarDealerSubsidy() {
        return carDealerSubsidy;
    }

    public void setOilSubsidy(String oilSubsidy) {
        this.oilSubsidy = oilSubsidy;
    }

    public String getOilSubsidy() {
        return oilSubsidy;
    }

    public void setOilSubsidyKil(String oilSubsidyKil) {
        this.oilSubsidyKil = oilSubsidyKil;
    }

    public String getOilSubsidyKil() {
        return oilSubsidyKil;
    }

    public void setGpsDeduct(String gpsDeduct) {
        this.gpsDeduct = gpsDeduct;
    }

    public String getGpsDeduct() {
        return gpsDeduct;
    }

    public void setGpsFeeWay(String gpsFeeWay) {
        this.gpsFeeWay = gpsFeeWay;
    }

    public String getGpsFeeWay() {
        return gpsFeeWay;
    }

    public long getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(long gpsFee) {
        this.gpsFee = gpsFee;
    }

    public long getAuthFee() {
        return authFee;
    }

    public void setAuthFee(long authFee) {
        this.authFee = authFee;
    }

    public long getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(long otherFee) {
        this.otherFee = otherFee;
    }

    public long getCompanyFee() {
        return companyFee;
    }

    public void setCompanyFee(long companyFee) {
        this.companyFee = companyFee;
    }

    public long getTeamFee() {
        return teamFee;
    }

    public void setTeamFee(long teamFee) {
        this.teamFee = teamFee;
    }

    public String getGreenBigSmj() {
        return greenBigSmj;
    }

    public void setGreenBigSmj(String greenBigSmj) {
        this.greenBigSmj = greenBigSmj;
    }

    public String getCarInvoice() {
        return carInvoice;
    }

    public void setCarInvoice(String carInvoice) {
        this.carInvoice = carInvoice;
    }

    public String getCarJqx() {
        return carJqx;
    }

    public void setCarJqx(String carJqx) {
        this.carJqx = carJqx;
    }

    public String getCarSyx() {
        return carSyx;
    }

    public void setCarSyx(String carSyx) {
        this.carSyx = carSyx;
    }

}
