package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 待办事项表
 *
 * @author: silver
 * @since: 2019-04-03 11:39:28
 * @history:
 */
@Data
public class BizTask extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 关联订单类型（EBizLogType）
    private String refType;

    // 关联订单编号
    private String refOrder;

    // 关联节点编号（ENode）
    private String refNode;

    // 任务内容
    private String content;

    // 创建时间
    private Date createDatetime;

    // 状态(0 待处理 1 已完成)
    private String status;

    // 操作人
    private String operater;

    // 操作角色
    private String operateRole;

    // 完成时间
    private Date finishDatetime;

    //*************db properties*************

    // 查询是否是我的,不空查询我的
    private String isMy;

    private String roleCode;

    private String userId;

    // 操作人名称
    private String operaterName;

    // 操作角色名称
    private String operateRoleName;

    // 客户姓名
    private String userName;

}
