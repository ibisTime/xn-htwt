package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 区域总经理审核
 *
 * @author: silver
 * @since: Apr 26, 2019 11:08:42 AM
 * @history:
 */
@Data
public class XN632461Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operator;

    /**
     * 审核结果
     */
    @NotBlank
    private String approveResult;

    private String approveNote;

}
