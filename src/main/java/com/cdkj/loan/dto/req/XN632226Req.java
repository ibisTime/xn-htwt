package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查入档清单
 *
 * @author : cyl
 * @since : 2019-05-11 14:40
 */
@Data
public class XN632226Req {

    // 入档清单编号
    @NotBlank
    private String code;
}

    
    