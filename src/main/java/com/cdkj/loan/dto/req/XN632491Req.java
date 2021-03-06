package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除征信流水
 * @author: silver 
 * @since: Apr 20, 2019 4:00:10 PM 
 * @history:
 */
public class XN632491Req {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
