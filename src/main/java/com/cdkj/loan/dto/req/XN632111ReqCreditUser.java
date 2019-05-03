package com.cdkj.loan.dto.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 录入征信结果（征信人员）
 * @author: jiafr 
 * @since: 2018年5月25日 下午10:23:09 
 * @history:
 */
public class XN632111ReqCreditUser {

    // 征信人员编号
    @NotBlank
    private String creditUserCode;

    // 信用卡占比
    @NotBlank
    @Min(0)
    @Max(1)
    private String creditCardOccupation;

    // 银行征信结果
    @NotBlank
    private String bankResult;

    // 银行征信结果
    @NotBlank
    private String bankCreditReport;

    // 大数据征信结果
    private String dataCreditReport;

    // 征信说明
    private String creditNote;

    public String getCreditCardOccupation() {
        return creditCardOccupation;
    }

    public void setCreditCardOccupation(String creditCardOccupation) {
        this.creditCardOccupation = creditCardOccupation;
    }

    public String getBankResult() {
        return bankResult;
    }

    public void setBankResult(String bankResult) {
        this.bankResult = bankResult;
    }

    public String getCreditUserCode() {
        return creditUserCode;
    }

    public void setCreditUserCode(String creditUserCode) {
        this.creditUserCode = creditUserCode;
    }

    public String getBankCreditReport() {
        return bankCreditReport;
    }

    public void setBankCreditReport(String bankCreditReport) {
        this.bankCreditReport = bankCreditReport;
    }

    public String getDataCreditReport() {
        return dataCreditReport;
    }

    public void setDataCreditReport(String dataCreditReport) {
        this.dataCreditReport = dataCreditReport;
    }

    public String getCreditNote() {
        return creditNote;
    }

    public void setCreditNote(String creditNote) {
        this.creditNote = creditNote;
    }

}
