package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-风控专员审核
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:17:30 
 * @history:
 */
public class XN632540Req {

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
