package com.cdkj.loan.enums;

/**
 * 公车归还状态
 * @author: CYL 
 * @since: 2018年6月23日 下午12:21:37 
 * @history:
 */
public enum EBusBorrowReturnStatus {
    TO_RETURN("0", "待归还"), TO_AUDIT("1", "待审核"), ALREADY_RETURN("2", "已归还");

    EBusBorrowReturnStatus(String code, String value) {
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
