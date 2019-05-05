package com.cdkj.loan.dto.req;

import lombok.Data;

/**
 * 我的分页查待办事项
 *
 * @author: silver
 * @since: Apr 3, 2019 2:06:17 PM
 * @history:
 */
@Data
public class XN632528Req extends APageReq {

    private static final long serialVersionUID = -8695549512079289220L;

    // 业务编号
    private String bizCode;

    // 关联订单类型
    private String refType;

    // 关联订单编号
    private String refOrder;

    // 状态(0 待处理 1 已完成)
    private String status;

    // 当前用户编号
    private String operator;
}
