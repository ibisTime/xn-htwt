package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-客户信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
@Data
public class XN632532Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /**
     * **********客户信息start*************
     */
    // 性别
    private String gender;

    // 英文名
    private String englishName;

    //发证机关
    private String authref;

    //证件有效期
    private String statdate;

    // 年龄
    private String age;

    // 民族
    private String nation;

    // 学历
    private String education;

    // 政治面貌
    private String political;

    // 职业
    private String workProfession;

    // 职称
    private String postTitle;

    // 有无驾照
    private String isDriceLicense;

    // 现有车辆
    private String carType;

    // 主要收入来源
    private String mainIncome;

    /**
     * 其他收入说明
     */
    private String otherIncomeNote;

    /**
     * 房产证情况
     */
    private String isHouseProperty;

    // 家庭紧急联系人信息1 姓名
    private String emergencyName1;

    // 家庭紧急联系人信息1 性别
    private String emergencySex1;

    // 家庭紧急联系人信息1 与申请人关系
    private String emergencyRelation1;

    // 家庭紧急联系人信息1 手机号码
    private String emergencyMobile1;

    // 家庭紧急联系人信息2 姓名
    private String emergencyName2;

    // 家庭紧急联系人信息2 性别
    private String emergencySex2;

    // 家庭紧急联系人信息2 与申请人关系
    private String emergencyRelation2;

    // 家庭紧急联系人信息2 手机号码
    private String emergencyMobile2;

    /**
     * ***********客户信息end**************
     */
}
