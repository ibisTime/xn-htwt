package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-录入抵押信息
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632131Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 抵押日期
    private String pledgeDatetime;

    // 绿大本扫描件
    private String greenBigSmj;

    // 车辆落户日期
    private String carSettleDatetime;

    // 发票
    private String carInvoice;

    // 交强险
    private String carJqx;

    // 商业险
    private String carSyx;

    // 保单日期
    private String policyDatetime;

    // 保单到期日
    private String policyDueDate;

    // 其他资料
    private String carSettleOtherPdf;

    public String getCarSettleDatetime() {
        return carSettleDatetime;
    }

    public void setCarSettleDatetime(String carSettleDatetime) {
        this.carSettleDatetime = carSettleDatetime;
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

    public String getPolicyDatetime() {
        return policyDatetime;
    }

    public void setPolicyDatetime(String policyDatetime) {
        this.policyDatetime = policyDatetime;
    }

    public String getPolicyDueDate() {
        return policyDueDate;
    }

    public void setPolicyDueDate(String policyDueDate) {
        this.policyDueDate = policyDueDate;
    }

    public String getCarSettleOtherPdf() {
        return carSettleOtherPdf;
    }

    public void setCarSettleOtherPdf(String carSettleOtherPdf) {
        this.carSettleOtherPdf = carSettleOtherPdf;
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

    public String getPledgeDatetime() {
        return pledgeDatetime;
    }

    public void setPledgeDatetime(String pledgeDatetime) {
        this.pledgeDatetime = pledgeDatetime;
    }

    public String getGreenBigSmj() {
        return greenBigSmj;
    }

    public void setGreenBigSmj(String greenBigSmj) {
        this.greenBigSmj = greenBigSmj;
    }
}
