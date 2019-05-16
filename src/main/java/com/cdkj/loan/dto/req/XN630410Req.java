package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN630410Req {

    @NotBlank(message = "品牌编号不能为空")
    private String brandCode;// 品牌编号

    @NotBlank(message = "名称不能为空")
    private String name; // 名称

    private String slogan;// 广告语

    @NotBlank(message = "广告图不能为空")
    private String advPic;// 广告图

    @NotBlank
    private String picNumber;// 图片数量

    @NotBlank
    private String level;// 级别

    @NotBlank
    private String isReferee;// 是否推荐

    @NotBlank(message = "最新修改人不能为空")
    private String updater;// 最新修改人

    private String remark;// 备注

    public String getBrandCode() {

        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(String picNumber) {
        this.picNumber = picNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIsReferee() {
        return isReferee;
    }

    public void setIsReferee(String isReferee) {
        this.isReferee = isReferee;
    }

}
