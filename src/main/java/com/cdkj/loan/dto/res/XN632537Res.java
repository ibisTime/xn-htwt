package com.cdkj.loan.dto.res;

import lombok.Data;

/**
 * @author : cyl
 * @since : 2019-05-02 21:28
 */
@Data
public class XN632537Res {

    // 业务编号
    private String bizCode;

    // 征信人员编号
    private String creditUserCode;

    // 流水类型（微信/支付宝/银行）
    private String type;

    // 流水时间起
    private String datetimeStart;

    // 流水时间止
    private String datetimeEnd;

    // 结息时间1
    private String jourInterest1;

    // 结息时间2
    private String jourInterest2;

    // 结息1
    private String interest1;

    // 结息2
    private String interest2;

    // 收入
    private String income;

    // 支出
    private String expend;

    // 帐户余额
    private String balance;

    // 月均收入
    private String monthIncome;

    // 月均支出
    private String monthExpend;

    // 流水图片
    private String pic;

    // 流水备注
    private String remark;


}

    
    