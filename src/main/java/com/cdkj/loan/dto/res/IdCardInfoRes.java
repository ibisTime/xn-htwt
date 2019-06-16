package com.cdkj.loan.dto.res;

import lombok.Data;

/**
 * @author : cyl
 * @since : 2019-06-16 16:53
 */
@Data
public class IdCardInfoRes {

    /**
     * 姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 民族
     */
    private String nationality;

    /**
     * 身份证号
     */
    private String idNo;

    /**
     * 生日
     */
    private String birth;

    /**
     * 地址
     */
    private String residenceAddress;

    /**
     * 发证机关
     */
    private String issue;

    /**
     * 证件有效期
     */
    private String endDate;

}

    
    