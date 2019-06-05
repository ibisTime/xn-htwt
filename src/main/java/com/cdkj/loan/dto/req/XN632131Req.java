package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-录入抵押信息
 *
 * @author: xieyj
 * @since: 2018年5月29日 下午10:31:16
 * @history:
 */
@Data
public class XN632131Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 绿大本扫描件
    private String greenBigSmj;

    // 合格证
    private String carHgzPic;

    // 发票
    private String carInvoice;

    // 交强险
    private String carJqx;

    // 商业险
    private String carSyx;

    // 保单日期
    private String policyDatetime;

    // 保单到期日
    private String policyDueDate;

    // 其他资料
    private String carSettleOtherPdf;
}
