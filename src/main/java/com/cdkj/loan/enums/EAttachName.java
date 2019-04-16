package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 附件名字
 * @author: taojian 
 * @since: 2019年4月9日 下午8:57:29 
 * @history:
 */
public enum EAttachName {

    // 二手车资源
    second_car_report("a1", "网页"), xsz_front("a2", "图片"), xsz_reverse("a3",
            "图片"), car_check_reprot("a4", "图片"), // 车辆价格核实报告

    // 主贷人资源
    mainLoaner_bank("z1", "图片"), mainLoaner_id_front("z2", "图片"), mainLoaner_id_reverse(
            "z3", "图片"), mainLoaner_auth_pdf("z4", "图片"), mainloaner_interview_pic(
            "z5", "图片"),

    // 共还人资源
    replier_bank("g1", "图片"), replier_id_front("g2", "图片"), replier_id_reverse(
            "g3", "图片"), replier_auth_pdf("g4", "图片"), replier_interview_pic(
            "g5", "图片"),

    // 担保人资源
    assurance_bank("d1", "图片"), assurance_id_front("d2", "图片"), assurance_id_reverse(
            "d3", "图片"), assurance_auth_pdf("d4", "图片"), assurance_interview_pic(
            "d5", "图片"),

    // 银行征信报告
    bank_credit_report("b1", "图片"),

    // 大数据征信报告
    data_credit_report("dcr1", "图片"),

    // 房屋信息
    house_pic("h1", "图片")

    ;

    public static Map<String, EAttachName> getMap() {
        Map<String, EAttachName> map = new HashMap<String, EAttachName>();
        for (EAttachName node : EAttachName.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    private EAttachName(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
