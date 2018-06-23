/**
 * @Title ECheckResult.java 
 * @Package com.ibis.account.enums 
 * @Description 
 * @author miyb  
 * @date 2015-2-26 下午2:58:54 
 * @version V1.0   
 */
package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author: miyb 
 * @since: 2015-2-26 下午2:58:54 
 * @history:
 */
public enum ESysRole {
    SALE("SR201800000000000000YWY", "业务员编号"), YWNQ("SR20180000000000000NQZY",
            "内勤专员"), LEADER("SR201805301244280427951", "团队长");

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
