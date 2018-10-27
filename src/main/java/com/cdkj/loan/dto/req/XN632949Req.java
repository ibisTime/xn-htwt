package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 立木征信分页查
 * @author: CYL 
 * @since: 2018年10月12日 下午4:44:21 
 * @history:
 */
public class XN632949Req {

    // 身份证号
    @NotBlank
    private String userId;

    // 业务类型
    @NotBlank
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
