package com.cdkj.loan.dto.req;

/**
 * 列表查征信人辅助资料
 * @author: silver 
 * @since: Apr 20, 2019 4:00:10 PM 
 * @history:
 */
public class XN632487Req extends AListReq {
    private static final long serialVersionUID = 2321342291291396176L;

    // 征信人编号
    private String creditUserCode;

    public String getCreditUserCode() {
        return creditUserCode;
    }

    public void setCreditUserCode(String creditUserCode) {
        this.creditUserCode = creditUserCode;
    }

}
