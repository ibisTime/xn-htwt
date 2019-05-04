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

    // GPS费用
    private Long gpsFee;

    // 公证费利率
    private Double authRate;

    // 返点利率
    private Double backRate;

    // 是否前置
    private String isPre;

    // 前置利率
    private Double preRate;

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
