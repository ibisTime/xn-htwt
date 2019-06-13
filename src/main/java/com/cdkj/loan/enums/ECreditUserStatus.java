/**
 * @Title EBlacklistStatus.java 
 * @Package com.std.user.enums 
 * @Description 
 * @author leo(haiqing)  
 * @date 2017年2月22日 下午12:16:45 
 * @version V1.0   
 */
package com.cdkj.loan.enums;

/** 
 * @author: haiqingzheng 
 * @since: 2017年2月22日 下午12:16:45 
 * @history:
 */
public enum ECreditUserStatus {
    to_icCredit("0", "待工行征信"), to_callback("1", "待回调"), done("2", "回调完成");

    ECreditUserStatus(String code, String value) {
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
