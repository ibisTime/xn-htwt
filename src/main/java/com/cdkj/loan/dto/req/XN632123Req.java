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

    // 公司视频
    @NotBlank
    private String companyVideo;

    @NotBlank
    private String interviewContract;// 面签合同

    @NotBlank
    private String operator;// 操作人

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getInterviewContract() {
        return interviewContract;
    }

    public void setInterviewContract(String interviewContract) {
        this.interviewContract = interviewContract;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
