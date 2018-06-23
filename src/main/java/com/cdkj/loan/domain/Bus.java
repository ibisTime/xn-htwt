package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 公车
* @author: CYunlai 
* @since: 2018-06-23 11:34:50
* @history:
*/
public class Bus extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 车辆型号
    private String model;

    // 车牌号
    private String number;

    // 保险到期日
    private Date insuranceEndDatetime;

    // 停放位置
    private String parkLocation;

    // 车辆照片
    private String pic;

    // 领用状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public Date getInsuranceEndDatetime() {
        return insuranceEndDatetime;
    }

    public void setInsuranceEndDatetime(Date insuranceEndDatetime) {
        this.insuranceEndDatetime = insuranceEndDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
