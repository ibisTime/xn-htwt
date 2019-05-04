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

    // 直客12期
    private String zkRate12;

    // 直客18期
    private String zkRate18;

    // 直客24期
    private String zkRate24;

    // 直客36期
    private String zkRate36;

    // 银行地址
    private String address;

    // 电话号码
    private String phoneNumber;

    // 邮编
    private String postCode;

    // 银行委托人
    private String bankClient;

    // 委托有效期
    private String clientValidDate;

    // 授权人姓名
    private String autherName;

    // 授权人电话
    private String autherPhoneNumber;

    // 授权人身份证
    private String autherIdNo;

    // 授权人地址
    private String autherAddress;

    // 信用卡类型
    private String creditCardType;

    // 信用卡名称
    private String creditCardName;

    // 所属地区
    private String belongArea;

    // 更新人
    private String updater;

    // 备注
    private String remark;
    
}
