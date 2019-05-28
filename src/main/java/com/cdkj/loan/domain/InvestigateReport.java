package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 调查报告
 *
 * @author: CYunlai
 * @since: 2018-07-05 17:40:20
 * @history:
 */
@Data
public class InvestigateReport extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 预算单编号
    private String budgetOrderCode;

    // 业务编号
    private String repayBizCode;

    // 团队编号
    private String teamCode;

    // 业务公司
    private String companyCode;

    // 业务种类
    private String bizType;

    // 客户姓名
    private String applyUserName;

    // 申请时间
    private Date applyDatetime;

    // 贷款银行
    private String loanBank;

    // 贷款金额
    private Long loanAmount;

    // 贷款期数
    private String loanPeriod;

    // 是否垫资
    private String isAdvanceFund;

    // 业务员
    private String saleUserId;

    // 担保方式
    private String guaMode;

    // 客户基本情况
    private String customerInformation;

    // 申请人征信情况
    private String bankCreditResultRemark;

    // 申请人贷款车辆价格核准情况
    private String priceApprovalPdf;

    // 车行168车价
    private Long car168Price;

    // 申请人工作情况及流水反映
    private String applyWorkAndJour;

    // 流水时间起
    private Date jourDatetimeStart;

    // 流水时间止
    private Date jourDatetimeEnd;

    // 流水结息1
    private String jourInterest1;

    // 流水结息2
    private String jourInterest2;

    // 结息1
    private Long interest1;

    // 结息2
    private Long interest2;

    // 收入
    private Long jourIncome;

    // 支出
    private Long jourExpend;

    // 帐户余额
    private Long jourBalance;

    // 月均收入
    private Long jourMonthIncome;

    // 月均支出
    private Long jourMonthExpend;

    // 流水图片
    private String jourPic;

    // 银行流水情况
    private String jourRemark;

    // 支付宝流水时间起
    private Date zfbJourDatetimeStart;

    // 支付宝流水时间止
    private Date zfbJourDatetimeEnd;

    // 支付宝流水结息1
    private String zfbJourInterest1;

    // 支付宝流水结息2
    private String zfbJourInterest2;

    // 支付宝结息1
    private Long zfbInterest1;

    // 支付宝结息2
    private Long zfbInterest2;

    // 支付宝收入
    private Long zfbJourIncome;

    // 支付宝支出
    private Long zfbJourExpend;

    // 支付宝帐户余额
    private Long zfbJourBalance;

    // 支付宝月均收入
    private Long zfbJourMonthIncome;

    // 支付宝月均支出
    private Long zfbJourMonthExpend;

    // 支付宝流水图片
    private String zfbJourPic;

    // 支付宝流水情况
    private String zfbJourRemark;

    // 微信流水时间起
    private Date wxJourDatetimeStart;

    // 微信流水时间止
    private Date wxJourDatetimeEnd;

    // 微信流水结息1
    private String wxJourInterest1;

    // 微信流水结息2
    private String wxJourInterest2;

    // 微信结息1
    private Long wxInterest1;

    // 微信结息2
    private Long wxInterest2;

    // 微信收入
    private Long wxJourIncome;

    // 微信支出
    private Long wxJourExpend;

    // 微信帐户余额
    private Long wxJourBalance;

    // 微信月均收入
    private Long wxJourMonthIncome;

    // 微信月均支出
    private Long wxJourMonthExpend;

    // 微信流水图片
    private String wxJourPic;

    // 微信流水情况
    private String wxJourRemark;

    // 房产情况及家访
    private String houseContract;

    // 家访地址
    private String homeVisit;

    // 家访照片
    private String housePicture;

    // 车辆基础信息
    private String basicsInformation;

    // 行驶证主副页
    private String xszPdf;

    // 行驶证车辆照片页
    private String xszCarPdf;

    // 车架号
    private String frameNo;

    // 车辆铭牌
    private String nameplate;

    // 车辆照片正前
    private String forwardPdf;

    // 车辆照片正后
    private String queenPdf;

    // 车辆照片正左
    private String leftPdf;

    // 车辆照片正右
    private String rightPdf;

    // 车辆照片左前45o
    private String lf45Pdf;

    // 车辆照片右前45o
    private String rf45Pdf;

    // 车辆照片左后45o
    private String lg45Pdf;

    // 车辆照片右后45o
    private String rr45Pdf;

    // 车辆照片发动机仓
    private String enginePdf;

    // 车辆中控台照片
    private String szmPdf;

    // 车辆档位照片
    private String gearsPdf;

    // 车辆功能区里照片
    private String functionalZonePdf;

    // 车辆里程表照片
    private String odometerPdf;

    // 车辆前排内饰照片
    private String frontRowPdf;

    // 车辆中排内饰照片
    private String rockRowPdf;

    // 车辆后备箱照片
    private String trunkPdf;

    // 车辆天窗照片
    private String louverPdf;

    // 车辆后排娱乐系统照片
    private String bankRowPdf;

    // 车辆核准截图
    private String checkApprovePdf;

    // 核准链接
    private String checkApproveLink;

    // 第三方评估价截图
    private String thirdValuationPdf;

    // 核准软件
    private String checkApproveSoftware;

    // 二手车市场成交价最低及最高截图
    private String usedCarCurrentRate;

    // 信息源
    private String informationSource;

    // 评估价
    private Long valuation;

    // 节点编号
    private String curNodeCode;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*----------辅助字段--------*/

    // 申请时间起
    private Date applyDatetimeStart;

    // 申请时间止
    private Date applyDatetimeEnd;

    // 业务公司
    private String companyName;

    // 贷款银行名称
    private String loanBankName;

    // 团队名称
    private String teamName;

    // 业务员姓名
    private String saleUserName;

    // 内勤编号
    private String insideJob;

    private String roleCode;

}
