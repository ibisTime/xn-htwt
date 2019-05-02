package com.cdkj.loan.enums;

/**
 * 物流单节点类型
 * @author: CYL 
 * @since: 2018年11月7日 下午5:29:00 
 * @history:
 */
public enum ELogisticsCurNodeType {
    SALE_SEND_BANK_LOAN("1", "业务员寄送材料（银行放款）"),

    FK_SEND_BANK_LOAN("2", "风控寄送材料（银行放款）"),

    FK_SEND_PLEDGE_CONTRACT("3", "风控寄送材料（抵押合同）"),

    SALE_SEND_CAR_PLEDGE("4", "业务员寄送材料（车辆抵押）"),

    FK_SEND_CAR_PLEDGE("5", "风控寄送材料（车辆抵押）"),

    FK_APPROVE_PASS_CAR_PLEDGE("6", "风控审核通过（车辆抵押）"),

    BANK_LOAN("9", "other"),
    CAR_MORTGAGE("9", "other");

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
