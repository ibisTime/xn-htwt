package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 征信详情查询
 * @author: jiafr 
 * @since: 2018年5月26日 下午2:35:44 
 * @history:
 */
@Data
public class XN632117Req {

    // 征信人员编号
    @NotBlank
    private String creditUserCode;


}
