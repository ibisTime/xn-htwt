package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 录入征信结果（征信人员）
 * @author: jiafr 
 * @since: 2018年5月25日 下午10:23:09 
 * @history:
 */
public class XN632111ReqCreditUser {

    // 征信人员编号
    @NotBlank
    private String creditUserCode;

    // 银行征信结果
    @NotBlank
    private String url;

    // 信用卡占比
    private String name;

    public String getCreditUserCode() {
        return creditUserCode;
    }

    public void setCreditUserCode(String creditUserCode) {
        this.creditUserCode = creditUserCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
