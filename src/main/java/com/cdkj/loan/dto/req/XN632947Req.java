package com.cdkj.loan.dto.req;

/**
 * 立木征信详情查
 * @author: CYL 
 * @since: 2018年10月12日 下午4:44:21 
 * @history:
 */
public class XN632947Req extends APageReq {

    private static final long serialVersionUID = -8053721220104743595L;

    // 用户编号
    private String userId;

    // 用户账号
    private String userName;

    // 业务类型
    private String bizType;

    // 标记
    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
