package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import com.cdkj.loan.dto.res.CarInfoRes;
import com.cdkj.loan.dto.res.LoanInfoRes;
import java.util.Date;
import java.util.List;

/**
 * 车贷业务
 *
 * @author: tao
 * @since: 2019-04-02 16:54:29
 * @history:
 */
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

    // 卡邮寄地址
    private String cardPostAddress;

    // 主线状态
    private String status;

    // 制卡状态
    private String makeCardStatus;

    // 面签状态
    private String mqStatus;

    // 发保合GPS状态
    private String fbhgpsStatus;

    // 第一次存档状态
    private String fircundangStatus;

    // 第二次存档状态
    private String seccundangStatus;

    // 作废状态
    private String zfStatus;

    // 当前节点编号
    private String curNodeCode;

    // 面签节点编号
    private String intevCurNodeCode;

    // 制卡节点
    private String makeCardNode;

    // 发保合gps节点
    private String fbhgpsNode;

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
    private String saleUserPositionName;

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

    // 手续费
    private BudgetOrderFee budgetOrderFee;

    public BudgetOrderFee getBudgetOrderFee() {
        return budgetOrderFee;
    }

    public void setBudgetOrderFee(BudgetOrderFee budgetOrderFee) {
        this.budgetOrderFee = budgetOrderFee;
    }

    public List<Repoint> getRepointList() {
        return repointList;
    }

    public void setRepointList(List<Repoint> repointList) {
        this.repointList = repointList;
    }

    public Advance getAdvance() {
        return advance;
    }

    public void setAdvance(Advance advance) {
        this.advance = advance;
    }

    public LoanInfoRes getLoanInfo() {
        return loanInfo;
    }

    public void setLoanInfo(LoanInfoRes loanInfo) {
        this.loanInfo = loanInfo;
    }

    public CarInfoRes getCarInfoRes() {
        return carInfoRes;
    }

    public void setCarInfoRes(CarInfoRes carInfoRes) {
        this.carInfoRes = carInfoRes;
    }

    public CarPledge getCarPledge() {
        return carPledge;
    }

    public void setCarPledge(CarPledge carPledge) {
        this.carPledge = carPledge;
    }

    public RepayBiz getRepayBiz() {
        return repayBiz;
    }

    public void setRepayBiz(RepayBiz repayBiz) {
        this.repayBiz = repayBiz;
    }

    public CreditUserExt getCreditUserExt() {
        return creditUserExt;
    }

    public void setCreditUserExt(CreditUserExt creditUserExt) {
        this.creditUserExt = creditUserExt;
    }

    public List<CreditJour> getCreditJours() {
        return creditJours;
    }

    public void setCreditJours(List<CreditJour> creditJours) {
        this.creditJours = creditJours;
    }

    public CarInfo getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(CarInfo carInfo) {
        this.carInfo = carInfo;
    }

    public List<CreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<CreditUser> creditUserList) {
        this.creditUserList = creditUserList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
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

    public String getLoanBankName() {
        return loanBankName;
    }

    public void setLoanBankName(String loanBankName) {
        this.loanBankName = loanBankName;
    }

    public CreditUser getCreditUser() {
        return creditUser;
    }

    public void setCreditUser(CreditUser creditUser) {
        this.creditUser = creditUser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public List<String> getIntevCurNodeCodeList() {
        return intevCurNodeCodeList;
    }

    public void setIntevCurNodeCodeList(List<String> intevCurNodeCodeList) {
        this.intevCurNodeCodeList = intevCurNodeCodeList;
    }

    public List<String> getMakeCardNodeList() {
        return makeCardNodeList;
    }

    public void setMakeCardNodeList(List<String> makeCardNodeList) {
        this.makeCardNodeList = makeCardNodeList;
    }

    public List<String> getFbhgpsNodeList() {
        return fbhgpsNodeList;
    }

    public void setFbhgpsNodeList(List<String> fbhgpsNodeList) {
        this.fbhgpsNodeList = fbhgpsNodeList;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<BizTask> getBizTasks() {
        return bizTasks;
    }

    public void setBizTasks(List<BizTask> bizTasks) {
        this.bizTasks = bizTasks;
    }

    public List<SYSBizLog> getBizLogs() {
        return bizLogs;
    }

    public void setBizLogs(List<SYSBizLog> bizLogs) {
        this.bizLogs = bizLogs;
    }

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public BudgetOrder getBudgetOrder() {
        return budgetOrder;
    }

    public void setBudgetOrder(BudgetOrder budgetOrder) {
        this.budgetOrder = budgetOrder;
    }

    public SYSUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SYSUser sysUser) {
        this.sysUser = sysUser;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setMqStatus(String mqStatus) {
        this.mqStatus = mqStatus;
    }

    public String getMqStatus() {
        return mqStatus;
    }

    public void setFbhgpsStatus(String fbhgpsStatus) {
        this.fbhgpsStatus = fbhgpsStatus;
    }

    public String getFbhgpsStatus() {
        return fbhgpsStatus;
    }

    public void setFircundangStatus(String fircundangStatus) {
        this.fircundangStatus = fircundangStatus;
    }

    public String getFircundangStatus() {
        return fircundangStatus;
    }

    public void setSeccundangStatus(String seccundangStatus) {
        this.seccundangStatus = seccundangStatus;
    }

    public String getSeccundangStatus() {
        return seccundangStatus;
    }

    public void setZfStatus(String zfStatus) {
        this.zfStatus = zfStatus;
    }

    public String getZfStatus() {
        return zfStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCaptainCode() {
        return captainCode;
    }

    public void setCaptainCode(String captainCode) {
        this.captainCode = captainCode;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getInsideJob() {
        return insideJob;
    }

    public void setInsideJob(String insideJob) {
        this.insideJob = insideJob;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

    public Long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getEnterLocation() {
        return enterLocation;
    }

    public void setEnterLocation(String enterLocation) {
        this.enterLocation = enterLocation;
    }

    public Date getEnterDatetime() {
        return enterDatetime;
    }

    public void setEnterDatetime(Date enterDatetime) {
        this.enterDatetime = enterDatetime;
    }

    public String getEnterFilelist() {
        return enterFilelist;
    }

    public void setEnterFilelist(String enterFilelist) {
        this.enterFilelist = enterFilelist;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getIntevCurNodeCode() {
        return intevCurNodeCode;
    }

    public void setIntevCurNodeCode(String intevCurNodeCode) {
        this.intevCurNodeCode = intevCurNodeCode;
    }

    public String getMakeCardNode() {
        return makeCardNode;
    }

    public void setMakeCardNode(String makeCardNode) {
        this.makeCardNode = makeCardNode;
    }

    public String getFbhgpsNode() {
        return fbhgpsNode;
    }

    public void setFbhgpsNode(String fbhgpsNode) {
        this.fbhgpsNode = fbhgpsNode;
    }

    public String getCancelNodeCode() {
        return cancelNodeCode;
    }

    public void setCancelNodeCode(String cancelNodeCode) {
        this.cancelNodeCode = cancelNodeCode;
    }

    public String getIsGpsAz() {
        return isGpsAz;
    }

    public void setIsGpsAz(String isGpsAz) {
        this.isGpsAz = isGpsAz;
    }

    public String getIsFinacing() {
        return isFinacing;
    }

    public void setIsFinacing(String isFinacing) {
        this.isFinacing = isFinacing;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getIsPlatInsure() {
        return isPlatInsure;
    }

    public void setIsPlatInsure(String isPlatInsure) {
        this.isPlatInsure = isPlatInsure;
    }

    public Long getShouldFeeAmount() {
        return shouldFeeAmount;
    }

    public void setShouldFeeAmount(Long shouldFeeAmount) {
        this.shouldFeeAmount = shouldFeeAmount;
    }

    public Long getRealFeeAmount() {
        return realFeeAmount;
    }

    public void setRealFeeAmount(Long realFeeAmount) {
        this.realFeeAmount = realFeeAmount;
    }

    public String getGuaMode() {
        return guaMode;
    }

    public void setGuaMode(String guaMode) {
        this.guaMode = guaMode;
    }

    public String getCreditNote() {
        return creditNote;
    }

    public void setCreditNote(String creditNote) {
        this.creditNote = creditNote;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public String getMakeCardStatus() {
        return makeCardStatus;
    }

    public void setMakeCardStatus(String makeCardStatus) {
        this.makeCardStatus = makeCardStatus;
    }

    public String getSecondCarReport() {
        return secondCarReport;
    }

    public void setSecondCarReport(String secondCarReport) {
        this.secondCarReport = secondCarReport;
    }

    public String getXszFront() {
        return xszFront;
    }

    public void setXszFront(String xszFront) {
        this.xszFront = xszFront;
    }

    public String getXszReverse() {
        return xszReverse;
    }

    public void setXszReverse(String xszReverse) {
        this.xszReverse = xszReverse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardPostAddress() {
        return cardPostAddress;
    }

    public void setCardPostAddress(String cardPostAddress) {
        this.cardPostAddress = cardPostAddress;
    }

    public String getRepayCardNumber() {
        return repayCardNumber;
    }

    public void setRepayCardNumber(String repayCardNumber) {
        this.repayCardNumber = repayCardNumber;
    }

    public List<String> getCundangStatusList() {
        return cundangStatusList;
    }

    public void setCundangStatusList(List<String> cundangStatusList) {
        this.cundangStatusList = cundangStatusList;
    }

}
