package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 上传复核回单
 * @author: silver 
 * @since: Apr 26, 2019 11:08:42 AM 
 * @history:
 */
public class XN632464Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operator;

}
