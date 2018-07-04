package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 准入单区域经理审核
 * @author: jiafr 
 * @since: 2018年7月4日 下午3:55:40 
 * @history:
 */
public class XN632140Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String approveResult;// 审核结果

    private String approveNote;// 审核说明

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

}
