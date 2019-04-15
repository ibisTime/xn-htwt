package com.cdkj.loan.dto.req;

public class XN630416Req extends AListReq {

    private String name; // 名称（选填）

    private String brandCode; // 品牌编号（选填）

    private String location;// UI位置

    private String status; // 状态（选填）

    private String isReferee;// 是否推荐

    public String getIsReferee() {
        return isReferee;
    }

    public void setIsReferee(String isReferee) {
        this.isReferee = isReferee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
