package com.cdkj.loan.dto.req;

import java.util.List;

/**
 * 订单分页查询
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN808070Req {

    // 状态
    private List<String> statusList;

    private String status;

    // 下单人
    private String applyUser;

    // 发货人
    private String deiverer;

    // 物流公司
    private String logisticsCompany;

    // 物流单号
    private String logisticsCode;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeiverer() {
        return deiverer;
    }

    public void setDeiverer(String deiverer) {
        this.deiverer = deiverer;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

}
