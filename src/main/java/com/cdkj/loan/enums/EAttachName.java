package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 附件名字
 *
 * @author: taojian
 * @since: 2019年4月9日 下午8:57:29
 * @history:
 */
public enum EAttachName {

    // 二手车资源
    second_car_report("second_car_report", "网页"),
    xsz_front("drive_license_front", "图片"),
    xsz_reverse("drive_license_reverse", "图片"),
    car_check_reprot("third_valuation_pdf", "图片"), // 车辆价格核实报告

    // 主贷人资源
    mainLoaner_bank("bank_report_apply", "图片"),
    mainLoaner_data("data_report_apply", "图片"),
    mainLoaner_id_front("id_no_front_apply", "图片"),
    mainLoaner_id_reverse("id_no_reverse_apply", "图片"),
    mainLoaner_auth_pdf("auth_pdf_apply", "图片"),
    mainloaner_interview_pic("interview_pic_apply", "图片"),

    // 共还人资源
    replier_bank("bank_report_gh", "图片"),
    replier_data("data_report_gh", "图片"),
    replier_id_front("id_no_front_gh", "图片"),
    replier_id_reverse("id_no_reverse_gh", "图片"),
    replier_auth_pdf("auth_pdf_gh", "图片"),
    replier_interview_pic("interview_pic_gh", "图片"),

    // 担保人资源
    assurance_bank("bank_report_gua0", "图片"),
    assurance_data("data_report_gua0", "图片"),
    assurance_id_front("id_no_front_gua0", "图片"),
    assurance_id_reverse("id_no_reverse_gua0", "图片"),
    assurance_auth_pdf("auth_pdf_gua0", "图片"),
    assurance_interview_pic("interview_pic_gua0", "图片"),

    assurance_bank1("bank_report_gua1", "图片"),
    assurance_data1("data_report_gua1", "图片"),
    assurance_id_front1("id_no_front_gua1", "图片"),
    assurance_id_reverse1("id_no_reverse_gua1", "图片"),
    assurance_auth_pdf1("auth_pdf_gua1", "图片"),
    assurance_interview_pic1("interview_pic_gua1", "图片"),

    // 房屋信息
    house_pic("house_picture_apply", "图片"),

    // 面签资源
    bank_vedio("bank_video", "视频"),
    bank_photo("bank_photo", "图片"),
    company_vedio("company_video", "视频"),
    company_contract("company_contract", "图片"),
    bank_contract("bank_contract", "图片"),
    advance_fund_pdf("advance_fund_amount_pdf", "图片"),
    other_vedio("other_video", "视频"),
    interview_other_pdf("interview_other_pdf", "其他"),

    // 录入准入单图片
    carHgzPic("car_hgz_pic", "合格证"),
    driveLicenseFront("drive_license_front", "行驶证正面"),
    driveLicenseReverse("drive_license_reverse", "行驶证反面"),
    workAssetPdf("work_asset_pdf", "工作资料上传"),
    assetPdf("asset_pdf_apply", "申请人资产资料pdf"),
    mateAssetPdf("asset_pdf_gh", "共还人资产资料pdf"),
    guaAssetPdf("asset_pdf_gua0", "担保人资产资料pdf"),
    guaAssetPdf1("asset_pdf_gua1", "担保人资产资料pdf"),
    houseContract("house_contract", "购房合同"),
    marryPdf("marry_pdf", "结婚证资料"),
    carPic("car_pic", "车辆照片"),
    otherPdf("other_pdf", "其他资料"),
    otherPic("other_pic", "其他辅助资料"),
    hkBookPdf("hkb_apply", "户口本资料"),
    houseInvoice("house_invoice", "其他辅助资料"),
    liveProvePdf("live_prove_pdf", "居住证明"),
    buildProvePdf("build_prove_pdf", "自建房证明"),
    housePictureApply("house_picture_apply", "家访照片"),
    improvePdf("improve_pdf", "收入证明"),
    frontTablePic("front_table_pic", "单位前台照片"),
    workPlacePic("work_place_pic", "单位场地照片"),
    salerAndcustomer("saler_and_customer", "业务员与客户合影"),
    advanceBillPdf("advance_bill_pdf", "垫资水单"),

    //车辆抵押
    pledgeUserIdCardFront("pledge_user_id_card_front", "代理人身份证正"),
    pledgeUserIdCardReverse("pledge_user_id_card_reverse", "代理人身份证反"),

    water_bill("h1", "图片");

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
