package com.cdkj.loan.enums;

/**
 * 业务状态
 * @author: taojian 
 * @since: 2019年4月2日 下午7:04:36 
 * @history:
 */
public enum ECdbizStatus {

    // 业务主状态
    A0("000", "待新录征信信息"), A1("001", "待录入征信单"), A2("002", "待风控专员审核征信单"),

    A1x("001x", "风控专员审核征信单不通过"), A3("003", "待录入准入单"), A4("004", "待区域总审核准入单"),

    A5("005", "待风控一审准入单"), A6("006", "待风控二审准入单"), A7("007", "待风控终审准入单"),

    A8("008", "待业务总监审核准入单"), A9("009", "待财务总监审核准入单"), A3x("003x", "准入单审核不通过"),

    A10("010", "待业务员寄送银行放款材料"), A11("011", "待风控审核收件(银行放款)"), A12("010x",
            "待业务员重寄材料(银行放款)"),

    A13("012", "风控提交银行"), A14("013", "风控录入银行放款信息"), A15("014", "财务确认银行收款"),

    A16("015", "银行收款"), A17("016", "业务员确认抵押申请"), A18("017", "风控寄抵押合同"),

    A19("018", "业务员审核抵押合同"), A20("019", "业务员录入抵押信息"), A21("020", "风控重寄抵押合同"),

    A22("021", "业务员寄送材料（车辆抵押）"), A23("022", "风控审核收件（车辆抵押）"), A24("023",
            "风控审核通过（车辆抵押）"),

    A25("024", "业务员重寄材料（车辆抵押）"), A26("025", "银行收件（车辆抵押）"), A27("026", "提交银行"),

    A28("027", "抵押材料已确认提交"),

    // 面签状态
    B00("000", "待录入面签信息"), B01("001", "待主管审核面签"),

    B02("002", "主管审核面签不通过"), B03("003", "面签完成"),

    // 发保合gps状态
    C00("000", "待垫资"), C01("001", "待录入发保合"),

    C02("002", "待主管审核发保合"), C01x("001x", "待重入发保合"),

    C03("003", "待安装gps"), C04("004", "待审核gps"),

    C05("005", "gps审核不通过"), C06("006", "gps完成"),

    // 第一次存档状态
    D0("000", "风控寄送银行放款材料"), D1("001", "贷后收件（银行放款）"),

    D2("002", "第一次已收件待存档"), D3("003", "第一次已存档"),

    // 第二次存档状态
    E0("000", "待风控寄件（车辆抵押）"), E1("001", "待担保公司收件（车辆抵押）"),

    E2("002", "第二次已收件待存档"), E3("003", "第二次已存档"),

    // 垫资状态(温州)
    F0("000", "确认用款单"), F1("001", "区域总经理审批"), F2("002", "省分公司总经理审批"),

    F3("003", "确认制单"), F4("004", "上传复核回单");

    public static ECdbizStatus matchCode(String code) {
        for (ECdbizStatus eCdbizStatus : ECdbizStatus.values()) {
            if (eCdbizStatus.code.equalsIgnoreCase(code)) {
                return eCdbizStatus;
            }
        }
        return null;
    }

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
