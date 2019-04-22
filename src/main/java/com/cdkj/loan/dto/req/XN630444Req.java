package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class XN630444Req {

    @NotBlank
    private String carCode;

    @NotEmpty
    private List<String> configCodeList;

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public List<String> getConfigCodeList() {
        return configCodeList;
    }

    public void setConfigCodeList(List<String> configCodeList) {
        this.configCodeList = configCodeList;
    }
}
