package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色
 * @author: CYL 
 * @since: 2018年11月10日 下午2:01:58 
 * @history:
 */
public enum ESysRole {
    SALE("SR201800000000000000YWY", "信贷专员"), YWNQ("SR20180000000000000NQZY",
            "团队内勤"), LEADER("SR201805301244280427951", "团队长");

    public static Map<String, ESysRole> getMap() {
        Map<String, ESysRole> map = new HashMap<String, ESysRole>();
        for (ESysRole eNum : ESysRole.values()) {
            map.put(eNum.getCode(), eNum);
        }
        return map;
    }

    ESysRole(String code, String value) {
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
