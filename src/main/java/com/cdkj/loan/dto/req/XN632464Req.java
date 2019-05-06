package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 上传复核回单
 *
 * @author: silver
 * @since: Apr 26, 2019 11:08:42 AM
 * @history:
 */
@Data
public class XN632464Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operator;

    // 垫资日期
    private String advanceFundDatetime;

    // 垫资金额
    private String advanceFundAmount;

    // 水单
    private String billPdf;

}
