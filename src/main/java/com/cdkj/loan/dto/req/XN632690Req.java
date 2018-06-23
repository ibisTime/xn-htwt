package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632690Req {

    // 车辆型号
    @NotBlank
    private String model;

    // 车牌号
    @NotBlank
    private String number;

    // 保险到期日
    @NotBlank
    private String insuranceEndDatetime;

    // 停放位置
    @NotBlank
    private String parkLocation;

    // 车辆照片
    @NotBlank
    private String pic;

    // 更新人
    @NotBlank
    private String updater;

    // 备注
    private String remark;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInsuranceEndDatetime() {
        return insuranceEndDatetime;
    }

    public void setInsuranceEndDatetime(String insuranceEndDatetime) {
        this.insuranceEndDatetime = insuranceEndDatetime;
    }

    public String getParkLocation() {
        return parkLocation;
    }

    public void setParkLocation(String parkLocation) {
        this.parkLocation = parkLocation;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
