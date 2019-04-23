package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 录入征信结果
 * @author: jiafr 
 * @since: 2018年5月24日 下午8:57:22 
 * @history:
 */
public class XN632111Req {

    // 征信单编号
    @NotBlank
    private String bizCode;

    // 操作人
    @NotBlank
    private String operator;

    // 征信结果
    @NotEmpty
    private List<XN632111ReqCreditUser> creditList;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public List<XN632111ReqCreditUser> getCreditList() {
        return creditList;
    }

    public void setCreditList(List<XN632111ReqCreditUser> creditList) {
        this.creditList = creditList;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
