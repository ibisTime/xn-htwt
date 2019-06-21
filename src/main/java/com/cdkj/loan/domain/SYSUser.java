package com.cdkj.loan.domain;

import com.cdkj.loan.dao.base.ABaseDO;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 平台用户
 *
 * @author: xieyj
 * @since: 2018年5月28日 下午9:42:29
 * @history:
 */
@Data
public class SYSUser extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 用户Id
    private String userId;

    // 类型
    private String type;

    // 头像
    private String photo;

    // 登录名
    private String loginName;

    // 手机号
    private String mobile;

    // 真实姓名
    private String realName;

    // 登录密码
    private String loginPwd;

    // 登录密码强度
    private String loginPwdStrength;

    // 注册时间
    private Date createDatetime;

    // 公司编号
    private String companyCode;

    // 部门编号
    private String departmentCode;

    // 岗位
    private String postCode;

    // 角色编号
    private String roleCode;

    // 员工编号
    private String jobNo;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 状态
    private String status;

    // 备注
    private String remark;

    // 团队编号
    private String teamCode;

    // 档案编号
    private String archiveCode;

    // **************db**********
    private Date createDatetimeStart;

    private Date createDatetimeEnd;

    private String keyword;

    private String postName;

    private String departmentName;

    private String companyName;

    private String teamName;

    // 角色名称
    private String roleName;

    // 真实姓名模糊查
    private String realNameQuery;

    // 登录名模糊查
    private String loginNameQuery;

    // 角色编号
    private List<String> roleCodeList;
}
