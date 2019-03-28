/**
 * @Title Calculate.java 
 * @Package com.cdkj.loan.domain 
 * @Description 
 * @author taojian  
 * @date 2019年3月13日 下午3:21:42 
 * @version V1.0   
 */
package com.cdkj.loan.domain;

import com.cdkj.loan.common.AmountUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.enums.EBoolean;

/** 
 * 车贷计算器
 * @author: taojian 
 * @since: 2019年3月13日 下午3:21:42 
 * @history:
 */
public class Calculate {
    // 原价
    private Long saleAmount;

    // 首付价
    private Long sfAmount;

    // 预计首付价
    private Long yjsfAmount;

    // 贷款金额
    private Long dkAmount;

    // 总贷款金额
    private Long dkTotalAmount;

    // 手续费
    private Long procedureAmount;

    // 月供
    private Long monthReply;

    // 额外费用
    private Long extraAmount;

    // 总花费
    private Long totalAmount;

    // 必要花费
    private Long byhf;

    // 商业保险
    private Long sybx;

    public Calculate(Double rate, Car car, String period, String isTotal) {
        this.saleAmount = car.getSalePrice();
        this.sybx = StringValidater.toLong(car.getJsqSybx());
        this.byhf = StringValidater.toLong(car.getJsqByhf());
        if (EBoolean.YES.getCode().equals(isTotal)) {
            this.totalAmount = this.saleAmount + this.sybx + this.byhf;
        } else {
            this.byhf += car.getFwAmount();
            this.sfAmount = car.getSfAmount();
            this.yjsfAmount = this.byhf + this.sybx + this.sfAmount;
            this.dkAmount = car.getSalePrice() - car.getSfAmount();
            this.dkTotalAmount = this.dkAmount;
            this.procedureAmount = AmountUtil.mul(this.dkTotalAmount, rate);
            this.monthReply = AmountUtil.divLL(this.dkTotalAmount
                    + this.procedureAmount, Long.valueOf(period));
            this.extraAmount = this.dkTotalAmount + this.procedureAmount
                    + this.sfAmount - this.saleAmount;
            this.totalAmount = AmountUtil.mul(this.monthReply,
                Double.valueOf(period))
                    + this.yjsfAmount;
        }

    }

    public Long getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(Long sfAmount) {
        this.sfAmount = sfAmount;
    }

    public Long getDkAmount() {
        return dkAmount;
    }

    public void setDkAmount(Long dkAmount) {
        this.dkAmount = dkAmount;
    }

    public Long getDkTotalAmount() {
        return dkTotalAmount;
    }

    public void setDkTotalAmount(Long dkTotalAmount) {
        this.dkTotalAmount = dkTotalAmount;
    }

    public Long getProcedureAmount() {
        return procedureAmount;
    }

    public void setProcedureAmount(Long procedureAmount) {
        this.procedureAmount = procedureAmount;
    }

    public Long getMonthReply() {
        return monthReply;
    }

    public void setMonthReply(Long monthReply) {
        this.monthReply = monthReply;
    }

    public Long getExtraAmount() {
        return extraAmount;
    }

    public void setExtraAmount(Long extraAmount) {
        this.extraAmount = extraAmount;
    }

    public Long getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Long saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Long getYjsfAmount() {
        return yjsfAmount;
    }

    public void setYjsfAmount(Long yjsfAmount) {
        this.yjsfAmount = yjsfAmount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getByhf() {
        return byhf;
    }

    public void setByhf(Long byhf) {
        this.byhf = byhf;
    }

    public Long getSybx() {
        return sybx;
    }

    public void setSybx(Long sybx) {
        this.sybx = sybx;
    }

    public static void main(String[] args) {
        System.out.println(AmountUtil.divLL(Long.valueOf(9), Long.valueOf(5)));
    }
}
