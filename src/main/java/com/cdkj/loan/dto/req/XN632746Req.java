package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详细查询库存类别
 * @author: silver 
 * @since: 2018年6月4日 下午8:57:23 
 * @history:
 */
public class XN632746Req {
    // 序号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
