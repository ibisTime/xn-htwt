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
 * 列表查车型配置
 * @author: taojian 
 * @since: 2019年3月12日 下午5:10:03 
 * @history:
 */
public class XN630448Req {

    @NotBlank
    private String carCode;// 车型编号

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

}
