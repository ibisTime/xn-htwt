package com.cdkj.loan.enums;

/** 
 * 立木征信状态
 * @author: CYL 
 * @since: 2018年10月10日 上午11:31:22 
 * @history:
 */
public enum ELimuCreditStatus {
    PENDING_CALLBACK("1", "待回调"), ALREADY_CALLBACK("2", "已回调");

    ELimuCreditStatus(String code, String value) {
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
