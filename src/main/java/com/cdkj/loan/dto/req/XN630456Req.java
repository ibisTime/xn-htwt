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
 * 详情查资讯
 * @author: taojian 
 * @since: 2019年3月12日 下午5:10:03 
 * @history:
 */
public class XN630456Req {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
