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
    second_car_report("second_car_report", "网页"), xsz_front(
            "drive_license_front", "图片"), xsz_reverse("drive_license_reverse",
            "图片"), car_check_reprot("a4", "图片"), // 车辆价格核实报告

    // 主贷人资源
    mainLoaner_bank("bank_report_apply", "图片"), mainLoaner_data(
            "data_report_apply", "图片"), mainLoaner_id_front(
            "id_no_front_apply", "图片"), mainLoaner_id_reverse(
            "id_no_reverse_apply", "图片"), mainLoaner_auth_pdf("auth_pdf_apply",
            "图片"), mainloaner_interview_pic("interview_pic_apply", "图片"),

    // 共还人资源
    replier_bank("bank_report_gh", "图片"), replier_data("data_report_gh", "图片"), replier_id_front(
            "id_no_front_gh", "图片"), replier_id_reverse("id_no_reverse_gh",
            "图片"), replier_auth_pdf("auth_pdf_gh", "图片"), replier_interview_pic(
            "interview_pic_gh", "图片"),

    // 担保人资源
    assurance_bank("bank_report_gua", "图片"), assurance_data("data_report_gua",
            "图片"), assurance_id_front("id_no_front_gua", "图片"), assurance_id_reverse(
            "id_no_reverse_gua", "图片"), assurance_auth_pdf("auth_pdf_gua", "图片"), assurance_interview_pic(
            "interview_pic_gua", "图片"),

    // 房屋信息
    house_pic("h1", "图片"),

    // 面签资源
    bank_vedio("bank_video", "视频"), bank_photo("bank_photo", "图片"), company_vedio(
            "company_video", "视频"), company_contract("company_contract", "图片"), bank_contract(
            "bank_contract", "图片"), advance_fund_pdf("advance_fund_amount_pdf",
            "图片"), other_vedio("other_video", "视频"), interview_other_pdf(
            "interview_other_pdf", "其他"),

    water_bill("h1", "图片")

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
