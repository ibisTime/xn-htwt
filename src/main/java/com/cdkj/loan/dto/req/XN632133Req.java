package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-内勤录入抵押信息
 *
 * @author: xieyj
 * @since: 2018年5月29日 下午10:31:16
 * @history:
 */
@Data
public class XN632133Req {

    @NotBlank
    private String code;// 预算单编号

    // 车牌号
    @NotBlank
    private String carNumber;

    // 登记证书
    @NotBlank
    private String carRegcerti;

    // 车辆批单
    @NotBlank
    private String carPd;

    // 车钥匙
    @NotBlank
    private String carKey;

    // 大本扫描件
    @NotBlank
    private String carBigSmj;

    // 车辆行驶证扫描件
    @NotBlank
    private String carXszSmj;

    // 完税证明扫描件
    @NotBlank
    private String dutyPaidProveSmj;

    // 抵押日期
    private String pledgeDatetime;

    // 车辆落户日期
    @NotBlank
    private String carSettleDatetime;

    // 落户地点
    @NotBlank
    private String settleAddress;

    // 代理人
    @NotBlank
    private String pledgeUser;

    // 代理人身份证号
    @NotBlank
    private String pledgeUserIdCard;

    // 代理人身份证正
    @NotBlank
    private String pledgeUserIdCardFront;

    // 代理人身份证反
    @NotBlank
    private String pledgeUserIdCardReverse;

    @NotBlank
    private String operator;// 操作人

}
