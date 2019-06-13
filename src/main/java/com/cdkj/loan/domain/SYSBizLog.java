package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

@Data
public class SYSBizLog extends ABaseDO {

    private static final long serialVersionUID = 2099380862896285572L;

    private Integer id;// 序号

    private String bizCode;// 业务编号

    private String refType;// 关联订单类型

    private String refOrder;// 关联订单编号

    private String dealNode;// 处理节点

    private String dealNote;// 处理说明

    private String operateRole;// 操作角色

    private String operator;// 操作人

    private String operatorName;// 操作人姓名(实际是登录名)

    private String operatorMobile;// 操作人手机号

    private Date startDatetime;// 操作开始时间

    private Date endDatetime;// 操作结束时间

    private String speedTime;// 花费时间

    /***********************db properties**********************/

    /*-------------辅助字段---------------*/

    private String operatorNameForQuery;// 操作人姓名模糊查

    private String operatorMobileForQuery;// 操作人手机号模糊查

    private String refOrderForQuery;// 关联订单编号模糊查询

    private String isLogistics;// 是否在物流传递中

    private String roleCode;// 角色编号

    private String userName;// 客户姓名

    private String loanBank;// 贷款银行编号

    private String bizType;// 业务种类(新车，二手车)

    private String departmentName;// 部门名称

    private String bizOrderType;// 业务单类型（ 征信单 准入单 还款业务 出差申请）

    private String logisticsStatus;// 物流单状态

    private String applyUserName;// 客户姓名

}
