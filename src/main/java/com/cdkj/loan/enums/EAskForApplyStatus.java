package com.cdkj.loan.enums;

/**
 * 领导请示申请状态
 * @author: CYL 
 * @since: 2018年6月5日 上午12:23:17 
 * @history:
 */
public enum EAskForApplyStatus {

    STAY_AUDIT("0", "待审核"), AUDIT_PASS("1", "审核通过"), AUDIT_NOT_PASS("2",
            "审核不通过");

    EAskForApplyStatus(String code, String value) {
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
