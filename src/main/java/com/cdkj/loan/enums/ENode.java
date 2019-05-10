package com.cdkj.loan.enums;

import com.cdkj.loan.exception.BizException;
import java.util.HashMap;
import java.util.Map;

/**
 * 征信节点
 *
 * @author: jiafr
 * @since: 2018年5月25日 下午3:01:56
 * @history:
 */
public enum ENode {

    // 征信节点
    new_credit("a1", "新录征信资料"), input_credit("a2", "录入征信结果"), approve_credit(
            "a3", "审核征信"), renew_credit("a1x", "重录征信资料"),

    // 准入单节点
    input_budget("b1", "录入准入单资料"), area_approve_budget("b2", "区域总审核准入单"), fk_fir_approve(
            "b3", "风控一审准入单"), fk_sec_approve("b4", "风控二审准入单"), fk_finish_approve(
            "b5", "风控终审准入单"), yw_approve_budget("b6", "业务总监审核准入单"), cw_approve_budget(
            "b7", "财务总监审核准入单"), renew_budget("b1x", "重录准入单"),

    // 制卡节点
    make_card_apply("h1", "制卡申请"), input_card_number("h2", "回录卡号"), make_card_finish(
            "h3", "制卡完成"),

    // 面签节点
    input_interview("b01", "新录面签信息"), approve_interview("b02", "主管审核面签信息"),

    reinput_interview("b01x", "重录面签信息"), achieve_interview("b03", "面签完成"),

    // 垫资
    sure_dz("g1", "确认用款单"), qy_manager_approve("g2", "区域总经理审批"),

    sfgs_manage_approve("g3", "省分公司总经理审批"), confirm_make_bill("g4", "确认制单"),

    upload_approve_back_bill("g5", "上传复核回单"),

    // 发保合节点
    input_fbh("c1", "新录入发保合"), approve_fbh("c2", "审核发保合"),

    reinput_fbh("c1x", "重录入发保合"),

    // gps
    set_gps("d1", "安装gps"), approve_gps("d2", "审核gps"),

    approve_fail_gps("d3", "gps审核不通过"), gps_done("d4", "gps安装完成"),

    // 银行放款节点
    submit_1("e1", "业务员寄送银行放款材料"), receive_approve_1("e2", "风控审核收件（银行放款）"),

    re_submit_1("e1x", "业务员重寄材料（银行放款）"), fk_submit("e3", "风控提交银行"),

    fk_input("e4", "风控录入银行放款信息"), cw_confirm_receipt("e5", "财务确认银行收款"),

    bank_receipt("e6", "待抵押申请"),

    submit_2("e7", "风控寄送银行放款材料"), receive_2("e8", "贷后收件（银行放款）"),

    first_receive_archive("e9", "第一次已收件待存档"), first_archive("e10", "第一次已存档"),

    // 车辆抵押
    confirm_pledge_apply("f1", "内勤确认抵押申请"), submit_3("f2", "风控寄抵押合同"),

    receive_approve_3("f3", "业务员审核抵押合同"), re_submit_3("f2x", "风控重寄抵押合同"),

    input_dy_info("f4", "业务员录入抵押信息"), submit_4("f5", "业务员寄送材料（车辆抵押）"),

    receive_approve_4("f6", "风控审核收件（车辆抵押）"), re_submit_4("f5x",
            "业务员重寄送材料（车辆抵押）"),

    submit_5("f7", "风控审核通过（车辆抵押）"), receive_5("f8", "银行收件（车辆抵押）"),

    to_commit_bank("f9", "提交银行"), dy_info_confirm_submit("f10", "抵押材料已确认提交"),

    submit_6("f11", "待风控寄件（车辆抵押）"), receive_6("f12", "待担保公司收件（车辆抵押）"),

    second_received_archive("f13", "第二次已收件待存档"), second_archive("f14", "第二次已存档"),

    // 旧版本征信节点
    FILLIN_CREDIT("001_01", "发起征信查询"), DISTRIBUTE_LEAFLETS("001_08", "派单"), INPUT_CREDIT_RESULT(
            "001_02", "录入征信结果"), AUDIT("001_03", "风控专员审核"), ACHIEVE("001_04",
            "征信完成"), BACK("001_05", "征信退回，重新发起征信"), AUDIT_NO_PASS("001_06",
            "风控专员审核不通过，重新录入征信结果"), CANCEL("001_07", "征信撤回，重新发起征信");

    public static Map<String, ENode> getMap() {
        Map<String, ENode> map = new HashMap<String, ENode>();
        for (ENode node : ENode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    public static ENode matchCode(String code) {
        ENode resultNote = null;
        for (ENode eNode : ENode.values()) {
            if (eNode.code.equalsIgnoreCase(code)) {
                resultNote = eNode;
                break;
            }
        }
        if (null == resultNote) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "节点[" + code + "]未找到匹配的节点信息数据");
        }

        return resultNote;
    }

    private ENode(String code, String value) {
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
