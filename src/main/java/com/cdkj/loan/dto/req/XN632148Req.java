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

    private String teamCode;// 团队编号

    private List<String> curNodeCodeList;// 当前节点编号

    private String isAdvanceFund;// 是否垫资

    // 入档位置
    private String enterLocation;

    public String getEnterLocation() {
        return enterLocation;
    }

    public void setEnterLocation(String enterLocation) {
        this.enterLocation = enterLocation;
    }

    // 是否安装了GPS(1是，0否)
    private String isGpsAz;

    @NotBlank
    private String roleCode;// 角色编号

    private String keyword; // 关键字

    private String operator; // 操作人

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
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
