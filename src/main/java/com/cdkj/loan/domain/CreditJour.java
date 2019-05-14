package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 征信流水
 *
 * @author: tao
 * @since: 2019-04-20 14:55:13
 * @history:
 */
@Data
public class CreditJour extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 征信人员编号
    private String creditUserCode;

    // 流水类型（微信/支付宝/银行）
    private String type;

    // 流水时间起
    private Date datetimeStart;

    // 流水时间止
    private Date datetimeEnd;

    // 流水结息1
    private Integer jourInterest1;

    // 流水结息2
    private Integer jourInterest2;

    // 结息1
    private Integer interest1;

    // 结息2
    private Integer interest2;

    // 收入
    private Integer income;

    // 支出
    private Integer expend;

    // 帐户余额
    private Integer balance;

    // 月均收入
    private Integer monthIncome;

    // 月均支出
    private Integer monthExpend;

    // 流水图片
    private String pic;

    // 流水备注
    private String remark;

    // **************************88

    private CreditUser creditUser;

}
