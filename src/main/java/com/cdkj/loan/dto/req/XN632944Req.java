package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 状态获取
 * @author: CYL 
 * @since: 2018年10月9日 下午5:05:01 
 * @history: 
 */
public class XN632944Req {

    @NotBlank
    private String tokendb;

    @NotBlank
    private String bizType;

    public String getTokendb() {
        return tokendb;
    }

    public void setTokendb(String tokendb) {
        this.tokendb = tokendb;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

}
