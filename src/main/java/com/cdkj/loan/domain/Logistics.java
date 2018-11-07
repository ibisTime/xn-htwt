package com.cdkj.loan.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.loan.dao.base.ABaseDO;

/**
 * 资料传递
 * @author: silver 
 * @since: 2018年5月29日 下午9:30:46 
 * @history:
 */
public class Logistics extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -6503834762017918669L;

    // 编号
    private String code;

    // 类型(1 预算单 2 gps)
    private String type;

    // 节点类型(1车辆抵押，2银行放款)
    private String curNodeType;

    // 业务编号
    private String bizCode;

    // 用户编号
    private String userId;

    // 团队编号
    private String teamCode;

    // 业务节点1
    private String fromNodeCode;

    // 业务节点2
    private String toNodeCode;

    // 寄送方式(1 线下 2 快递)
    private String sendType;

    // 快递公司
    private String logisticsCompany;

    // 快递单号
    private String logisticsCode;

    // 发货时间
    private Date sendDatetime;

    // 发货说明
    private String sendNote;

    // 收件时间
    private Date receiptDatetime;

    // 发件人
    private String sender;

    // 收件人
    private String receiver;

    // 材料清单
    private String filelist;

    // 状态(0 待发件 1已发件待收件 2已收件审核 3已收件待补件)
    private String status;

    // 备注
    private String remark;

    // ***********db properties***********

    // 用户姓名
    private String userName;

    // 客户姓名
    private String customerName;

    // 状态List
    private List<String> statusList;

    // 类型List
    private List<String> typeList;

    // 发件人
    private String senderName;

    // 收件人
    private String receiverName;

    private GpsApply gpsApply;

    // 业务团队
    private String teamName;

    // 角色
    private String userRole;

    // 内勤名称
    private String insideJobName;

    // 信贷专员姓名
    private String saleUserName;

    public String getInsideJobName() {
        return insideJobName;
    }

    public void setInsideJobName(String insideJobName) {
        this.insideJobName = insideJobName;
    }

    public String getSaleUserName() {
        return saleUserName;
    }

    public void setSaleUserName(String saleUserName) {
        this.saleUserName = saleUserName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public GpsApply getGpsApply() {
        return gpsApply;
    }

    public void setGpsApply(GpsApply gpsApply) {
        this.gpsApply = gpsApply;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getCurNodeType() {
        return curNodeType;
    }

    public void setCurNodeType(String curNodeType) {
        this.curNodeType = curNodeType;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getFilelist() {
        return filelist;
    }

    public void setFilelist(String filelist) {
        this.filelist = filelist;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFromNodeCode() {
        return fromNodeCode;
    }

    public void setFromNodeCode(String fromNodeCode) {
        this.fromNodeCode = fromNodeCode;
    }

    public String getToNodeCode() {
        return toNodeCode;
    }

    public void setToNodeCode(String toNodeCode) {
        this.toNodeCode = toNodeCode;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getLogisticsCompany() {
        return logisticsCompany;
    }

    public void setLogisticsCompany(String logisticsCompany) {
        this.logisticsCompany = logisticsCompany;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public Date getSendDatetime() {
        return sendDatetime;
    }

    public void setSendDatetime(Date sendDatetime) {
        this.sendDatetime = sendDatetime;
    }

    public String getSendNote() {
        return sendNote;
    }

    public void setSendNote(String sendNote) {
        this.sendNote = sendNote;
    }

    public Date getReceiptDatetime() {
        return receiptDatetime;
    }

    public void setReceiptDatetime(Date receiptDatetime) {
        this.receiptDatetime = receiptDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
