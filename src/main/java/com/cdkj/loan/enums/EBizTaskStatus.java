package com.cdkj.loan.enums;

/**
 * 待办事项状态
 * @author: silver 
 * @since: Apr 3, 2019 1:56:56 PM 
 * @history:
 */
public enum EBizTaskStatus {

    TO_HANDLE("0", "待处理"), DONE("1", "已完成");

    EBizTaskStatus(String code, String value) {
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
