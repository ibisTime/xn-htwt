package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 业务报表
 * @author: jiafr 
 * @since: 2018年7月11日 下午3:56:40 
 * @history:
 */
public class XN632915Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String applyUserName;// 客户姓名

    private String bizType;// 业务种类

    private String loanPeriod;// 贷款期限

    private String curNodeCode;// 贷款进度

    @NotBlank
    private String userId;// 用户编号

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
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
