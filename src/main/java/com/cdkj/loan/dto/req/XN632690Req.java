package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 出差申请新增
 * @author: jiafr 
 * @since: 2018年6月23日 下午3:11:27 
 * @history:
 */
public class XN632690Req {

    // 申请人编号
    @NotBlank
    private String applyUserCode;

    // 出差时间起
    @NotBlank
    private String tripDatetimeStart;

    // 出差时间止
    @NotBlank
    private String tripDatetimeEnd;

    // 出差事由
    @NotBlank
    private String tripReason;

    // 出差线路
    @NotBlank
    private String tripLine;

    // 飞机票费用标准
    private String aircraftFeeStandard;

    // 飞机票天数
    private String aircraftDays;

    // 飞机票预算金额
    private String aircraftBudget;

    // 火车票费用标准
    private String trainFeeStandard;

    // 火车票天数
    private String trainDays;

    // 火车票预算金额
    private String trainBudget;

    // 市内交通费用标准
    private String urbanFeeStandart;

    // 市内交通天数
    private String urbanDays;

    // 市内交通预算金额
    private String urbanBudget;

    // 住宿费
    private String hotelCost;

    // 伙食补助
    private String foodSubsidy;

    // 招待费
    private String entertainmentCost;

    // 其他
    private String other;

    // 备用金
    private String spareCash;

    // 更新人
    @NotBlank
    private String updater;

    // 申请说明
    private String applyNote;

    public String getApplyUserCode() {
        return applyUserCode;
    }

    public void setApplyUserCode(String applyUserCode) {
        this.applyUserCode = applyUserCode;
    }

    public String getTripDatetimeStart() {
        return tripDatetimeStart;
    }

    public void setTripDatetimeStart(String tripDatetimeStart) {
        this.tripDatetimeStart = tripDatetimeStart;
    }

    public String getTripDatetimeEnd() {
        return tripDatetimeEnd;
    }

    public void setTripDatetimeEnd(String tripDatetimeEnd) {
        this.tripDatetimeEnd = tripDatetimeEnd;
    }

    public String getTripReason() {
        return tripReason;
    }

    public void setTripReason(String tripReason) {
        this.tripReason = tripReason;
    }

    public String getTripLine() {
        return tripLine;
    }

    public void setTripLine(String tripLine) {
        this.tripLine = tripLine;
    }

    public String getAircraftFeeStandard() {
        return aircraftFeeStandard;
    }

    public void setAircraftFeeStandard(String aircraftFeeStandard) {
        this.aircraftFeeStandard = aircraftFeeStandard;
    }

    public String getAircraftDays() {
        return aircraftDays;
    }

    public void setAircraftDays(String aircraftDays) {
        this.aircraftDays = aircraftDays;
    }

    public String getAircraftBudget() {
        return aircraftBudget;
    }

    public void setAircraftBudget(String aircraftBudget) {
        this.aircraftBudget = aircraftBudget;
    }

    public String getTrainFeeStandard() {
        return trainFeeStandard;
    }

    public void setTrainFeeStandard(String trainFeeStandard) {
        this.trainFeeStandard = trainFeeStandard;
    }

    public String getTrainDays() {
        return trainDays;
    }

    public void setTrainDays(String trainDays) {
        this.trainDays = trainDays;
    }

    public String getTrainBudget() {
        return trainBudget;
    }

    public void setTrainBudget(String trainBudget) {
        this.trainBudget = trainBudget;
    }

    public String getUrbanFeeStandart() {
        return urbanFeeStandart;
    }

    public void setUrbanFeeStandart(String urbanFeeStandart) {
        this.urbanFeeStandart = urbanFeeStandart;
    }

    public String getUrbanDays() {
        return urbanDays;
    }

    public void setUrbanDays(String urbanDays) {
        this.urbanDays = urbanDays;
    }

    public String getUrbanBudget() {
        return urbanBudget;
    }

    public void setUrbanBudget(String urbanBudget) {
        this.urbanBudget = urbanBudget;
    }

    public String getHotelCost() {
        return hotelCost;
    }

    public void setHotelCost(String hotelCost) {
        this.hotelCost = hotelCost;
    }

    public String getFoodSubsidy() {
        return foodSubsidy;
    }

    public void setFoodSubsidy(String foodSubsidy) {
        this.foodSubsidy = foodSubsidy;
    }

    public String getEntertainmentCost() {
        return entertainmentCost;
    }

    public void setEntertainmentCost(String entertainmentCost) {
        this.entertainmentCost = entertainmentCost;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getSpareCash() {
        return spareCash;
    }

    public void setSpareCash(String spareCash) {
        this.spareCash = spareCash;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

}
