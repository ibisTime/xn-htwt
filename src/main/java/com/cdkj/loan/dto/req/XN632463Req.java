package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认制单
 * @author: silver 
 * @since: Apr 26, 2019 11:08:42 AM 
 * @history:
 */
public class XN632463Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operator;

    private String makeBillNote;

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

    public String getMakeBillNote() {
        return makeBillNote;
    }

    public void setMakeBillNote(String makeBillNote) {
        this.makeBillNote = makeBillNote;
    }

}
