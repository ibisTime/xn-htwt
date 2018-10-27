package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 立木征信
* @author: CYunlai 
* @since: 2018-10-10 11:19:00
* @history:
*/
public class LimuCredit extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private int id;

    // 用户编号
    private String userId;

    // 用户账号
    private String userName;

    // 客户姓名
    private String customerName;

    // 业务类型
    private String bizType;

    // 标记
    private String token;

    // 查询时间
    private Date foundDatetime;

    // 状态
    private String status;

    // 查询结果
    private String result;

    // 回调时间
    private Date callbackDatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setFoundDatetime(Date foundDatetime) {
        this.foundDatetime = foundDatetime;
    }

    public void setCallbackDatetime(Date callbackDatetime) {
        this.callbackDatetime = callbackDatetime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public Date getFoundDatetime() {
        return foundDatetime;
    }

    public Date getCallbackDatetime() {
        return callbackDatetime;
    }

    @Override
    public String toString() {
        return "LimuCredit [id=" + id + ", userId=" + userId + ", userName="
                + userName + ", bizType=" + bizType + ", token=" + token
                + ", foundDatetime=" + foundDatetime + ", status=" + status
                + ", result=" + result + ", callbackDatetime="
                + callbackDatetime + "]";
    }

}
