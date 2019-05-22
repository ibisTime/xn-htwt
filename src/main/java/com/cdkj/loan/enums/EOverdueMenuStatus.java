package com.cdkj.loan.enums;

/**
 * 逾期名单状态
 *
 * @author: CYL
 * @since: 2018年6月2日 下午9:24:02
 * @history:
 */
public enum EOverdueMenuStatus {
    DCL("0", "信息不匹配待处理"), YCL("1", "已匹配"), YSDCL("2", "已手动匹配");

    EOverdueMenuStatus(String code, String value) {
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
