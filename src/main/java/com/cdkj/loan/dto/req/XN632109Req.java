package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 主贷人和配偶一键互换
 * @author: CYL 
 * @since: 2018年11月6日 上午11:12:44 
 * @history:
 */
public class XN632109Req {

    // 贷款人编号
    @NotBlank
    private String selfCode;

    // 配偶编号
    @NotBlank
    private String wifeCode;

    public String getSelfCode() {
        return selfCode;
    }

    public void setSelfCode(String selfCode) {
        this.selfCode = selfCode;
    }

    public String getWifeCode() {
        return wifeCode;
    }

    public void setWifeCode(String wifeCode) {
        this.wifeCode = wifeCode;
    }

}
