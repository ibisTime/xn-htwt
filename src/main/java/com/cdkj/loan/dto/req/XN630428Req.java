/**
 * @Title XN630428Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author taojian  
 * @date 2019年3月13日 下午4:55:23 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 车贷计算器
 * @author: taojian 
 * @since: 2019年3月13日 下午4:55:23 
 * @history:
 */
public class XN630428Req {

    @NotBlank
    private String carCode;

    @NotBlank
    private String period;

    @NotBlank
    private String isTotal;

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getIsTotal() {
        return isTotal;
    }

    public void setIsTotal(String isTotal) {
        this.isTotal = isTotal;
    }
}
