package com.cdkj.loan.dto.req;

public class XN632910Req {

    // 业务编号
    private String code;

    // 客户姓名
    private String applyUserName;

    // 所属区域
    private String region;

    // 贷款银行编号（支行编号）
    private String loanBank;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getLoanBank() {
        return loanBank;
    }

    public void setLoanBank(String loanBank) {
        this.loanBank = loanBank;
    }

}
