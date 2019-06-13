package com.cdkj.loan.enums;

/**
 * @author xieyj
 * @date: 2019-05-02 20:07
 */
public enum EParamErrorCode {

    DEFAULT("xn805000", "参数异常");

    private String code;

    private String info;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    EParamErrorCode(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
