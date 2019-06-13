package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查查征信人辅助资料
 * @author: silver 
 * @since: Apr 20, 2019 4:00:10 PM 
 * @history:
 */
public class XN632486Req {

    // 编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
