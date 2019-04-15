package com.cdkj.loan.enums;

public enum EMissionStatus {

    to_handle("0", "待完成"), handle("1", "已完成"), valid("2", "已作废");
    EMissionStatus(String code, String status) {
        this.code = code;
        this.status = status;
    }

    private String code;

    private String status;

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

}
