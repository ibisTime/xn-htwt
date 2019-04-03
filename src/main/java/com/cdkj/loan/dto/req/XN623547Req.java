package com.cdkj.loan.dto.req;

/**
 * 列表查附件
 * @author: silver 
 * @since: Apr 2, 2019 5:39:08 PM 
 * @history:
 */
public class XN623547Req extends AListReq {

    private static final long serialVersionUID = 7449070659363764165L;

    // 业务编号
    private String bizCode;

    // 附件类型
    private String attachType;

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

}
