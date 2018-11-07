package com.cdkj.loan.enums;

/**
 * 物流单节点类型
 * @author: CYL 
 * @since: 2018年11月7日 下午5:29:00 
 * @history:
 */
public enum ELogisticsCurNodeType {
    CAR_MORTGAGE("1", "车辆抵押"), BANK_LOAN("2", "银行放款");

    ELogisticsCurNodeType(String code, String value) {
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
