package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-车辆信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
@Data
public class XN632531Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    /***************车辆信息start**************/

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

    // 车辆照片
    private String carPic;

    // 合格证
    private String carHgzPic;

    /****************车辆信息end***************/
}
