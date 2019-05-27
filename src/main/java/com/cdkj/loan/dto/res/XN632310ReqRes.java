package com.cdkj.loan.dto.res;

import lombok.Data;

/**
 * 返点账号列表
 *
 * @author : cyl
 * @since : 2019-05-27 15:42
 */
@Data
public class XN632310ReqRes {

    // 返点账号编号
    private String repointCardCode;

    // 实返金额
    private String actualAmount;

    // 水单
    private String waterBill;

    private String remark;
}

    
    