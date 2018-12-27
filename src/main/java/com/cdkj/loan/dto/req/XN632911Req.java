package com.cdkj.loan.dto.req;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 代办事项OSS
 * @author: jiafr 
 * @since: 2018年7月6日 下午2:05:21 
 * @history:
 */
public class XN632911Req extends APageReq {

    private static final long serialVersionUID = 7948180551552144337L;

    @NotBlank
    private String roleCode;// 角色编号

    private String teamCode;// 团队编号

    private String parentOrder;// 业务编号

    private String refType;// 流程类型

    private String applyUserName;// 客户姓名

    public String getApplyUserName() {
        return applyUserName;
    }

    public void setApplyUserName(String applyUserName) {
        this.applyUserName = applyUserName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getParentOrder() {
        return parentOrder;
    }

    public void setParentOrder(String parentOrder) {
        this.parentOrder = parentOrder;
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
    }

}
