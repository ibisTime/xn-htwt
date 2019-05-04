package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 贷款产品
 *
 * @author: silver
 * @since: 2018年5月30日 上午11:29:54
 * @history:
 */
@Data
public class LoanProduct extends ABaseDO {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -3072309115192038821L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 名称
    private String name;

    // 贷款银行(编号)
    private String loanBank;

    // 贷款期限
    private String loanPeriod;

    // 万元系数
    private Long wanFactor;

    // 年利率
    private Double yearRate;

    // 公证费利率
    private Double authRate;

    // 是否前置
    private String isPre;

    // 前置利率
    private Double preRate;

    private String assureType;// 担保费类型(1单笔/2贷款额百分比)

    private Long assureFee;// 单笔担保费

    private Double assureRate;// 担保费贷款额百分比

    private String dzType;// 垫资费类型(1单笔/2贷款额百分比)

    private Long dzFee;// 单笔垫资费

    private Double dzRate;// 垫资费贷款额百分比

    private String lyAmountType;// 履约保证金类型(1单笔/2贷款额百分比)

    private Long lyAmountFee;// 单笔履约保证金

    private Double lyAmountRate;// 履约保证金贷款额百分比

    private String gpsType;// GPS类型(1单笔/2贷款额百分比)

    private Long gpsFee;// 单笔GPS费

    private Double gpsRate;// GPS垫资费贷款额百分比

    private String otherType;// 杂费类型(1单笔/2贷款额百分比)

    private Long otherFee;// 单笔杂费

    private Double otherRate;// 杂费贷款额百分比

    private String introduceType;// 介绍费类型(1单笔/2贷款额百分比)

    private Long introduceFee;// 单笔介绍费

    private Double introduceRate;// 介绍费贷款额百分比

    private String returnPointType;// 返点类型(1单笔/2贷款额百分比)

    private Long returnPointFee;// 单笔返点

    private Double returnPointRate;// 返点贷款额百分比

    private String insuAgencyYear1Type;// 1年保险代理费类型(1平台/2车行)

    private Long insuAgencyYear1Fee;// 1年保险代理费

    private String insuAgencyYear2Type;// 2年保险代理费类型(1平台/2车行)

    private Long insuAgencyYear2Fee;// 2年保险代理费

    private String insuAgencyYear3Type;// 3年保险代理费类型(1平台/2车行)

    private Long insuAgencyYear3Fee;// 3年保险代理费

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ************db properties************

    // 贷款银行名称
    private String loanBankName;
}
