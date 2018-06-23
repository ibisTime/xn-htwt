package com.cdkj.loan.enums;

/**
 * 公车借用状态
 * @author: CYL 
 * @since: 2018年6月23日 下午12:21:37 
 * @history:
 */
public enum EBusBorrowStatus {
    TO_AUDIT("0", "待审核"), TO_RETURN("1", "待归还"), AUDIT_NOT_PASS("2",
            "审核不通过"), RETURN_TO_AUDIT("3", "归还待审核"), ALREADY_RETURN("4", "已归还");

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
