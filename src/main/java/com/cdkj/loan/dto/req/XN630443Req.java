/**
 * @Title XN630440Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author taojian  
 * @date 2019年3月12日 下午5:10:03 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 车型配置
 * @author: taojian 
 * @since: 2019年3月12日 下午5:10:03 
 * @history:
 */
public class XN630443Req {

    @NotBlank
    private String carCode;// 车型编号

    private List<String> configCodeList;// 配置编号列表

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public List<String> getConfigCodeList() {
        return configCodeList;
    }

    public void setConfigCodeList(List<String> configCodeList) {
        this.configCodeList = configCodeList;
    }

}
