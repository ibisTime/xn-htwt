package com.cdkj.loan.dto.req;

/**
 * 确认收货Req
 * @author: xieyj 
 * @since: 2016年6月12日 上午9:27:04 
 * @history:
 */
public class XN808058Req {

    // 编号(必填)
    private String specsCode;

    // 更新人(必填)
    private String quantity;

    public String getSpecsCode() {
        return specsCode;
    }

    public void setSpecsCode(String specsCode) {
        this.specsCode = specsCode;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
