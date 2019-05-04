package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 新增贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:52:02 
 * @history:
 */
@Data
public class XN632170Req {
    // 类型
    @NotBlank
    private String type;

    // 名称
    @NotBlank
    private String name;

    // 贷款银行(编号)
    @NotBlank
    private String loanBank;

    @NotBlank
    private String loanPeriod;

    // 万元系数
    @NotBlank
    private String wanFactor;

    // 年利率
    @NotBlank
    private String yearRate;

    // GPS费用
    @NotBlank
    private String gpsFee;

    // 公证费利率
    @NotBlank
    private String authRate;

    // 返点利率
    @NotBlank
    private String backRate;

    // 是否前置
    @NotBlank
    private String isPre;

    // 前置利率
    @NotBlank
    private String preRate;

    // 更新人
    @NotBlank
    private String updater;
}
