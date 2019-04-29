package com.cdkj.loan.enums;

/**
 * 附件类型
 * @author: silver 
 * @since: Apr 28, 2019 5:59:10 PM 
 * @history:
 */
public enum EAttachmentCategory {

    car_procedure("car_procedure", "车辆手续");

    public static EAttachmentCategory matchCode(String code) {
        for (EAttachmentCategory eAttachmentCategory : EAttachmentCategory
            .values()) {
            if (eAttachmentCategory.code.equalsIgnoreCase(code)) {
                return eAttachmentCategory;
            }
        }
        return null;
    }

    EAttachmentCategory(String code, String value) {
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
