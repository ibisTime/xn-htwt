package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.List;
import lombok.Data;

/**
 * 征信人员
 *
 * @author: jiafr
 * @since: 2018年5月24日 下午9:32:23
 * @history:
 */
@Data
public class CreditUser extends ABaseDO {

    /** ************************ 征信结果信息 ************************** */

    /**
     * 征信人员编号
     */
    private String code;

    /**
     * 预算单编号
     */
    private String bizCode;

    /**
     * 征信人类型（主贷人/配偶/担保人）
     */
    private String relation;

    /**
     * 贷款角色
     */
    private String loanRole;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 英文名
     */
    private String englishName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 证件类型
     */
    private String idKind;

    /**
     * 证件号码
     */
    private String idNo;

    /**
     * 发证机关
     */
    private String authref;

    /**
     * 证件有效期（yyyymmdd）
     */
    private String statdate;

    /**
     * 信用卡占比
     */
    private Double creditCardOccupation;

    /**
     * 银行征信结果
     */
    private String bankCreditResult;

    /**
     * 银行征信结果说明
     */
    private String bankCreditResultRemark;

    /** ************************ 客户基本信息 ************************ */

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 政治面貌
     */
    private String political;

    /**
     * 民族
     */
    private String nation;

    /**
     * 学历
     */
    private String education;

    /**
     * 职业
     */
    private String workProfession;

    /**
     * 职称
     */
    private String postTitle;

    /**
     * 客户生日
     */
    private String customerBirth;

    /**
     * 现有车辆类型
     */
    private String carType;

    /**
     * 有无驾照
     */
    private String isDriceLicense;

    /**
     * 主要收入来源
     */
    private String mainIncome;

    /**
     * 其他收入说明
     */
    private String otherIncomeNote;

    /**
     * 房产证情况
     */
    private String isHouseProperty;

    /** *********************** 紧急联系人信息 ************************ */

    /**
     * 联系人1姓名
     */
    private String emergencyName1;

    /**
     * 联系人1性别
     */
    private String emergencySex1;

    /**
     * 联系人1与申请人关系
     */
    private String emergencyRelation1;

    /**
     * 联系人1手机号码
     */
    private String emergencyMobile1;

    /**
     * 联系人2姓名
     */
    private String emergencyName2;

    /**
     * 联系人2性别
     */
    private String emergencySex2;

    /**
     * 联系人2与申请人关系
     */
    private String emergencyRelation2;

    /**
     * 联系人2手机号码
     */
    private String emergencyMobile2;

    /** *********************** 工作信息 ************************ */

    /**
     * 所属行业
     */
    private String workBelongIndustry;

    /**
     * 单位性质
     */
    private String workCompanyProperty;

    /**
     * 工作单位名称
     */
    private String companyName;

    /**
     * 工作单位所在省
     */
    private String companyProvince;

    /**
     * 工作单位所在市
     */
    private String companyCity;

    /**
     * 工作单位所在区
     */
    private String companyArea;

    /**
     * 工作单位地址
     */
    private String companyAddress;

    /**
     * 工作单位联系电话
     */
    private String companyContactNo;

    /**
     * 何时进入现单位工作
     */
    private String workDatetime;

    /**
     * 职位
     */
    private String position;

    /**
     * 员工数量
     */
    private String employeeQuantity;

    /**
     * 企业月产值
     */
    private String enterpriseMonthOutput;

    /**
     * 月收入
     */
    private Long monthIncome;

    /**
     * 工作描述及还款来源分析（已确定）
     */
    private String otherWorkNote;

    /** ********************** 家庭信息 ************************ */

    /**
     * 婚姻状况
     */
    private String marryState;

    /**
     * 家庭人口
     */
    private Integer familyNumber;

    /**
     * 家庭电话
     */
    private String familyPhone;

    /**
     * 家庭主要财产
     */
    private String familyMainAsset;

    /**
     * 主要财产包括
     */
    private String mainAssetInclude;

    /**
     * 户籍地省
     */
    private String birthAddressProvince;

    /**
     * 户籍地市
     */
    private String birthAddressCity;

    /**
     * 户籍地区
     */
    private String birthAddressArea;

    /**
     * 户籍地详细地址
     */
    private String birthAddress;

    /**
     * 户口所在地邮编
     */
    private String birthPostCode;

    /**
     * 现住房屋类型
     */
    private String nowHouseType;

    /**
     * 现住地址省
     */
    private String nowAddressProvince;

    /**
     * 现住地址市
     */
    private String nowAddressCity;

    /**
     * 现住地址区
     */
    private String nowAddressArea;

    /**
     * 现居住地址
     */
    private String nowAddress;

    /**
     * 何时入住现居住地址
     */
    private String nowAddressDate;

    /**
     * 现居住地址邮编
     */
    private String nowPostCode;

    /**
     * 是否为第一担保人
     */
    private String isFirstGua;

    /**
     * ******************* 辅助字段 ************************
     */

    // 征信人员列表
    private List<CreditUser> creditUserList;

    /**
     * 征信报告
     */
    // 工行征信编号
    private String icbankCode;

    // 工行征信结果
    private String result;

    // 工行征信贷款逾期记录
    private String loanCrdt;

    // 工行征信信用卡逾期记录
    private String cardCrdt;

    // 工行征信专项卡分期笔数
    private Long leftNum;

    // 工行征信未结清余额
    private Long leftAmount;

    // 工行征信备注
    private String note;

    // 工行征信回调状态
    private String status;

    private List<Attachment> attachments;

    /**
     * ************** 附件图片 ************************
     */
    private String idFront;

    private String idReverse;

    private String authPdf;

    private String interviewPic;

    private String dataCreditReport;

    private String BankCreditReport;

    private String driceLicense;

    private String marryPdf;

    private String otherPdf;

    private String workAssetPdf;

    private String singleProvePdf;

    private String incomeProvePdf;

    private String liveProvePdf;

    private String buildProvePdf;
}
