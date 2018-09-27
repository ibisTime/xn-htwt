package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

public class XN632212Req {

    // 编号
    @NotBlank
    private String id;

    // 序号
    @NotBlank
    private String number;

    // 名称
    @NotBlank
    private String name;

    // 更新人
    @NotBlank
    private String updater;

    public String getNumber() {
        return number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
