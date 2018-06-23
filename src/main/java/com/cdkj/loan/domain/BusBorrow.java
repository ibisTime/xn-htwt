package com.cdkj.loan.domain;

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
    private String applyDatetime;

    // 领用说明
    private String applyNote;

    // 所属部门
    private String departmentCode;

    // 使用时间起
    private String useDatetimeStart;

    // 使用时间止
    private String useDatetimeEnd;

    // 行驶公里数
    private String driveKil;

    // 归还时间
    private String returnDatetime;

    // 状态
    private String status;

    // 更新人
    private String updater;

    // 更新时间
    private String updateDatetime;

    // 备注
    private String remark;

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

    public void setApplyDatetime(String applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setUseDatetimeStart(String useDatetimeStart) {
        this.useDatetimeStart = useDatetimeStart;
    }

    public String getUseDatetimeStart() {
        return useDatetimeStart;
    }

    public void setUseDatetimeEnd(String useDatetimeEnd) {
        this.useDatetimeEnd = useDatetimeEnd;
    }

    public String getUseDatetimeEnd() {
        return useDatetimeEnd;
    }

    public String getDriveKil() {
        return driveKil;
    }

    public void setDriveKil(String driveKil) {
        this.driveKil = driveKil;
    }

    public String getReturnDatetime() {
        return returnDatetime;
    }

    public void setReturnDatetime(String returnDatetime) {
        this.returnDatetime = returnDatetime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

}
