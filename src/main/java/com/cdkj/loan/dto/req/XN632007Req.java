package com.cdkj.loan.dto.req;

import lombok.Data;

@Data
public class XN632007Req {

    private String type;// 类型

    private String companyCode;// 公司编号

    private String keyword;// 关键字

    // 垫资类型(1收款，2出款)
    private String advanceType;


}
