package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认完成
 *
 * @author: silver
 * @since: Apr 28, 2019 1:39:09 PM
 * @history:
 */
@Data
public class XN632503Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

}
