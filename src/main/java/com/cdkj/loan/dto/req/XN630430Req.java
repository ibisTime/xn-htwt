package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630430Req {

    @NotBlank(message = "申请人编号不能为空")
    private String userId; // 申请人编号

    @NotBlank(message = "申请人手机号不能为空")
    private String userMobile; // 申请人手机号

    @NotBlank(message = "车型编号不能为空")
    private String carCode; // 车型编号

    @NotBlank(message = "分期期数不能为空")
    private String periods; // 分期期数

    @NotBlank(message = "计算器信息不能为空")
    private String saleDesc; // 计算器信息

    private String remark; // 备注

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getPeriods() {
        return periods;
    }

    public void setPeriods(String periods) {
        this.periods = periods;
    }

    public String getSaleDesc() {
        return saleDesc;
    }

    public void setSaleDesc(String saleDesc) {
        this.saleDesc = saleDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
