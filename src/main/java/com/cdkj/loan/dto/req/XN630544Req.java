package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630544Req {

    @NotBlank
    private String code;// 还款计划编号

    @NotBlank
    private String prepayPhoto;// 还款截图

    @NotBlank
    private String operator;// 操作人

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

    public String getPrepayPhoto() {
        return prepayPhoto;
    }

    public void setPrepayPhoto(String prepayPhoto) {
        this.prepayPhoto = prepayPhoto;
    }

}
