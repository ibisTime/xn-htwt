package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630515Req {

    @NotBlank
    private String code;// 还款业务编号

    @NotBlank
    private String paperPhoto;// 纸质申请照片

    @NotBlank
    private String updater;// 操作人

    private String remark;// 备注

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPaperPhoto() {
        return paperPhoto;
    }

    public void setPaperPhoto(String paperPhoto) {
        this.paperPhoto = paperPhoto;
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
