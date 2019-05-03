package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.ISYSUserAO;
import com.cdkj.loan.bo.IArchiveBO;
import com.cdkj.loan.bo.IBizTeamBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.ISmsOutBO;
import com.cdkj.loan.bo.ITencentBO;
import com.cdkj.loan.bo.IUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.MD5Util;
import com.cdkj.loan.common.PwdUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSRole;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630060Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EDepartmentType;
import com.cdkj.loan.enums.ESYSUserStatus;
import com.cdkj.loan.enums.ESysUserType;
import com.cdkj.loan.enums.EUser;
import com.cdkj.loan.exception.BizException;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SYSUserAOImpl implements ISYSUserAO {

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private ISYSRoleBO sysRoleBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBizTeamBO bizTeamBO;

    @Autowired
    private ITencentBO tencentBO;

    @Autowired
    private IArchiveBO archiveBO;

    @Autowired
    private ISmsOutBO smsOutBO;

    @Autowired
    private IUserBO userBO;

    @Override
    public String doAddUser(String type, String loginName, String loginPwd,
            String mobile, String avatar, String realName, String roleCode,
            String postCode, String archiveCode) {

        SYSUser data = new SYSUser();
        String userId = OrderNoGenerater.generate("U");
        data.setUserId(userId);
        data.setType(ESysUserType.Plat.getCode());
        data.setLoginName(loginName);
        // 判断手机号是否存在
        doCheckMobile(mobile);
        data.setMobile(mobile);
        data.setPhoto(avatar);
        data.setRealName(realName);
        data.setLoginPwd(MD5Util.md5(loginPwd));
        data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(loginPwd));

        data.setCreateDatetime(new Date());
        data.setRoleCode(roleCode);
        data.setPostCode(postCode);
        data.setDepartmentCode(departmentBO.getDepartmentByPost(postCode));
        data.setCompanyCode(departmentBO.getCompanyByDepartment(data
                .getDepartmentCode()));

        data.setStatus(ESYSUserStatus.BLOCK.getCode());
        sysUserBO.saveUser(data);

        // 注册腾讯云用户
        // tencentBO.register(userId, realName, ESystemCode.HTWT.getCode(),
        // ESystemCode.HTWT.getCode());

        return userId;
    }

    @Override
    public String doLogin(String type, String loginName, String loginPwd) {
        SYSUser condition = new SYSUser();
        condition.setType(type);
        condition.setLoginName(loginName);

        List<SYSUser> userList = sysUserBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "登录名不存在");
        }
        condition.setLoginPwd(MD5Util.md5(loginPwd));

        List<SYSUser> userList2 = sysUserBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList2)) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "登录密码错误");
        }
        SYSUser user = userList2.get(0);
        if (!ESYSUserStatus.NORMAL.getCode().equals(user.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "该用户操作存在异常");
        }
        return user.getUserId();
    }

    @Override
    @Transactional
    public void doChangeMoblie(String userId, String newMobile,
            String newCaptcha, String oldMobile, String oldCaptcha) {
        SYSUser user = sysUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("xn000000", "用户不存在");
        }
        if (newMobile.equals(oldMobile)) {
            throw new BizException("xn000000", "新手机与原手机一致");
        }
        // 验证手机号
        sysUserBO.isMobileExist(newMobile);
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(newMobile, newCaptcha, "630052");

        // 短信验证码是否正确
        smsOutBO.checkCaptcha(oldMobile, oldCaptcha, "630052");
        sysUserBO.refreshMobile(userId, newMobile);
        // 发送短信
        // smsOutBO.sendSmsOut(oldMobile,
        // "尊敬的" + PhoneUtil.hideMobile(oldMobile) + "用户，您于"
        // + DateUtil.dateToStr(new Date(),
        // DateUtil.DATA_TIME_PATTERN_1)
        // + "提交的更改绑定手机号码服务已审核通过，现绑定手机号码为" + newMobile
        // + "，请妥善保管您的账户相关信息。",
        // "805061", user.getCompanyCode(), user.getSystemCode());
    }

    @Override
    @Transactional
    public void doModifyLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd) {
        if (oldLoginPwd.equals(newLoginPwd)) {
            throw new BizException("li01006", "新登录密码不能与原有密码重复");
        }
        // 验证当前登录密码是否正确
        sysUserBO.checkLoginPwd(userId, oldLoginPwd);
        // 重置
        sysUserBO.refreshLoginPwd(userId, newLoginPwd);
        // 发送短信
        // SYSUser user = sysUserBO.getUser(userId);
        // if (!EUserKind.Plat.getCode().equals(user.getType())) {
        // smsOutBO.sendSmsOut(user.getMobile(),
        // "尊敬的" + PhoneUtil.hideMobile(user.getMobile())
        // + "用户，您的登录密码修改成功。请妥善保管您的账户相关信息。",
        // "805064", user.getCompanyCode(), user.getSystemCode());
        // }
    }

    @Override
    @Transactional
    public void doResetLoginPwdByOss(String userId, String loginPwd,
            String udpater, String remark) {
        SYSUser data = sysUserBO.getUser(userId);
        sysUserBO.refreshLoginPwd(data, loginPwd, udpater, remark);
    }

    @Override
    public void doModifyPhoto(String userId, String photo) {
        sysUserBO.refreshPhoto(userId, photo);
    }

    @Override
    public void doCloseOpen(String userId, String updater, String remark) {
        SYSUser user = sysUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户不存在");
        }
        // admin 不注销
        if (EUser.ADMIN.getCode().equals(user.getLoginName())) {
            throw new BizException("li01004", "管理员无法注销");
        }
        String mobile = user.getMobile();
        // String smsContent = "";
        ESYSUserStatus userStatus = null;
        if (ESYSUserStatus.NORMAL.getCode().equalsIgnoreCase(user.getStatus())) {
            // smsContent = "您的账号已被管理员封禁";
            userStatus = ESYSUserStatus.BLOCK;
        } else {
            // smsContent = "您的账号已被管理员解封,请遵守平台相关规则";
            userStatus = ESYSUserStatus.NORMAL;
        }
        sysUserBO.refreshStatus(userId, userStatus, updater, remark);
        // if (!EUserKind.Plat.getCode().equals(user.getType())
        // && PhoneUtil.isMobile(mobile)) {
        // // 发送短信
        // smsOutBO.sendSmsOut(mobile,
        // "尊敬的" + PhoneUtil.hideMobile(mobile) + smsContent, "805091");
        // }
    }

    @Override
    public void doRoleUser(String userId, String roleCode, String updater,
            String remark) {
        SYSUser user = sysUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户不存在");
        }
        SYSRole role = sysRoleBO.getSYSRole(roleCode);
        if (role == null) {
            throw new BizException("li01004", "角色不存在");
        }
        sysUserBO.refreshRole(userId, roleCode, updater, remark);
    }

    @Override
    public void doModifyPost(String userId, String postCode, String updater,
            String remark) {
        Department post = departmentBO.getDepartment(postCode);

        // 部门编号
        String departmentCode = post.getParentCode();
        while (true) {
            Department department = departmentBO.getDepartment(departmentCode);
            if (EDepartmentType.DEPARTMENT.getCode().equals(
                    department.getType())) {
                departmentCode = department.getCode();
                break;
            } else {
                departmentCode = department.getParentCode();
            }
        }

        // 公司编号
        String companyCode = departmentCode;
        while (true) {
            Department company = departmentBO.getDepartment(companyCode);
            if (EDepartmentType.SUBBRANCH_COMPANY.getCode().equals(
                    company.getType())) {
                companyCode = company.getCode();
                break;
            } else {
                companyCode = company.getParentCode();
            }
        }

        sysUserBO.refreshPost(userId, postCode, departmentCode, companyCode,
                updater, remark);
    }

    @Override
    public void resetAdminLoginPwd(String userId, String newLoginPwd) {
        SYSUser user = sysUserBO.getUser(userId);
        sysUserBO.resetAdminLoginPwd(user, newLoginPwd);
    }

    @Override
    @Transactional
    public void doResetLoginPwd(String mobile, String smsCaptcha,
            String newLoginPwd) {
        SYSUser user = sysUserBO.getUserByMobile(mobile);
        if (StringUtils.isBlank(user.getUserId())) {
            throw new BizException("li01004", "用户不存在,请先注册");
        }
        if (ESYSUserStatus.BLOCK.getCode().equals(user.getStatus())) {
            throw new BizException("xn805050", "该账号"
                    + ESYSUserStatus.BLOCK.getValue() + "，请联系工作人员");
        }
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha, "630053");
        sysUserBO.refreshLoginPwd(user, newLoginPwd, user.getUserId(), "修改密码");
        // // 发送短信
        // smsOutBO.sendSmsOut(mobile,
        // "尊敬的" + PhoneUtil.hideMobile(mobile)
        // + "用户，您的登录密码重置成功。请妥善保管您的账户相关信息。",
        // "805063", companyCode, systemCode);
    }

    @Override
    public void doCheckMobile(String mobile) {
        sysUserBO.isMobileExist(mobile);
    }

    @Override
    public Paginable<SYSUser> queryUserPage(int start, int limit,
            SYSUser condition) {
        if (condition.getCreateDatetimeStart() != null
                && condition.getCreateDatetimeEnd() != null
                && condition.getCreateDatetimeEnd().before(
                condition.getCreateDatetimeStart())) {
            throw new BizException("xn0000", "开始时间不能大于结束时间");
        }
        Paginable<SYSUser> page = sysUserBO.getPaginable(start, limit,
                condition);

        for (SYSUser sysUser : page.getList()) {
            if (StringUtils.isNotBlank(sysUser.getPostCode())) {
                sysUser.setPostName(departmentBO.getDepartment(
                        sysUser.getPostCode()).getName());
            }
            if (StringUtils.isNotBlank(sysUser.getDepartmentCode())) {
                sysUser.setDepartmentName(departmentBO.getDepartment(
                        sysUser.getDepartmentCode()).getName());
            }
            if (StringUtils.isNotBlank(sysUser.getCompanyCode())) {
                sysUser.setCompanyName(departmentBO.getDepartment(
                        sysUser.getCompanyCode()).getName());
            }
            if (StringUtils.isNotBlank(sysUser.getTeamCode())) {
                sysUser.setTeamName(bizTeamBO.getBizTeam(sysUser.getTeamCode())
                        .getName());
            }
            if (StringUtils.isNotBlank(sysUser.getRoleCode())) {
                SYSRole sysRole = sysRoleBO.getSYSRole(sysUser.getRoleCode());
                sysUser.setRoleName(sysRole.getName());
            }
        }
        return page;
    }

    @Override
    public List<SYSUser> queryUserList(SYSUser condition) {
        if (condition.getCreateDatetimeStart() != null
                && condition.getCreateDatetimeEnd() != null
                && condition.getCreateDatetimeEnd().before(
                condition.getCreateDatetimeStart())) {
            throw new BizException("xn0000", "开始时间不能大于结束时间");
        }
        return sysUserBO.queryUserList(condition);
    }

    @Override
    public SYSUser getUser(String userId) {
        SYSUser sysUser = sysUserBO.getUser(userId);
        return sysUser;
    }

    @Override
    public void doModifyTeam(String userId, String teamCode, String updater) {
        sysUserBO.refreshTeam(userId, teamCode, updater);
    }

    @Override
    public void doEditUser(XN630060Req req) {
        SYSUser user = sysUserBO.getUser(req.getUserId());
        user.setPhoto(req.getPhoto());
        user.setLoginName(req.getLoginName());

        SYSUser sysUser = new SYSUser();
        sysUser.setMobile(req.getMobile());
        List<SYSUser> userList = queryUserList(sysUser);
        if (CollectionUtils.isNotEmpty(userList)
                && !user.getMobile().equals(req.getMobile())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "该手机号已存在，请重新输入！");
        }
        user.setMobile(req.getMobile());
        user.setRealName(req.getRealName());
        user.setRoleCode(req.getRoleCode());
        user.setPostCode(req.getPostCode());
        String departmentCode = departmentBO.getDepartmentByPost(req
                .getPostCode());
        user.setDepartmentCode(departmentCode);
        String companyCode = departmentBO
                .getCompanyByDepartment(departmentCode);
        user.setCompanyCode(companyCode);
        user.setUpdater(req.getUpdater());
        user.setUpdateDatetime(new Date());
        user.setRemark(req.getRemark());
        sysUserBO.refreshUser(user);
    }

}
