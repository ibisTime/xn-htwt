package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 征信派单
 * @author: CYL 
 * @since: 2018年9月29日 上午11:31:51 
 * @history:
 */
public class XN632119Req {

    // 征信单编号
    @NotBlank
    private String bizCode;

    // 内勤
    @NotBlank
    private String insideJob;

    // 操作人
    @NotBlank
    private String operator;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getInsideJob() {
        return insideJob;
    }

    public void setInsideJob(String insideJob) {
        this.insideJob = insideJob;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
