package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 附件名字
 * @author: taojian 
 * @since: 2019年4月9日 下午8:57:29 
 * @history:
 */
public enum EAttachName {

    // 主贷人/共还人/担保人银行征信结果
    mainLoaner_bank("1", "图片"), replier_bank("2", "图片"), assurance_bank("3",
            "图片");

    public static Map<String, EAttachName> getMap() {
        Map<String, EAttachName> map = new HashMap<String, EAttachName>();
        for (EAttachName node : EAttachName.values()) {
            map.put(node.getCode(), node);
        }
        return map;
    }

    private EAttachName(String code, String value) {
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
