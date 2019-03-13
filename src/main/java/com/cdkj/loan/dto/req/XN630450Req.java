/**
 * @Title XN630440Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author taojian  
 * @date 2019年3月12日 下午5:10:03 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 新增资讯
 * @author: taojian 
 * @since: 2019年3月12日 下午5:10:03 
 * @history:
 */
public class XN630450Req {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String advPic;

    @NotBlank
    private String picNumber;

    @NotBlank
    private String pic;

    @NotBlank
    private String context;

    @NotBlank
    private String tag;

    @NotBlank
    private String updater;

    private String remark;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getPicNumber() {
        return picNumber;
    }

    public void setPicNumber(String picNumber) {
        this.picNumber = picNumber;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

}
