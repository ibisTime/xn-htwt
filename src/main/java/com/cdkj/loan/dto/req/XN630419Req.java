package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN630419Req {

    // 车系标识
    private String seriesId;

    @NotBlank
    private String updater;

    private String cdkjToken;
}
