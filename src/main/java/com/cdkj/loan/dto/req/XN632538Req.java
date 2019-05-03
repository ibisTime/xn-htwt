package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author : haiqingzheng
 * @since : 2019-05-03 19:58
 */
public class XN632538Req {

    /**
     * 业务编号
     */
    @NotBlank
    private String code;

    /**
     * 操作人
     */
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
