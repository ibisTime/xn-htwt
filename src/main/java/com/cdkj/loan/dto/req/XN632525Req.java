package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 分页查待办事项
 *
 * @author: silver
 * @since: Apr 3, 2019 2:06:17 PM
 * @history:
 */
@Data
public class XN632525Req extends APageReq {

    private static final long serialVersionUID = -8695549512079289219L;

    // 业务编号
    private String bizCode;

    // 关联订单编号
    private String refOrder;

    // 关联节点
    private String refNode;

    // 客户姓名
    private String userName;

    // 状态(0 待处理 1 已完成)
    private String status;

    // 操作人
    @NotBlank
    private String userId;

}
