package com.cdkj.loan.enums;

/**
 * 公车申请状态
 * @author: CYL 
 * @since: 2018年6月23日 下午12:21:37 
 * @history:
 */
public enum EBusBorrowStatus {
    TO_AUDIT("0", "待审核"), AUDIT_PASS("1", "审核通过"), AUDIT_NOT_PASS("2", "审核不通过");

    EBusBorrowStatus(String code, String value) {
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
