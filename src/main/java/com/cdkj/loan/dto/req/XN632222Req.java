package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入档清单
 *
 * @author : cyl
 * @since : 2019-05-11 14:40
 */
@Data
public class XN632222Req {

    // 入档清单编号
    @NotBlank
    private String code;

    // 内容
    @NotBlank
    private String content;

    // 份数
    @NotBlank
    private String fileCount;

    // 存放时间
    @NotBlank
    private String depositDateTime;

    // 存放人
    @NotBlank
    private String operator;

    // 备注
    @NotBlank
    private String remark;
}

    
    