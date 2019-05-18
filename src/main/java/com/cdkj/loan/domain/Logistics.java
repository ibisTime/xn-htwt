package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 资料传递
 *
 * @author: silver
 * @since: 2018年5月29日 下午9:30:46
 * @history:
 */
@Data
public class Logistics extends ABaseDO {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = -6503834762017918669L;

    // 编号
    private String code;

    // 类型(1 预算单 2 gps)
    private String type;

    // 节点类型(1车辆抵押，2银行放款)
    private String curNodeType;

    // 业务编号
    private String bizCode;

    // 用户编号
    private String userId;

    // 团队编号
    private String teamCode;

    // 业务节点1
    private String fromNodeCode;

    // 业务节点2
    private String toNodeCode;

    // 寄送方式(1 线下 2 快递)
    private String sendType;

    // 快递公司
    private String logisticsCompany;

    // 快递单号
    private String logisticsCode;

    // 发货时间
    private Date sendDatetime;

    // 发货说明
    private String sendNote;

    // 收件时间
    private Date receiptDatetime;

    // 发件人
    private String sender;

    // 收件人
    private String receiver;

    // 材料清单
    private String filelist;

    // 状态(0 待发件 1已发件待收件 2已收件审核 3已收件待补件)
    private String status;

    // 备注
    private String remark;

    // ***********db properties***********

    // 用户姓名
    private String userName;

    // 客户姓名
    private String customerName;

    // 状态List
    private List<String> statusList;

    // 类型List
    private List<String> typeList;

    // 发件人
    private String senderName;

    // 收件人
    private String receiverName;

    private GpsApply gpsApply;

    // 业务团队
    private String teamName;

    // 角色
    private String userRole;

    // 内勤名称
    private String insideJobName;

    // 信贷专员姓名
    private String saleUserName;

    // 业务编号模糊查
    private String bizCodeForQuery;
}
