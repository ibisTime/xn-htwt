package com.cdkj.loan.dto.req;

/**
 * 新增任务
 * @author: taojian 
 * @since: 2019年4月15日 上午10:22:41 
 * @history:
 */
public class XN623590Req {

    // 业务编号
    private String bizCode;

    // 任务名称
    private String name;

    // 时间
    private String time;

    // 创建人
    private String creater;

    // 认领人
    private String getUser;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getGetUser() {
        return getUser;
    }

    public void setGetUser(String getUser) {
        this.getUser = getUser;
    }

}
