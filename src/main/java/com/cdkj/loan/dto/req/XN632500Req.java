package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 新录入准入单
 *
 * @author: taojian
 * @since: 2019年4月28日 上午10:19:41
 * @history:
 */
@Data
public class XN632500Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    @NotBlank
    // 处理类型(0 保存 1 发送)
    private String dealType;

    /***************贷款信息start**************/

    // 贷款期限
    private String loanPeriod;// repayBiz

    // 银行利率
    private String bankRate;

    // 贷款产品编号
    private String loanProductCode;// repayBiz

    // 年华费率
    private String yearRate;

    // GPS费用
    private String gpsFee;// carinfo

    // 公证费用
    private String authFee;// carinfo

    // 返点利率
    private String backRate;

    // 前置利率
    private Double preRate;

    // 首付金额
    private String firstAmount;// repayBiz

    // 首付比例
    private String firstRate;// repayBiz

    // 首月月供
    private String firstRepayAmount;// repayBiz

    // 月供金额

    private String monthAmount;// repayBiz

    // 是否垫资

    private String isAdvanceFund;// cdbiz

    // 是否融资

    private String isFinacing;// cdbiz

    // 是否安装gps

    private String isAzGps;// cdbiz

    // 是否我司续保
    private String isPlatInsure;

    // 月供保证金

    private String monthDeposit;// carInfo

    // 履约保证金

    private String lyDeposit;// repayBiz

    // 团队服务费

    private String teamFee;// carInfo

    /****************贷款信息end***************/

    /***************车辆信息start**************/

    // 机动车销售公司

    private String vehicleCompanyName;// carInfo

    // 开票单位

    private String invoiceCompany;// carInfo

    // 开票价

    private String invoicePrice;// carInfo

    // 车辆类型

    private String carType;// carInfo

    // 品牌

    private String carBrand;// carInfo

    // 车系

    private String carSeries;// carInfo

    // 车型

    private String carModel;// carInfo

    // 车型名称

    private String carModelName;// carInfo

    // 颜色

    private String carColor;// carInfo

    // 车架号

    private String carFrameNo;// carInfo

    // 发动机号

    private String carEngineNo;// carInfo

    // 市场指导价

    private String originalPrice;// carInfo

    // 所属区域

    private String region;// carInfo

    // 厂家贴息
    private String carDealerSubsidy;// carInfo

    // 油补公里数
    private String oilSubsidyKil;// carInfo

    // 油补
    private String oilSubsidy;// carInfo

    // 代理人

    private String pledgeUser;// carPledge

    // 代理人身份证复印件
    private String pledgeUserIdCard;// carPledge

    // 抵押地点

    private String pledgeAddress;// carPledge

    // 落户地点

    private String settleAddress;// carInfo

    // 车辆照片

    private String carPic;

    // 合格证

    private String carHgzPic;

    /****************车辆信息end***************/

    /***************客户信息start**************/
    // 性别

    private String gender;// creditUserExt

    // 年龄

    private String age;// creditUserExt

    // 民族

    private String nation;// creditUserExt

    // 学历

    private String education;// creditUserExt

    // 政治面貌

    private String political;// creditUserExt

    // 职业
    private String workProfession;// creditUserExt

    // 职称
    private String postTitle;// creditUserExt

    // 有无驾照
    private String isDriceLicense;// creditUserExt

    // 现有车辆
    private String carTypeNow;// creditUserExt

    // 主要收入来源

    private String mainIncome;// creditUserExt

    // 家庭紧急联系人信息1 姓名

    private String emergencyName1;// creditUserExt

    // 家庭紧急联系人信息1 与申请人关系

    private String emergencyRelation1;// creditUserExt

    // 家庭紧急联系人信息1 手机号码

    private String emergencyMobile1;// creditUserExt

    // 家庭紧急联系人信息2 姓名
    private String emergencyName2;// creditUserExt

    // 家庭紧急联系人信息2 与申请人关系
    private String emergencyRelation2;// creditUserExt

    // 家庭紧急联系人信息2 手机号码
    private String emergencyMobile2;// creditUserExt

    /****************客户信息end***************/

    /***************家庭情况start**************/

    // 婚姻状况

    private String marryState;// creditUserExt

    // 家庭人口

    private String familyNumber;// creditUserExt

    // 家庭电话

    private String familyPhone;// creditUserExt

    // 家庭主要财产

    private String familyMainAsset;// creditUserExt

    // 主要财产包括

    private String mainAssetInclude;// creditUserExt

    // 户口所在地

    private String residenceAddress;// creditUser

    // 户口所在地邮编2

    private String postCode2;// creditUser

    // 现居住地址

    private String nowAddress;// creditUserExt

    // 现居住地址邮编1

    private String postCode;// creditUserExt

    // 户口本资料
    private String hkBookPdf;

    // 结婚证资料
    private String marryPdf;

    // 购房合同
    private String houseContract;

    // 购房发票
    private String houseInvoice;

    // 居住证明
    private String liveProvePdf;

    // 自建房证明
    private String buildProvePdf;

    // 家访照片
    private String housePictureApply;

    /****************家庭情况end***************/

    /***************工作情况start**************/

    // 是否自己单位
    private String isSelfCompany;// creditUserExt

    // 所属行业
    private String workBelongIndustry;// creditUserExt

    // 单位性质
    private String workCompanyProperty;// creditUserExt

    // 工作单位名称

    private String workCompanyName;// creditUser

    // 工作单位地址

    private String workCompanyAddress;// creditUser

    // 工作单位电话
    private String workPhone;// creditUser

    // 何时进入现单位工作
    private String workDatetime;// creditUserExt

    // 职位
    private String position;// creditUserExt

    // 月收入

    private String monthIncome;// creditUserExt

    // 收入证明
    private String improvePdf;

    // 单位前台照片
    private String frontTablePic;

    // 单位场地照片
    private String workPlacePic;

    // 业务员与客户合影
    private String salerAndcustomer;

    /****************工作情况end***************/

    /***************共还人信息start**************/

    // 户籍地省市区
    private String mateBirthAddressProvince;// creditUser

    private String mateBirthAddressCity;// creditUser

    private String mateBirthAddressArea;// creditUser

    // 户籍地地址
    private String mateBirthAddress;// creditUser

    // 户籍地邮编
    private String matePostCode;// creditUser

    // 配偶学历
    private String mateEducation;// creditUser

    // 配偶工作单位名称
    private String mateCompanyName;// creditUser

    // 配偶工作单位地址
    private String mateCompanyAddress;// creditUser

    // 配偶工作单位联系电话
    private String mateCompanyContactNo;// creditUser

    private String mateAssetPdf;

    /****************共还人信息end***************/

    /***************担保人信息start**************/

    // 户籍地省市区
    private String guaBirthAddressProvince;// creditUser

    private String guaBirthAddressCity;// creditUser

    private String guaBirthAddressArea;// creditUser

    // 户籍地地址
    private String guaBirthAddress;// creditUser

    // 户籍地邮编
    private String guaPostCode;// creditUser

    // 配偶学历
    private String guaEducation;// creditUser

    // 配偶工作单位名称
    private String guaCompanyName;// creditUser

    // 配偶工作单位地址
    private String guaCompanyAddress;// creditUser

    // 配偶工作单位联系电话
    private String guaCompanyContactNo;// creditUser

    private String guaAssetPdf;

    /****************担保人信息end***************/

    /**************冗余字段*****************/
    // 工作描述及还款来源分析
    private String otherWorkNote;

    // 工作资料上传
    private String workAssetPdf;

    // 其他资料
    private String otherPdf;

    // 身份证资料
    private String idCardPdf;

    // 其他辅助资料
    private String otherPic;

    // 房屋照片
    private String housePicture;

    /*******************************/
}
