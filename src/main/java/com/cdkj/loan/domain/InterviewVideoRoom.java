package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 面签视频房间
* @author: CYunlai 
* @since: 2018-10-24 15:22:55
* @history:
*/
public class InterviewVideoRoom extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 房间编号
    private String code;

    // 房主id
    private String homeOwnerId;

    // 混流视频下载地址
    private String hlUrl;

    // 状态（0可用，1不可用）
    private String status;

    // 创建时间
    private Date createDatetime;

    // 预算单编号
    private String budgetCode;

    public String getBudgetCode() {
        return budgetCode;
    }

    public void setBudgetCode(String budgetCode) {
        this.budgetCode = budgetCode;
    }

    public String getHomeOwnerId() {
        return homeOwnerId;
    }

    public void setHomeOwnerId(String homeOwnerId) {
        this.homeOwnerId = homeOwnerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setHlUrl(String hlUrl) {
        this.hlUrl = hlUrl;
    }

    public String getHlUrl() {
        return hlUrl;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

}
