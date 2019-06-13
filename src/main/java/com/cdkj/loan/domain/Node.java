package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.List;
import lombok.Data;

@Data
public class Node extends ABaseDO {

    private static final long serialVersionUID = 4733016091171187458L;

    private String code;// 节点编号

    private String name;// 节点名称

    private String type;// 类型

    private String orderNo;// 排序编号

    private String remark;// 备注

    // **********db properties**********

    private String nameQuery;

    private String roleCode;// 角色编号

    private String isChoice; // 当前角色是否拥有

    private List<String> typeList;// 类型list

    private List<String> codeList;// 编号list


}
