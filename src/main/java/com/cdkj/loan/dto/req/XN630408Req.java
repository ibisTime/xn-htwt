package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN630408Req {

    @NotBlank
    private String updater;

    private String cdkjToken;

}
