package com.cdkj.loan.dto.req;

/**
 * 征信修改（征信人员）
 * @author: jiafr 
 * @since: 2018年5月29日 下午11:16:15 
 * @history:
 */
public class XN632112ReqCreditUser {

    // 征信人员编号
    private String code;

    // 姓名
    private String userName;

    // 与借款人关系
    private String relation;

    // 贷款角色
    private String loanRole;

    // 身份证号
    private String idNo;

    // 手机号
    private String mobile;

    // 身份证正面
    private String idFront;

    // 身份证反面
    private String idReverse;

    // 征信查询授权书
    private String authPdf;

    // 面签照片
    private String interviewPic;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLoanRole() {
        return loanRole;
    }

    public void setLoanRole(String loanRole) {
        this.loanRole = loanRole;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdNoFront() {
        return idFront;
    }

    public void setIdNoFront(String idNoFront) {
        this.idFront = idNoFront;
    }

    public String getIdNoReverse() {
        return idReverse;
    }

    public void setIdNoReverse(String idNoReverse) {
        this.idReverse = idNoReverse;
    }

    public String getAuthPdf() {
        return authPdf;
    }

    public void setAuthPdf(String authPdf) {
        this.authPdf = authPdf;
    }

    public String getInterviewPic() {
        return interviewPic;
    }

    public void setInterviewPic(String interviewPic) {
        this.interviewPic = interviewPic;
    }

}
