package com.cdkj.loan.enums;

import java.util.HashMap;
import java.util.Map;

import com.cdkj.loan.exception.BizException;

/**
 * 附件类型
 * @author: silver 
 * @since: Apr 2, 2019 5:27:46 PM 
 * @history:
 */
public enum EAttachmentType {
    MainLoan_Gonghang("01", "主贷人工行"),

    MainLoan_Tongdun("02", "主贷人同盾"),

    MainLoan_Limu("03", "主贷人立目");

    public static Map<String, EAttachmentType> getAttachmentTypeResultMap() {
        Map<String, EAttachmentType> map = new HashMap<String, EAttachmentType>();
        for (EAttachmentType type : EAttachmentType.values()) {
            map.put(type.getCode(), type);
        }
        return map;
    }

    public static EAttachmentType getAttachmentType(String code) {
        Map<String, EAttachmentType> map = getAttachmentTypeResultMap();
        EAttachmentType result = map.get(code);
        if (result == null) {
            throw new BizException("XN0000", code + "对应的附件类型不存在");
        }
        return result;
    }

    EAttachmentType(String code, String value) {
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
