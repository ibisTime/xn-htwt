package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 征信新增
 *
 * @author: jiafr
 * @since: 2018年5月24日 下午8:57:22
 * @history:
 */
@Data
public class XN632110Req {

    @NotBlank
    private String loanBankCode;

    @NotBlank
    private String creditLoanAmount;

    // 业务种类（0新车1二手车）
    @NotBlank
    private String bizType;

    // 二手车报告
    private String secondCarReport;

    // 行驶证正面
    private String xszFront;

    // 行驶证反面
    private String xszReverse;

    @NotBlank
    private String operator;

    // 0保存 1发送
    @NotBlank
    private String buttonCode;

    // 征信说明
    private String note;

    // 征信人员列表
    @NotEmpty
    private List<XN632110ReqCreditUser> creditUserList;


}
