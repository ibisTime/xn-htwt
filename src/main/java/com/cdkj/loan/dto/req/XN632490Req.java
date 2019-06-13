package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增征信流水
 * @author: silver 
 * @since: Apr 20, 2019 4:00:10 PM 
 * @history:
 */
public class XN632490Req {

    // 业务编号
    @NotBlank
    private String bizCode;

    // 征信人员编号
    @NotBlank
    private String creditUserCode;

    // 流水类型（微信/支付宝/银行）
    @NotBlank
    private String type;

    // 流水时间起
    private String datetimeStart;

    // 流水时间止
    private String datetimeEnd;

    // 流水结息1
    private String jourInterest1;

    // 流水结息2
    private String jourInterest2;

    // 结息1
    private String interest1;

    // 结息2
    private String interest2;

    // 收入
    private String income;

    // 支出
    private String expend;

    // 帐户余额
    private String balance;

    // 月均收入
    private String monthIncome;

    // 月均支出
    private String monthExpend;

    // 流水图片
    private String pic;

    // 流水备注
    private String remark;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getCreditUserCode() {
        return creditUserCode;
    }

    public void setCreditUserCode(String creditUserCode) {
        this.creditUserCode = creditUserCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetimeStart() {
        return datetimeStart;
    }

    public void setDatetimeStart(String datetimeStart) {
        this.datetimeStart = datetimeStart;
    }

    public String getDatetimeEnd() {
        return datetimeEnd;
    }

    public void setDatetimeEnd(String datetimeEnd) {
        this.datetimeEnd = datetimeEnd;
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

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpend() {
        return expend;
    }

    public void setExpend(String expend) {
        this.expend = expend;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getMonthExpend() {
        return monthExpend;
    }

    public void setMonthExpend(String monthExpend) {
        this.monthExpend = monthExpend;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
