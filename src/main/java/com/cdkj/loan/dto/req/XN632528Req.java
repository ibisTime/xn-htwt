package com.cdkj.loan.dto.req;

/**
 * 我的分页查待办事项
 * @author: silver
 * @since: Apr 3, 2019 2:06:17 PM
 * @history:
 */
public class XN632528Req extends APageReq {

    private static final long serialVersionUID = -8695549512079289220L;

    // 业务编号
    private String bizCode;

    // 关联订单类型
    private String refType;

    // 关联订单编号
    private String refOrder;

    // 状态(0 待处理 1 已完成)
    private String status;

    // 当前用户编号
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

    public String getRefOrder() {
        return refOrder;
    }

    public void setRefOrder(String refOrder) {
        this.refOrder = refOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
