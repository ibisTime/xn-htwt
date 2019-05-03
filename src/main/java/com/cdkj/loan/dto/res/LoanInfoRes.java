package com.cdkj.loan.dto.res;

/**
 * 贷款信息res
 *
 * @author : cyl
 * @since : 2019-05-03 15:32
 */
public class LoanInfoRes {

    // 贷款期限
    private Integer periods;// repayBiz

    // 银行利率
    private Double bankRate;

    // 贷款金额
    private Long loanAmount;

    // 开票价
    private String invoicePrice;// carInfo

    // 贷款产品编号
    private String loanProductCode;// repayBiz

    // 贷款产品名称
    private String loanProductName;

    // GPS费用
    private String gpsFee;// carinfo

    // 公证费用
    private String authFee;// carinfo

    // 首付金额
    private Long sfAmount;// repayBiz

    // 首付比例
    private Double sfRate;// repayBiz

    // 是否垫资
    private String isAdvanceFund;// cdbiz

    // 是否融资
    private String isFinancing;// cdbiz

    // 是否安装gps
    private String isAzGps;// cdbiz

    // 是否我司续保
    private String isCompanyContinue;// cdbiz

    // 月供保证金
    private Long monthDeposit;// carInfo

    // 团队服务费
    private Long teamFee;// carInfo

    // 其他费用
    private Long otherFee;// carInfo


    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public String getLoanProductName() {
        return loanProductName;
    }

    public void setLoanProductName(String loanProductName) {
        this.loanProductName = loanProductName;
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

    public String getIsAzGps() {
        return isAzGps;
    }

    public void setIsAzGps(String isAzGps) {
        this.isAzGps = isAzGps;
    }

    public String getIsCompanyContinue() {
        return isCompanyContinue;
    }

    public void setIsCompanyContinue(String isCompanyContinue) {
        this.isCompanyContinue = isCompanyContinue;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Double getBankRate() {
        return bankRate;
    }

    public void setBankRate(Double bankRate) {
        this.bankRate = bankRate;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(Long sfAmount) {
        this.sfAmount = sfAmount;
    }

    public Double getSfRate() {
        return sfRate;
    }

    public void setSfRate(Double sfRate) {
        this.sfRate = sfRate;
    }

    public Long getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(Long monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public Long getTeamFee() {
        return teamFee;
    }

    public void setTeamFee(Long teamFee) {
        this.teamFee = teamFee;
    }

    public Long getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(Long otherFee) {
        this.otherFee = otherFee;
    }
}

    
    