package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 征信流水
* @author: tao 
* @since: 2019-04-20 14:55:13
* @history:
*/
public class CreditJour extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 征信人员编号
    private String creditUserCode;

    // 流水类型（微信/支付宝/银行）
    private String type;

    // 流水时间起
    private Date datetimeStart;

    // 流水时间止
    private Date datetimeEnd;

    // 流水结息1
    private Integer jourInterest1;

    // 流水结息2
    private Integer jourInterest2;

    // 结息1
    private Integer interest1;

    // 结息2
    private Integer interest2;

    // 收入
    private Integer income;

    // 支出
    private Integer expend;

    // 帐户余额
    private Integer balance;

    // 月均收入
    private Integer monthIncome;

    // 月均支出
    private Integer monthExpend;

    // 流水图片
    private String pic;

    // 流水备注
    private String remark;

    // **************************88

    private CreditUser creditUser;

    public CreditUser getCreditUser() {
        return creditUser;
    }

    public void setCreditUser(CreditUser creditUser) {
        this.creditUser = creditUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public Date getDatetimeStart() {
        return datetimeStart;
    }

    public void setDatetimeStart(Date datetimeStart) {
        this.datetimeStart = datetimeStart;
    }

    public Date getDatetimeEnd() {
        return datetimeEnd;
    }

    public void setDatetimeEnd(Date datetimeEnd) {
        this.datetimeEnd = datetimeEnd;
    }

    public Integer getJourInterest1() {
        return jourInterest1;
    }

    public void setJourInterest1(Integer jourInterest1) {
        this.jourInterest1 = jourInterest1;
    }

    public Integer getJourInterest2() {
        return jourInterest2;
    }

    public void setJourInterest2(Integer jourInterest2) {
        this.jourInterest2 = jourInterest2;
    }

    public Integer getInterest1() {
        return interest1;
    }

    public void setInterest1(Integer interest1) {
        this.interest1 = interest1;
    }

    public Integer getInterest2() {
        return interest2;
    }

    public void setInterest2(Integer interest2) {
        this.interest2 = interest2;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getExpend() {
        return expend;
    }

    public void setExpend(Integer expend) {
        this.expend = expend;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(Integer monthIncome) {
        this.monthIncome = monthIncome;
    }

    public Integer getMonthExpend() {
        return monthExpend;
    }

    public void setMonthExpend(Integer monthExpend) {
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
