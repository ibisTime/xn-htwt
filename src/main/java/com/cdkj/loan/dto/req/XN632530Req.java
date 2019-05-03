package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-贷款信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632530Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    @NotBlank
    // 处理类型(0 保存 1 发送)
    private String dealType;

    /***************贷款信息start**************/

    // 贷款期限
    @NotBlank
    private String loanPeriod;// repayBiz

    // 银行利率
    @NotBlank
    private String bankRate;

    // 贷款金额
    @NotBlank
    private String loanAmount;

    // 开票价
    @NotBlank
    private String invoicePrice;// carInfo

    // 贷款产品编号
    @NotBlank
    private String loanProductCode;// repayBiz

    // GPS费用
    @NotBlank
    private String gpsFee;// carinfo

    // 公证费用
    @NotBlank
    private String authFee;// carinfo

    // 首付金额
    @NotBlank
    private String firstAmount;// repayBiz

    // 首付比例
    @NotBlank
    private String firstRate;// repayBiz

    // 是否垫资
    @NotBlank
    private String isAdvanceFund;// cdbiz

    // 是否融资
    @NotBlank
    private String isFinancing;// cdbiz

    // 是否安装gps
    @NotBlank
    private String isAzGps;// cdbiz

    // 是否我司续保
    @NotBlank
    private String isCompanyContinue;// cdbiz

    // 月供保证金
    @NotBlank
    private String monthDeposit;// carInfo

    // 团队服务费
    @NotBlank
    private String teamFee;// carInfo

    // 其他费用
    @NotBlank
    private String otherFee;// carInfo

    /****************贷款信息end***************/

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

    public String getBankRate() {
        return bankRate;
    }

    public void setBankRate(String bankRate) {
        this.bankRate = bankRate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public String getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(String invoicePrice) {
        this.invoicePrice = invoicePrice;
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

    public String getMonthDeposit() {
        return monthDeposit;
    }

    public void setMonthDeposit(String monthDeposit) {
        this.monthDeposit = monthDeposit;
    }


    public String getTeamFee() {
        return teamFee;
    }

    public void setTeamFee(String teamFee) {
        this.teamFee = teamFee;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }
}
