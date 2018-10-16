package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 运营商报告采集状态查询
 * @author: CYL 
 * @since: 2018年10月9日 下午5:05:01 
 * @history: 
 */
public class XN632935Req {

    @NotBlank
    private String tokendb;

    public String getTokendb() {
        return tokendb;
    }

    public void setTokendb(String tokendb) {
        this.tokendb = tokendb;
    }

}
