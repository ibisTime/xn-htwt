package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 还款业务
 *
 * @author: haiqingzheng
 * @since: 2018年05月01日 17:58:51
 * @history:
 */
@Data
public class RepayBiz extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 贷款产品编号
    private String loanProductCode;

    // 贷款产品名称
    private String loanProductName;

    // 申请人编号
    private String userId;

    // 申请人姓名
    private String realName;

    // 申请人证件类型
    private String idKind;

    // 申请人证件号
    private String idNo;

    // 还款卡编号(现存卡号)
    private String bankcardCode;

    // 关联类型
    private String refType;

    // 关联编号(准入单编号)
    private String refCode;

    // 业务总价
    private Long bizPrice;

    // 首付比例
    private Double sfRate;

    // 首付金额
    private Long sfAmount;

    // 贷款银行
    private String loanBank;

    // 贷款金额
    private Long loanAmount;

    // 总期数
    private Integer periods;

    // 剩余期数
    private Integer restPeriods;

    // 银行利率
    private Double bankRate;

    // 银行基准利率
    private Double bankBenchmarkRate;

    // 我司贷款成数
    private Double companyLoanCs;

    // 综合利率
    private Double globalRate;

    // 贷款时间起点
    private Date loanStartDatetime;

    // 贷款时间终点
    private Date loanEndDatetime;

    // 放款时间
    private Date bankFkDatetime;

    // 风险保证金
    private Long fxDeposit;

    // 首期还款日期
    private Date firstRepayDatetime;

    // 首期月供金额
    private Long firstRepayAmount;

    // 每期还款日期(银行还款日)
    private Integer monthDatetime;

    // 每期月供金额
    private Long monthAmount;

    // 履约保证金（可退）
    private Long lyDeposit;

    // 扣除的履约保证金(退款金额)
    private Long cutLyDeposit;

    // 节点
    private String curNodeCode;

    // 担保风险金
    private String fxAmount;

    // 剩余欠款(剩余本金本息，利息已包含在本金中)
    private Long restAmount;

    // 未还清收总成本
    private Long restTotalCost;

    // 再次逾期保证金总额
    private Long overdueTotalDeposit;

    // 再次逾期保证金总收入
    private Long overdueTotalDepositIncome;

    // 额外保证金收入(作废)
    private Long totalInDeposit;

    // 逾期总金额
    private Long overdueAmount;

    // 累计逾期期数(记住历史逾期的次数)
    private Integer totalOverdueCount;

    // 实际逾期期数(现在在逾期的次数)
    private Integer curOverdueCount;

    // 黑名单处理结果备案(商品分期)
    private String blackHandleNote;

    // 纸质申请照片
    private String paperPhoto;

    // 是否提前结清(0=正常结清 1=提前结清)
    private String isAdvanceSettled;

    // 结清证明
    private String settleAttach;

    // 结清时间
    private Date settleDatetime;

    // 解除抵押时间
    private Date releaseDatetime;

    // 最近修改人
    private String updater;

    // 最近修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 团队编号
    private String teamCode;

    // ****** 辅助字段 ******

    // 业务团队
    private BizTeam bizTeam;

    // 领队信息
    private SYSUser leadUser;

    // 预算单编号
    private String budgetOrderCode;

    // 用户信息
    private User user;

    // 统计未代偿总金额
    private String unRepayTotalAmount;

    // 角色编号
    private String roleCode;

    // 车贷订单
    private BudgetOrder budgetOrder;

    // 还款计划列表
    List<RepayPlan> repayPlanList;

    // 商品订单
    private Order mallOrder;

    // 实际退款金额
    private Long actualRefunds;

    // 借款余额
    private Long loanBalance;

    // 银行名称
    private String loanBankName;

    // 银行放款日期
    private Date bankFkDatetimeStart;

    // 银行放款日期
    private Date bankFkDatetimeEnd;

    private String keyword;// 关键字

    private RepayPlan overdueRepayPlan;

    private List<String> curNodeCodeList;// 节点

    private String realNameQuery;// 姓名模糊查

    private Long retreatDeposit;// 可退押金金额

    // 业务员编号
    private String saleUserId;

    // 内勤编号
    private String insideJob;

    //支行
    private String subbranchBankName;



}
