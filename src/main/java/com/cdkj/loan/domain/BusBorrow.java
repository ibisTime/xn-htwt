package com.cdkj.loan.domain;

import java.util.Date;

import com.cdkj.loan.dao.base.ABaseDO;

/**
* 公车借用
* @author: CYunlai 
* @since: 2018-06-23 11:31:58
* @history:
*/
public class BusBorrow extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 公车编号
    private String busCode;

    // 申领人
    private String applyUser;

    // 申请时间
    private Date applyDatetime;

    // 领用说明
    private String applyNote;

    // 所属部门
    private String departmentCode;

    // 使用时间起
    private Date useDatetimeStart;

    // 使用时间止
    private Date useDatetimeEnd;

    // 行驶公里数
    private double driveKil;

    // 归还时间
    private Date returnDatetime;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    /*--------辅助字段----------*/

    // 更新人姓名
    private String updaterName;

    // 申领人姓名
    private String applyUserName;

    // 部门名称
    private String departmentName;

    // 公车车型
    private String busMobile;

    // 公车车牌号
    private String busNumber;

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getBusMobile() {
        return busMobile;
    }

    public void setBusMobile(String busMobile) {
        this.busMobile = busMobile;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getBusCode() {
        return busCode;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Date getUseDatetimeStart() {
        return useDatetimeStart;
    }

    public void setUseDatetimeStart(Date useDatetimeStart) {
        this.useDatetimeStart = useDatetimeStart;
    }

    public Date getUseDatetimeEnd() {
        return useDatetimeEnd;
    }

    public void setUseDatetimeEnd(Date useDatetimeEnd) {
        this.useDatetimeEnd = useDatetimeEnd;
    }

    public double getDriveKil() {
        return driveKil;
    }

    public void setDriveKil(double driveKil) {
        this.driveKil = driveKil;
    }

    public Date getReturnDatetime() {
        return returnDatetime;
    }

    public void setReturnDatetime(Date returnDatetime) {
        this.returnDatetime = returnDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
