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
            "001x", "风控专员审核征信单不通过"), A3("003", "待录入准入单"), A4("004", "待区域总审核准入单"), A5(
            "005", "待风控一审准入单"), A6("006", "待风控二审准入单"), A7("007", "待风控终审准入单"), A8(
            "008", "待业务总监审核准入单"), A9("009", "待财务总监审核准入单"), A3x("003x",
            "准入单审核不通过"), A10("010", "待业务员寄送银行放款材料"),

    // 面签状态
    B00("000", "待录入面签信息"), B01("001", "待主管审核面签"),

    B02("002", "主管审核面签不通过"), B03("003", "面签完成"),

    // 发保合gps状态
    C00("000", "待垫资"), C01("001", "待录入发保合");

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
