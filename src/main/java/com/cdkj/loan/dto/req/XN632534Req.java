package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-工作情况
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632534Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    @NotBlank
    // 处理类型(0 保存 1 发送)
    private String dealType;

    /***************工作情况start**************/

    // 是否自己单位
    @NotBlank
    private String isSelfCompany;// creditUserExt

    // 所属行业
    private String workBelongIndustry;// creditUserExt

    // 单位性质
    @NotBlank
    private String workCompanyProperty;// creditUserExt

    // 工作单位名称
    @NotBlank
    private String workCompanyName;// creditUser

    // 工作单位地址
    @NotBlank
    private String workCompanyAddress;// creditUser

    // 工作单位电话
    private String workPhone;// creditUser

    // 何时进入现单位工作
    private String workDatetime;// creditUserExt

    // 职位
    private String position;// creditUserExt

    // 月收入
    @NotBlank
    private String monthIncome;// creditUserExt

    // 收入证明
    private String improvePdf;

    // 单位前台照片
    private String frontTablePic;

    // 单位场地照片
    private String workPlacePic;

    // 业务员与客户合影
    private String salerAndcustomer;

    // 工作描述及还款来源分析
    private String otherWorkNote;

    /****************工作情况end***************/

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

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getIsSelfCompany() {
        return isSelfCompany;
    }

    public void setIsSelfCompany(String isSelfCompany) {
        this.isSelfCompany = isSelfCompany;
    }

    public String getWorkBelongIndustry() {
        return workBelongIndustry;
    }

    public void setWorkBelongIndustry(String workBelongIndustry) {
        this.workBelongIndustry = workBelongIndustry;
    }

    public String getWorkCompanyProperty() {
        return workCompanyProperty;
    }

    public void setWorkCompanyProperty(String workCompanyProperty) {
        this.workCompanyProperty = workCompanyProperty;
    }

    public String getWorkCompanyName() {
        return workCompanyName;
    }

    public void setWorkCompanyName(String workCompanyName) {
        this.workCompanyName = workCompanyName;
    }

    public String getWorkCompanyAddress() {
        return workCompanyAddress;
    }

    public void setWorkCompanyAddress(String workCompanyAddress) {
        this.workCompanyAddress = workCompanyAddress;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkDatetime() {
        return workDatetime;
    }

    public void setWorkDatetime(String workDatetime) {
        this.workDatetime = workDatetime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    public String getImprovePdf() {
        return improvePdf;
    }

    public void setImprovePdf(String improvePdf) {
        this.improvePdf = improvePdf;
    }

    public String getFrontTablePic() {
        return frontTablePic;
    }

    public void setFrontTablePic(String frontTablePic) {
        this.frontTablePic = frontTablePic;
    }

    public String getWorkPlacePic() {
        return workPlacePic;
    }

    public void setWorkPlacePic(String workPlacePic) {
        this.workPlacePic = workPlacePic;
    }

    public String getSalerAndcustomer() {
        return salerAndcustomer;
    }

    public void setSalerAndcustomer(String salerAndcustomer) {
        this.salerAndcustomer = salerAndcustomer;
    }

    public String getOtherWorkNote() {
        return otherWorkNote;
    }

    public void setOtherWorkNote(String otherWorkNote) {
        this.otherWorkNote = otherWorkNote;
    }
}
