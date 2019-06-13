package com.cdkj.loan.dto.res;

import java.util.Date;
import lombok.Data;

/**
 * 车辆信息res
 *
 * @author : cyl
 * @since : 2019-05-03 15:42
 */
@Data
public class CarInfoRes {

    // 机动车销售公司
    private String vehicleCompanyName;// carInfo

    // 开票单位
    private String invoiceCompany;// carInfo

    // 车辆类型
    private String carType;// carInfo

    // 品牌
    private String carBrand;// carInfo

    // 车系
    private String carSeries;// carInfo

    // 车型
    private String carModel;// carInfo

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

    // 落户地点
    private String settleAddress;// carInfo

    // 车牌号
    private String carNumber;

    // 车辆落户日期
    private Date carSettleDatetime;// carInfo

    // 保单日期
    private Date policyDatetime;

    // 保单到期日
    private Date policyDueDate;

    // 车辆照片
    private String carPic;

    // 合格证
    private String carHgzPic;

    // 开票价
    private String invoicePrice;// carInfo

    // 银行服务费
    private Long bankFee;// carInfo

}
