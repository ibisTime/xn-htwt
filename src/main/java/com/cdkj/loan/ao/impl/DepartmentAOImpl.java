package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IDepartmentAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN630100Req;
import com.cdkj.loan.dto.req.XN630102Req;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EDepartmentStatus;
import com.cdkj.loan.enums.EDepartmentType;
import com.cdkj.loan.enums.ESYSUserStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class DepartmentAOImpl implements IDepartmentAO {

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Override
    public String addDepartment(XN630100Req req) {
        Department data = new Department();
        data.setType(req.getType());
        data.setName(req.getName());
        if (!EDepartmentType.POSITION.getCode().equals(req.getType())) {
            SYSUser sysUser = sysUserBO.getUser(req.getLeadUserId());
            if (ESYSUserStatus.BLOCK.getCode().equals(sysUser.getStatus())) {
                throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                    "负责人已被注销");
            }
        }

        data.setLeadUserId(req.getLeadUserId());
        data.setParentCode(req.getParentCode());
        data.setOrderNo(StringValidater.toInteger(req.getOrderNo()));
        data.setStatus(EDepartmentStatus.AVAILABLE.getCode());
        data.setUpdater(req.getUpdater());

        data.setUpdateDatetime(new Date());
        data.setRemark(req.getRemark());
        return departmentBO.saveDepartment(data);
    }

    @Override
    public void editDepartment(XN630102Req req) {
        Department data = departmentBO.getDepartment(req.getCode());
        data.setType(req.getType());
        data.setName(req.getName());
        SYSUser sysUser = sysUserBO.getUser(req.getLeadUserId());
        if (ESYSUserStatus.BLOCK.getCode().equals(sysUser.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(), "负责人已被注销");
        }

        data.setLeadUserId(req.getLeadUserId());
        data.setParentCode(req.getParentCode());
        data.setOrderNo(StringValidater.toInteger(req.getOrderNo()));
        data.setUpdater(req.getUpdater());
        data.setUpdateDatetime(new Date());

        data.setRemark(req.getRemark());
        departmentBO.refreshDepartment(data);
    }

    @Override
    public void dropDepartment(String code) {
        Department department = departmentBO.getDepartment(code);
        if (EDepartmentStatus.UNAVAILABLE.getCode()
            .equals(department.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前职能部门已被删除");
        }
        department.setStatus(EDepartmentStatus.UNAVAILABLE.getCode());
        departmentBO.refreshStatus(department);
    }

    @Override
    public Paginable<Department> queryDepartmentPage(int start, int limit,
            Department condition) {
        Paginable<Department> page = departmentBO.getPaginable(start, limit,
            condition);
        for (Department department : page.getList()) {
            initDepartment(department);
        }
        return page;
    }

    @Override
    public List<Department> queryDepartmentList(Department condition) {
        List<Department> list = departmentBO.queryDepartmentList(condition);
        for (Department department : list) {
            initDepartment(department);
        }
        return list;
    }

    @Override
    public Department getDepartment(String code) {
        Department department = departmentBO.getDepartment(code);
        initDepartment(department);
        return department;
    }

    private void initDepartment(Department department) {
        SYSUser leadUser = sysUserBO.getUser(department.getLeadUserId());
        department.setLeadMobile(leadUser.getMobile());
        department.setLeadName(leadUser.getRealName());
    }
}
