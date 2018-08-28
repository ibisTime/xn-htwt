package com.cdkj.loan.enums;

/**
 * 
 * @author: jiafr 
 * @since: 2018年7月10日 下午4:47:43 
 * @history:
 */
public enum EBizOrderType {
    C("C", "征信单"), BO("BO", "准入单"), RB("RB", "还款业务单"), IR("IR", "调查报告");

    EBizOrderType(String code, String value) {
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
