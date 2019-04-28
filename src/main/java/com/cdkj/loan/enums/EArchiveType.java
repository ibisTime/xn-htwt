package com.cdkj.loan.enums;

/**
 * 存档状态
 * @author: silver 
 * @since: Apr 28, 2019 2:30:20 PM 
 * @history:
 */
public enum EArchiveType {

    FIRST("1", "第一次存档"), SECOND("2", "第二次存档");

    public static EArchiveType matchCode(String code) {
        for (EArchiveType archiveType : EArchiveType.values()) {
            if (archiveType.code.equalsIgnoreCase(code)) {
                return archiveType;
            }
        }
        return null;
    }

    EArchiveType(String code, String value) {
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
