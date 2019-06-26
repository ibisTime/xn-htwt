package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改品牌logo
 *
 * @author : cyl
 * @since : 2019-06-26 10:38
 */
@Data
public class XN630482Req {

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    private String code;

    /**
     * 品牌名称
     */
    @NotBlank
    private String brandName;

    /**
     * 品牌logo
     */
    @NotBlank
    private String brandLogo;
}

    
    