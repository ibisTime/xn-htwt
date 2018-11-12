package com.cdkj.loan.enums;

/** 
 * 立木征信状态
 * @author: CYL 
 * @since: 2018年10月10日 上午11:31:22 
 * @history:
 */
public enum ELimuCreditStatus {
    IN_THE_QUERY("1", "查询中"), QUERY_SUCCESS("2", "查询成功"), QUERY_FAILURE(
        "3", "查询失败"), RENEW_QUERY("4", "重新查询");

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
