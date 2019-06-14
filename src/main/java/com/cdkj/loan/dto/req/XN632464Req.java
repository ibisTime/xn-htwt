package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

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
    @NotBlank
    private String advanceFundDatetime;

    // 垫资金额
    @NotBlank
    private String advanceFundAmount;

    // 水单
    @NotBlank
    private String billPdf;

    /**
     * 出款账号
     */
    @NotBlank(message = "出款账号不能为空")
    private String advanceCardCode;

    /**
     * 收款账号
     */
    @NotEmpty(message = "收款账号不能为空")
    private List<String> collectCardCodeList;


}
