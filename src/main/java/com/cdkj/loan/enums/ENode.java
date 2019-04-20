package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 征信节点
 * @author: jiafr 
 * @since: 2018年5月25日 下午3:01:56 
 * @history:
 */
public enum ENode {

    // 200征信节点
    new_credit("a1", "新录征信资料"), input_credit("a2", "录入征信结果"), approve_credit(
            "a3", "审核征信"), renew_credit("ax1", "重录征信资料"),

    // 200准入单节点
    input_budget("b1", "录入准入单资料"), area_approve_budget("b2", "区域总审核准入单"), fk_fir_approve(
            "b3", "风控一审准入单"), fk_sec_approve("b4", "风控二审准入单"), fk_finish_approve(
            "b5", "风控终审准入单"), yw_approve_budget("b6", "业务总监审核准入单"), cw_approve_budget(
            "b7", "财务总监审核准入单"), renew_budget("b1x", "重录准入单"),

    // 200面签节点
    input_interview("b01", "新录面签信息"), approve_interview("b02", "主管审核面签信息"),

    reinput_interview("b01x", "重录面签信息"), achieve_interview("b03", "面签完成"),

    // 垫资
    sure_dz("O", "确认垫资"),

    // 发保合节点
    input_fbh("c1", "新录入发保合"),

    // gps
    set_gps("d1", "安装gps"),

    // 银行放款节点
    submit_1("e1", "业务员寄送银行放款材料"), receive_approve_1("e2","风控审核收件（银行放款）"),

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
        for (ENode eNode : ENode.values()) {
            if (eNode.code.equalsIgnoreCase(code)) {
                return eNode;
            }
        }
        return null;
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
