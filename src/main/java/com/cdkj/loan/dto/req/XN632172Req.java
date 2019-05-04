package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改贷款产品
 * @author: silver 
 * @since: 2018年5月30日 下午12:52:02 
 * @history:
 */
@Data
public class XN632172Req {
    // 编号
    @NotBlank
    private String code;

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

    // 公证费利率
    @NotBlank
    private String authRate;

    // 是否前置
    @NotBlank
    private String isPre;

    // 前置利率
    @NotBlank
    private String preRate;

    //@NotBlank
    private String assureType;// 担保费类型(1单笔/2贷款额百分比)

    //    @NotBlank
    private String assureFee;// 单笔担保费

    //    @NotBlank
    private String assureRate;// 担保费贷款额百分比

    //    @NotBlank
    private String dzType;// 垫资费类型(1单笔/2贷款额百分比)

    //    @NotBlank
    private String dzFee;// 单笔垫资费

    //    @NotBlank
    private String dzRate;// 垫资费贷款额百分比

    //    @NotBlank
    private String lyAmountType;// 履约保证金类型(1单笔/2贷款额百分比)

    //    @NotBlank
    private String lyAmountFee;// 单笔履约保证金

    //    @NotBlank
    private String lyAmountRate;// 履约保证金贷款额百分比

    //    @NotBlank
    private String gpsType;// GPS类型(1单笔/2贷款额百分比)

    //    @NotBlank
    private String gpsFee;// 单笔GPS费

    //    @NotBlank
    private String gpsRate;// GPS垫资费贷款额百分比

    //    @NotBlank
    private String otherType;// 杂费类型(1单笔/2贷款额百分比)

    //    @NotBlank
    private String otherFee;// 单笔杂费

    //    @NotBlank
    private String otherRate;// 杂费贷款额百分比

    //    @NotBlank
    private String introduceType;// 介绍费类型(1单笔/2贷款额百分比)

    //    @NotBlank
    private String introduceFee;// 单笔介绍费

    //    @NotBlank
    private String introduceRate;// 介绍费贷款额百分比

    //    @NotBlank
    private String returnPointType;// 返点类型(1单笔/2贷款额百分比)

    //    @NotBlank
    private String returnPointFee;// 单笔返点

    //    @NotBlank
    private String returnPointRate;// 返点贷款额百分比

    //    @NotBlank
    private String insuAgencyYear1Type;// 1年保险代理费类型(1平台/2车行)

    private String insuAgencyYear1Fee;// 1年保险代理费

    //    @NotBlank
    private String insuAgencyYear2Type;// 2年保险代理费类型(1平台/2车行)

    private String insuAgencyYear2Fee;// 2年保险代理费

    //    @NotBlank
    private String insuAgencyYear3Type;// 3年保险代理费类型(1平台/2车行)

    private String insuAgencyYear3Fee;// 3年保险代理费

    // 更新人
    @NotBlank
    private String updater;
}
