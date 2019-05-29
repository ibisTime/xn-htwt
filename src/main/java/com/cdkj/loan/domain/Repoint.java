package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 返点表
 *
 * @author: jiafr
 * @since: 2018-06-08 21:35:51
 * @history:
 */
@Data
public class Repoint extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 团队编号
    private String teamCode;

    // 团队长
    private String captain;

    // 业务编号
    private String bizCode;

    // 应返金额
    private Long shouldAmount;

    // 实返金额
    private Long actualAmount;

    // 收款账号
    private String accountNo;

    // 收款银行
    private String bank;

    // 收款支行
    private String subbranch;

    // 水单
    private String waterBill;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*----------辅助字段-----------*/

    private SYSUser user;// 用户

    private List<RepointAccount> repointAccountList;
}
