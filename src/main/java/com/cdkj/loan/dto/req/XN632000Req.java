package com.cdkj.loan.dto.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN632000Req {

    @NotBlank
    private String type;// 类型

    @NotBlank
    private String companyCode;// 公司编号

    // 垫资类型(1收款，2出款)
    private String advanceType;

    @NotBlank
    private String realName;// 户名

    @NotBlank
    private String bankCode;// 银行行别

    @NotBlank
    private String bankcardNumber;// 账号

    private String subbranch;// 支行名称

    @NotBlank
    @Min(0)
    @Max(1)
    private String pointRate;

    private String remark;// 备注

}
