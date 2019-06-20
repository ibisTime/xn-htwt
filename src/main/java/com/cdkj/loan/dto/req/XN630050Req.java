package com.cdkj.loan.dto.req;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: xieyj
 * @since: 2016年9月17日 下午3:58:52
 * @history:
 */
@Data
public class XN630050Req {

    // 登录名（必填）
    @NotBlank(message = "登录名不能为空")
    private String loginName;

    // 登录密码（选填）
    @NotBlank(message = "登录密码不能为空")
    private String loginPwd;

    // 手机号（必填）
    @NotBlank(message = "手机号不能为空")
    private String mobile;

    // 真实姓名（必填）
    private String realName;

    // 类型（必填）
    @NotBlank(message = "类型不能为空")
    private String type;

    // 推荐人（选填）
    private String userRefree;

    // 角色编号
    @NotBlank
    private String roleCode;

    // 岗位
    @NotBlank
    private String postCode;

    // 人事档案
    private String archiveCode;

    private String smsCaptcha; // 手机验证码

    // 备注（选填）
    private String remark;

}
