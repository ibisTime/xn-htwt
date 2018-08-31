package com.cdkj.loan.dto.req;

import java.util.List;

public class XN630147Req {

    private String name;// 节点名称

    private String type;// 流程类型

    private List<String> typeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

}
