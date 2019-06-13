package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 还款业务节点
 *
 * @author: xieyj
 * @since: 2018年6月8日 下午3:47:31
 * @history:
 */
public enum ERepayBizNode {
    // 车贷
    TO_REPAY("j1", "还款中"), QKCS_DEPART_CHECK("j2", "清欠催收部审核"), BANK_CHECK(
            "j3", "驻行人员审核"), MANAGER_CHECK("j4", "总经理审核"), FINANCE_CHECK(
            "j5", "财务审核"), RELEASE_MORTGAGE("j6", "解除抵押"), SETTLED(
            "j7", "已结清"), QKCSB_APPLY_TC("j8", "清欠催收部申请拖车"), FINANCE_REMIT(
            "j9", "财务打款"), QKCSB_TOTC("j10", "清欠催收部拖车结果待录入"), QKCSB_TC_INPUT(
            "j11", "清欠催收部拖车结果已录入"), JUDICIAL_LAWSUIT("j13", "司法诉讼"), BAD_DEBT(
            "j14", "坏账"), TEAN_BUY_OUT("j15", "业务团队买断"), TEAM_RENT(
            "j16", "业务团队租赁"), QKCSB_REDEEM_APPLY("j17", "清欠催收部申请赎回"), RISK_MANAGER_CHECK(
            "j18", "风控主管审核"), FINANCE_MANAGER_CHECK("j19", "财务经理审核"), PREPAYMENT_APPROVE(
            "j20", "提前还款审核"),

    // 商品分期的节点
    PRO_TO_REPAY("005_01", "还款中"), PRO_SETTLED("005_02", "确认结清"), PRO_CONFIRM_SETTLE(
            "005_03", "已结清"), PRO_BAD_DEBT("005_04", "确认不还");

    public static Map<String, ERepayBizNode> getMap() {
        Map<String, ERepayBizNode> map = new HashMap<String, ERepayBizNode>();
        for (ERepayBizNode node : ERepayBizNode.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    private ERepayBizNode(String code, String value) {
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
