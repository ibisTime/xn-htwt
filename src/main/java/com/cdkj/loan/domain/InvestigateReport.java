package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 调查报告
* @author: CYunlai 
* @since: 2018-07-05 17:02:44
* @history:
*/
public class InvestigateReport extends ABaseDO {

	private static final long serialVersionUID = 1L;

	// 编号
	private String code;

	// 预算单编号
	private String budgetOrderCode;

	// 业务编号
	private String repayBizCode;

	// 业务公司
	private String companyOde;

	// 业务种类
	private String bizYpe;

	// 客户姓名
	private String applyUserName;

	// 申请时间
	private String applyDatetime;

	// 贷款银行
	private String loanBank;

	// 贷款金额
	private String loanAmount;

	// 贷款期数
	private String loanPeriod;

	// 是否垫资
	private String isAdvanceFund;

	// 业务员
	private String saleUserId;

	// 担保方式
	private String guaMode;

	// 申请人征信情况
	private String customerInformation;

	// 申请人贷款车辆价格核准情况
	private String bankCreditResultPdf;

	// 车行168车价
	private String priceApprovalPdf;

	// 申请人工作情况及流水反映
	private String car168Price;

	// 银行流水
	private String applyWorkAndJour;

	// 银行流水情况
	private String jourPic;

	// 支付宝流水
	private String jourRemark;

	// 支付宝流水情况
	private String zfbJourPic;

	// 微信流水
	private String zfbJourRemark;

	// 微信流水情况
	private String wxJourPic;

	// 房产情况及家访
	private String wxJourPdf;

	// 家访地址
	private String houseContract;

	// 家访照片
	private String homeVisit;

	// 车辆基础信息
	private String basicsInformation;

	// 行驶证主副页
	private String xszPdf;

	// 行驶证车辆照片页
	private String xszCarPdf;

	// 车架号
	private String frameNo;

	// 车辆铭牌
	private String nameplate;

	// 车辆照片正前
	private String forwardPdf;

	// 车辆照片正后
	private String queenPdf;

	// 车辆照片正左
	private String leftPdf;

	// 车辆照片正右
	private String rightPdf;

	// 车辆照片左前45o
	private String lf45Pdf;

	// 车辆照片右前45o
	private String rf45Pdf;

	// 车辆照片左后45o
	private String lg45Pdf;

	// 车辆照片右后45o
	private String rr45Pdf;

	// 车辆照片发动机仓
	private String enginePdf;

	// 车辆中控台照片
	private String szmPdf;

	// 车辆档位照片
	private String gearsPdf;

	// 车辆功能区里照片
	private String functionalZonePdf;

	// 车辆里程表照片
	private String odometerPdf;

	// 车辆前排内饰照片
	private String frontRowPdf;

	// 车辆中排内饰照片
	private String rockRowPdf;

	// 车辆后备箱照片
	private String trunkPdf;

	// 车辆天窗照片
	private String louverPdf;

	// 车辆后排娱乐系统照片
	private String bankRowPdf;

	// 车辆核准截图
	private String checkApprovePdf;

	// 核准链接
	private String checkApproveLink;

	// 第三方评估价截图
	private String thirdValuationPdf;

	// 核准软件
	private String checkApproveSoftware;

	// 二手车市场成交价最低及最高截图
	private String usedCarCurrentRate;

	// 信息源
	private String informationSource;

	// 评估价
	private String valuation;

	// 节点编号
	private String curNodeCode;

	// 更新人
	private String updater;

	// 更新时间
	private String updateDatetime;

	// 备注
	private String remark;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setBudgetOrderCode(String budgetOrderCode) {
		this.budgetOrderCode = budgetOrderCode;
	}

	public String getBudgetOrderCode() {
		return budgetOrderCode;
	}

	public void setRepayBizCode(String repayBizCode) {
		this.repayBizCode = repayBizCode;
	}

	public String getRepayBizCode() {
		return repayBizCode;
	}

	public void setCompanyOde(String companyOde) {
		this.companyOde = companyOde;
	}

	public String getCompanyOde() {
		return companyOde;
	}

	public void setBizYpe(String bizYpe) {
		this.bizYpe = bizYpe;
	}

	public String getBizYpe() {
		return bizYpe;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyDatetime(String applyDatetime) {
		this.applyDatetime = applyDatetime;
	}

	public String getApplyDatetime() {
		return applyDatetime;
	}

	public void setLoanBank(String loanBank) {
		this.loanBank = loanBank;
	}

	public String getLoanBank() {
		return loanBank;
	}

	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanAmount() {
		return loanAmount;
	}

	public void setLoanPeriod(String loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public String getLoanPeriod() {
		return loanPeriod;
	}

	public void setIsAdvanceFund(String isAdvanceFund) {
		this.isAdvanceFund = isAdvanceFund;
	}

	public String getIsAdvanceFund() {
		return isAdvanceFund;
	}

	public void setSaleUserId(String saleUserId) {
		this.saleUserId = saleUserId;
	}

	public String getSaleUserId() {
		return saleUserId;
	}

	public void setGuaMode(String guaMode) {
		this.guaMode = guaMode;
	}

	public String getGuaMode() {
		return guaMode;
	}

	public void setCustomerInformation(String customerInformation) {
		this.customerInformation = customerInformation;
	}

	public String getCustomerInformation() {
		return customerInformation;
	}

	public void setBankCreditResultPdf(String bankCreditResultPdf) {
		this.bankCreditResultPdf = bankCreditResultPdf;
	}

	public String getBankCreditResultPdf() {
		return bankCreditResultPdf;
	}

	public void setPriceApprovalPdf(String priceApprovalPdf) {
		this.priceApprovalPdf = priceApprovalPdf;
	}

	public String getPriceApprovalPdf() {
		return priceApprovalPdf;
	}

	public void setCar168Price(String car168Price) {
		this.car168Price = car168Price;
	}

	public String getCar168Price() {
		return car168Price;
	}

	public void setApplyWorkAndJour(String applyWorkAndJour) {
		this.applyWorkAndJour = applyWorkAndJour;
	}

	public String getApplyWorkAndJour() {
		return applyWorkAndJour;
	}

	public void setJourPic(String jourPic) {
		this.jourPic = jourPic;
	}

	public String getJourPic() {
		return jourPic;
	}

	public void setJourRemark(String jourRemark) {
		this.jourRemark = jourRemark;
	}

	public String getJourRemark() {
		return jourRemark;
	}

	public void setZfbJourPic(String zfbJourPic) {
		this.zfbJourPic = zfbJourPic;
	}

	public String getZfbJourPic() {
		return zfbJourPic;
	}

	public void setZfbJourRemark(String zfbJourRemark) {
		this.zfbJourRemark = zfbJourRemark;
	}

	public String getZfbJourRemark() {
		return zfbJourRemark;
	}

	public void setWxJourPic(String wxJourPic) {
		this.wxJourPic = wxJourPic;
	}

	public String getWxJourPic() {
		return wxJourPic;
	}

	public void setWxJourPdf(String wxJourPdf) {
		this.wxJourPdf = wxJourPdf;
	}

	public String getWxJourPdf() {
		return wxJourPdf;
	}

	public void setHouseContract(String houseContract) {
		this.houseContract = houseContract;
	}

	public String getHouseContract() {
		return houseContract;
	}

	public void setHomeVisit(String homeVisit) {
		this.homeVisit = homeVisit;
	}

	public String getHomeVisit() {
		return homeVisit;
	}

	public void setBasicsInformation(String basicsInformation) {
		this.basicsInformation = basicsInformation;
	}

	public String getBasicsInformation() {
		return basicsInformation;
	}

	public void setXszPdf(String xszPdf) {
		this.xszPdf = xszPdf;
	}

	public String getXszPdf() {
		return xszPdf;
	}

	public void setXszCarPdf(String xszCarPdf) {
		this.xszCarPdf = xszCarPdf;
	}

	public String getXszCarPdf() {
		return xszCarPdf;
	}

	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}

	public String getFrameNo() {
		return frameNo;
	}

	public void setNameplate(String nameplate) {
		this.nameplate = nameplate;
	}

	public String getNameplate() {
		return nameplate;
	}

	public void setForwardPdf(String forwardPdf) {
		this.forwardPdf = forwardPdf;
	}

	public String getForwardPdf() {
		return forwardPdf;
	}

	public void setQueenPdf(String queenPdf) {
		this.queenPdf = queenPdf;
	}

	public String getQueenPdf() {
		return queenPdf;
	}

	public void setLeftPdf(String leftPdf) {
		this.leftPdf = leftPdf;
	}

	public String getLeftPdf() {
		return leftPdf;
	}

	public void setRightPdf(String rightPdf) {
		this.rightPdf = rightPdf;
	}

	public String getRightPdf() {
		return rightPdf;
	}

	public void setLf45Pdf(String lf45Pdf) {
		this.lf45Pdf = lf45Pdf;
	}

	public String getLf45Pdf() {
		return lf45Pdf;
	}

	public void setRf45Pdf(String rf45Pdf) {
		this.rf45Pdf = rf45Pdf;
	}

	public String getRf45Pdf() {
		return rf45Pdf;
	}

	public void setLg45Pdf(String lg45Pdf) {
		this.lg45Pdf = lg45Pdf;
	}

	public String getLg45Pdf() {
		return lg45Pdf;
	}

	public void setRr45Pdf(String rr45Pdf) {
		this.rr45Pdf = rr45Pdf;
	}

	public String getRr45Pdf() {
		return rr45Pdf;
	}

	public void setEnginePdf(String enginePdf) {
		this.enginePdf = enginePdf;
	}

	public String getEnginePdf() {
		return enginePdf;
	}

	public void setSzmPdf(String szmPdf) {
		this.szmPdf = szmPdf;
	}

	public String getSzmPdf() {
		return szmPdf;
	}

	public void setGearsPdf(String gearsPdf) {
		this.gearsPdf = gearsPdf;
	}

	public String getGearsPdf() {
		return gearsPdf;
	}

	public void setFunctionalZonePdf(String functionalZonePdf) {
		this.functionalZonePdf = functionalZonePdf;
	}

	public String getFunctionalZonePdf() {
		return functionalZonePdf;
	}

	public void setOdometerPdf(String odometerPdf) {
		this.odometerPdf = odometerPdf;
	}

	public String getOdometerPdf() {
		return odometerPdf;
	}

	public void setFrontRowPdf(String frontRowPdf) {
		this.frontRowPdf = frontRowPdf;
	}

	public String getFrontRowPdf() {
		return frontRowPdf;
	}

	public void setRockRowPdf(String rockRowPdf) {
		this.rockRowPdf = rockRowPdf;
	}

	public String getRockRowPdf() {
		return rockRowPdf;
	}

	public void setTrunkPdf(String trunkPdf) {
		this.trunkPdf = trunkPdf;
	}

	public String getTrunkPdf() {
		return trunkPdf;
	}

	public void setLouverPdf(String louverPdf) {
		this.louverPdf = louverPdf;
	}

	public String getLouverPdf() {
		return louverPdf;
	}

	public void setBankRowPdf(String bankRowPdf) {
		this.bankRowPdf = bankRowPdf;
	}

	public String getBankRowPdf() {
		return bankRowPdf;
	}

	public void setCheckApprovePdf(String checkApprovePdf) {
		this.checkApprovePdf = checkApprovePdf;
	}

	public String getCheckApprovePdf() {
		return checkApprovePdf;
	}

	public void setCheckApproveLink(String checkApproveLink) {
		this.checkApproveLink = checkApproveLink;
	}

	public String getCheckApproveLink() {
		return checkApproveLink;
	}

	public void setThirdValuationPdf(String thirdValuationPdf) {
		this.thirdValuationPdf = thirdValuationPdf;
	}

	public String getThirdValuationPdf() {
		return thirdValuationPdf;
	}

	public void setCheckApproveSoftware(String checkApproveSoftware) {
		this.checkApproveSoftware = checkApproveSoftware;
	}

	public String getCheckApproveSoftware() {
		return checkApproveSoftware;
	}

	public void setUsedCarCurrentRate(String usedCarCurrentRate) {
		this.usedCarCurrentRate = usedCarCurrentRate;
	}

	public String getUsedCarCurrentRate() {
		return usedCarCurrentRate;
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

	public void setCurNodeCode(String curNodeCode) {
		this.curNodeCode = curNodeCode;
	}

	public String getCurNodeCode() {
		return curNodeCode;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getUpdateDatetime() {
		return updateDatetime;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

}