package com.cdkj.loan.dto.req;

public class XN632790Req {

    // 公车编号
    private String busCode;

    // 使用时间起
    private String useDatetimeStart;

    // 使用时间止
    private String useDatetimeEnd;

    // 申领人
    private String applyUser;

    // 领用说明
    private String applyNote;

    public String getBusCode() {
        return busCode;
    }

    public void setBusCode(String busCode) {
        this.busCode = busCode;
    }

    public String getUseDatetimeStart() {
        return useDatetimeStart;
    }

    public void setUseDatetimeStart(String useDatetimeStart) {
        this.useDatetimeStart = useDatetimeStart;
    }

    public String getUseDatetimeEnd() {
        return useDatetimeEnd;
    }

    public void setUseDatetimeEnd(String useDatetimeEnd) {
        this.useDatetimeEnd = useDatetimeEnd;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

}
