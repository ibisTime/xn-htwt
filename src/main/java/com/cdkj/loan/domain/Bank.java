package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;

/**
 * 银行信息
 * @author: silver 
 * @since: 2018年5月27日 下午3:43:43 
 * @history:
 */
@Data
public class Bank extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 7671886097276757226L;

    // 编号
    private String code;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 开户支行名称
    private String subbranch;

    // 12期
    private Double rate12;

    // 18期
    private Double rate18;

    // 24期
    private Double rate24;

    // 36期
    private Double rate36;

    // 直客12期
    private Double zkRate12;

    // 直客18期
    private Double zkRate18;

    // 直客24期
    private Double zkRate24;

    // 直客36期
    private Double zkRate36;

    // 银行地址
    private String address;

    // 电话号码
    private String phoneNumber;

    // 邮编
    private String postCode;

    // 银行委托人
    private String bankClient;

    // 委托有效期
    private Date clientValidDate;

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

    // 状态(预留)
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;


    /*---------辅助字段-----------*/

    // 更新人名称
    private String updaterName;

    // 支行名称
    private String subbranchQuery;
}
