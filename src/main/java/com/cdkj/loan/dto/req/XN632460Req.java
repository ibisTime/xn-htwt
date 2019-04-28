package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认用款单
 * @author: silver 
 * @since: Apr 26, 2019 11:08:42 AM 
 * @history:
 */
public class XN632460Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
