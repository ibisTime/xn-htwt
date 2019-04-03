package com.cdkj.loan.dto.req;

/**
 * 分页查资源
 * @author: silver 
 * @since: Apr 2, 2019 5:39:08 PM 
 * @history:
 */
public class XN623595Req extends APageReq {

    private static final long serialVersionUID = 7449070659363764165L;

    // 业务编号
    private String bizCode;

    // 资源名称
    private String fileName;

    // 文件类型（图，网页，视频）
    private String fileType;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

}
