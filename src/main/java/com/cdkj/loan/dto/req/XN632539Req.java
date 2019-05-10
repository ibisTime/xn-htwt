package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-抵押信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
@Data
public class XN632539Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /**************抵押信息*****************/

    // 代理人
    private String pledgeUser;

    // 代理人身份证号
    private String pledgeUserIdCard;

    // 代理人身份证正
    private String pledgeUserIdCardFront;

    // 代理人身份证反
    private String pledgeUserIdCardReverse;

    // 抵押地点
    private String pledgeAddress;

    /*******************************/
}
