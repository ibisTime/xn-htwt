package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 返点账号列表
 *
 * @author: CYunlai
 * @since: 2019-05-27 15:26:03
 * @history:
 */
@Data
public class RepointAccount extends ABaseDO {

    // 编号
    private String code;

    // 返点编号
    private String repointCode;

    // 返点账号编号
    private String repointCardCode;

    // 实返金额
    private Long actualAmount;

    // 水单
    private String waterBill;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*************DB**************/

    /**
     * 收款账号
     */
    private CollectBankcard collectBankcard;
}