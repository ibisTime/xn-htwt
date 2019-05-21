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
 * 详情查业务
 *
 * @author: taojian
 * @since: 2019年4月2日 下午7:34:42
 * @history:
 */
public class XN632516Req {

    @NotBlank
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
