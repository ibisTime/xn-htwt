package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午3:43:43 
 * @history:
 */
@Data
public class Bank extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7671886097276757226L;

    // 编号
    private String code;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 支行名称
    private String subbranch;

    // 12期
    private Double rate12;

    // 18期
    private Double rate18;

    // 24期
    private Double rate24;

    // 36期
    private Double rate36;

    // 状态(预留)
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*---------辅助字段-----------*/

    // 更新人名称
    private String updaterName;

    // 支行名称
    private String subbranchQuery;
}
