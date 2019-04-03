package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 资源池
* @author: silver 
* @since: 2019-04-03 17:44:41
* @history:
*/
public class FilePool extends ABaseDO {

    private static final long serialVersionUID = 5377164956974574120L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 资源名称
    private String fileName;

    // 文件类型（图，网页，视频）
    private String fileType;

    // 数量
    private String number;

    // url地址
    private String url;

    // 创建时间
    private Date createDatetime;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

}
