package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增品牌logo
 *
 * @author : cyl
 * @since : 2019-06-26 10:38
 */
@Data
public class XN630480Req {

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

    
    