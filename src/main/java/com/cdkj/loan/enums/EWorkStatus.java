package com.cdkj.loan.enums;

/**
 * 工作状态
 * @author: jiafr 
 * @since: 2018年7月11日 下午6:40:28 
 * @history:
 */
public enum EWorkStatus {
    TRY("1", "试用"), ON_JOB("2", "在职"), LEAVE("3", "离职"), RETIRE("4", "退休");

    EWorkStatus(String code, String value) {
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
