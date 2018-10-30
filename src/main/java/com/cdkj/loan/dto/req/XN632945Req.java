package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 车险查询
 * @author: CYL 
 * @since: 2018年10月9日 下午5:05:01 
 * @history: 支持的保险公司为 ：PICC 中国人民保险      CPIC 太平洋保险       PAIC 平安保险      SPIC 三星保险       CCIC 大地保险       TPIC 中国太平 
 */
public class XN632945Req {

    // 保险公司
    @NotBlank
    private String insuranceCompany;

    // 查询类型
    @NotBlank
    private String type;

    // 账号(授权查询必需)
    private String username;

    // 密码,使用 base64 编码(授权查询必需)
    private String password;

    // 保单号(保单查询必需)
    private String policyNo;

    // 投保人身份证号(保单查询必需)
    private String identityNo;

    // 身份证号
    private String idNo;

    // 客户姓名
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
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

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

}
