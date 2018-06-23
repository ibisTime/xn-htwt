package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 出差申请节点
 * @author: jiafr 
 * @since: 2018年6月23日 下午3:38:54 
 * @history:
 */
public enum EBusinessTripApplyNode {

    APPLY("009_01", "申请出差"), DEPARTMENT_AUDIT("009_02", "部门主管审核"), FINANCE_AUDIT(
            "009_03", "财务主管审核"), GENERAL_AUDIT("009_04", "总经理审核"), AUDIT_PASS(
            "009_05", "审核通过"), MODIFY_APPLY("009_06", "修改申请");

    public static Map<String, EBusinessTripApplyNode> getMap() {
        Map<String, EBusinessTripApplyNode> map = new HashMap<String, EBusinessTripApplyNode>();
        for (EBusinessTripApplyNode node : EBusinessTripApplyNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    EBusinessTripApplyNode(String code, String value) {
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
