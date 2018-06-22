package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 手续费明细录入
 * @author: xieyj 
 * @since: 2018年5月30日 下午7:24:06 
 * @history:
 */
public class XN632160Req {

    // 交款类型
    @NotBlank
    private String remitType;

    // 交款项目
    @NotBlank
    private String remitProject;

    // 金额
    @NotBlank
    private String amount;

    // 平台账户
    @NotBlank
    private String platBankcard;

    // 汇款人
    @NotBlank
    private String remitUser;

    // 到账时间
    @NotBlank
    private String reachDatetime;

    // 备注
    private String remark;

    // 操作人
    @NotBlank
    private String operator;

    // 手续费编号
    @NotBlank
    private String feeCode;

    // 处理类型（0保存1发送）
    @NotBlank
    private String dealType;

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getRemitType() {
        return remitType;
    }

    public void setRemitType(String remitType) {
        this.remitType = remitType;
    }

    public String getRemitProject() {
        return remitProject;
    }

    public void setRemitProject(String remitProject) {
        this.remitProject = remitProject;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPlatBankcard() {
        return platBankcard;
    }

    public void setPlatBankcard(String platBankcard) {
        this.platBankcard = platBankcard;
    }

    public String getRemitUser() {
        return remitUser;
    }

    public void setRemitUser(String remitUser) {
        this.remitUser = remitUser;
    }

    public String getReachDatetime() {
        return reachDatetime;
    }

    public void setReachDatetime(String reachDatetime) {
        this.reachDatetime = reachDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

}
