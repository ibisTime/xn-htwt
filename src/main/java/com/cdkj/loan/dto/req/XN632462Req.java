package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 省分公司总经理审核
 * @author: silver 
 * @since: Apr 26, 2019 11:08:42 AM 
 * @history:
 */
public class XN632462Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operator;

    @NotBlank
    private String approveResult;

    private String approveNote;

    private List<XN632462ReqMission> missionList;

    public List<XN632462ReqMission> getMissionList() {
        return missionList;
    }

    public void setMissionList(List<XN632462ReqMission> missionList) {
        this.missionList = missionList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

}
