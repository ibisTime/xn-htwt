package com.cdkj.loan.dto.req;

import lombok.Data;

@Data
public class XN632205Req extends APageReq {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 163932874954488442L;

    // 编号
    private String code;

    // 业务编号
    private String repayBizCode;

    // 客户姓名
    private String applyUserName;

    // 信贷专员
    private String saleUserId;

    // 申请时间起
    private String applyDatetimeStart;

    // 申请时间止
    private String applyDatetimeEnd;

    // 是否垫资
    private String isAdvanceFund;

    private String userId;


}
