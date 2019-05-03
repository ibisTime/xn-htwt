package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-客户信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632532Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /***************客户信息start**************/
    // 性别
    @NotBlank
    private String gender;// creditUserExt

    // 年龄
    @NotBlank
    private String age;// creditUserExt

    // 民族
    @NotBlank
    private String nation;// creditUserExt

    // 学历
    @NotBlank
    private String education;// creditUserExt

    // 政治面貌
    @NotBlank
    private String political;// creditUserExt

    // 职业
    private String workProfession;// creditUserExt

    // 职称
    private String postTitle;// creditUserExt

    // 有无驾照
    @NotBlank
    private String isDriceLicense;// creditUserExt

    // 现有车辆
    private String carTypeNow;// creditUserExt

    // 主要收入来源
    @NotBlank
    private String mainIncome;// creditUserExt

    // 家庭紧急联系人信息1 姓名
    @NotBlank
    private String emergencyName1;// creditUserExt

    // 家庭紧急联系人信息1 与申请人关系
    @NotBlank
    private String emergencyRelation1;// creditUserExt

    // 家庭紧急联系人信息1 手机号码
    @NotBlank
    private String emergencyMobile1;// creditUserExt

    // 家庭紧急联系人信息2 姓名
    @NotBlank
    private String emergencyName2;// creditUserExt

    // 家庭紧急联系人信息2 与申请人关系
    @NotBlank
    private String emergencyRelation2;// creditUserExt

    // 家庭紧急联系人信息2 手机号码
    @NotBlank
    private String emergencyMobile2;// creditUserExt

    /****************客户信息end***************/

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getWorkProfession() {
        return workProfession;
    }

    public void setWorkProfession(String workProfession) {
        this.workProfession = workProfession;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getIsDriceLicense() {
        return isDriceLicense;
    }

    public void setIsDriceLicense(String isDriceLicense) {
        this.isDriceLicense = isDriceLicense;
    }

    public String getCarTypeNow() {
        return carTypeNow;
    }

    public void setCarTypeNow(String carTypeNow) {
        this.carTypeNow = carTypeNow;
    }

    public String getMainIncome() {
        return mainIncome;
    }

    public void setMainIncome(String mainIncome) {
        this.mainIncome = mainIncome;
    }

    public String getEmergencyName1() {
        return emergencyName1;
    }

    public void setEmergencyName1(String emergencyName1) {
        this.emergencyName1 = emergencyName1;
    }

    public String getEmergencyRelation1() {
        return emergencyRelation1;
    }

    public void setEmergencyRelation1(String emergencyRelation1) {
        this.emergencyRelation1 = emergencyRelation1;
    }

    public String getEmergencyMobile1() {
        return emergencyMobile1;
    }

    public void setEmergencyMobile1(String emergencyMobile1) {
        this.emergencyMobile1 = emergencyMobile1;
    }

    public String getEmergencyName2() {
        return emergencyName2;
    }

    public void setEmergencyName2(String emergencyName2) {
        this.emergencyName2 = emergencyName2;
    }

    public String getEmergencyRelation2() {
        return emergencyRelation2;
    }

    public void setEmergencyRelation2(String emergencyRelation2) {
        this.emergencyRelation2 = emergencyRelation2;
    }

    public String getEmergencyMobile2() {
        return emergencyMobile2;
    }

    public void setEmergencyMobile2(String emergencyMobile2) {
        this.emergencyMobile2 = emergencyMobile2;
    }
}
