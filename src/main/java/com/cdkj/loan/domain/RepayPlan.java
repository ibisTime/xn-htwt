package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 还款计划
 *
 * @author: haiqingzheng
 * @since: 2018年05月01日 18:52:51
 * @history:
 */
@Data
public class RepayPlan extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 关联类型
    private String refType;

    // 关联业务编号
    private String repayBizCode;

    // 借款人编号
    private String userId;

    // 总期数
    private int periods;

    // 当前期数
    private int curPeriods;

    // 还款时间
    private Date repayDatetime;

    // 本期本金
    private Long repayCapital;

    // 本期利息
    private Long repayInterest;

    // 本期还款金额
    private Long repayAmount;

    // 实际代偿金额
    private Long payedAmount;

    // 剩余欠款
    private Long overplusAmount;

    // 逾期金额
    private Long overdueAmount;

    // 节点
    private String curNodeCode;

    private String prepayPhoto;// 还款截图

    // 逾期处理人
    private String overdueHandler;

    // 逾期处理时间
    private Date overdueHandleDatetime;

    // 逾期处理说明
    private String overdueHandleNote;

    // 清收费用总额
    private Long totalFee;

    // 已缴纳清收费用总额
    private Long payedFee;

    // 再次逾期保证金
    private Long overdueDeposit;

    // 再次逾期保证金收取方式
    private String depositWay;

    // 实际可退的再次逾期保证金(作废)
    private Long shouldDeposit;

    // 已催款次数
    private int remindCount;

    // 已还金额(实还金额)
    private Long realRepayAmount;

    // 代偿是否缴纳
    private String isRepay;

    // 拖车申请金额
    private Long tsCarAmount;

    // 拖车收款账号
    private String tsBankcardNumber;

    // 拖车开户行
    private String tsBankName;

    // 拖车开户支行
    private String tsSubbranch;

    // 拖车申请说明
    private String tcApplyNote;

    // 打款金额
    private Long remitAmount;

    // 打款水单
    private String remitBillPdf;

    // 收车地点
    private String takeCarAddress;

    // 拖车时间
    private Date takeDatetime;

    // 拖车人员
    private String takeName;

    // 拖车停放位置
    private String takeLocation;

    // 拖车说明
    private String takeNote;

    // 流水
    private String jourPdf;

    // 房产
    private String housePdf;

    // 担保人姓名
    private String guaName;

    // 担保人身份证号
    private String guaIdNo;

    // 担保人手机号
    private String guaMobile;

    // 担保人现居住地址
    private String guaNowAddress;

    // 担保赎回说明
    private String guaNote;

    // 建议(1=6个月保证金/2=已结清)
    private String suggest;

    // 建议说明
    private String suggestNote;

    // 团队买断扣除金额
    private Long buyOutAmount;

    // ************************db properties************************
    // 还款计划开始时间
    private Date repayStartDatetime;

    // 还款计划结束时间
    private Date repayEndDatetime;

    // 用户信息
    private User user;

    // 还款业务
    private RepayBiz repayBiz;

    // 费用清单
    private List<Cost> costList;

    // 催收记录
    private List<RemindLog> remindLogList;

    // 状态list
    private List<String> curNodeCodeList;

    // 未结清贷款金额
    private Long unsettledLoan;

    // 还款卡号
    private String bankcardNumber;

    // 角色编号
    private String roleCode;

}
