package com.cdkj.loan.enums;

public enum ERepayPlanNode {
    // 车贷
    TO_REPAY("l1", "待还款"), REPAY_YES("l2", "已还款"), OVERDUE("l3",
            "已逾期待处理"), HANDLER_TO_GREEN("l4", "缴纳违约押金，进绿名单"), HANDLER_TO_YELLOW(
            "l5", "已代偿，进黄名单"), HANDLER_TO_RED("l6", "催收失败，进红名单处理"), QKCSB_APPLY_TC(
            "l7", "红名单处理中"), BAD_DEBT("l8", "坏账"), TEAN_BUY_OUT(
            "l9", "业务团队买断"), TEAM_RENT("l10", "业务团队租赁"), OVERDUE_TO_TRUE(
            "l11", "逾期待确认"),

    // 商品计划节点
    PRD_TO_REPAY("006_01", "待还款"), REPAY_APPROVE("006_06", "还款审核"), PRD_REPAY_YES(
            "006_02", "已还款"), PRD_OVERDUE("006_03", "已逾期待处理"), PRD_HANDLER_TO_GREEN(
            "006_04", "逾期处理，进绿名单"), PRD_HANDLER_TO_BLACK("006_05", "不还，进黑名单");

    ERepayPlanNode(String code, String value) {
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
