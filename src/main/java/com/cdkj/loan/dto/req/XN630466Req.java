package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查用户行为
 * @author: taojian 
 * @since: 2019年3月13日 下午5:12:59 
 * @history:
 */
public class XN630466Req {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
