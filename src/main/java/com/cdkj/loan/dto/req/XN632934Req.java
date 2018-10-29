package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632934Req {
    // 身份证号
    @NotBlank
    private String identityCardNo;

    // 姓名
    @NotBlank
    private String identityName;

    // 账号
    @NotBlank
    private String username;

    // 密码
    @NotBlank
    private String password;

    // 第 一 联 系 人 省 份 证 号
    private String contactIdentityNo1st;

    // 第 二 联 系 人 省 份 证 号
    private String contactIdentityNo2nd;

    // 第 三 联 系 人 省 份 证 号
    private String contactIdentityNo3rd;

    // 第 一 联 系 人手机号
    private String contactMobile1st;

    // 第 二 联 系 人手机号
    private String contactMobile2nd;

    // 第 三 联 系 人手机号
    private String contactMobile3rd;

    // 第 一 联 系 人姓名
    private String contactName1st;

    // 第 二 联 系 人姓名
    private String contactName2nd;

    // 第 三 联 系 人姓名
    private String contactName3rd;

    // 第 一 联 系 人关系
    private String contactRelationship1st;

    // 第 二 联 系 人关系
    private String contactRelationship2nd;

    // 第 三 联 系 人关系
    private String contactRelationship3rd;

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getContactIdentityNo1st() {
        return contactIdentityNo1st;
    }

    public void setContactIdentityNo1st(String contactIdentityNo1st) {
        this.contactIdentityNo1st = contactIdentityNo1st;
    }

    public String getContactIdentityNo2nd() {
        return contactIdentityNo2nd;
    }

    public void setContactIdentityNo2nd(String contactIdentityNo2nd) {
        this.contactIdentityNo2nd = contactIdentityNo2nd;
    }

    public String getContactIdentityNo3rd() {
        return contactIdentityNo3rd;
    }

    public void setContactIdentityNo3rd(String contactIdentityNo3rd) {
        this.contactIdentityNo3rd = contactIdentityNo3rd;
    }

    public String getContactMobile1st() {
        return contactMobile1st;
    }

    public void setContactMobile1st(String contactMobile1st) {
        this.contactMobile1st = contactMobile1st;
    }

    public String getContactMobile2nd() {
        return contactMobile2nd;
    }

    public void setContactMobile2nd(String contactMobile2nd) {
        this.contactMobile2nd = contactMobile2nd;
    }

    public String getContactMobile3rd() {
        return contactMobile3rd;
    }

    public void setContactMobile3rd(String contactMobile3rd) {
        this.contactMobile3rd = contactMobile3rd;
    }

    public String getContactName1st() {
        return contactName1st;
    }

    public void setContactName1st(String contactName1st) {
        this.contactName1st = contactName1st;
    }

    public String getContactName2nd() {
        return contactName2nd;
    }

    public void setContactName2nd(String contactName2nd) {
        this.contactName2nd = contactName2nd;
    }

    public String getContactName3rd() {
        return contactName3rd;
    }

    public void setContactName3rd(String contactName3rd) {
        this.contactName3rd = contactName3rd;
    }

    public String getContactRelationship1st() {
        return contactRelationship1st;
    }

    public void setContactRelationship1st(String contactRelationship1st) {
        this.contactRelationship1st = contactRelationship1st;
    }

    public String getContactRelationship2nd() {
        return contactRelationship2nd;
    }

    public void setContactRelationship2nd(String contactRelationship2nd) {
        this.contactRelationship2nd = contactRelationship2nd;
    }

    public String getContactRelationship3rd() {
        return contactRelationship3rd;
    }

    public void setContactRelationship3rd(String contactRelationship3rd) {
        this.contactRelationship3rd = contactRelationship3rd;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
