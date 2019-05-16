package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 人工确认还款
 *
 * @author : cyl
 * @since : 2019-05-16 21:43
 */
@Data
public class XN630530Req {

    @NotBlank
    private List<String> code;// 还款计划编号


}
