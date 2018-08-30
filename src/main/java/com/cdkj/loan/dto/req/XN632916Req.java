package com.cdkj.loan.dto.req;

/**
 * 团队报表
 * @author: jiafr 
 * @since: 2018年7月11日 下午1:57:40 
 * @history:
 */
public class XN632916Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String applyUserName;// 客户姓名

    private String bizType;// 业务种类

    private String loanPeriod;// 贷款期限

    private String teamCode;// 团队编号

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
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

}
