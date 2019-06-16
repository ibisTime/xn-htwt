package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import lombok.Data;

/**
 * 垫资收款卡号
 *
 * @author: CYunlai
 * @since: 2019-06-14 17:24:14
 * @history:
 */
@Data
public class AdvanceCollectCard extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 收款卡编号
    private String collectBankcardCode;

    /************DB*************/

    // 账号
    private String bankcardNumber;
}