package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认用款单
 *
 * @author: silver
 * @since: Apr 26, 2019 11:08:42 AM
 * @history:
 */
@Data
public class XN632460Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operator;

    /**
     * 是否垫资
     */
    @NotBlank
    private String isAdvanceFund;

}
