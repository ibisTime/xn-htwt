package com.cdkj.loan.dto.res;

import com.cdkj.loan.enums.EBoolean;

public class BooleanRes {
    // 是否成功
    private boolean isSuccess;

    // 是否需要快递
    private String isExpress;

    public BooleanRes() {
    }

    public BooleanRes(boolean isSuccess) {
        this.isSuccess = isSuccess;
        this.isExpress = EBoolean.NO.getCode();
    }

    public BooleanRes(boolean isSuccess, String isExpress) {
        this.isSuccess = isSuccess;
        this.isExpress = isExpress;
    }

    public String getIsExpress() {
        return isExpress;
    }

    public void setIsExpress(String isExpress) {
        this.isExpress = isExpress;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
