package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 车辆信息
 *
 * @author: tao
 * @since: 2019-04-24 09:37:43
 * @history:
 */
@Data
public class CarInfo extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 业务编号
    private String bizCode;

    // 品牌
    private String carBrand;

    // 车系
    private String carSeries;

    // 车型
    private String carModel;

    // 上牌时间
    private String regDate;

    // 行驶公里数
    private String mile;

    // 车型名称
    private String carModelName;

    // 车辆类型
    private String carType;

    // 颜色
    private String carColor;

    // 车架号
    private String carFrameNo;

    // 发动机号
    private String carEngineNo;

    // 市场指导价
    private String originalPrice;

    // 开票价
    private String invoicePrice;

    // 机动车销售公司
    private String vehicleCompanyName;

    // 开票单位
    private String invoiceCompany;

    // 所属区域
    private String region;

    // 评估栏
    private String evaluateColumn;

    // 保单日期
    private Date policyDatetime;

    // 保单到期日
    private Date policyDueDate;

    // 汽车经销商编号
    private String carDealerCode;

    // 汽车经销商名称（外单）
    private String outCarDealerName;

    // 购车途径
    private String shopWay;

    // 商业险合计
    private String commerceInsurance;

    // 担保合同编号
    private String guaranteeContractCode;

    // 银行合同编号
    private String bankContractCode;

    // 合同签订日
    private String contractSignDate;

    // 登记证书号
    private String regCertificateCode;

    // 里程表
    private String secondOdometer;

    // 核准链接
    private String checkApproveLink;

    // 核准软件
    private String checkApproveSoftware;

    // 信息源
    private String informationSource;

    // 评估价
    private String valuation;

    // 车行168车价
    private String car168Price;

    // 铭牌
    private String secondNumber;

    // 发票是否正确
    private String isRightInvoice;

    // 现发票价
    private String currentInvoicePrice;

    // 绿大本编号
    private String greenBigCode;

    // 车牌号
    private String carNumber;

    // 车辆落户日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date carSettleDatetime;

    // 落户地点
    private String settleAddress;

    // 汽车经销商厂家贴息
    private String carDealerSubsidy;

    // 油补
    private String oilSubsidy;

    // 油补公里数
    private String oilSubsidyKil;

    // GPS提成
    private String gpsDeduct;

    // GPS收费方式（1转账2按揭款3返点4不收费）
    private String gpsFeeWay;

    // GPS费用
    private Long gpsFee;

    // 公证费
    private Long authFee;

    // 其他费用
    private Long otherFee;

    // 公司服务费
    private Long companyFee;

    // 团队服务费
    private Long teamFee;

    // 银行服务费
    private Long bankFee;

    // 月供保证金
    private Long monthDeposit;

    /****DB Properties****/

    // 绿大本扫描件
    private String greenBigSmj;

    // 发票
    private String carInvoice;

    // 交强险
    private String carJqx;

    // 商业险
    private String carSyx;

}
