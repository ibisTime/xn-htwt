package com.cdkj.loan.ao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBusBorrowAO;
import com.cdkj.loan.bo.IBusBO;
import com.cdkj.loan.bo.IBusBorrowBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Bus;
import com.cdkj.loan.domain.BusBorrow;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.req.XN632790Req;
import com.cdkj.loan.enums.EApproveResult;
import com.cdkj.loan.enums.EBizErrorCode;
import com.cdkj.loan.enums.EBusBorrowStatus;
import com.cdkj.loan.exception.BizException;

@Service
public class BusBorrowAOImpl implements IBusBorrowAO {

    @Autowired
    private IBusBorrowBO busBorrowBO;

    @Autowired
    private IBusBO busBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Override
    public String addBusBorrow(XN632790Req req) {
        BusBorrow data = new BusBorrow();
        data.setBusCode(req.getBusCode());
        data.setApplyUser(req.getApplyUser());
        data.setApplyDatetime(new Date());
        data.setApplyNote(req.getApplyNote());
        SYSUser user = sysUserBO.getUser(req.getApplyUser());
        data.setDepartmentCode(user.getDepartmentCode());
        data.setUseDatetimeStart(DateUtil.strToDate(req.getUseDatetimeStart(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setUseDatetimeEnd(DateUtil.strToDate(req.getUseDatetimeEnd(),
            DateUtil.FRONT_DATE_FORMAT_STRING));
        data.setStatus(EBusBorrowStatus.TO_AUDIT.getCode());
        return busBorrowBO.saveBusBorrow(data);
    }

    @Override
    public void auditBusBorrow(String code, String approveResult,
            String updater, String remark) {
        BusBorrow condition = busBorrowBO.getBusBorrow(code);
        if (!EBusBorrowStatus.TO_AUDIT.getCode()
            .equals(condition.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态不是待审核状态，不能操作！");
        }
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            condition.setStatus(EBusBorrowStatus.TO_RETURN.getCode());
        } else {
            condition.setStatus(EBusBorrowStatus.AUDIT_NOT_PASS.getCode());
        }
        condition.setUpdater(updater);
        condition.setUpdateDatetime(new Date());
        condition.setRemark(remark);
        busBorrowBO.auditBusBorrow(condition);
    }

    @Override
    public void returnBusBorrow(String code, String driveKil, String updater,
            String remark) {
        BusBorrow condition = busBorrowBO.getBusBorrow(code);
        if (!EBusBorrowStatus.TO_RETURN.getCode()
            .equals(condition.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态不是待归还状态，不能操作！");
        }
        condition.setStatus(EBusBorrowStatus.RETURN_TO_AUDIT.getCode());
        condition.setDriveKil(StringValidater.toDouble(driveKil));
        condition.setReturnDatetime(new Date());
        condition.setUpdater(updater);
        condition.setUpdateDatetime(new Date());
        condition.setRemark(remark);
        busBorrowBO.returnBusBorrow(condition);
    }

    @Override
    public void auditBusBorrowReturn(String code, String approveResult,
            String updater, String remark) {
        BusBorrow condition = busBorrowBO.getBusBorrow(code);
        if (!EBusBorrowStatus.RETURN_TO_AUDIT.getCode()
            .equals(condition.getStatus())) {
            throw new BizException(EBizErrorCode.DEFAULT.getCode(),
                "当前状态不是归还待审核状态，不能操作！");
        }
        if (EApproveResult.PASS.getCode().equals(approveResult)) {
            condition.setStatus(EBusBorrowStatus.ALREADY_RETURN.getCode());
        } else {
            condition.setStatus(EBusBorrowStatus.TO_RETURN.getCode());
        }
        condition.setUpdater(updater);
        condition.setUpdateDatetime(new Date());
        condition.setRemark(remark);
        busBorrowBO.auditBusBorrowReturn(condition);
    }

    @Override
    public Paginable<BusBorrow> queryBusBorrowPage(int start, int limit,
            BusBorrow condition) {
        Paginable<BusBorrow> paginable = busBorrowBO.getPaginable(start, limit,
            condition);
        for (BusBorrow busBorrow : paginable.getList()) {
            initBudgetOrder(busBorrow);
        }
        return paginable;
    }

    @Override
    public List<BusBorrow> queryBusBorrowList(BusBorrow condition) {
        List<BusBorrow> queryBusBorrowList = busBorrowBO
            .queryBusBorrowList(condition);
        for (BusBorrow busBorrow : queryBusBorrowList) {
            initBudgetOrder(busBorrow);
        }
        return queryBusBorrowList;
    }

    @Override
    public BusBorrow getBusBorrow(String code) {
        BusBorrow busBorrow = busBorrowBO.getBusBorrow(code);
        initBudgetOrder(busBorrow);
        return busBorrow;
    }

    private void initBudgetOrder(BusBorrow busBorrow) {
        if (StringUtils.isNotBlank(busBorrow.getUpdater())) {
            SYSUser user = sysUserBO.getUser(busBorrow.getUpdater());
            busBorrow.setUpdaterName(user.getRealName());
        }
        if (StringUtils.isNotBlank(busBorrow.getDepartmentCode())) {
            Department department = departmentBO
                .getDepartment(busBorrow.getDepartmentCode());
            busBorrow.setDepartmentName(department.getName());
        }
        if (StringUtils.isNotBlank(busBorrow.getBusCode())) {
            Bus bus = busBO.getBus(busBorrow.getBusCode());
            busBorrow.setBusMobile(bus.getModel());
        }
    }

}
