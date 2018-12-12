package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

import com.cdkj.loan.domain.CreditUser;

/**
 * 风控专员审核
 * @author: jiafr 
 * @since: 2018年5月26日 下午9:14:21 
 * @history:
 */
public class XN632113Req {

    // 征信单编号
    @NotBlank
    private String code;

    // 征信人列表
    private List<CreditUser> creditUserList;

    // 审核结果
    @NotBlank
    private String approveResult;

    // 审核说明
    private String approveNote;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CreditUser> getCreditUserList() {
        return creditUserList;
    }

    public void setCreditUserList(List<CreditUser> creditUserList) {
        this.creditUserList = creditUserList;
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
