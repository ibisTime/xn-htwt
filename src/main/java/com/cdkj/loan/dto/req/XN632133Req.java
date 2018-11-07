package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 预算单-抵押完成
 * @author: xieyj 
 * @since: 2018年5月29日 下午10:31:16 
 * @history:
 */
public class XN632133Req {

    @NotBlank
    private String code;// 预算单编号

    // 车牌号
    @NotBlank
    private String carNumber;

    // 登记证书
    @NotBlank
    private String carRegcerti;

    // 车辆批单
    @NotBlank
    private String carPd;

    // 车钥匙
    @NotBlank
    private String carKey;

    // 大本扫描件
    @NotBlank
    private String carBigSmj;

    // 车辆行驶证扫描件
    @NotBlank
    private String carXszSmj;

    // 完税证明扫描件
    @NotBlank
    private String dutyPaidProveSmj;

    @NotBlank
    private String operator;// 操作人

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarXszSmj() {
        return carXszSmj;
    }

    public void setCarXszSmj(String carXszSmj) {
        this.carXszSmj = carXszSmj;
    }

    public String getDutyPaidProveSmj() {
        return dutyPaidProveSmj;
    }

    public void setDutyPaidProveSmj(String dutyPaidProveSmj) {
        this.dutyPaidProveSmj = dutyPaidProveSmj;
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

    public String getCarRegcerti() {
        return carRegcerti;
    }

    public void setCarRegcerti(String carRegcerti) {
        this.carRegcerti = carRegcerti;
    }

    public String getCarPd() {
        return carPd;
    }

    public void setCarPd(String carPd) {
        this.carPd = carPd;
    }

    public String getCarKey() {
        return carKey;
    }

    public void setCarKey(String carKey) {
        this.carKey = carKey;
    }

    public String getCarBigSmj() {
        return carBigSmj;
    }

    public void setCarBigSmj(String carBigSmj) {
        this.carBigSmj = carBigSmj;
    }

}
