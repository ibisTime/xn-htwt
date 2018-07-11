package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 预算单
 * @author: jiafr 
 * @since: 2018年5月29日 下午5:48:13 
 * @history:
 */
public class BudgetOrder extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

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

    // 开票单位
    private String invoiceCompany;

    // 品牌
    private String carBrand;

    // 车系
    private String carSeries;

    // 车型
    private String carModel;

    // 车辆类型
    private String carType;

    // 车辆照片
    private String carPic;

    // 合格证
    private String carHgzPic;

    // 行驶证
    private String driveLicense;

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

    // 配偶支付宝流水结息
    private String mateZfbJourInterest;

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
    private String mateWxJourInterest;

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
    private String mateJourInterest;

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

    // 担保人支付宝流水结息
    private String guaZfbJourInterest;

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

    // 担保人微信流水结息
    private String guaWxJourInterest;

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

    // 担保人流水结息
    private String guaJourInterest;

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

    // 支付宝流水结息
    private String zfbJourInterest;

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

    // 微信流水结息
    private String wxJourInterest;

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

    // 流水结息
    private String jourInterest;

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

    // 垫资日期
    private Date advanceFundDatetime;

    // 垫资金额
    private Long advanceFundAmount;

    // 水单
    private String billPdf;

    // 资金划转授权书
    private String advanceFundAmountPdf;

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

    // 银行提交时间
    private Date bankCommitDatetime;

    // 银行提交说明
    private String bankCommitNote;

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
    private Date repayCompanyDate;

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

    // 抵押地点
    private String pledgeAddress;

    // 抵押日期
    private Date pledgeDatetime;

    // 绿大本扫描件
    private String greenBigSmj;

    // 抵押提交银行时间
    private Date pledgeBankCommitDatetime;

    // 抵押提交说明
    private String pledgeBankCommitNote;

    // 入档位置
    private String enterLocation;

    // 业务员
    private String saleUserId;

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

    // 客户申请作废时的节点编号
    private String cancelNodeCode;

    // 冻结状态
    private String frozenStatus;

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

    // 业务编号模糊差查
    private String repayBizCodeForQuery;

    // 联系电话
    private String contactNo;

    // 内勤
    private String insideJob;

    // 刷卡总手续费=团队服务费+银行服务费+公司服务费
    private String cardTotalFee;

    // 刷卡总金额 = 贷款金额+刷卡总手续费
    private String cardTotalAmount;

    public String getCardTotalAmount() {
        return cardTotalAmount;
    }

    public void setCardTotalAmount(String cardTotalAmount) {
        this.cardTotalAmount = cardTotalAmount;
    }

    public String getCardTotalFee() {
        return cardTotalFee;
    }

    public void setCardTotalFee(String cardTotalFee) {
        this.cardTotalFee = cardTotalFee;
    }

    public String getInsideJob() {
        return insideJob;
    }

    public void setInsideJob(String insideJob) {
        this.insideJob = insideJob;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getRepayBizCodeForQuery() {
        return repayBizCodeForQuery;
    }

    public void setRepayBizCodeForQuery(String repayBizCodeForQuery) {
        this.repayBizCodeForQuery = repayBizCodeForQuery;
    }

    public String getApplyUserNameForQuery() {
        return applyUserNameForQuery;
    }

    public void setApplyUserNameForQuery(String applyUserNameForQuery) {
        this.applyUserNameForQuery = applyUserNameForQuery;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAdvanceFlag() {
        return advanceFlag;
    }

    public void setAdvanceFlag(String advanceFlag) {
        this.advanceFlag = advanceFlag;
    }

    public String getCurNodeCodeDz() {
        return curNodeCodeDz;
    }

    public void setCurNodeCodeDz(String curNodeCodeDz) {
        this.curNodeCodeDz = curNodeCodeDz;
    }

    public String getCurNodeCodeFk() {
        return curNodeCodeFk;
    }

    public void setCurNodeCodeFk(String curNodeCodeFk) {
        this.curNodeCodeFk = curNodeCodeFk;
    }

    public Date getBankFkDatetimeStart() {
        return bankFkDatetimeStart;
    }

    public void setBankFkDatetimeStart(Date bankFkDatetimeStart) {
        this.bankFkDatetimeStart = bankFkDatetimeStart;
    }

    public Date getBankFkDatetimeEnd() {
        return bankFkDatetimeEnd;
    }

    public void setBankFkDatetimeEnd(Date bankFkDatetimeEnd) {
        this.bankFkDatetimeEnd = bankFkDatetimeEnd;
    }

    public Date getAdvanceFundDatetimeStart() {
        return advanceFundDatetimeStart;
    }

    public void setAdvanceFundDatetimeStart(Date advanceFundDatetimeStart) {
        this.advanceFundDatetimeStart = advanceFundDatetimeStart;
    }

    public Date getAdvanceFundDatetimeEnd() {
        return advanceFundDatetimeEnd;
    }

    public void setAdvanceFundDatetimeEnd(Date advanceFundDatetimeEnd) {
        this.advanceFundDatetimeEnd = advanceFundDatetimeEnd;
    }

    public String getCancelNodeCode() {
        return cancelNodeCode;
    }

    public void setCancelNodeCode(String cancelNodeCode) {
        this.cancelNodeCode = cancelNodeCode;
    }

    public String getFrozenStatus() {
        return frozenStatus;
    }

    public void setFrozenStatus(String frozenStatus) {
        this.frozenStatus = frozenStatus;
    }

    public String getBackAdvanceStatus() {
        return backAdvanceStatus;
    }

    public void setBackAdvanceStatus(String backAdvanceStatus) {
        this.backAdvanceStatus = backAdvanceStatus;
    }

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<BudgetOrderGps> getBudgetOrderGpsList() {
        return budgetOrderGpsList;
    }

    public void setBudgetOrderGpsList(List<BudgetOrderGps> budgetOrderGpsList) {
        this.budgetOrderGpsList = budgetOrderGpsList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public String getLoanProductName() {
        return loanProductName;
    }

    public void setLoanProductName(String loanProductName) {
        this.loanProductName = loanProductName;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public Long getGpsFee() {
        return gpsFee;
    }

    public void setGpsFee(Long gpsFee) {
        this.gpsFee = gpsFee;
    }

    public Long getAuthFee() {
        return authFee;
    }

    public void setAuthFee(Long authFee) {
        this.authFee = authFee;
    }

    public Long getBankFee() {
        return bankFee;
    }

    public void setBankFee(Long bankFee) {
        this.bankFee = bankFee;
    }

    public Long getCompanyFee() {
        return companyFee;
    }

    public void setCompanyFee(Long companyFee) {
        this.companyFee = companyFee;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Long invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Long getMonthDeposit() {
        return monthDeposit;
    }

    public String getCarSettleOtherPdf() {
        return carSettleOtherPdf;
    }

    public void setCarSettleOtherPdf(String carSettleOtherPdf) {
        this.carSettleOtherPdf = carSettleOtherPdf;
    }

    public void setMonthDeposit(Long monthDeposit) {
        this.monthDeposit = monthDeposit;
    }

    public Long getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(Long firstAmount) {
        this.firstAmount = firstAmount;
    }

    public Double getFirstRate() {
        return firstRate;
    }

    public void setFirstRate(Double firstRate) {
        this.firstRate = firstRate;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getSettleAddress() {
        return settleAddress;
    }

    public void setSettleAddress(String settleAddress) {
        this.settleAddress = settleAddress;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarryState() {
        return marryState;
    }

    public void setMarryState(String marryState) {
        this.marryState = marryState;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getIsCardMailAddress() {
        return isCardMailAddress;
    }

    public void setIsCardMailAddress(String isCardMailAddress) {
        this.isCardMailAddress = isCardMailAddress;
    }

    public String getPostCode1() {
        return postCode1;
    }

    public void setPostCode1(String postCode1) {
        this.postCode1 = postCode1;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getPostCode2() {
        return postCode2;
    }

    public void setPostCode2(String postCode2) {
        this.postCode2 = postCode2;
    }

    public String getFamilyMainAsset() {
        return familyMainAsset;
    }

    public void setFamilyMainAsset(String familyMainAsset) {
        this.familyMainAsset = familyMainAsset;
    }

    public String getMainAssetInclude() {
        return mainAssetInclude;
    }

    public void setMainAssetInclude(String mainAssetInclude) {
        this.mainAssetInclude = mainAssetInclude;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getBankVideo() {
        return bankVideo;
    }

    public void setBankVideo(String bankVideo) {
        this.bankVideo = bankVideo;
    }

    public String getCompanyVideo() {
        return companyVideo;
    }

    public void setCompanyVideo(String companyVideo) {
        this.companyVideo = companyVideo;
    }

    public String getMainIncome() {
        return mainIncome;
    }

    public void setMainIncome(String mainIncome) {
        this.mainIncome = mainIncome;
    }

    public String getWorkCompanyName() {
        return workCompanyName;
    }

    public void setWorkCompanyName(String workCompanyName) {
        this.workCompanyName = workCompanyName;
    }

    public String getWorkCompanyAddress() {
        return workCompanyAddress;
    }

    public void setWorkCompanyAddress(String workCompanyAddress) {
        this.workCompanyAddress = workCompanyAddress;
    }

    public String getSelfCompanyArea() {
        return selfCompanyArea;
    }

    public void setSelfCompanyArea(String selfCompanyArea) {
        this.selfCompanyArea = selfCompanyArea;
    }

    public Integer getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(Integer familyNumber) {
        this.familyNumber = familyNumber;
    }

    public Integer getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(Integer employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public String getEnterpriseMonthOutput() {
        return enterpriseMonthOutput;
    }

    public void setEnterpriseMonthOutput(String enterpriseMonthOutput) {
        this.enterpriseMonthOutput = enterpriseMonthOutput;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getOtherWorkNote() {
        return otherWorkNote;
    }

    public void setOtherWorkNote(String otherWorkNote) {
        this.otherWorkNote = otherWorkNote;
    }

    public String getWorkAssetPdf() {
        return workAssetPdf;
    }

    public void setWorkAssetPdf(String workAssetPdf) {
        this.workAssetPdf = workAssetPdf;
    }

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getMateName() {
        return mateName;
    }

    public void setMateName(String mateName) {
        this.mateName = mateName;
    }

    public String getMateMobile() {
        return mateMobile;
    }

    public void setMateMobile(String mateMobile) {
        this.mateMobile = mateMobile;
    }

    public String getMateIdNo() {
        return mateIdNo;
    }

    public void setMateIdNo(String mateIdNo) {
        this.mateIdNo = mateIdNo;
    }

    public String getMateEducation() {
        return mateEducation;
    }

    public void setMateEducation(String mateEducation) {
        this.mateEducation = mateEducation;
    }

    public String getMateCompanyName() {
        return mateCompanyName;
    }

    public void setMateCompanyName(String mateCompanyName) {
        this.mateCompanyName = mateCompanyName;
    }

    public String getMateCompanyAddress() {
        return mateCompanyAddress;
    }

    public void setMateCompanyAddress(String mateCompanyAddress) {
        this.mateCompanyAddress = mateCompanyAddress;
    }

    public String getAdvanceFundAmountPdf() {
        return advanceFundAmountPdf;
    }

    public void setAdvanceFundAmountPdf(String advanceFundAmountPdf) {
        this.advanceFundAmountPdf = advanceFundAmountPdf;
    }

    public String getOtherVideo() {
        return otherVideo;
    }

    public void setOtherVideo(String otherVideo) {
        this.otherVideo = otherVideo;
    }

    public String getMateCompanyContactNo() {
        return mateCompanyContactNo;
    }

    public void setMateCompanyContactNo(String mateCompanyContactNo) {
        this.mateCompanyContactNo = mateCompanyContactNo;
    }

    public String getGuaName() {
        return guaName;
    }

    public void setGuaName(String guaName) {
        this.guaName = guaName;
    }

    public String getGuaMobile() {
        return guaMobile;
    }

    public void setGuaMobile(String guaMobile) {
        this.guaMobile = guaMobile;
    }

    public String getGuaIdNo() {
        return guaIdNo;
    }

    public void setGuaIdNo(String guaIdNo) {
        this.guaIdNo = guaIdNo;
    }

    public Date getPolicyDatetime() {
        return policyDatetime;
    }

    public void setPolicyDatetime(Date policyDatetime) {
        this.policyDatetime = policyDatetime;
    }

    public Date getPolicyDueDate() {
        return policyDueDate;
    }

    public void setPolicyDueDate(Date policyDueDate) {
        this.policyDueDate = policyDueDate;
    }

    public String getGuaPhone() {
        return guaPhone;
    }

    public void setGuaPhone(String guaPhone) {
        this.guaPhone = guaPhone;
    }

    public String getGuaCompanyName() {
        return guaCompanyName;
    }

    public void setGuaCompanyName(String guaCompanyName) {
        this.guaCompanyName = guaCompanyName;
    }

    public String getGuaCompanyAddress() {
        return guaCompanyAddress;
    }

    public void setGuaCompanyAddress(String guaCompanyAddress) {
        this.guaCompanyAddress = guaCompanyAddress;
    }

    public String getGuaHouseAssetAddress() {
        return guaHouseAssetAddress;
    }

    public void setGuaHouseAssetAddress(String guaHouseAssetAddress) {
        this.guaHouseAssetAddress = guaHouseAssetAddress;
    }

    public String getEmergencyName1() {
        return emergencyName1;
    }

    public String getHkBookPdf() {
        return hkBookPdf;
    }

    public void setHkBookPdf(String hkBookPdf) {
        this.hkBookPdf = hkBookPdf;
    }

    public String getIdCardPdf() {
        return idCardPdf;
    }

    public void setIdCardPdf(String idCardPdf) {
        this.idCardPdf = idCardPdf;
    }

    public Long getMateInterest1() {
        return mateInterest1;
    }

    public void setMateInterest1(Long mateInterest1) {
        this.mateInterest1 = mateInterest1;
    }

    public Long getMateInterest2() {
        return mateInterest2;
    }

    public void setMateInterest2(Long mateInterest2) {
        this.mateInterest2 = mateInterest2;
    }

    public Long getGuaInterest1() {
        return guaInterest1;
    }

    public void setGuaInterest1(Long guaInterest1) {
        this.guaInterest1 = guaInterest1;
    }

    public Long getGuaInterest2() {
        return guaInterest2;
    }

    public void setGuaInterest2(Long guaInterest2) {
        this.guaInterest2 = guaInterest2;
    }

    public Long getInterest1() {
        return interest1;
    }

    public void setInterest1(Long interest1) {
        this.interest1 = interest1;
    }

    public Long getInterest2() {
        return interest2;
    }

    public void setInterest2(Long interest2) {
        this.interest2 = interest2;
    }

    public String getMarryPdf() {
        return marryPdf;
    }

    public void setMarryPdf(String marryPdf) {
        this.marryPdf = marryPdf;
    }

    public String getOtherPdf() {
        return otherPdf;
    }

    public void setOtherPdf(String otherPdf) {
        this.otherPdf = otherPdf;
    }

    public void setEmergencyName1(String emergencyName1) {
        this.emergencyName1 = emergencyName1;
    }

    public Long getMateZfbInterest1() {
        return mateZfbInterest1;
    }

    public void setMateZfbInterest1(Long mateZfbInterest1) {
        this.mateZfbInterest1 = mateZfbInterest1;
    }

    public Long getMateZfbInterest2() {
        return mateZfbInterest2;
    }

    public void setMateZfbInterest2(Long mateZfbInterest2) {
        this.mateZfbInterest2 = mateZfbInterest2;
    }

    public Long getMateWxInterest1() {
        return mateWxInterest1;
    }

    public void setMateWxInterest1(Long mateWxInterest1) {
        this.mateWxInterest1 = mateWxInterest1;
    }

    public Long getMateWxInterest2() {
        return mateWxInterest2;
    }

    public void setMateWxInterest2(Long mateWxInterest2) {
        this.mateWxInterest2 = mateWxInterest2;
    }

    public Long getGuaZfbInterest1() {
        return guaZfbInterest1;
    }

    public void setGuaZfbInterest1(Long guaZfbInterest1) {
        this.guaZfbInterest1 = guaZfbInterest1;
    }

    public Long getGuaZfbInterest2() {
        return guaZfbInterest2;
    }

    public void setGuaZfbInterest2(Long guaZfbInterest2) {
        this.guaZfbInterest2 = guaZfbInterest2;
    }

    public Long getGuaWxInterest1() {
        return guaWxInterest1;
    }

    public void setGuaWxInterest1(Long guaWxInterest1) {
        this.guaWxInterest1 = guaWxInterest1;
    }

    public Long getGuaWxInterest2() {
        return guaWxInterest2;
    }

    public void setGuaWxInterest2(Long guaWxInterest2) {
        this.guaWxInterest2 = guaWxInterest2;
    }

    public Long getZfbInterest1() {
        return zfbInterest1;
    }

    public void setZfbInterest1(Long zfbInterest1) {
        this.zfbInterest1 = zfbInterest1;
    }

    public Long getZfbInterest2() {
        return zfbInterest2;
    }

    public void setZfbInterest2(Long zfbInterest2) {
        this.zfbInterest2 = zfbInterest2;
    }

    public String getPledgeUser() {
        return pledgeUser;
    }

    public void setPledgeUser(String pledgeUser) {
        this.pledgeUser = pledgeUser;
    }

    public String getPledgeAddress() {
        return pledgeAddress;
    }

    public void setPledgeAddress(String pledgeAddress) {
        this.pledgeAddress = pledgeAddress;
    }

    public Long getWxInterest1() {
        return wxInterest1;
    }

    public void setWxInterest1(Long wxInterest1) {
        this.wxInterest1 = wxInterest1;
    }

    public Long getWxInterest2() {
        return wxInterest2;
    }

    public void setWxInterest2(Long wxInterest2) {
        this.wxInterest2 = wxInterest2;
    }

    public String getEmergencyRelation1() {
        return emergencyRelation1;
    }

    public void setEmergencyRelation1(String emergencyRelation1) {
        this.emergencyRelation1 = emergencyRelation1;
    }

    public String getEmergencyMobile1() {
        return emergencyMobile1;
    }

    public void setEmergencyMobile1(String emergencyMobile1) {
        this.emergencyMobile1 = emergencyMobile1;
    }

    public String getEmergencyName2() {
        return emergencyName2;
    }

    public void setEmergencyName2(String emergencyName2) {
        this.emergencyName2 = emergencyName2;
    }

    public String getEmergencyRelation2() {
        return emergencyRelation2;
    }

    public void setEmergencyRelation2(String emergencyRelation2) {
        this.emergencyRelation2 = emergencyRelation2;
    }

    public String getEmergencyMobile2() {
        return emergencyMobile2;
    }

    public void setEmergencyMobile2(String emergencyMobile2) {
        this.emergencyMobile2 = emergencyMobile2;
    }

    public Date getJourDatetimeStart() {
        return jourDatetimeStart;
    }

    public void setJourDatetimeStart(Date jourDatetimeStart) {
        this.jourDatetimeStart = jourDatetimeStart;
    }

    public Date getJourDatetimeEnd() {
        return jourDatetimeEnd;
    }

    public void setJourDatetimeEnd(Date jourDatetimeEnd) {
        this.jourDatetimeEnd = jourDatetimeEnd;
    }

    public Long getJourIncome() {
        return jourIncome;
    }

    public void setJourIncome(Long jourIncome) {
        this.jourIncome = jourIncome;
    }

    public Long getJourExpend() {
        return jourExpend;
    }

    public void setJourExpend(Long jourExpend) {
        this.jourExpend = jourExpend;
    }

    public Long getJourBalance() {
        return jourBalance;
    }

    public void setJourBalance(Long jourBalance) {
        this.jourBalance = jourBalance;
    }

    public Long getJourMonthIncome() {
        return jourMonthIncome;
    }

    public void setJourMonthIncome(Long jourMonthIncome) {
        this.jourMonthIncome = jourMonthIncome;
    }

    public Long getJourMonthExpend() {
        return jourMonthExpend;
    }

    public void setJourMonthExpend(Long jourMonthExpend) {
        this.jourMonthExpend = jourMonthExpend;
    }

    public String getJourRemark() {
        return jourRemark;
    }

    public void setJourRemark(String jourRemark) {
        this.jourRemark = jourRemark;
    }

    public String getHouseContract() {
        return houseContract;
    }

    public void setHouseContract(String houseContract) {
        this.houseContract = houseContract;
    }

    public String getHousePicture() {
        return housePicture;
    }

    public void setHousePicture(String housePicture) {
        this.housePicture = housePicture;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getBankPhoto() {
        return bankPhoto;
    }

    public void setBankPhoto(String bankPhoto) {
        this.bankPhoto = bankPhoto;
    }

    public String getCompanyContract() {
        return companyContract;
    }

    public void setCompanyContract(String companyContract) {
        this.companyContract = companyContract;
    }

    public String getBankContract() {
        return bankContract;
    }

    public void setBankContract(String bankContract) {
        this.bankContract = bankContract;
    }

    public String getInterviewOtherPdf() {
        return interviewOtherPdf;
    }

    public void setInterviewOtherPdf(String interviewOtherPdf) {
        this.interviewOtherPdf = interviewOtherPdf;
    }

    public Date getAdvanceFundDatetime() {
        return advanceFundDatetime;
    }

    public void setAdvanceFundDatetime(Date advanceFundDatetime) {
        this.advanceFundDatetime = advanceFundDatetime;
    }

    public Long getAdvanceFundAmount() {
        return advanceFundAmount;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public void setAdvanceFundAmount(Long advanceFundAmount) {
        this.advanceFundAmount = advanceFundAmount;
    }

    public String getBillPdf() {
        return billPdf;
    }

    public void setBillPdf(String billPdf) {
        this.billPdf = billPdf;
    }

    public Date getCarSettleDatetime() {
        return carSettleDatetime;
    }

    public void setCarSettleDatetime(Date carSettleDatetime) {
        this.carSettleDatetime = carSettleDatetime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarInvoice() {
        return carInvoice;
    }

    public void setCarInvoice(String carInvoice) {
        this.carInvoice = carInvoice;
    }

    public String getCarJqx() {
        return carJqx;
    }

    public void setCarJqx(String carJqx) {
        this.carJqx = carJqx;
    }

    public String getCarSyx() {
        return carSyx;
    }

    public void setCarSyx(String carSyx) {
        this.carSyx = carSyx;
    }

    public String getCarRegcerti() {
        return carRegcerti;
    }

    public void setCarRegcerti(String carRegcerti) {
        this.carRegcerti = carRegcerti;
    }

    public String getCarPd() {
        return carPd;
    }

    public void setCarPd(String carPd) {
        this.carPd = carPd;
    }

    public String getCarKey() {
        return carKey;
    }

    public void setCarKey(String carKey) {
        this.carKey = carKey;
    }

    public String getWorkIsCardMailAddress() {
        return workIsCardMailAddress;
    }

    public void setWorkIsCardMailAddress(String workIsCardMailAddress) {
        this.workIsCardMailAddress = workIsCardMailAddress;
    }

    public String getCarBigSmj() {
        return carBigSmj;
    }

    public void setCarBigSmj(String carBigSmj) {
        this.carBigSmj = carBigSmj;
    }

    public Date getBankCommitDatetime() {
        return bankCommitDatetime;
    }

    public void setBankCommitDatetime(Date bankCommitDatetime) {
        this.bankCommitDatetime = bankCommitDatetime;
    }

    public String getBankCommitNote() {
        return bankCommitNote;
    }

    public void setBankCommitNote(String bankCommitNote) {
        this.bankCommitNote = bankCommitNote;
    }

    public String getRepayBankCode() {
        return repayBankCode;
    }

    public void setRepayBankCode(String repayBankCode) {
        this.repayBankCode = repayBankCode;
    }

    public String getRepayBankName() {
        return repayBankName;
    }

    public void setRepayBankName(String repayBankName) {
        this.repayBankName = repayBankName;
    }

    public String getRepaySubbranch() {
        return repaySubbranch;
    }

    public void setRepaySubbranch(String repaySubbranch) {
        this.repaySubbranch = repaySubbranch;
    }

    public String getRepayBankcardNumber() {
        return repayBankcardNumber;
    }

    public void setRepayBankcardNumber(String repayBankcardNumber) {
        this.repayBankcardNumber = repayBankcardNumber;
    }

    public int getRepayBillDate() {
        return repayBillDate;
    }

    public void setRepayBillDate(int repayBillDate) {
        this.repayBillDate = repayBillDate;
    }

    public int getRepayBankDate() {
        return repayBankDate;
    }

    public void setRepayBankDate(int repayBankDate) {
        this.repayBankDate = repayBankDate;
    }

    public Date getRepayCompanyDate() {
        return repayCompanyDate;
    }

    public void setRepayCompanyDate(Date repayCompanyDate) {
        this.repayCompanyDate = repayCompanyDate;
    }

    public Long getRepayFirstMonthAmount() {
        return repayFirstMonthAmount;
    }

    public void setRepayFirstMonthAmount(Long repayFirstMonthAmount) {
        this.repayFirstMonthAmount = repayFirstMonthAmount;
    }

    public Date getRepayFirstMonthDatetime() {
        return repayFirstMonthDatetime;
    }

    public void setRepayFirstMonthDatetime(Date repayFirstMonthDatetime) {
        this.repayFirstMonthDatetime = repayFirstMonthDatetime;
    }

    public Long getRepayMonthAmount() {
        return repayMonthAmount;
    }

    public void setRepayMonthAmount(Long repayMonthAmount) {
        this.repayMonthAmount = repayMonthAmount;
    }

    public Date getBankFkDatetime() {
        return bankFkDatetime;
    }

    public void setBankFkDatetime(Date bankFkDatetime) {
        this.bankFkDatetime = bankFkDatetime;
    }

    public String getReceiptBankCode() {
        return receiptBankCode;
    }

    public void setReceiptBankCode(String receiptBankCode) {
        this.receiptBankCode = receiptBankCode;
    }

    public String getReceiptBankName() {
        return receiptBankName;
    }

    public void setReceiptBankName(String receiptBankName) {
        this.receiptBankName = receiptBankName;
    }

    public String getReceiptBankcardNumber() {
        return receiptBankcardNumber;
    }

    public void setReceiptBankcardNumber(String receiptBankcardNumber) {
        this.receiptBankcardNumber = receiptBankcardNumber;
    }

    public String getReceiptPdf() {
        return receiptPdf;
    }

    public void setReceiptPdf(String receiptPdf) {
        this.receiptPdf = receiptPdf;
    }

    public String getReceiptRemark() {
        return receiptRemark;
    }

    public void setReceiptRemark(String receiptRemark) {
        this.receiptRemark = receiptRemark;
    }

    public Date getPledgeDatetime() {
        return pledgeDatetime;
    }

    public void setPledgeDatetime(Date pledgeDatetime) {
        this.pledgeDatetime = pledgeDatetime;
    }

    public String getGreenBigSmj() {
        return greenBigSmj;
    }

    public void setGreenBigSmj(String greenBigSmj) {
        this.greenBigSmj = greenBigSmj;
    }

    public Date getPledgeBankCommitDatetime() {
        return pledgeBankCommitDatetime;
    }

    public void setPledgeBankCommitDatetime(Date pledgeBankCommitDatetime) {
        this.pledgeBankCommitDatetime = pledgeBankCommitDatetime;
    }

    public String getPledgeBankCommitNote() {
        return pledgeBankCommitNote;
    }

    public void setPledgeBankCommitNote(String pledgeBankCommitNote) {
        this.pledgeBankCommitNote = pledgeBankCommitNote;
    }

    public String getEnterLocation() {
        return enterLocation;
    }

    public void setEnterLocation(String enterLocation) {
        this.enterLocation = enterLocation;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public String getCarEngineNo() {
        return carEngineNo;
    }

    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo;
    }

    public Date getMateZfbJourDatetimeStart() {
        return mateZfbJourDatetimeStart;
    }

    public void setMateZfbJourDatetimeStart(Date mateZfbJourDatetimeStart) {
        this.mateZfbJourDatetimeStart = mateZfbJourDatetimeStart;
    }

    public Date getMateZfbJourDatetimeEnd() {
        return mateZfbJourDatetimeEnd;
    }

    public void setMateZfbJourDatetimeEnd(Date mateZfbJourDatetimeEnd) {
        this.mateZfbJourDatetimeEnd = mateZfbJourDatetimeEnd;
    }

    public Long getMateZfbJourIncome() {
        return mateZfbJourIncome;
    }

    public void setMateZfbJourIncome(Long mateZfbJourIncome) {
        this.mateZfbJourIncome = mateZfbJourIncome;
    }

    public Long getMateZfbJourExpend() {
        return mateZfbJourExpend;
    }

    public void setMateZfbJourExpend(Long mateZfbJourExpend) {
        this.mateZfbJourExpend = mateZfbJourExpend;
    }

    public Long getMateZfbJourBalance() {
        return mateZfbJourBalance;
    }

    public void setMateZfbJourBalance(Long mateZfbJourBalance) {
        this.mateZfbJourBalance = mateZfbJourBalance;
    }

    public Long getMateZfbJourMonthIncome() {
        return mateZfbJourMonthIncome;
    }

    public void setMateZfbJourMonthIncome(Long mateZfbJourMonthIncome) {
        this.mateZfbJourMonthIncome = mateZfbJourMonthIncome;
    }

    public Long getMateZfbJourMonthExpend() {
        return mateZfbJourMonthExpend;
    }

    public void setMateZfbJourMonthExpend(Long mateZfbJourMonthExpend) {
        this.mateZfbJourMonthExpend = mateZfbJourMonthExpend;
    }

    public String getMateZfbJourPic() {
        return mateZfbJourPic;
    }

    public String getCarHgzPic() {
        return carHgzPic;
    }

    public void setCarHgzPic(String carHgzPic) {
        this.carHgzPic = carHgzPic;
    }

    public void setMateZfbJourPic(String mateZfbJourPic) {
        this.mateZfbJourPic = mateZfbJourPic;
    }

    public String getMateZfbJourRemark() {
        return mateZfbJourRemark;
    }

    public void setMateZfbJourRemark(String mateZfbJourRemark) {
        this.mateZfbJourRemark = mateZfbJourRemark;
    }

    public Date getMateWxJourDatetimeStart() {
        return mateWxJourDatetimeStart;
    }

    public void setMateWxJourDatetimeStart(Date mateWxJourDatetimeStart) {
        this.mateWxJourDatetimeStart = mateWxJourDatetimeStart;
    }

    public Date getMateWxJourDatetimeEnd() {
        return mateWxJourDatetimeEnd;
    }

    public void setMateWxJourDatetimeEnd(Date mateWxJourDatetimeEnd) {
        this.mateWxJourDatetimeEnd = mateWxJourDatetimeEnd;
    }

    public Long getMateWxJourIncome() {
        return mateWxJourIncome;
    }

    public void setMateWxJourIncome(Long mateWxJourIncome) {
        this.mateWxJourIncome = mateWxJourIncome;
    }

    public Long getMateWxJourExpend() {
        return mateWxJourExpend;
    }

    public void setMateWxJourExpend(Long mateWxJourExpend) {
        this.mateWxJourExpend = mateWxJourExpend;
    }

    public Long getTeamFee() {
        return teamFee;
    }

    public void setTeamFee(Long teamFee) {
        this.teamFee = teamFee;
    }

    public Long getMateWxJourBalance() {
        return mateWxJourBalance;
    }

    public void setMateWxJourBalance(Long mateWxJourBalance) {
        this.mateWxJourBalance = mateWxJourBalance;
    }

    public Long getMateWxJourMonthIncome() {
        return mateWxJourMonthIncome;
    }

    public void setMateWxJourMonthIncome(Long mateWxJourMonthIncome) {
        this.mateWxJourMonthIncome = mateWxJourMonthIncome;
    }

    public Long getMateWxJourMonthExpend() {
        return mateWxJourMonthExpend;
    }

    public void setMateWxJourMonthExpend(Long mateWxJourMonthExpend) {
        this.mateWxJourMonthExpend = mateWxJourMonthExpend;
    }

    public String getMateWxJourPic() {
        return mateWxJourPic;
    }

    public void setMateWxJourPic(String mateWxJourPic) {
        this.mateWxJourPic = mateWxJourPic;
    }

    public String getMateWxJourRemark() {
        return mateWxJourRemark;
    }

    public void setMateWxJourRemark(String mateWxJourRemark) {
        this.mateWxJourRemark = mateWxJourRemark;
    }

    public Date getMateJourDatetimeStart() {
        return mateJourDatetimeStart;
    }

    public void setMateJourDatetimeStart(Date mateJourDatetimeStart) {
        this.mateJourDatetimeStart = mateJourDatetimeStart;
    }

    public Date getMateJourDatetimeEnd() {
        return mateJourDatetimeEnd;
    }

    public void setMateJourDatetimeEnd(Date mateJourDatetimeEnd) {
        this.mateJourDatetimeEnd = mateJourDatetimeEnd;
    }

    public Long getMateJourIncome() {
        return mateJourIncome;
    }

    public void setMateJourIncome(Long mateJourIncome) {
        this.mateJourIncome = mateJourIncome;
    }

    public Long getMateJourExpend() {
        return mateJourExpend;
    }

    public void setMateJourExpend(Long mateJourExpend) {
        this.mateJourExpend = mateJourExpend;
    }

    public Long getMateJourBalance() {
        return mateJourBalance;
    }

    public void setMateJourBalance(Long mateJourBalance) {
        this.mateJourBalance = mateJourBalance;
    }

    public Long getMateJourMonthIncome() {
        return mateJourMonthIncome;
    }

    public void setMateJourMonthIncome(Long mateJourMonthIncome) {
        this.mateJourMonthIncome = mateJourMonthIncome;
    }

    public Long getMateJourMonthExpend() {
        return mateJourMonthExpend;
    }

    public void setMateJourMonthExpend(Long mateJourMonthExpend) {
        this.mateJourMonthExpend = mateJourMonthExpend;
    }

    public String getMateJourPic() {
        return mateJourPic;
    }

    public void setMateJourPic(String mateJourPic) {
        this.mateJourPic = mateJourPic;
    }

    public String getMateJourRemark() {
        return mateJourRemark;
    }

    public void setMateJourRemark(String mateJourRemark) {
        this.mateJourRemark = mateJourRemark;
    }

    public String getMateAssetPdf() {
        return mateAssetPdf;
    }

    public void setMateAssetPdf(String mateAssetPdf) {
        this.mateAssetPdf = mateAssetPdf;
    }

    public Date getGuaZfbJourDatetimeStart() {
        return guaZfbJourDatetimeStart;
    }

    public void setGuaZfbJourDatetimeStart(Date guaZfbJourDatetimeStart) {
        this.guaZfbJourDatetimeStart = guaZfbJourDatetimeStart;
    }

    public Date getGuaZfbJourDatetimeEnd() {
        return guaZfbJourDatetimeEnd;
    }

    public void setGuaZfbJourDatetimeEnd(Date guaZfbJourDatetimeEnd) {
        this.guaZfbJourDatetimeEnd = guaZfbJourDatetimeEnd;
    }

    public Long getGuaZfbJourIncome() {
        return guaZfbJourIncome;
    }

    public void setGuaZfbJourIncome(Long guaZfbJourIncome) {
        this.guaZfbJourIncome = guaZfbJourIncome;
    }

    public Long getGuaZfbJourExpend() {
        return guaZfbJourExpend;
    }

    public void setGuaZfbJourExpend(Long guaZfbJourExpend) {
        this.guaZfbJourExpend = guaZfbJourExpend;
    }

    public Long getGuaZfbJourBalance() {
        return guaZfbJourBalance;
    }

    public void setGuaZfbJourBalance(Long guaZfbJourBalance) {
        this.guaZfbJourBalance = guaZfbJourBalance;
    }

    public Long getGuaZfbJourMonthIncome() {
        return guaZfbJourMonthIncome;
    }

    public void setGuaZfbJourMonthIncome(Long guaZfbJourMonthIncome) {
        this.guaZfbJourMonthIncome = guaZfbJourMonthIncome;
    }

    public Long getGuaZfbJourMonthExpend() {
        return guaZfbJourMonthExpend;
    }

    public void setGuaZfbJourMonthExpend(Long guaZfbJourMonthExpend) {
        this.guaZfbJourMonthExpend = guaZfbJourMonthExpend;
    }

    public String getGuaZfbJourPic() {
        return guaZfbJourPic;
    }

    public void setGuaZfbJourPic(String guaZfbJourPic) {
        this.guaZfbJourPic = guaZfbJourPic;
    }

    public String getGuaZfbJourRemark() {
        return guaZfbJourRemark;
    }

    public void setGuaZfbJourRemark(String guaZfbJourRemark) {
        this.guaZfbJourRemark = guaZfbJourRemark;
    }

    public Date getGuaWxJourDatetimeStart() {
        return guaWxJourDatetimeStart;
    }

    public void setGuaWxJourDatetimeStart(Date guaWxJourDatetimeStart) {
        this.guaWxJourDatetimeStart = guaWxJourDatetimeStart;
    }

    public Date getGuaWxJourDatetimeEnd() {
        return guaWxJourDatetimeEnd;
    }

    public void setGuaWxJourDatetimeEnd(Date guaWxJourDatetimeEnd) {
        this.guaWxJourDatetimeEnd = guaWxJourDatetimeEnd;
    }

    public Long getGuaWxJourIncome() {
        return guaWxJourIncome;
    }

    public void setGuaWxJourIncome(Long guaWxJourIncome) {
        this.guaWxJourIncome = guaWxJourIncome;
    }

    public Long getGuaWxJourExpend() {
        return guaWxJourExpend;
    }

    public void setGuaWxJourExpend(Long guaWxJourExpend) {
        this.guaWxJourExpend = guaWxJourExpend;
    }

    public Long getGuaWxJourBalance() {
        return guaWxJourBalance;
    }

    public void setGuaWxJourBalance(Long guaWxJourBalance) {
        this.guaWxJourBalance = guaWxJourBalance;
    }

    public Long getGuaWxJourMonthIncome() {
        return guaWxJourMonthIncome;
    }

    public void setGuaWxJourMonthIncome(Long guaWxJourMonthIncome) {
        this.guaWxJourMonthIncome = guaWxJourMonthIncome;
    }

    public Long getGuaWxJourMonthExpend() {
        return guaWxJourMonthExpend;
    }

    public void setGuaWxJourMonthExpend(Long guaWxJourMonthExpend) {
        this.guaWxJourMonthExpend = guaWxJourMonthExpend;
    }

    public String getGuaWxJourPic() {
        return guaWxJourPic;
    }

    public void setGuaWxJourPic(String guaWxJourPic) {
        this.guaWxJourPic = guaWxJourPic;
    }

    public String getGuaWxJourRemark() {
        return guaWxJourRemark;
    }

    public void setGuaWxJourRemark(String guaWxJourRemark) {
        this.guaWxJourRemark = guaWxJourRemark;
    }

    public Date getGuaJourDatetimeStart() {
        return guaJourDatetimeStart;
    }

    public String getMateZfbJourInterest() {
        return mateZfbJourInterest;
    }

    public void setMateZfbJourInterest(String mateZfbJourInterest) {
        this.mateZfbJourInterest = mateZfbJourInterest;
    }

    public String getMateWxJourInterest() {
        return mateWxJourInterest;
    }

    public void setMateWxJourInterest(String mateWxJourInterest) {
        this.mateWxJourInterest = mateWxJourInterest;
    }

    public String getMateJourInterest() {
        return mateJourInterest;
    }

    public void setMateJourInterest(String mateJourInterest) {
        this.mateJourInterest = mateJourInterest;
    }

    public String getGuaZfbJourInterest() {
        return guaZfbJourInterest;
    }

    public void setGuaZfbJourInterest(String guaZfbJourInterest) {
        this.guaZfbJourInterest = guaZfbJourInterest;
    }

    public String getGuaWxJourInterest() {
        return guaWxJourInterest;
    }

    public void setGuaWxJourInterest(String guaWxJourInterest) {
        this.guaWxJourInterest = guaWxJourInterest;
    }

    public String getGuaJourInterest() {
        return guaJourInterest;
    }

    public void setGuaJourInterest(String guaJourInterest) {
        this.guaJourInterest = guaJourInterest;
    }

    public String getZfbJourInterest() {
        return zfbJourInterest;
    }

    public void setZfbJourInterest(String zfbJourInterest) {
        this.zfbJourInterest = zfbJourInterest;
    }

    public String getWxJourInterest() {
        return wxJourInterest;
    }

    public void setWxJourInterest(String wxJourInterest) {
        this.wxJourInterest = wxJourInterest;
    }

    public String getJourInterest() {
        return jourInterest;
    }

    public void setJourInterest(String jourInterest) {
        this.jourInterest = jourInterest;
    }

    public void setGuaJourDatetimeStart(Date guaJourDatetimeStart) {
        this.guaJourDatetimeStart = guaJourDatetimeStart;
    }

    public Date getGuaJourDatetimeEnd() {
        return guaJourDatetimeEnd;
    }

    public void setGuaJourDatetimeEnd(Date guaJourDatetimeEnd) {
        this.guaJourDatetimeEnd = guaJourDatetimeEnd;
    }

    public Long getGuaJourIncome() {
        return guaJourIncome;
    }

    public void setGuaJourIncome(Long guaJourIncome) {
        this.guaJourIncome = guaJourIncome;
    }

    public Long getGuaJourExpend() {
        return guaJourExpend;
    }

    public void setGuaJourExpend(Long guaJourExpend) {
        this.guaJourExpend = guaJourExpend;
    }

    public Long getGuaJourBalance() {
        return guaJourBalance;
    }

    public void setGuaJourBalance(Long guaJourBalance) {
        this.guaJourBalance = guaJourBalance;
    }

    public String getDriveLicense() {
        return driveLicense;
    }

    public void setDriveLicense(String driveLicense) {
        this.driveLicense = driveLicense;
    }

    public String getEvaluateColumn() {
        return evaluateColumn;
    }

    public void setEvaluateColumn(String evaluateColumn) {
        this.evaluateColumn = evaluateColumn;
    }

    public Long getGuaJourMonthIncome() {
        return guaJourMonthIncome;
    }

    public void setGuaJourMonthIncome(Long guaJourMonthIncome) {
        this.guaJourMonthIncome = guaJourMonthIncome;
    }

    public Long getGuaJourMonthExpend() {
        return guaJourMonthExpend;
    }

    public void setGuaJourMonthExpend(Long guaJourMonthExpend) {
        this.guaJourMonthExpend = guaJourMonthExpend;
    }

    public String getGuaJourPic() {
        return guaJourPic;
    }

    public void setGuaJourPic(String guaJourPic) {
        this.guaJourPic = guaJourPic;
    }

    public String getGuaJourRemark() {
        return guaJourRemark;
    }

    public void setGuaJourRemark(String guaJourRemark) {
        this.guaJourRemark = guaJourRemark;
    }

    public String getGuaAssetPdf() {
        return guaAssetPdf;
    }

    public void setGuaAssetPdf(String guaAssetPdf) {
        this.guaAssetPdf = guaAssetPdf;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getZfbJourDatetimeStart() {
        return zfbJourDatetimeStart;
    }

    public void setZfbJourDatetimeStart(Date zfbJourDatetimeStart) {
        this.zfbJourDatetimeStart = zfbJourDatetimeStart;
    }

    public Date getZfbJourDatetimeEnd() {
        return zfbJourDatetimeEnd;
    }

    public void setZfbJourDatetimeEnd(Date zfbJourDatetimeEnd) {
        this.zfbJourDatetimeEnd = zfbJourDatetimeEnd;
    }

    public Long getZfbJourIncome() {
        return zfbJourIncome;
    }

    public void setZfbJourIncome(Long zfbJourIncome) {
        this.zfbJourIncome = zfbJourIncome;
    }

    public Long getZfbJourExpend() {
        return zfbJourExpend;
    }

    public void setZfbJourExpend(Long zfbJourExpend) {
        this.zfbJourExpend = zfbJourExpend;
    }

    public Long getZfbJourBalance() {
        return zfbJourBalance;
    }

    public void setZfbJourBalance(Long zfbJourBalance) {
        this.zfbJourBalance = zfbJourBalance;
    }

    public Long getZfbJourMonthIncome() {
        return zfbJourMonthIncome;
    }

    public void setZfbJourMonthIncome(Long zfbJourMonthIncome) {
        this.zfbJourMonthIncome = zfbJourMonthIncome;
    }

    public Long getZfbJourMonthExpend() {
        return zfbJourMonthExpend;
    }

    public void setZfbJourMonthExpend(Long zfbJourMonthExpend) {
        this.zfbJourMonthExpend = zfbJourMonthExpend;
    }

    public String getZfbJourPic() {
        return zfbJourPic;
    }

    public void setZfbJourPic(String zfbJourPic) {
        this.zfbJourPic = zfbJourPic;
    }

    public String getZfbJourRemark() {
        return zfbJourRemark;
    }

    public void setZfbJourRemark(String zfbJourRemark) {
        this.zfbJourRemark = zfbJourRemark;
    }

    public Date getWxJourDatetimeStart() {
        return wxJourDatetimeStart;
    }

    public void setWxJourDatetimeStart(Date wxJourDatetimeStart) {
        this.wxJourDatetimeStart = wxJourDatetimeStart;
    }

    public Date getWxJourDatetimeEnd() {
        return wxJourDatetimeEnd;
    }

    public void setWxJourDatetimeEnd(Date wxJourDatetimeEnd) {
        this.wxJourDatetimeEnd = wxJourDatetimeEnd;
    }

    public Long getWxJourIncome() {
        return wxJourIncome;
    }

    public void setWxJourIncome(Long wxJourIncome) {
        this.wxJourIncome = wxJourIncome;
    }

    public Long getWxJourExpend() {
        return wxJourExpend;
    }

    public void setWxJourExpend(Long wxJourExpend) {
        this.wxJourExpend = wxJourExpend;
    }

    public Long getWxJourBalance() {
        return wxJourBalance;
    }

    public void setWxJourBalance(Long wxJourBalance) {
        this.wxJourBalance = wxJourBalance;
    }

    public Long getWxJourMonthIncome() {
        return wxJourMonthIncome;
    }

    public void setWxJourMonthIncome(Long wxJourMonthIncome) {
        this.wxJourMonthIncome = wxJourMonthIncome;
    }

    public Long getWxJourMonthExpend() {
        return wxJourMonthExpend;
    }

    public void setWxJourMonthExpend(Long wxJourMonthExpend) {
        this.wxJourMonthExpend = wxJourMonthExpend;
    }

    public String getWxJourPic() {
        return wxJourPic;
    }

    public void setWxJourPic(String wxJourPic) {
        this.wxJourPic = wxJourPic;
    }

    public String getWxJourRemark() {
        return wxJourRemark;
    }

    public void setWxJourRemark(String wxJourRemark) {
        this.wxJourRemark = wxJourRemark;
    }

    public String getJourPic() {
        return jourPic;
    }

    public void setJourPic(String jourPic) {
        this.jourPic = jourPic;
    }

    public String getAssetPdf() {
        return assetPdf;
    }

    public void setAssetPdf(String assetPdf) {
        this.assetPdf = assetPdf;
    }

    public String getWorkCompanyProperty() {
        return workCompanyProperty;
    }

    public void setWorkCompanyProperty(String workCompanyProperty) {
        this.workCompanyProperty = workCompanyProperty;
    }

    public String getWorkBelongIndustry() {
        return workBelongIndustry;
    }

    public void setWorkBelongIndustry(String workBelongIndustry) {
        this.workBelongIndustry = workBelongIndustry;
    }

    public String getWorkProfession() {
        return workProfession;
    }

    public void setWorkProfession(String workProfession) {
        this.workProfession = workProfession;
    }

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getBackAdvanceAmount() {
        return backAdvanceAmount;
    }

    public void setBackAdvanceAmount(String backAdvanceAmount) {
        this.backAdvanceAmount = backAdvanceAmount;
    }

    public String getBackAdvanceAccount() {
        return backAdvanceAccount;
    }

    public void setBackAdvanceAccount(String backAdvanceAccount) {
        this.backAdvanceAccount = backAdvanceAccount;
    }

    public String getBackAdvanceOpenBank() {
        return backAdvanceOpenBank;
    }

    public void setBackAdvanceOpenBank(String backAdvanceOpenBank) {
        this.backAdvanceOpenBank = backAdvanceOpenBank;
    }

    public String getBackAdvanceSubbranch() {
        return backAdvanceSubbranch;
    }

    public void setBackAdvanceSubbranch(String backAdvanceSubbranch) {
        this.backAdvanceSubbranch = backAdvanceSubbranch;
    }

    public String getBackAdvanceWaterBill() {
        return backAdvanceWaterBill;
    }

    public void setBackAdvanceWaterBill(String backAdvanceWaterBill) {
        this.backAdvanceWaterBill = backAdvanceWaterBill;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

}
