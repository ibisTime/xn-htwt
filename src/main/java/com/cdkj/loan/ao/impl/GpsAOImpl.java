package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IGpsBO;
import com.cdkj.loan.bo.ISYSRoleBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.domain.SYSRole;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632701Res;
import com.cdkj.loan.enums.EBoolean;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.enums.EGpsUseStatus;

@Service
public class GpsAOImpl implements IGpsAO {

    @Autowired
    private IGpsBO gpsBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IBudgetOrderAO budgetOrderAO;

    @Autowired
    private ISYSRoleBO sysRoleBO;

    @Override
    @Transactional
    public String addGps(String gpsDevNo, String gpsType, String updater) {
        // 验证gps设备号是否唯一
        gpsBO.checkGpsDevNo(gpsDevNo);

        Gps data = new Gps();
        String code = OrderNoGenerater.generate(EGeneratePrefix.GPS.getCode());
        data.setCode(code);
        data.setGpsDevNo(gpsDevNo);
        data.setGpsType(gpsType);
        data.setApplyStatus(EBoolean.NO.getCode());
        data.setUseStatus(EGpsUseStatus.UN_USE.getCode());
        data.setUpdater(updater);
        data.setUpdatedatetime(new Date());
        gpsBO.saveGps(data);
        return code;
    }

    @Override
    @Transactional
    public void editGps(String code, String gpsDevNo, String gpsType,
            String updater) {
        Gps gps = gpsBO.getGps(code);
        gps.setGpsDevNo(gpsDevNo);
        gps.setGpsType(gpsType);
        gps.setUpdater(updater);
        gps.setUpdatedatetime(new Date());
        gpsBO.editGps(gps);
    }

    @Override
    @Transactional
    public void addGpsList(List<XN632701Res> gpsList) {
        for (XN632701Res res : gpsList) {
            // 验证gps设备号是否唯一
            gpsBO.checkGpsDevNo(res.getGpsDevNo());

            Gps data = new Gps();
            String code = OrderNoGenerater
                .generate(EGeneratePrefix.GPS.getCode());
            data.setCode(code);
            data.setGpsDevNo(res.getGpsDevNo());
            data.setGpsType(res.getGpsType());
            data.setApplyStatus(EBoolean.NO.getCode());
            data.setUseStatus(EGpsUseStatus.UN_USE.getCode());
            gpsBO.saveGps(data);
        }
    }

    @Override
    public Paginable<Gps> queryGpsPage(int start, int limit, Gps condition) {
        Paginable<Gps> page = gpsBO.getPaginable(start, limit, condition);
        List<Gps> list = page.getList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (Gps gps : list) {
                initGps(gps);
            }
        }
        return page;
    }

    @Override
    public List<Gps> queryGpsList(Gps condition) {
        List<Gps> list = gpsBO.queryGpsList(condition);
        if (CollectionUtils.isNotEmpty(list)) {
            for (Gps gps : list) {
                initGps(gps);
            }
        }
        return list;
    }

    @Override
    public Gps getGps(String code) {
        Gps gps = gpsBO.getGps(code);
        if (null != gps) {
            initGps(gps);
        }
        return gps;
    }

    // 初始化gps数据，包含公司名称 和 业务员姓名
    private void initGps(Gps gps) {
        // 业务公司名称
        if (StringUtils.isNotBlank(gps.getCompanyCode())) {
            Department department = departmentBO
                .getDepartment(gps.getCompanyCode());
            gps.setCompanyName(department.getName());
        }

        // 业务员姓名
        if (StringUtils.isNotBlank(gps.getApplyUser())) {
            SYSUser sysUser = sysUserBO.getUser(gps.getApplyUser());
            gps.setApplyUserName(sysUser.getRealName());
            SYSRole sysRole = sysRoleBO.getSYSRole(sysUser.getRoleCode());
            gps.setApplyUserRole(sysRole.getName());
        }

        // 预算单（要展示客户姓名专员等一系列字段）
        if (StringUtils.isNotBlank(gps.getBizCode())) {
            BudgetOrder budgetOrder = budgetOrderAO
                .getBudgetOrder(gps.getBizCode());
            gps.setBudgetOrder(budgetOrder);
        }
    }

}
