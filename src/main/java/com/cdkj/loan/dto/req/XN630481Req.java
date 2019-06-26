package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 删除品牌logo
 *
 * @author : cyl
 * @since : 2019-06-26 10:38
 */
@Data
public class XN630481Req {

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String code;
}

    
    