package com.cdkj.loan.dto.req;

/**
 * 分页查用户行为
 * @author: taojian 
 * @since: 2019年3月13日 下午5:12:59 
 * @history:
 */
public class XN630465Req extends APageReq {

    private String type;

    private String toType;

    private String toCode;

    private String creater;

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

}
