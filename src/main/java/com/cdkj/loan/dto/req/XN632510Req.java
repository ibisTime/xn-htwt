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

    // 卡邮寄地址省
    @NotBlank
    private String cardPostProvince;

    // 卡邮寄地址市
    @NotBlank
    private String cardPostCity;

    // 卡邮寄地址区
    @NotBlank
    private String cardPostArea;

    // 卡邮寄地址
    @NotBlank
    private String cardPostAddress;

    // 卡邮寄地址邮编
    @NotBlank
    private String cardPostCode;

    // 红卡照片
    private String redCardPic;

    //专项额度核定申请表
    private String specialQuatoPic;

    //红卡照片与身份证正反面拼接图片
    private String redCardPicWithIdPic;

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

    public String getSpecialQuatoPic() {
        return specialQuatoPic;
    }

    public void setSpecialQuatoPic(String specialQuatoPic) {
        this.specialQuatoPic = specialQuatoPic;
    }

    public String getRedCardPicWithIdPic() {
        return redCardPicWithIdPic;
    }

    public void setRedCardPicWithIdPic(String redCardPicWithIdPic) {
        this.redCardPicWithIdPic = redCardPicWithIdPic;
    }

    public String getCardPostProvince() {
        return cardPostProvince;
    }

    public void setCardPostProvince(String cardPostProvince) {
        this.cardPostProvince = cardPostProvince;
    }

    public String getCardPostCity() {
        return cardPostCity;
    }

    public void setCardPostCity(String cardPostCity) {
        this.cardPostCity = cardPostCity;
    }

    public String getCardPostArea() {
        return cardPostArea;
    }

    public void setCardPostArea(String cardPostArea) {
        this.cardPostArea = cardPostArea;
    }

    public String getCardPostCode() {
        return cardPostCode;
    }

    public void setCardPostCode(String cardPostCode) {
        this.cardPostCode = cardPostCode;
    }
}
