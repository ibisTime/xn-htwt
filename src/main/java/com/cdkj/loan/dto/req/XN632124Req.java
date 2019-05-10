package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 内勤确认
 *
 * @author: CYL
 * @since: 2018年11月8日 下午4:05:51
 * @history:
 */
@Data
public class XN632124Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String approveNote;// 审核说明

    // 代理人
    @NotBlank
    private String pledgeUser;

    // 代理人身份证号
    @NotBlank
    private String pledgeUserIdCard;

    // 代理人身份证正
    @NotBlank
    private String pledgeUserIdCardFront;

    // 代理人身份证反
    @NotBlank
    private String pledgeUserIdCardReverse;

    @NotBlank
    private String operator;// 操作人

}
