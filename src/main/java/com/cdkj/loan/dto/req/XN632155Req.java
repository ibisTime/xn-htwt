package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;

/**
 * 分页查询资料补发
 *
 * @author: silver
 * @since: 2018年5月29日 下午11:02:18
 * @history:
 */
@Data
public class XN632155Req extends APageReq {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 389113977005434174L;

    // 业务编号
    private String bizCode;

    // 用户编号
    private String userId;

    // 状态
    private String status;

    // 角色编号
    private String roleCode;

    // 收件人
    private String receiver;

    // 类型
    private String type;

    // 类型List
    private List<String> typeList;

    // 状态List
    private List<String> statusList;

    // 业务编号模糊查
    private String bizCodeForQuery;

}
