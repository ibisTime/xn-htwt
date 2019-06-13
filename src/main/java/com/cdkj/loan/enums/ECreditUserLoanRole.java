package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 征信人员表 贷款角色
 * @author: jiafr 
 * @since: 2018年5月30日 下午1:29:03 
 * @history:
 */
public enum ECreditUserLoanRole {

    APPLY_USER("1", "申请人"), GHR("2", "共还人"), GUARANTOR("3", "担保人");

    ECreditUserLoanRole(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static Map<String, ECreditUserLoanRole> getMap() {
        Map<String, ECreditUserLoanRole> map = new HashMap<String, ECreditUserLoanRole>();
        for (ECreditUserLoanRole role : ECreditUserLoanRole.values()) {
            map.put(role.getCode(), role);
        }
        return map;
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
