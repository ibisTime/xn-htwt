package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 处理待办事项
 * @author: silver 
 * @since: Apr 3, 2019 2:06:17 PM 
 * @history:
 */
public class XN632521Req {

    @NotBlank
    private String code;

    @NotBlank
    private String operater;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

}
