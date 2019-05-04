package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午4:46:11 
 * @history:
 */
@Data
public class XN632032Req {
    // 编号
    @NotBlank
    private String code;

    // 银行编号
    @NotBlank
    private String bankCode;

    // 银行名称
    @NotBlank
    private String bankName;

    // 支行名称
    @NotBlank
    private String subbranch;

    // 12期
    private String rate12;

    // 18期
    private String rate18;

    // 24期
    private String rate24;

    // 36期
    private String rate36;

    // 更新人
    private String updater;

    // 备注
    private String remark;
    
}
