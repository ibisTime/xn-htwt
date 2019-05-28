/**
 * @Title XNlh5010Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 下午5:00:54 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 所在市数据字典
 */
public class XN630038Req {

    // 父key（必填）
    @NotBlank(message = "不为空")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        key = key;
    }
}
