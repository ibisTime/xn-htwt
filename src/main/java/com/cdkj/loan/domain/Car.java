package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

public class Car extends ABaseDO {

    private static final long serialVersionUID = 8968327303357507883L;

    private String code; // 编号

    private String isReferee;// 是否推荐

    private String name; // 名称

    private String seriesCode;// 车系编号

    private String seriesName;// 车系名称

    private String brandCode;// 品牌编号

    private String brandName;// 品牌名称

    private String bankCode;// 银行编号

    private String level;// 级别

    private String version;// 规格/版本

    private String structure;// 结构

    private Double displacement;// 排量

    private String fromPlace;// 车源地

    private String procedure;// 手续

    private Long originalPrice;// 原价

    private Long salePrice;// 参考价

    private Long sfAmount; // 首付金额

    private Long fwAmount;// 服务费

    private String jsqByhf;// 必要花费

    private String jsqSybx;// 商业保险

    private Integer location;// UI位置

    private Integer orderNo;// UI次序

    private String slogan;// 广告语

    private String advPic;// 广告图

    private Long picNumber;// 图片数量

    private String pic;// 缩略图

    private String description;// 图文描述

    private String outsideColor;// 外部颜色

    private String insideColor;// 内部颜色

    private String status;// 状态（待上架/已上架/已下架）

    private String updater;// 最新修改人

    private Date updateDatetime;// 最新修改时间

    private String remark;// 备注

    /*---------辅助字段----------*/

    // 最新修改人姓名
    private String updaterName;

    // 搜索名称
    private String queryName;

    // 排量起
    private Double displacementStart;

    // 排量止
    private Double displacementEnd;

    // 价格起
    private Long priceStart;

    // 价格止
    private Long priceEnd;

    // 级别列表
    private List<String> levelList;

    // 结构列表
    private List<String> structureList;

    // 规格版本列表
    private List<String> versionList;

    // 车型配置列表
    private List<CarCarconfig> caonfigList;

    // 收藏数
    private Long collectNumber;

    // 全部配置
    private List<Carconfig> configs;

    private String isMore;

    public String getIsMore() {
        return isMore;
    }

    public void setIsMore(String isMore) {
        this.isMore = isMore;
    }

    public List<Carconfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<Carconfig> configs) {
        this.configs = configs;
    }

    public Long getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Long collectNumber) {
        this.collectNumber = collectNumber;
    }

    private String isCollect;// 是否收藏

    public String getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(String isCollect) {
        this.isCollect = isCollect;
    }

    public Double getDisplacementStart() {
        return displacementStart;
    }

    public void setDisplacementStart(Double displacementStart) {
        this.displacementStart = displacementStart;
    }

    public Double getDisplacementEnd() {
        return displacementEnd;
    }

    public void setDisplacementEnd(Double displacementEnd) {
        this.displacementEnd = displacementEnd;
    }

    public Long getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(Long priceStart) {
        this.priceStart = priceStart;
    }

    public Long getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Long priceEnd) {
        this.priceEnd = priceEnd;
    }

    public List<String> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<String> levelList) {
        this.levelList = levelList;
    }

    public List<String> getStructureList() {
        return structureList;
    }

    public void setStructureList(List<String> structureList) {
        this.structureList = structureList;
    }

    public List<String> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<String> versionList) {
        this.versionList = versionList;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public Long getSfAmount() {
        return sfAmount;
    }

    public void setSfAmount(Long sfAmount) {
        this.sfAmount = sfAmount;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Double getDisplacment() {
        return displacement;
    }

    public void setDisplacment(Double displacment) {
        this.displacement = displacment;
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

    public Long getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(Long picNumber) {
        this.picNumber = picNumber;
    }

    public Long getFwAmount() {
        return fwAmount;
    }

    public void setFwAmount(Long fwAmount) {
        this.fwAmount = fwAmount;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public List<CarCarconfig> getCaonfigList() {
        return caonfigList;
    }

    public void setCaonfigList(List<CarCarconfig> caonfigList) {
        this.caonfigList = caonfigList;
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

}
