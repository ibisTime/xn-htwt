package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改征信
 *
 * @author: jiafr
 * @since: 2018年5月29日 下午7:36:06
 * @history:
 */
@Data
public class XN632112Req {

    // 征信单编号
    @NotBlank
    private String bizCode;

    // 贷款银行
    private String loanBankCode;

    // 贷款金额
    private String creditLoanAmount;

    // 业务种类
    @NotBlank
    private String bizType;

    // 二手车评估报告
    private String secondCarReport;

    private String xszFront;

    private String xszReverse;

    private List<XN632110ReqCreditUser> creditUserList;

    // 操作按钮
    @NotBlank
    private String buttonCode;

    // 操作人
    @NotBlank
    private String operator;

}
