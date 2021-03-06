package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 征信详情查询
 * @author: jiafr 
 * @since: 2018年5月26日 下午2:35:44 
 * @history:
 */
public class XN632118Req {

    // 征信单编号
    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
