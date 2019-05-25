package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import com.cdkj.loan.dto.res.CarInfoRes;
import com.cdkj.loan.dto.res.LoanInfoRes;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 车贷业务
 *
 * @author: tao
 * @since: 2019-04-02 16:54:29
 * @history:
 */
@Data
public class Cdbiz extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 业务类型（0新车1二手车）
    private String type;

    // 预算单类型 (1正常单2外单)
    private String bizType;

    // 还款业务编号
    private String repayBizCode;

    // 业务公司编号
    private String companyCode;

    // 团队编号
    private String teamCode;

    // 团队队长
    private String captainCode;

    // 业务员编号
    private String saleUserId;

    // 内勤编号
    private String insideJob;

    // 贷款银行
    private String loanBank;

    // 贷款信息
    private BankLoan bankLoan;

    // 征信贷款额
    private Long creditLoanAmount;

    // 贷款额
    private Long loanAmount;

    // 入档位置
    private String enterLocation;

    // 入档时间
    private Date enterDatetime;

    // 档案目录
    private String enterFilelist;

    // 还款卡号
    private String repayCardNumber;

    // 卡邮寄地址省
    private String cardPostProvince;

    // 卡邮寄地址市
    private String cardPostCity;

    // 卡邮寄地址区
    private String cardPostArea;

    // 卡邮寄地址
    private String cardPostAddress;

    // 卡邮寄地址邮编
    private String cardPostCode;

    // 主线状态
    private String status;

    // 制卡状态
    private String makeCardStatus;

    // 面签状态
    private String intevStatus;

    // 发保合GPS状态
    private String fbhgpsStatus;

    // 存档状态
    private String enterStatus;

    // 作废状态
    private String cancelStatus;

    // 当前节点编号
    private String curNodeCode;

    // 面签节点编号
    private String intevCurNodeCode;

    // 制卡节点
    private String makeCardNode;

    // 发保合gps节点
    private String fbhgpsNode;

    // 入档节点
    private String enterNodeCode;

    // 客户申请作废时的节点编号
    private String cancelNodeCode;

    // 是否需要安装GPS
    private String isGpsAz;

    // 是否融资
    private String isFinacing;

    // 是否垫资
    private String isAdvanceFund;

    // 是否我司续保
    private String isPlatInsure;

    // 应收手续费总额
    private Long shouldFeeAmount;

    // 实收手续费总额
    private Long realFeeAmount;

    // 担保方式
    private String guaMode;

    // 征信说明
    private String creditNote;

    // 申请时间
    private Date applyDatetime;

    // 备注
    private String remark;

    // *********************************

    private SYSUser sysUser;

    private Credit credit;

    private BudgetOrder budgetOrder;

    private List<Attachment> attachments;

    private List<BizTask> bizTasks;

    private List<SYSBizLog> bizLogs;

    private List<String> curNodeCodeList;

    private List<String> intevCurNodeCodeList;

    private List<String> makeCardNodeList;

    private List<String> fbhgpsNodeList;

    // 入档节点
    private List<String> enterNodeCodeList;

    private List<String> cancelNodeCodeList;

    private String roleCode;

    private String userId;

    private CarInfo carInfo;

    // 公司名称
    private String companyName;

    // 团队名称
    private String teamName;

    // 业务员名称
    private String saleUserName;

    // 业务员公司
    private String saleUserCompanyName;

    // 业务员部门
    private String saleUserDepartMentName;

    // 业务员职位
    private String saleUserPostName;

    // 内勤名称
    private String insideJobName;

    // 内勤公司
    private String insideJobCompanyName;

    // 内勤部门
    private String insideJobDepartMentName;

    // 内勤职位
    private String insideJobPostName;

    // 主贷人
    private CreditUser creditUser;

    // 贷款银行
    private String loanBankName;

    // 申请时间起
    private Date applyDatetimeStart;

    // 申请时间止
    private Date applyDatetimeEnd;

    // 征信人列表
    private List<CreditUser> creditUserList;

    // 二手车评估报告
    private String secondCarReport;

    // 行驶证正面
    private String xszFront;

    // 行驶证翻面
    private String xszReverse;

    // 主贷人名称
    private String userName;

    // 还款业务
    private RepayBiz repayBiz;

    // 征信人信息
    private CreditUserExt creditUserExt;

    // 征信人流水
    private List<CreditJour> creditJours;

    // gps安装列表
    private List<BudgetOrderGps> budgetOrderGps;

    // 存档状态列表
    private List<String> cundangStatusList;

    // 抵押
    private CarPledge carPledge;

    // 贷款信息
    private LoanInfoRes loanInfo;

    // 车辆信息
    private CarInfoRes carInfoRes;

    // 车辆信息
    private Advance advance;

    // 返点列表
    private List<Repoint> repointList;

    // 还款计划列表
    private List<RepayPlan> repayPlanList;

    // 手续费
    private BudgetOrderFee budgetOrderFee;

    // 业务是否经办
    private String isMy;

    // 作废原因
    private String cancelReason;

    // 面签生成时间
    private Date intevDateTime;

}
