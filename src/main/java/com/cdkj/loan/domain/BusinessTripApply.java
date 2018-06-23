package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 出差申请
* @author: jiafr 
* @since: 2018-06-23 14:47:08
* @history:
*/
public class BusinessTripApply extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 申请人编号
    private String applyUserCode;

    // 工号
    private String jobNo;

    // 部门编号
    private String departmentCode;

    // 职位编号
    private String postCode;

    // 申请时间
    private Date applyDatetime;

    // 出差时间起
    private Date tripDatetimeStart;

    // 出差时间止
    private Date tripDatetimeEnd;

    // 出差事由
    private String tripReason;

    // 出差线路
    private String tripLine;

    // 飞机票费用标准
    private String aircraftFeeStandard;

    // 飞机票天数
    private String aircraftDays;

    // 飞机票预算金额
    private Long aircraftBudget;

    // 火车票费用标准
    private String trainFeeStandard;

    // 火车票天数
    private String trainDays;

    // 火车票预算金额
    private Long trainBudget;

    // 市内交通费用标准
    private String urbanFeeStandart;

    // 市内交通天数
    private String urbanDays;

    // 市内交通预算金额
    private Long urbanBudget;

    // 住宿费
    private Long hotelCost;

    // 伙食补助
    private Long foodSubsidy;

    // 招待费
    private Long entertainmentCost;

    // 其他(详细明细)
    private String other;

    // 小计
    private Long subtotal;

    // 备用金
    private Long spareCash;

    // 费用合计
    private Long costTotal;

    // 部门主管编号
    private String departmentManagerCode;

    // 财务主管编号
    private String financeManagerCode;

    // 总经理编号
    private String generalManagerCode;

    // 节点
    private String curNodeCode;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 申请说明
    private String applyNote;

    // 备注
    private String remark;

    /**********db properties**********/

    private Date applyDatetimeStart;

    private Date applyDatetimeEnd;

    private String applyUserName;

    private String departmentName;

    private String postName;

    // 角色编号
    private String roleCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApplyUserCode() {
        return applyUserCode;
    }

    public void setApplyUserCode(String applyUserCode) {
        this.applyUserCode = applyUserCode;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public Date getTripDatetimeStart() {
        return tripDatetimeStart;
    }

    public void setTripDatetimeStart(Date tripDatetimeStart) {
        this.tripDatetimeStart = tripDatetimeStart;
    }

    public Date getTripDatetimeEnd() {
        return tripDatetimeEnd;
    }

    public void setTripDatetimeEnd(Date tripDatetimeEnd) {
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

    public Long getAircraftBudget() {
        return aircraftBudget;
    }

    public void setAircraftBudget(Long aircraftBudget) {
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

    public Long getTrainBudget() {
        return trainBudget;
    }

    public void setTrainBudget(Long trainBudget) {
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

    public Long getUrbanBudget() {
        return urbanBudget;
    }

    public void setUrbanBudget(Long urbanBudget) {
        this.urbanBudget = urbanBudget;
    }

    public Long getHotelCost() {
        return hotelCost;
    }

    public void setHotelCost(Long hotelCost) {
        this.hotelCost = hotelCost;
    }

    public Long getFoodSubsidy() {
        return foodSubsidy;
    }

    public void setFoodSubsidy(Long foodSubsidy) {
        this.foodSubsidy = foodSubsidy;
    }

    public Long getEntertainmentCost() {
        return entertainmentCost;
    }

    public void setEntertainmentCost(Long entertainmentCost) {
        this.entertainmentCost = entertainmentCost;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Long getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Long subtotal) {
        this.subtotal = subtotal;
    }

    public Long getSpareCash() {
        return spareCash;
    }

    public void setSpareCash(Long spareCash) {
        this.spareCash = spareCash;
    }

    public Long getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(Long costTotal) {
        this.costTotal = costTotal;
    }

    public String getDepartmentManagerCode() {
        return departmentManagerCode;
    }

    public void setDepartmentManagerCode(String departmentManagerCode) {
        this.departmentManagerCode = departmentManagerCode;
    }

    public String getFinanceManagerCode() {
        return financeManagerCode;
    }

    public void setFinanceManagerCode(String financeManagerCode) {
        this.financeManagerCode = financeManagerCode;
    }

    public String getGeneralManagerCode() {
        return generalManagerCode;
    }

    public void setGeneralManagerCode(String generalManagerCode) {
        this.generalManagerCode = generalManagerCode;
    }

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
