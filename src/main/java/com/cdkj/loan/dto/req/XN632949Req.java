package com.cdkj.loan.dto.req;

/**
 * 立木征信分页查
 * @author: CYL 
 * @since: 2018年10月12日 下午4:44:21 
 * @history:
 */
public class XN632949Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 用户编号
    private String userId;

    // 业务类型
    private String bizType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

}
