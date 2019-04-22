package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 任务
* @author: tao 
* @since: 2019-04-14 16:59:51
* @history:
*/
public class Mission extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 任务名字
    private String name;

    // 限时（h）
    private Long time;

    // 发布人
    private String creater;

    // 认领人
    private String getUser;

    // 状态
    private String status;

    // 创建时间
    private Date createDatetime;

    // 截止时间
    private Date deadline;

    // 完成时间
    private Date finishDatetime;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTime() {
        return time;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreater() {
        return creater;
    }

    public void setGetUser(String getUser) {
        this.getUser = getUser;
    }

    public String getGetUser() {
        return getUser;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setFinishDatetime(Date finishDatetime) {
        this.finishDatetime = finishDatetime;
    }

    public Date getFinishDatetime() {
        return finishDatetime;
    }

}
