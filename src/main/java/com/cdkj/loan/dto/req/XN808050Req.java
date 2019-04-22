package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 立即下单
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN808050Req {

    // 还款卡编号
    @NotBlank
    private String bankcardCode;

    // 收件人姓名（必填）
    @NotBlank
    private String receiver;

    // 收件人电话（必填）
    @NotBlank
    private String reMobile;

    // 收货地址（必填）
    @NotBlank
    private String reAddress;

    // 申请人（必填）
    @NotBlank
    private String applyUser;

    // 申请备注（选填）

    private String applyNote;

    // 规格列表
    @NotEmpty
    private List<XN808058Req> specsList;

    public String getBankcardCode() {
        return bankcardCode;
    }

    public void setBankcardCode(String bankcardCode) {
        this.bankcardCode = bankcardCode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReMobile() {
        return reMobile;
    }

    public void setReMobile(String reMobile) {
        this.reMobile = reMobile;
    }

    public String getReAddress() {
        return reAddress;
    }

    public void setReAddress(String reAddress) {
        this.reAddress = reAddress;
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

    public List<XN808058Req> getSpecsList() {
        return specsList;
    }

    public void setSpecsList(List<XN808058Req> specsList) {
        this.specsList = specsList;
    }

}
