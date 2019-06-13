package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 驻行抵押申请
 * @author: CYL 
 * @since: 2018年11月7日 上午11:53:23 
 * @history:
 */
public class XN632144Req {

    // 预算单编号
    @NotBlank
    private String code;

    // 补充说明
    @NotBlank
    private String supplementNote;

    private String pledgeUser;

    private String pledgeUserIdCard;

    private String pledgeAddress;

    private String pledgeUserIdCardFront;

    private String pledgeUserIdCardReverse;

    // 操作人
    @NotBlank
    private String operator;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSupplementNote() {
        return supplementNote;
    }

    public void setSupplementNote(String supplementNote) {
        this.supplementNote = supplementNote;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPledgeUser() {
        return pledgeUser;
    }

    public void setPledgeUser(String pledgeUser) {
        this.pledgeUser = pledgeUser;
    }

    public String getPledgeUserIdCard() {
        return pledgeUserIdCard;
    }

    public void setPledgeUserIdCard(String pledgeUserIdCard) {
        this.pledgeUserIdCard = pledgeUserIdCard;
    }

    public String getPledgeAddress() {
        return pledgeAddress;
    }

    public void setPledgeAddress(String pledgeAddress) {
        this.pledgeAddress = pledgeAddress;
    }

    public String getPledgeUserIdCardFront() {
        return pledgeUserIdCardFront;
    }

    public void setPledgeUserIdCardFront(String pledgeUserIdCardFront) {
        this.pledgeUserIdCardFront = pledgeUserIdCardFront;
    }

    public String getPledgeUserIdCardReverse() {
        return pledgeUserIdCardReverse;
    }

    public void setPledgeUserIdCardReverse(String pledgeUserIdCardReverse) {
        this.pledgeUserIdCardReverse = pledgeUserIdCardReverse;
    }
}
