package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 用户行为
* @author: jiafr 
* @since: 2019-03-13 17:00:33
* @history:
*/
public class Action extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 对象类型
    private String toType;

    // 对象编号
    private String toCode;

    // 行为用户
    private String creater;

    // 行为时间
    private Date createDatetime;

    // 备注
    private String remark;

    // **********************************

    private Car car;

    private CarNews carNews;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarNews getCarNews() {
        return carNews;
    }

    public void setCarNews(CarNews carNews) {
        this.carNews = carNews;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getToType() {
        return toType;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public String getToCode() {
        return toCode;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
