package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 调查报告节点
 * @author: CYL
 * @since: 2018年7月5日 下午6:06:22
 * @history:
 */
public enum EInvestigateReportNode {
    COMMIT_APPLY("010_01", "提交调查申请"), RISK_APPROVE("010_02","风控专员审核"), MORTGAGE_APPROVE("010_03",
                    "驻行人员审核"), FINISH("010_04", "已完成");

    public static Map<String, EInvestigateReportNode> getMap() {
        Map<String, EInvestigateReportNode> map = new HashMap<String, EInvestigateReportNode>();
        for (EInvestigateReportNode node : EInvestigateReportNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    EInvestigateReportNode(String code, String value) {
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
