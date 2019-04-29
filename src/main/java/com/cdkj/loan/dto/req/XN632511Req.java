/**
 * @Title XN632515Req.java 
 * @Package com.cdkj.loan.dto.req 
 * @Description 
 * @author taojian  
 * @date 2019年4月2日 下午7:34:42 
 * @version V1.0   
 */
package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * 制卡申请
 * @author: taojian 
 * @since: 2019年4月2日 下午7:34:42 
 * @history:
 */
public class XN632511Req {

    // 编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    // 还款卡号
    @NotBlank
    private String repayCardNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRepayCardNumber() {
        return repayCardNumber;
    }

    public void setRepayCardNumber(String repayCardNumber) {
        this.repayCardNumber = repayCardNumber;
    }

}
