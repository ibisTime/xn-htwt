package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改入准入单-车辆信息
 *
 * @author : cyl
 * @since : 2019-05-02 19:29
 */
public class XN632531Req {

    // 业务编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    @NotBlank
    // 处理类型(0 保存 1 发送)
    private String dealType;

    /***************车辆信息start**************/

    // 机动车销售公司
    @NotBlank
    private String vehicleCompanyName;// carInfo

    // 开票单位
    @NotBlank
    private String invoiceCompany;// carInfo

    // 车辆类型
    @NotBlank
    private String carType;// carInfo

    // 品牌
    @NotBlank
    private String carBrand;// carInfo

    // 车系
    @NotBlank
    private String carSeries;// carInfo

    // 车型
    @NotBlank
    private String carModel;// carInfo

    // 颜色
    @NotBlank
    private String carColor;// carInfo

    // 车架号
    @NotBlank
    private String carFrameNo;// carInfo

    // 发动机号
    @NotBlank
    private String carEngineNo;// carInfo

    // 市场指导价
    @NotBlank
    private String originalPrice;// carInfo

    // 所属区域
    @NotBlank
    private String region;// carInfo

    // 厂家贴息
    @NotBlank
    private String carDealerSubsidy;// carInfo

    // 油补公里数
    @NotBlank
    private String oilSubsidyKil;// carInfo

    // 油补
    private String oilSubsidy;// carInfo

    // 落户地点
    @NotBlank
    private String settleAddress;// carInfo

    // 车辆照片
    @NotBlank
    private String carPic;

    // 合格证
    @NotBlank
    private String carHgzPic;

    /****************车辆信息end***************/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getVehicleCompanyName() {
        return vehicleCompanyName;
    }

    public void setVehicleCompanyName(String vehicleCompanyName) {
        this.vehicleCompanyName = vehicleCompanyName;
    }

    public String getInvoiceCompany() {
        return invoiceCompany;
    }

    public void setInvoiceCompany(String invoiceCompany) {
        this.invoiceCompany = invoiceCompany;
    }


    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }


    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public String getCarEngineNo() {
        return carEngineNo;
    }

    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCarDealerSubsidy() {
        return carDealerSubsidy;
    }

    public void setCarDealerSubsidy(String carDealerSubsidy) {
        this.carDealerSubsidy = carDealerSubsidy;
    }

    public String getOilSubsidyKil() {
        return oilSubsidyKil;
    }

    public void setOilSubsidyKil(String oilSubsidyKil) {
        this.oilSubsidyKil = oilSubsidyKil;
    }

    public String getOilSubsidy() {
        return oilSubsidy;
    }

    public void setOilSubsidy(String oilSubsidy) {
        this.oilSubsidy = oilSubsidy;
    }


    public String getSettleAddress() {
        return settleAddress;
    }

    public void setSettleAddress(String settleAddress) {
        this.settleAddress = settleAddress;
    }

    public String getCarPic() {
        return carPic;
    }

    public void setCarPic(String carPic) {
        this.carPic = carPic;
    }

    public String getCarHgzPic() {
        return carHgzPic;
    }

    public void setCarHgzPic(String carHgzPic) {
        this.carHgzPic = carHgzPic;
    }
}
