package com.cdkj.loan.dto.req;

/**
 * 分页查征信流水
 * @author: silver 
 * @since: Apr 20, 2019 4:00:10 PM 
 * @history:
 */
public class XN632495Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 业务编号
    private String bizCode;

    // 征信人员编号
    private String creditUserCode;

    // 流水类型（微信/支付宝/银行）
    private String type;

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

}
