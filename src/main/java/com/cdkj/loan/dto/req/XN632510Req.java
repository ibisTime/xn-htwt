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
public class XN632510Req {

    // 编号
    @NotBlank
    private String code;

    // 操作人
    @NotBlank
    private String operator;

    // 卡邮寄地址
    @NotBlank
    private String cardPostAddress;

    // 红卡地址
    private String redCardPic;

    public String getRedCardPic() {
        return redCardPic;
    }

    public void setRedCardPic(String redCardPic) {
        this.redCardPic = redCardPic;
    }

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

    public String getCardPostAddress() {
        return cardPostAddress;
    }

    public void setCardPostAddress(String cardPostAddress) {
        this.cardPostAddress = cardPostAddress;
    }

}
