package com.cdkj.loan.dto.req;

/**
 * 分页查询退客户垫资款
 * @author: jiafr 
 * @since: 2018年6月9日 下午10:31:06 
 * @history:
 */
public class XN632185Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 客户姓名
    private String applyUserName;

    // 业务编号
    private String code;

    // 是否垫资
    private String isAdvanceFund;

    // 业务员（信贷专员）
    private String saleUserId;

    // 申请时间起
    private String startDatetime;

    // 申请时间止
    private String endDatetime;

    // 当前节点编号
    private String curNodeCode;

    public String getCurNodeCode() {
        return curNodeCode;
    }

    public void setCurNodeCode(String curNodeCode) {
        this.curNodeCode = curNodeCode;
    }

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(String saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getIsAdvanceFund() {
        return isAdvanceFund;
    }

    public void setIsAdvanceFund(String isAdvanceFund) {
        this.isAdvanceFund = isAdvanceFund;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    public String getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(String endDatetime) {
        this.endDatetime = endDatetime;
    }

}
