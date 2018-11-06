package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 预算单节点
 * @author: CYL 
 * @since: 2018年5月28日 下午8:31:51 
 * @history:
 */
public enum EBudgetOrderNode {
    WRITE_BUDGET_ORDER("002_01", "填写准入申请单"), AREA_APPROVE("002_24", "区域经理审核"), INTERNAL_APPROVE(
            "002_25", "内勤主管审核"), RISK_ONE_APPROVE("002_02", "风控一审"),RISK_TWO_APPROVE(
            "002_27", "风控二审"), RISK_CHARGE_APPROVE("002_03", "风控终审"),YBIZ_CHARGE_APPROVE(
            "002_28", "业务总监审核"), AGAIN_WRITE("002_04", "重新填写准入申请单"), INTERVIEW(
            "002_05", "面签"), INTERVIEW_INTERNAL_APPROVE("002_26", "内勤主管审核(面签)"), FINANCEAUDIT(
            "002_29","财务审核"),ADVANCEFUND("002_07", "财务垫资"), AGAIN_INTERVIEW("002_08", "重新面签"),
            RISK_CONTROLLER_APPROVE("002_30","风控专员审核"),

    GPSAZ("002_09", "业务团队安装GPS"), GPSMANAGERAPPROVE("002_10", "GPS管理员审核"), AGAINGPSAZ(
            "002_12", "业务团队重新安装GPS"), CARSETTLE("002_11", "业务团队车辆落户"), DHAPPROVEDATA(
            "002_13", "业务贷后审核材料"), COMMITBANK3("002_14", "驻行人员审核放款材料"),

    COMMITBANK("002_15", "驻行人员回录提交放款材料"), ENTRYLOAN("002_16", "录入放款信息"), CONFIRMLOAN(
            "002_17", "财务确认银行放款"), ENTRYMORTGAGE("002_18", "业务团队车辆抵押录入"), MORTGAGECOMMITBANK(
            "002_19", "驻行人员审核抵押材料"), ENTRYCOMMITBANK("002_20", "抵押提交银行"), MORTGAGEFINISH(
            "002_21", "抵押完成"), ARCHIVE("002_22", "入档"), ARCHIVE_END("002_23",
            "入档完成"),BANK_ALREADY_LOAN("002_31","银行已放款"),

    // 客户作废的节点
    CANCEL_START("007_01", "申请作废"), CANCEL_BIZ_AUDIT("007_02", "业务总监审核"), CANCEL_FINANCE_AUDIT(
            "007_03", "财务总监审核"), CANCEL_END("007_04", "申请作废结束"), CANCEL_FAIL(
            "007_05", "作废审核不通过");

    public static Map<String, EBudgetOrderNode> getMap() {
        Map<String, EBudgetOrderNode> map = new HashMap<String, EBudgetOrderNode>();
        for (EBudgetOrderNode node : EBudgetOrderNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    EBudgetOrderNode(String code, String value) {
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
