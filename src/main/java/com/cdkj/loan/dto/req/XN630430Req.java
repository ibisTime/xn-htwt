package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630430Req {

    @NotBlank(message = "申请人编号不能为空")
    private String userId; // 申请人编号

    @NotBlank(message = "申请人手机号不能为空")
    private String userMobile; // 申请人手机号

    @NotBlank(message = "车型编号不能为空")
    private String carCode; // 车型编号

    @NotBlank
    private String name;// 申请人姓名

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
