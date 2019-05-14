package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 预算单
 *
 * @author: jiafr
 * @since: 2018年5月29日 下午5:48:13
 * @history:
 */
@Data
public class BudgetOrder extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 还款业务编号
    private String repayBizCode;

    // 贷款产品编号
    private String loanProductCode;

    // 产品名称
    private String loanProductName;

    // 所属区域
    private String region;

    // 贷款银行
    private String loanBank;

    // GPS费用
    private Long gpsFee;

    // 公证费
    private Long authFee;

    // 其他费用
    private Long otherFee;

    // 银行服务费
    private Long bankFee;

    // 公司服务费
    private Long companyFee;

    // 团队服务费
    private Long teamFee;

    // 征信单编号
    private String creditCode;

    // 业务种类(新车，二手车)
    private String bizType;

    // 贷款期数
    private String loanPeriod;

    // 机动车销售公司
    private String vehicleCompanyName;

    // 开票单位
    private String invoiceCompany;

    // 品牌
    private String carBrand;

    // 车系
    private String carSeries;

    // 车辆型号
    private String carModel;

    // 车型名称
    private String carModelName;

    // 车辆类型
    private String carType;

    // 车辆照片
    private String carPic;

    // 合格证
    private String carHgzPic;

    // 行驶证正面
    private String driveLicenseFront;

    // 行驶证反面
    private String driveLicenseReverse;

    // 评估栏
    private String evaluateColumn;

    // 车架号
    private String carFrameNo;

    // 发动机号
    private String carEngineNo;

    // 市场指导价
    private Long originalPrice;

    // 开票价
    private Long invoicePrice;

    // 颜色
    private String carColor;

    // 月供保证金(履约保证金)
    private Long monthDeposit;

    // 首付金额
    private Long firstAmount;

    // 首付比例
    private Double firstRate;

    // 贷款金额
    private Long loanAmount;

    // 落户地点
    private String settleAddress;

    // 申请人编号(代注册回写)
    private String applyUserId;

    // 申请人姓名
    private String applyUserName;

    // 性别
    private String gender;

    // 年龄
    private Integer age;

    // 婚姻状况
    private String marryState;

    // 政治面貌
    private String political;

    // 民族
    private String nation;

    // 学历
    private String education;

    // 证件类型
    private String idKind;

    // 身份证号
    private String idNo;

    // 家庭人口
    private Integer familyNumber;

    // 手机号
    private String mobile;

    // 现居住地址
    private String nowAddress;

    // 是否卡邮寄地址
    private String isCardMailAddress;

    // 邮编1
    private String postCode1;

    // 户口所在地
    private String residenceAddress;

    // 邮编2
    private String postCode2;

    // 家庭主要财产
    private String familyMainAsset;

    // 主要财产包括
    private String mainAssetInclude;

    // 主要收入来源
    private String mainIncome;

    // 工作单位名称
    private String workCompanyName;

    // 工作单位地址
    private String workCompanyAddress;

    // 工作单位是否卡邮寄地址
    private String workIsCardMailAddress;

    // 单位性质
    private String workCompanyProperty;

    // 所属行业
    private String workBelongIndustry;

    // 职业
    private String workProfession;

    // 何时进入现单位工作
    private String workDatetime;

    // 自营公司单位面积
    private String selfCompanyArea;

    // 其他工作描述
    private String otherWorkNote;

    // 工作资料上传
    private String workAssetPdf;

    // 员工数量
    private Integer employeeQuantity;

    // 企业月产值
    private String enterpriseMonthOutput;

    // 职位
    private String position;

    // 职称
    private String postTitle;

    // 月收入
    private String monthIncome;

    // 配偶姓名
    private String mateName;

    // 配偶手机号
    private String mateMobile;

    // 配偶身份证号
    private String mateIdNo;

    // 配偶学历
    private String mateEducation;

    // 配偶工作单位名称
    private String mateCompanyName;

    // 配偶工作单位地址
    private String mateCompanyAddress;

    // 配偶工作单位联系电话
    private String mateCompanyContactNo;

    // 配偶支付宝流水时间起
    private Date mateZfbJourDatetimeStart;

    // 配偶支付宝流水时间止
    private Date mateZfbJourDatetimeEnd;

    // 配偶支付宝流水结息1
    private String mateZfbJourInterest1;

    // 配偶支付宝流水结息2
    private String mateZfbJourInterest2;

    // 配偶支付宝结息1
    private Long mateZfbInterest1;

    // 配偶支付宝结息2
    private Long mateZfbInterest2;

    // 配偶支付宝收入
    private Long mateZfbJourIncome;

    // 配偶支付宝支出
    private Long mateZfbJourExpend;

    // 配偶支付宝帐户余额
    private Long mateZfbJourBalance;

    // 配偶支付宝月均收入
    private Long mateZfbJourMonthIncome;

    // 配偶支付宝月均支出
    private Long mateZfbJourMonthExpend;

    // 配偶支付宝流水图片
    private String mateZfbJourPic;

    // 配偶支付宝流水备注
    private String mateZfbJourRemark;

    // 配偶微信流水时间起
    private Date mateWxJourDatetimeStart;

    // 配偶微信流水时间止
    private Date mateWxJourDatetimeEnd;

    // 配偶微信流水结息
    private String mateWxJourInterest1;

    // 配偶微信流水结息
    private String mateWxJourInterest2;

    // 配偶微信结息1
    private Long mateWxInterest1;

    // 配偶微信结息2
    private Long mateWxInterest2;

    // 配偶微信收入
    private Long mateWxJourIncome;

    // 配偶微信支出
    private Long mateWxJourExpend;

    // 配偶微信帐户余额
    private Long mateWxJourBalance;

    // 配偶微信月均收入
    private Long mateWxJourMonthIncome;

    // 配偶微信月均支出
    private Long mateWxJourMonthExpend;

    // 配偶微信流水图片
    private String mateWxJourPic;

    // 配偶微信流水备注
    private String mateWxJourRemark;

    // 配偶流水时间起
    private Date mateJourDatetimeStart;

    // 配偶流水时间止
    private Date mateJourDatetimeEnd;

    // 配偶流水结息
    private String mateJourInterest1;

    // 配偶流水结息
    private String mateJourInterest2;

    // 配偶结息1
    private Long mateInterest1;

    // 配偶结息2
    private Long mateInterest2;

    // 配偶收入
    private Long mateJourIncome;

    // 配偶支出
    private Long mateJourExpend;

    // 配偶帐户余额
    private Long mateJourBalance;

    // 配偶月均收入
    private Long mateJourMonthIncome;

    // 配偶月均支出
    private Long mateJourMonthExpend;

    // 配偶流水图片
    private String mateJourPic;

    // 配偶流水备注
    private String mateJourRemark;

    // 配偶资产资料pdf
    private String mateAssetPdf;

    // 担保人姓名
    private String guaName;

    // 担保人手机号
    private String guaMobile;

    // 担保人身份证号
    private String guaIdNo;

    // 担保人固定电话
    private String guaPhone;

    // 担保人工作单位名称
    private String guaCompanyName;

    // 担保人工作单位地址
    private String guaCompanyAddress;

    // 担保人房产地址
    private String guaHouseAssetAddress;

    // 担保人支付宝流水时间起
    private Date guaZfbJourDatetimeStart;

    // 担保人支付宝流水时间止
    private Date guaZfbJourDatetimeEnd;

    // 担保人支付宝流水结息1
    private String guaZfbJourInterest1;

    // 担保人支付宝流水结息2
    private String guaZfbJourInterest2;

    // 担保人支付宝结息1
    private Long guaZfbInterest1;

    // 担保人支付宝结息2
    private Long guaZfbInterest2;

    // 担保人支付宝收入
    private Long guaZfbJourIncome;

    // 担保人支付宝支出
    private Long guaZfbJourExpend;

    // 担保人支付宝帐户余额
    private Long guaZfbJourBalance;

    // 担保人支付宝月均收入
    private Long guaZfbJourMonthIncome;

    // 担保人支付宝月均支出
    private Long guaZfbJourMonthExpend;

    // 担保人支付宝流水图片
    private String guaZfbJourPic;

    // 担保人支付宝流水备注
    private String guaZfbJourRemark;

    // 担保人微信流水时间起
    private Date guaWxJourDatetimeStart;

    // 担保人微信流水时间止
    private Date guaWxJourDatetimeEnd;

    // 担保人微信流水结息1
    private String guaWxJourInterest1;

    // 担保人微信流水结息2
    private String guaWxJourInterest2;

    // 担保人微信结息1
    private Long guaWxInterest1;

    // 担保人微信结息2
    private Long guaWxInterest2;

    // 担保人微信收入
    private Long guaWxJourIncome;

    // 担保人微信支出
    private Long guaWxJourExpend;

    // 担保人微信帐户余额
    private Long guaWxJourBalance;

    // 担保人微信月均收入
    private Long guaWxJourMonthIncome;

    // 担保人微信月均支出
    private Long guaWxJourMonthExpend;

    // 担保人微信流水图片
    private String guaWxJourPic;

    // 担保人微信流水备注
    private String guaWxJourRemark;

    // 担保人流水时间起
    private Date guaJourDatetimeStart;

    // 担保人流水时间止
    private Date guaJourDatetimeEnd;

    // 担保人流水结息1
    private String guaJourInterest1;

    // 担保人流水结息2
    private String guaJourInterest2;

    // 担保人结息1
    private Long guaInterest1;

    // 担保人结息2
    private Long guaInterest2;

    // 担保人收入
    private Long guaJourIncome;

    // 担保人支出
    private Long guaJourExpend;

    // 担保人帐户余额
    private Long guaJourBalance;

    // 担保人月均收入
    private Long guaJourMonthIncome;

    // 担保人月均支出
    private Long guaJourMonthExpend;

    // 担保人流水图片
    private String guaJourPic;

    // 担保人流水备注
    private String guaJourRemark;

    // 担保人资产资料pdf
    private String guaAssetPdf;

    // 家庭紧急联系人信息1 姓名
    private String emergencyName1;

    // 家庭紧急联系人信息1 与申请人关系
    private String emergencyRelation1;

    // 家庭紧急联系人信息1 手机号码
    private String emergencyMobile1;

    // 家庭紧急联系人信息2 姓名
    private String emergencyName2;

    // 家庭紧急联系人信息2 与申请人关系
    private String emergencyRelation2;

    // 家庭紧急联系人信息2 手机号码
    private String emergencyMobile2;

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

    // 支付宝流水备注
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

    // 微信流水备注
    private String wxJourRemark;

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

    // 流水备注
    private String jourRemark;

    // 资产资料pdf
    private String assetPdf;

    // 购房合同
    private String houseContract;

    // 房屋照片
    private String housePicture;

    // 户口本资料
    private String hkBookPdf;

    // 身份证资料
    private String idCardPdf;

    // 结婚证资料
    private String marryPdf;

    // 其他资料
    private String otherPdf;

    // 是否垫资
    private String isAdvanceFund;

    // 是否融资
    private String isFinancing;

    // 银行视频
    private String bankVideo;

    // 银行面签照片
    private String bankPhoto;

    // 公司视频
    private String companyVideo;

    // 公司合同
    private String companyContract;

    // 银行合同
    private String bankContract;

    // 其他视频
    private String otherVideo;

    // 面签其他资料
    private String interviewOtherPdf;

    // 是否面签完成
    private String isInterview;

    // 是否录入发保合
    private String isEntryMortgage;

    // 垫资日期
    private Date advanceFundDatetime;

    // 垫资金额
    private Long advanceFundAmount;

    // 水单
    private String billPdf;

    // 垫资说明
    private String advanceNote;

    // 资金划转授权书
    private String advanceFundAmountPdf;

    // 驻行申请：补充说明
    private String supplementNote;

    // 车辆落户日期
    private Date carSettleDatetime;

    // 车牌号
    private String carNumber;

    // 发票
    private String carInvoice;

    // 交强险
    private String carJqx;

    // 商业险
    private String carSyx;

    // 保单日期
    private Date policyDatetime;

    // 保单到期日
    private Date policyDueDate;

    // 车辆落户其他资料
    private String carSettleOtherPdf;

    // 登记证书
    private String carRegcerti;

    // 车辆批单
    private String carPd;

    // 车钥匙
    private String carKey;

    // 大本扫描件
    private String carBigSmj;

    // 车辆行驶证扫描件
    private String carXszSmj;

    // 完税证明扫描件
    private String dutyPaidProveSmj;

    // 银行提交时间
    private Date bankCommitDatetime;

    // 银行提交说明
    private String bankCommitNote;

    // 是否抵押完成(1是0否)
    private String isMortgage;

    // 还款卡银行行别
    private String repayBankCode;

    // 还款卡银行名称
    private String repayBankName;

    // 还款卡开户支行
    private String repaySubbranch;

    // 还款卡号
    private String repayBankcardNumber;

    // 银行账单日
    private int repayBillDate;

    // 银行还款日
    private int repayBankDate;

    // 公司还款日
    private int repayCompanyDate;

    // 首期月供金额
    private Long repayFirstMonthAmount;

    // 首期还款日期
    private Date repayFirstMonthDatetime;

    // 每期月供金额
    private Long repayMonthAmount;

    // 银行放款日期
    private Date bankFkDatetime;

    // 收款银行
    private String receiptBankCode;

    // 收款银行名称
    private String receiptBankName;

    // 收款银行卡号
    private String receiptBankcardNumber;

    // 收款凭证
    private String receiptPdf;

    // 收款备注
    private String receiptRemark;

    // 代理人
    private String pledgeUser;

    // 代理人身份证复印件
    private String pledgeUserIdCardCopy;

    // 抵押地点
    private String pledgeAddress;

    // 抵押日期
    private Date pledgeDatetime;

    // 车辆价格核实报告
    private String carPriceCheckReport;

    // 绿大本扫描件
    private String greenBigSmj;

    // 抵押提交银行时间
    private Date pledgeBankCommitDatetime;

    // 抵押提交说明
    private String pledgeBankCommitNote;

    // 抵押情况（1是，0否）pledge_status
    private String pledgeStatus;

    // 入档位置
    private String enterLocation;

    // 入档时间
    private Date enterDatetime;

    // 入档清单
    private String enterFileList;

    // 业务员（信贷专员）
    private String saleUserId;

    // 内勤
    private String insideJob;

    // 团队编号
    private String teamCode;

    // 业务公司编号
    private String companyCode;

    // 申请时间
    private Date applyDatetime;

    // 退客户垫资款状态
    private String backAdvanceStatus;

    // 退客户垫资款 退款金额
    private String backAdvanceAmount;

    // 退客户垫资款 收款账号
    private String backAdvanceAccount;

    // 退客户垫资款 开户行
    private String backAdvanceOpenBank;

    // 退客户垫资款 开户支行
    private String backAdvanceSubbranch;

    // 退客户垫资款 水单
    private String backAdvanceWaterBill;

    // 当前节点编号
    private String curNodeCode;

    // 准入单审核次数
    private Long approveCount;

    // 面签节点编号
    private String intevCurNodeCode;

    // 垫资节点编号
    private String advanfCurNodeCode;

    // 客户申请作废时的节点编号
    private String cancelNodeCode;

    // 冻结状态
    private String frozenStatus;

    // 是否安装了GPS(1是，0否)
    private String isGpsAz;

    // 是否是资料传递中（1是，0否）
    private String isLogistics;

    // 最新备注
    private String remark;

    /*---------辅助字段----------*/
    // 申请时间起始
    private Date applyDatetimeStart;

    // 申请时间结束
    private Date applyDatetimeEnd;

    // 角色编号
    private String roleCode;

    // gps安装列表
    private List<BudgetOrderGps> budgetOrderGpsList;

    // 征信列表
    private Credit credit;

    // 公司名称
    private String companyName;

    // 区域经理名称
    private String areaName;

    // 区域经理手机号
    private String areaMobile;

    // 业务员姓名
    private String saleUserName;

    // 贷款银行名称
    private String loanBankName;

    // 申请时间起始
    private Date advanceFundDatetimeStart;

    // 申请时间结束
    private Date advanceFundDatetimeEnd;

    // 银行放款日期
    private Date bankFkDatetimeStart;

    // 银行放款日期
    private Date bankFkDatetimeEnd;

    // 垫资节点
    private String curNodeCodeDz;

    // 放款节点
    private String curNodeCodeFk;

    // 超过一天的标志
    private String advanceFlag;

    // 团队名称
    private String teamName;

    private String keyword;

    // 申请人姓名模糊差查
    private String applyUserNameForQuery;

    private List<String> curNodeCodeList;

    private List<String> intevCurNodeCodeList;

    private List<String> advanfCurNodeCodeList;

    // 还款业务编号模糊差查
    private String repayBizCodeForQuery;

    // 查询还款业务不为null的业务单（进行到贷后的业务）
    private String repayBizCodeNotNull;

    // 联系电话
    private String contactNo;

    // 刷卡总手续费=团队服务费+银行服务费+公司服务费
    private String cardTotalFee;

    // 刷卡总金额 = 贷款金额+刷卡总手续费
    private String cardTotalAmount;

    // 是否作废（按节点判断的）
    private String isCancel;

    // 入档情况（按节点判断的）
    private String enterStatus;

    // 未入档节点
    private String curNodeCodeNoEnter;

    // 未作废节点
    private String curNodeCodeNoCancel;

    // 资料快递
    private String informationExpress;

    // 收件日期
    private Date receiptDatetime;

    // 编号模糊查
    private String codeQuery;

    private int advanceDays;// 垫资天数

    // 资料快递单号及时间
    private String logisticsDate;

    // 内勤名称
    private String insideJobName;

    // 征信二手车评估报告
    private String secondCarReport;

    private List<Attachment> attachments;

    private Cdbiz cdbiz;

}
