package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

public class Series extends ABaseDO {

    private static final long serialVersionUID = -6146787706371232676L;

    private String code;// 编号

    private String brandCode; // 品牌编号

    private String name; // 名称

    private String slogan;// 广告语

    private String advPic;// 广告图

    private Long picNumber;// 图片数量

    private Long price;// 价格区间

    private Long highest;// 最高价

    private Long lowest;// 最低价

    private String level;// 级别

    private String isReferee;// 是否推荐

    private String location;// UI位置

    private Integer orderNo;// UI次序

    private String status;// 状态

    private String updater;// 最新修改人

    private Date updateDatetime;// 最新修改时间

    private String remark;// 备注

    /*----------辅助字段-----------*/

    // 最新修改人姓名
    private String updaterName;

    private List<Car> cars;

    private Long carNumber;

    public Long getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Long carNumber) {
        this.carNumber = carNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(Long picNumber) {
        this.picNumber = picNumber;
    }

    public Long getHighest() {
        return highest;
    }

    public void setHighest(Long highest) {
        this.highest = highest;
    }

    public Long getLowest() {
        return lowest;
    }

    public void setLowest(Long lowest) {
        this.lowest = lowest;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIsReferee() {
        return isReferee;
    }

    public void setIsReferee(String isReferee) {
        this.isReferee = isReferee;
    }

}
