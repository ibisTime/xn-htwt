package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class XN632300ReqOverdue {

    @NotBlank
    private String realName;//

    @NotBlank
    private String idNo;// 证件号

    @NotBlank
    private String loanAmount;// 贷款金额

    @NotBlank
    private String fkDatetime;// 放款日期

    @NotBlank
    private String periods;// 总期数

    @NotBlank
    private String overdueAmount;// 逾期金额

    private String remainAmount;// 剩余金额

    // 创建时间
    private String createDatetime;


}
