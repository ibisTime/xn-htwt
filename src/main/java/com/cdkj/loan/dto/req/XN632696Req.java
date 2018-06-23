package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 详情查询出差申请
 * @author: jiafr 
 * @since: 2018年6月23日 下午5:31:11 
 * @history:
 */
public class XN632696Req {

    // 出差申请编号(必填)
    @NotBlank(message = "编号不能为空")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
