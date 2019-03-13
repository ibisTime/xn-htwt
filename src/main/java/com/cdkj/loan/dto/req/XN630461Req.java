package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除用户行为
 * @author: taojian 
 * @since: 2019年3月13日 下午5:12:59 
 * @history:
 */
public class XN630461Req {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
