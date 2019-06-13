package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN630418Req {

    // 品牌标识
    private String brandId;

    // 更新人
    @NotBlank
    private String updater;

    private String cdkjToken;

}
