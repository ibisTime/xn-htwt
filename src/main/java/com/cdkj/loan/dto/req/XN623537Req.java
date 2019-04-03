package com.cdkj.loan.dto.req;

/**
 * 列表查操作日志
 * @author: silver 
 * @since: Apr 2, 2019 5:39:08 PM 
 * @history:
 */
public class XN623537Req extends AListReq {

    // 业务编号
    private String bizCode;

    // 关联订单类型
    private String refType;

    // 关联订单编号
    private String refOrder;

    // 处理节点
    private String dealNode;

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

    public String getDealNode() {
        return dealNode;
    }

    public void setDealNode(String dealNode) {
        this.dealNode = dealNode;
    }

}
