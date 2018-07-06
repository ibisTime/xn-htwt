package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.ReqBudget;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizLogType;

@Service
public class SYSBizLogAOImpl implements ISYSBizLogAO {

    @Autowired
    private ISYSBizLogBO sysBizLogBO;

    @Autowired
    private ICreditBO creditBO;

    @Autowired
    private IDepartmentBO departmentBO;

    @Autowired
    private IBudgetOrderBO budgetOrderBO;

    @Autowired
    private IReqBudgetBO reqBudgetBO;

    @Override
    public List<SYSBizLog> querySYSBizLogList(SYSBizLog condition) {
        return sysBizLogBO.querySYSBizLogList(condition);
    }

    @Override
    public SYSBizLog getSYSBizLog(int id) {
        return sysBizLogBO.getSYSBizLog(id);
    }

    @Override
    public Paginable<SYSBizLog> querySYSBizLogPage(int start, int limit,
            SYSBizLog condition) {
        return sysBizLogBO.getPaginable(start, limit, condition);
    }

    @Override
    public Paginable<SYSBizLog> querySYSBizLogPageByRoleCode(int start,
            int limit, SYSBizLog condition) {
        Paginable<SYSBizLog> paginable = sysBizLogBO.getPaginableByRoleCode(
            start, limit, condition);
        List<SYSBizLog> list = paginable.getList();
        for (SYSBizLog sysBizLog : list) {
            todoThing(sysBizLog);
        }
        return paginable;
    }

    private SYSBizLog todoThing(SYSBizLog data) {

        data.setCode(data.getRefOrder());

        String userName = "";
        String companyName = "";
        if (EBizLogType.CREDIT.getCode().equals(data.getRefType())) {
            Credit credit = creditBO.getCredit(data.getRefOrder());
            userName = credit.getUserName();
            Department department = departmentBO.getDepartment(credit
                .getCompanyCode());
            companyName = department.getName();

        }
        if (EBizLogType.BUDGET_ORDER.getCode().equals(data.getRefType())
                || EBizLogType.BUDGET_CANCEL.getCode()
                    .equals(data.getRefType())) {
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
                .getRefType());
            userName = budgetOrder.getApplyUserName();
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            companyName = department.getName();
            data.setLoanBank(budgetOrder.getLoanBank());
            data.setBizType(budgetOrder.getBizType());
        }
        if (EBizLogType.REQ_BUDGET.getCode().equals(data.getRefType())) {
            ReqBudget reqBudget = reqBudgetBO.getReqBudget(data.getRefOrder());
            userName = reqBudget.getApplyUser();
            Department department = departmentBO.getDepartment(reqBudget
                .getCompanyCode());
            companyName = department.getName();
        }

        if (EBizLogType.BACK_ADVANCE_FUND.getCode().equals(data.getRefType())) {

        }
        if (EBizLogType.BUSINESS_TRIP_APPLY.getCode().equals(data.getRefType())) {

        }
        if (EBizLogType.INVESTIGATEREPORT.getCode().equals(data.getRefType())) {

        }
        data.setUserName(userName);
        data.setCurNodeCode(data.getDealNode());
        data.setCompanyName(companyName);
        data.setFlowTypeCode(data.getRefType());
        data.setUpdateDatetime(DateUtil.dateToStr(data.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        return data;
    }

}
