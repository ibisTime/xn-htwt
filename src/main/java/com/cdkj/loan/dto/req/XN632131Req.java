package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-录入抵押信息
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632131Req {

    @NotBlank
    private String code;// 预算单编号

    @NotBlank
    private String operator;// 操作人

    // 抵押日期
    private String pledgeDatetime;

    // 绿大本扫描件
    private String greenBigSmj;

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

    public String getPledgeDatetime() {
        return pledgeDatetime;
    }

    public void setPledgeDatetime(String pledgeDatetime) {
        this.pledgeDatetime = pledgeDatetime;
    }

    public String getGreenBigSmj() {
        return greenBigSmj;
    }

    public void setGreenBigSmj(String greenBigSmj) {
        this.greenBigSmj = greenBigSmj;
    }
}
