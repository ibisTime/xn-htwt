package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 调查报告-风控专员审核
 * @author: CYL 
 * @since: 2018年7月5日 下午6:46:20 
 * @history:
 */
public class XN632201Req {

    @NotBlank
    private String code;// 调查报告编号

    @NotBlank
    private String approveResult;// 审核结果

    private String approveNote;// 审核说明

    @NotBlank
    private String updater;// 操作人

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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

}
