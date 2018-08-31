package com.cdkj.loan.enums;

/**
 * 资料传递状态
 * @author: silver 
 * @since: 2018年5月29日 下午10:18:47 
 * @history:
 */
public enum ELogisticsStatus {
    TO_SEND("0", "待发件"), TO_RECEIVE("1", "已发件待收件"), RECEIVED("2", "已收件审核"), TO_SEND_AGAIN(
            "3", "已收件待补件"),
    // GPS节点
    SEND("011_01", "GPS发件"), RECEIVE("011_02", "GPS收件"),

    // 资料传递节点
    YWDH_SEND("012_01", "业务贷后资料发件"), YWDH_RECEIVE("012_02", "业务贷后资料收件"), ZHFK_SEND(
            "013_01", "驻行放款材料发件"), ZHFK_RECEIVE("013_02", "驻行放款材料收件"), ZHDY_SEND(
            "014_01", "驻行抵押材料发件"), ZHDY_RECEIVE("014_02", "驻行抵押材料收件");

    ELogisticsStatus(String code, String value) {
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
