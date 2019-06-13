package com.cdkj.loan.enums;

/**
 * 征信人员表 与借款人关系
 * @author: jiafr 
 * @since: 2018年5月30日 下午1:26:59 
 * @history:
 */
public enum ECreditJourType {

    wx("1", "微信"), zfb("2", "支付宝"), bank("3", "银行");

    ECreditJourType(String code, String value) {
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
