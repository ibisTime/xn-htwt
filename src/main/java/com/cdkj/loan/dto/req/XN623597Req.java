package com.cdkj.loan.dto.req;

/**
 * 列表查资源
 * @author: silver 
 * @since: Apr 2, 2019 5:39:08 PM 
 * @history:
 */
public class XN623597Req extends AListReq {

    private static final long serialVersionUID = 7449070659363764165L;

    // 业务编号
    private String bizCode;

    private String creater;

    private String getUser;

    private String status;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getGetUser() {
        return getUser;
    }

    public void setGetUser(String getUser) {
        this.getUser = getUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
