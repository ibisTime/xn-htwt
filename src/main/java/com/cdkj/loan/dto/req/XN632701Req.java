package com.cdkj.loan.dto.req;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class XN632701Req {

    // gps列表
    @NotEmpty
    private List<XN632701Res> gpsList;

    public List<XN632701Res> getGpsList() {
        return gpsList;
    }

    public void setGpsList(List<XN632701Res> gpsList) {
        this.gpsList = gpsList;
    }

}
