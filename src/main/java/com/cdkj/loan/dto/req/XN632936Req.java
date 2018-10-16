package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 运营商报告验证码输入
 * @author: CYL 
 * @since: 2018年10月9日 下午5:05:01 
 * @history: 
 */
public class XN632936Req {

    @NotBlank
    private String tokendb;

    // 输入值
    @NotBlank
    private String input;

    public String getTokendb() {
        return tokendb;
    }

    public void setTokendb(String tokendb) {
        this.tokendb = tokendb;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
