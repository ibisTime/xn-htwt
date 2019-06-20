package com.cdkj.loan.dto.req;

import java.util.List;

public class XN630432Req extends APageReq {

    private String name; // 名称

    private String seriesCode;// 车系编号

    private String seriesName;// 车系名称

    private String brandCode;// 品牌编号

    private String brandName;// 品牌名称

    private String status;// 状态（待上架/已上架/已下架）

    private String isReferee;

    private String displacementEnd;

    private String displacementStart;

    private String location;

    private String priceStart;

    private String priceEnd;

    private String queryName;

    private List<String> levelList;

    private List<String> structureList;

    private List<String> versionList;

    private String isMore;

    public String getIsMore() {
        return isMore;
    }

    public void setIsMore(String isMore) {
        this.isMore = isMore;
    }

    public String getIsReferee() {
        return isReferee;
    }

    public void setIsReferee(String isReferee) {
        this.isReferee = isReferee;
    }

    public String getDisplacementEnd() {
        return displacementEnd;
    }

    public void setDisplacementEnd(String displacementEnd) {
        this.displacementEnd = displacementEnd;
    }

    public String getDisplacementStart() {
        return displacementStart;
    }

    public void setDisplacementStart(String displacementStart) {
        this.displacementStart = displacementStart;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPriceStart() {
        return priceStart;
    }

    public void setPriceStart(String priceStart) {
        this.priceStart = priceStart;
    }

    public String getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(String priceEnd) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

}
