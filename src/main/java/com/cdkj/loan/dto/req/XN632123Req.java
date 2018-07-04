package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-面签
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:28:08 
 * @history:
 */
public class XN632123Req {

    @NotBlank
    private String code;// 预算单编号

    // 银行视频
    @NotBlank
    private String bankVideo;

    // 银行面签照片
    private String bankPhoto;

    // 公司视频
    @NotBlank
    private String companyVideo;

    // 公司合同
    private String companyContract;

    // 银行合同
    private String bankContract;

    // 资金划转授权书
    private String advanceFundAmountPdf;

    // 其他视频
    private String otherVideo;

    // 面签其他资料
    private String interviewOtherPdf;

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOtherVideo() {
        return otherVideo;
    }

    public void setOtherVideo(String otherVideo) {
        this.otherVideo = otherVideo;
    }

    public String getBankPhoto() {
        return bankPhoto;
    }

    public void setBankPhoto(String bankPhoto) {
        this.bankPhoto = bankPhoto;
    }

    public String getCompanyContract() {
        return companyContract;
    }

    public void setCompanyContract(String companyContract) {
        this.companyContract = companyContract;
    }

    public String getBankContract() {
        return bankContract;
    }

    public void setBankContract(String bankContract) {
        this.bankContract = bankContract;
    }

    public String getAdvanceFundAmountPdf() {
        return advanceFundAmountPdf;
    }

    public void setAdvanceFundAmountPdf(String advanceFundAmountPdf) {
        this.advanceFundAmountPdf = advanceFundAmountPdf;
    }

    public String getInterviewOtherPdf() {
        return interviewOtherPdf;
    }

    public void setInterviewOtherPdf(String interviewOtherPdf) {
        this.interviewOtherPdf = interviewOtherPdf;
    }

    public String getBankVideo() {
        return bankVideo;
    }

    public void setBankVideo(String bankVideo) {
        this.bankVideo = bankVideo;
    }

    public String getCompanyVideo() {
        return companyVideo;
    }

    public void setCompanyVideo(String companyVideo) {
        this.companyVideo = companyVideo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
