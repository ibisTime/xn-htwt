package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;

/**
* 待办事项表
* @author: silver 
* @since: 2019-04-03 11:39:28
* @history:
*/
public class BizTask extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 关联订单类型（EBizLogType）
    private String refType;

    // 关联订单编号
    private String refOrder;

    // 关联节点编号（ENode）
    private String refNode;

    // 任务内容
    private String content;

    // 创建时间
    private Date createDatetime;

    // 状态(0 待处理 1 已完成)
    private String status;

    // 操作人
    private String operater;

    // 操作角色
    private String operateRole;

    // 完成时间
    private Date finishDatetime;

    //*************db properties*************

    // 查询是否是我的,不空查询我的
    private String isMy;

    private String roleCode;

    private String userId;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsMy() {
        return isMy;
    }

    public void setIsMy(String isMy) {
        this.isMy = isMy;
    }

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

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public String getOperateRole() {
        return operateRole;
    }

    public void setOperateRole(String operateRole) {
        this.operateRole = operateRole;
    }

    public Date getFinishDatetime() {
        return finishDatetime;
    }

    public void setFinishDatetime(Date finishDatetime) {
        this.finishDatetime = finishDatetime;
    }

    public String getRefNode() {
        return refNode;
    }

    public void setRefNode(String refNode) {
        this.refNode = refNode;
    }

}
