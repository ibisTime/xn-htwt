package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 业务
* @author: jiafr 
* @since: 2019-03-27 11:05:21
* @history:
*/
public class BizOrder extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 主贷人
    private String mainLoaner;

    // 经办银行
    private String bankCode;

    // 业务类型
    private String bizType;

    // 当前节点
    private String curNode;

    // 备注
    private String remark;

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

    public void setMainLoaner(String mainLoaner) {
        this.mainLoaner = mainLoaner;
    }

    public String getMainLoaner() {
        return mainLoaner;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setCurNode(String curNode) {
        this.curNode = curNode;
    }

    public String getCurNode() {
        return curNode;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
