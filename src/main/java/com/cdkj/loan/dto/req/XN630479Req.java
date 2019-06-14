package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN630479Req {

    private String cdkjToken;

    @NotBlank
    private String modelId;// 车型标识

    @NotBlank
    private String regDate;// 待估车辆的上牌时间

    @NotBlank
    private String mile;// 待估车辆的公里数(单位万公里)

    @NotBlank
    private String zone;// 城市标识


}
