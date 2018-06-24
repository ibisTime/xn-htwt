package com.cdkj.loan.enums;

/**
 * 公车状态
 * @author: CYL 
 * @since: 2018年6月23日 下午12:21:37 
 * @history:
 */
public enum EBusStatus {
    NO_COLLAR("0", "未领用"), COLLAR_DURING("1", "领用中"), CANCELLATION("2", "已注销");

    EBusStatus(String code, String value) {
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
