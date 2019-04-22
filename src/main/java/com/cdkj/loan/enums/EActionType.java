package com.cdkj.loan.enums;

/**
 * @author: xieyj 
 * @since: 2016年11月11日 上午10:54:16 
 * @history:
 */
public enum EActionType {
    share("0", "分享"), feet("1", "足迹"), attention("2", "关注"), collect("3", "收藏"), like(
            "4", "点赞");

    EActionType(String code, String value) {
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
