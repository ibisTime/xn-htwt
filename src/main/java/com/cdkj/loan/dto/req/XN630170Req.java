package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 列表查询业务单
 * @author: jiafr 
 * @since: 2018年7月10日 下午3:56:24 
 * @history:
 */
public class XN630170Req extends APageReq {

    private static final long serialVersionUID = 5780013307270124748L;

    @NotBlank
    private String type;// 流程类型 RB C...

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
