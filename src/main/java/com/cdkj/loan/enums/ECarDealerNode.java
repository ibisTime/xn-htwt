package com.cdkj.loan.enums;

/**
 * 经销商审核节点
 * @author: CYL 
 * @since: 2018年5月23日 上午10:57:01 
 * @history:
 */
public enum ECarDealerNode {

    NEW_ADD("006_01", "新增"), DROP("006_02", "删除");

    ECarDealerNode(String code, String value) {
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
