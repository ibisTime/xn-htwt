package com.cdkj.loan.enums;

/**
 * 业务状态
 * @author: taojian 
 * @since: 2019年4月2日 下午7:04:36 
 * @history:
 */
public enum ECdbizStatus {

    // 业务主状态
    A0("000", "待新录征信信息"), A1("001", "待录入征信单"), A2("002", "待风控专员审核征信单"), A1x(
            "001x",
            "风控专员审核征信单不通过"), A3("003", "待录入准入单"), A4("004", "待区域总审核准入单"),

    // 面签状态
    B00("000", "待录入面签信息"), B01("001", "待主管审核面签"),

    B02("002", "主管审核面签不通过"), B03("003", "面签完成");

    ECdbizStatus(String code, String value) {
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
