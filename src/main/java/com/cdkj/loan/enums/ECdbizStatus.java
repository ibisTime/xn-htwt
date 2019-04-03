package com.cdkj.loan.enums;

/**
 * 业务状态
 * @author: taojian 
 * @since: 2019年4月2日 下午7:04:36 
 * @history:
 */
public enum ECdbizStatus {

    A1("001", "待录入征信单"), A2("002", "待风控专员审核征信单"), A1x("001x", "风控专员审核征信单不通过"), A3(
            "003", "待录入准入单");

    ECdbizStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

}
