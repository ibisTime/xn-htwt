package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class XN630420Req {

    @NotBlank
    private String isReferee;// 是否推荐

    @NotBlank(message = "名称不能为空")
    private String name; // 名称

    @NotBlank(message = "车系名称不能为空")
    private String seriesCode; // 车系名称

    @NotBlank
    private String bankCode;// 银行编号

    @NotBlank
    private String level;// 级别

    @NotBlank
    private String version;

    @NotBlank
    private String structure;

    @NotBlank
    private String displacement;

    @NotBlank
    private String fromPlace;

    @NotBlank
    private String procedure;

    @NotBlank(message = "原价不能为空")
    private String originalPrice; // 原价

    @NotBlank(message = "参考价不能为空")
    private String salePrice; // 参考价

    @NotBlank(message = "首付金额不能为空")
    private String sfAmount; // 首付金额

    private String fwAmount;// 服务费

    @NotBlank
    private String jsqByhf;

    @NotBlank
    private String jsqSybx;

    private String slogan; // 广告语

    @NotBlank(message = "广告图不能为空")
    private String advPic; // 广告图

    @NotBlank
    private String picNumber;

    @NotBlank(message = "缩略图不能为空")
    private String pic; // 缩略图

    @NotBlank(message = "图文描述不能为空")
    private String description; // 图文描述

    @NotBlank
    private String outsideColor;// 外部颜色

    @NotBlank
    private String insideColor;// 内部颜色

    @NotBlank(message = "最新修改人不能为空")
    private String updater; // 最新修改人

    private String remark; // 备注

    private List<String> configList;

    public List<String> getConfigList() {
        return configList;
    }

    public void setConfigList(List<String> configList) {
        this.configList = configList;
    }

    public String getOutsideColor() {
        return outsideColor;
    }

    public void setOutsideColor(String outsideColor) {
        this.outsideColor = outsideColor;
    }

    public String getInsideColor() {
        return insideColor;
    }

    public void setInsideColor(String insideColor) {
        this.insideColor = insideColor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeriesCode() {
        return seriesCode;
    }

    public void setSeriesCode(String seriesCode) {
        this.seriesCode = seriesCode;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(String sfAmount) {
        this.sfAmount = sfAmount;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getIsReferee() {
        return isReferee;
    }

    public void setIsReferee(String isReferee) {
        this.isReferee = isReferee;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getJsqByhf() {
        return jsqByhf;
    }

    public void setJsqByhf(String jsqByhf) {
        this.jsqByhf = jsqByhf;
    }

    public String getJsqSybx() {
        return jsqSybx;
    }

    public void setJsqSybx(String jsqSybx) {
        this.jsqSybx = jsqSybx;
    }

    public String getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(String picNumber) {
        this.picNumber = picNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getFwAmount() {
        return fwAmount;
    }

    public void setFwAmount(String fwAmount) {
        this.fwAmount = fwAmount;
    }

}
