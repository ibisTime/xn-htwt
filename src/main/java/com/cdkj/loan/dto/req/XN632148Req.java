package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class XN632148Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String code;// 业务编号

    // 还款业务编号
    private String repayBizCode;

    private String applyUserName;// 客户姓名

    private String applyDatetimeStart;// 申请时间起始

    private String applyDatetimeEnd;// 申请时间结束

    private String saleUserId;// 业务员用户编号

    private String companyCode;// 公司编号

    private String curNodeCode;// 当前节点编号

    private String intevCurNodeCode;

    private String advanfCurNodeCode;

    private List<String> curNodeCodeList;// 当前节点编号

    private List<String> intevCurNodeCodeList;

    private List<String> advanfCurNodeCodeList;

    private String isAdvanceFund;// 是否垫资

    private String isEntryMortgage;// 是否录入发保合
    // 是否面签完成

    private String isInterview;

    // 入档位置
    private String enterLocation;

    // 是否安装了GPS(1是，0否)
    private String isGpsAz;

    @NotBlank
    private String roleCode;// 角色编号

    private String keyword; // 关键字

    private String userId; // 操作人

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

    public String getAdvanfCurNodeCode() {
        return advanfCurNodeCode;
    }

    public void setAdvanfCurNodeCode(String advanfCurNodeCode) {
        this.advanfCurNodeCode = advanfCurNodeCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsEntryMortgage() {
        return isEntryMortgage;
    }

    public void setIsEntryMortgage(String isEntryMortgage) {
        this.isEntryMortgage = isEntryMortgage;
    }

    public String getIsInterview() {
        return isInterview;
    }

    public void setIsInterview(String isInterview) {
        this.isInterview = isInterview;
    }

    public List<String> getIntevCurNodeCodeList() {
        return intevCurNodeCodeList;
    }

    public void setIntevCurNodeCodeList(List<String> intevCurNodeCodeList) {
        this.intevCurNodeCodeList = intevCurNodeCodeList;
    }

    public List<String> getAdvanfCurNodeCodeList() {
        return advanfCurNodeCodeList;
    }

    public void setAdvanfCurNodeCodeList(List<String> advanfCurNodeCodeList) {
        this.advanfCurNodeCodeList = advanfCurNodeCodeList;
    }

    public String getEnterLocation() {
        return enterLocation;
    }

    public void setEnterLocation(String enterLocation) {
        this.enterLocation = enterLocation;
    }

    public String getIsGpsAz() {
        return isGpsAz;
    }

    public void setIsGpsAz(String isGpsAz) {
        this.isGpsAz = isGpsAz;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getRepayBizCode() {
        return repayBizCode;
    }

    public void setRepayBizCode(String repayBizCode) {
        this.repayBizCode = repayBizCode;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getCurNodeCodeList() {
        return curNodeCodeList;
    }

    public void setCurNodeCodeList(List<String> curNodeCodeList) {
        this.curNodeCodeList = curNodeCodeList;
    }

    public String getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(String applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public String getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(String applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
