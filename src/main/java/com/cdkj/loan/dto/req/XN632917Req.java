package com.cdkj.loan.dto.req;

/**
 * 内勤主管分配情况
 * @author: CYL 
 * @since: 2018年12月11日 上午11:43:40 
 * @history:
 */
public class XN632917Req {

    private String userName;// 客户姓名

    // 内勤
    private String insideJob;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInsideJob() {
        return insideJob;
    }

    public void setInsideJob(String insideJob) {
        this.insideJob = insideJob;
    }

}
