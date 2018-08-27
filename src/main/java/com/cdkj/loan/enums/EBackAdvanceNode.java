package com.cdkj.loan.enums;

/**
 * 退客户垫资款
 * @author: jiafr 
 * @since: 2018年8月27日 下午9:38:33 
 * @history:
 */
public enum EBackAdvanceNode {
    FINANCE_REFUND("008_01", "财务退款");

    EBackAdvanceNode(String code, String value) {
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
