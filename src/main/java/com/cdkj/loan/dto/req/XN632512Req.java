/**
 * @Title XN632515Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author taojian  
 * @date 2019年4月2日 下午7:34:42 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 工行制卡
 */
public class XN632512Req {

    // 编号
    @NotBlank
    private String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }




}
