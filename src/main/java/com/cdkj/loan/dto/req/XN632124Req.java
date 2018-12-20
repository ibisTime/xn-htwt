package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 内勤确认
 * @author: CYL 
 * @since: 2018年11月8日 下午4:05:51 
 * @history:
 */
public class XN632124Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String approveNote;// 审核说明

    // 代理人
    @NotBlank
    private String pledgeUser;

    // 代理人身份证复印件
    private String pledgeUserIdCardCopy;

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPledgeUser() {
        return pledgeUser;
    }

    public void setPledgeUser(String pledgeUser) {
        this.pledgeUser = pledgeUser;
    }

    public String getPledgeUserIdCardCopy() {
        return pledgeUserIdCardCopy;
    }

    public void setPledgeUserIdCardCopy(String pledgeUserIdCardCopy) {
        this.pledgeUserIdCardCopy = pledgeUserIdCardCopy;
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
