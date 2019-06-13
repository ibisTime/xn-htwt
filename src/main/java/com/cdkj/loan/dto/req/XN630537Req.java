package com.cdkj.loan.dto.req;

import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 人工确认逾期
 *
 * @author : cyl
 * @since : 2019-05-16 21:43
 */
@Data
public class XN630537Req {

    @NotEmpty
    private List<String> codeList;// 还款计划编号

    // 操作人
    @NotBlank
    private String operator;

}
