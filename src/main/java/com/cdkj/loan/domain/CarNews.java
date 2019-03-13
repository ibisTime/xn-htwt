package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 车辆资讯
* @author: jiafr 
* @since: 2019-03-13 10:40:15
* @history:
*/
public class CarNews extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 标题
    private String title;

    // 作者
    private String author;

    // 广告图
    private String advPic;

    // 图片数量
    private Long picNumber;

    // 缩略图
    private String pic;

    // 阅读次数
    private Long readCount;

    // 内容
    private String context;

    // 标签
    private String tag;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setPicNumber(Long picNumber) {
        this.picNumber = picNumber;
    }

    public Long getPicNumber() {
        return picNumber;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
