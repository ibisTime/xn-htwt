package com.cdkj.loan.enums;

public enum EBizLogType {

    CREDIT("001", "征信"), BUDGET_ORDER("002", "预算单"), REPAY_BIZ("003", "还款业务"), REQ_BUDGET(
            "005", "预算款"), BUDGET_CANCEL("007", "客户作废"), BACK_ADVANCE_FUND(
            "008", "退客户垫资款"), BUSINESS_TRIP_APPLY("009", "出差申请"), INVESTIGATEREPORT(
            "010", "调查报告"), GPS_LOGISTICS("011", "GPS收发件"), LOGISTICS("012",
            "资料传递");

    EBizLogType(String code, String value) {
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
