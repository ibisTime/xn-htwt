package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 操作日志
* @author: silver 
* @since: 2019-04-02 18:55:52
* @history:
*/
public class BizLog extends ABaseDO {
    private static final long serialVersionUID = -3218068680410265367L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 关联订单类型
    private String refType;

    // 关联订单编号
    private String refOrder;

    // 处理节点
    private String dealNode;

    // 处理说明
    private String dealNote;

    // 操作角色
    private String operateRole;

    // 操作人
    private String operator;

    // 操作人姓名
    private String operatorName;

    // 操作人手机号
    private String operatorMobile;

    // 操作开始时间
    private Date startDatetime;

    // 操作结束时间
    private Date endDatetime;

    // 花费时间(单位：秒)
    private String speedTime;

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

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefOrder(String refOrder) {
        this.refOrder = refOrder;
    }

    public String getRefOrder() {
        return refOrder;
    }

    public void setDealNode(String dealNode) {
        this.dealNode = dealNode;
    }

    public String getDealNode() {
        return dealNode;
    }

    public void setDealNote(String dealNote) {
        this.dealNote = dealNote;
    }

    public String getDealNote() {
        return dealNote;
    }

    public void setOperateRole(String operateRole) {
        this.operateRole = operateRole;
    }

    public String getOperateRole() {
        return operateRole;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorMobile(String operatorMobile) {
        this.operatorMobile = operatorMobile;
    }

    public String getOperatorMobile() {
        return operatorMobile;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Date endDatetime) {
        this.endDatetime = endDatetime;
    }

    public void setSpeedTime(String speedTime) {
        this.speedTime = speedTime;
    }

    public String getSpeedTime() {
        return speedTime;
    }

}
