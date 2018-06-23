package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632792Req {

    // 编号
    @NotBlank
    private String code;

    // 行驶公里数
    @NotBlank
    private String driveKil;

    // 更新人
    private String updater;

    private String remark;// 备注

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDriveKil() {
        return driveKil;
    }

    public void setDriveKil(String driveKil) {
        this.driveKil = driveKil;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
