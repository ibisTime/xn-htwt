package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import lombok.Data;

@Data
public class CollectBankcard extends ABaseDO {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    private String code;// 编号

    private String type;// 类型

    private String belongBank;// 三种银行

    private String companyCode;// 公司编号

    private String realName;// 户名

    private String bankCode;// 银行行别

    private String bankName;// 银行名称

    private String subbranch;// 支行名称

    private String bankcardNumber;// 账号

    private Double pointRate;// 返点比例

    private String remark;// 备注

    /*---------辅助字段----------*/

    private String keyword;// 关键字

    private String companyName;// 公司名称


}
