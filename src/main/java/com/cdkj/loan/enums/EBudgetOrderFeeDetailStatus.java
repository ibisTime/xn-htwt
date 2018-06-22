package com.cdkj.loan.enums;

/**
 * 手续费明细状态
 * @author: jiafr 
 * @since: 2018年6月22日 下午5:34:45 
 * @history:
 */
public enum EBudgetOrderFeeDetailStatus {

    UNCOMMITTED("0", "未提交"), SUBMITTED("1", "已提交");

    EBudgetOrderFeeDetailStatus(String code, String value) {
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
