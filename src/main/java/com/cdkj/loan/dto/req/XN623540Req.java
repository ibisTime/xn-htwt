package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 添加附件
 * @author: silver 
 * @since: Apr 2, 2019 5:39:08 PM 
 * @history:
 */
public class XN623540Req {

    // 业务编号
    @NotBlank
    private String bizCode;

    // 附件类型
    @NotBlank
    private String attachType;

    // url地址
    @NotBlank
    private String url;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getAttachType() {
        return attachType;
    }

    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
