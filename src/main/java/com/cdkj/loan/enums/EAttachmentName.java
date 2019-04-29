package com.cdkj.loan.enums;

/**
 * 附件名称
 * @author: silver 
 * @since: Apr 28, 2019 5:59:01 PM 
 * @history:
 */
public enum EAttachmentName {

    // car_procedure车辆手续）
    car_invoice("car_invoice", "车辆发票"),

    car_jqx("car_jqx", "交强险"),

    car_syx("car_syx", "商业险"),

    green_big_smj("car_syx", "绿大本扫描件");

    public static EAttachmentName matchCode(String code) {
        for (EAttachmentName eAttachmentName : EAttachmentName.values()) {
            if (eAttachmentName.code.equalsIgnoreCase(code)) {
                return eAttachmentName;
            }
        }
        return null;
    }

    EAttachmentName(String code, String value) {
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
