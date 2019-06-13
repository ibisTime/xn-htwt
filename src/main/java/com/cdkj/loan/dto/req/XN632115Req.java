package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;

/**
 * 征信分页查询 （按角色权限）
 *
 * @author: jiafr
 * @since: 2018年5月26日 上午10:18:51
 * @history:
 */
@Data
public class XN632115Req extends APageReq {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 1L;

    // 用户id
    private String userId;

    // 征信单编号
    private String code;

    private String bizCode;

    // 客户姓名
    private String userName;

    // 业务员编号
    private String saleUserId;

    // 预算单编号
    private String budgetOrderCode;

    // 申请日期开始
    private String applyDatetimeStart;

    // 申请日期结束
    private String applyDatetimeEnd;

    // 节点编号
    private String curNodeCode;

    // 角色编号
    private String roleCode;

    // 征信是否通过 0未通过1已通过
    private String isPass;

    // 关键字
    private String keyword;

    private List<String> curNodeCodeList;

    private List<String> enterNodeCodeList;
    // 是否作废
    private String isCancel;
}
