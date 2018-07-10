package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.enums.EBizOrderType;

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

    @Autowired
    private IRepayBizBO repayBizBO;

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
        ArrayList<SYSBizLog> resList = new ArrayList<SYSBizLog>();
        for (SYSBizLog sysBizLog : list) {
            SYSBizLog latestOperateRecordByBizCode = sysBizLogBO
                .getLatestOperateRecordByBizCode(sysBizLog.getRefOrder());
            todoThing(latestOperateRecordByBizCode);
            resList.add(latestOperateRecordByBizCode);
        }
        list.removeAll(list);
        for (SYSBizLog sysBizLog : resList) {
            list.add(sysBizLog);
        }
        return paginable;
    }

    private SYSBizLog todoThing(SYSBizLog data) {

        String refOrder = data.getRefOrder().substring(0, 1);

        data.setCode(data.getRefOrder());
        String userName = "";
        String companyName = "";
        if ("C".equals(refOrder)) {
            Credit credit = creditBO.getCredit(data.getRefOrder());
            userName = credit.getUserName();
            Department department = departmentBO.getDepartment(credit
                .getCompanyCode());
            companyName = department.getName();
        }
        if ("R".equals(refOrder)) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getRefOrder());
            userName = repayBiz.getRealName();
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(repayBiz
                .getBudgetOrderCode());
            userName = budgetOrder.getApplyUserName();
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            companyName = department.getName();
        }
        if ("B".equals(refOrder)) {
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
                .getRefOrder());
            userName = budgetOrder.getApplyUserName();
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            companyName = department.getName();
            data.setLoanBank(budgetOrder.getLoanBank());
            data.setBizType(budgetOrder.getBizType());
        }

        data.setUserName(userName);
        data.setCurNodeCode(data.getDealNode());
        data.setCompanyName(companyName);
        data.setFlowTypeCode(data.getRefType());
        data.setUpdateDatetime(DateUtil.dateToStr(data.getEndDatetime(),
            DateUtil.FRONT_DATE_FORMAT_STRING));

        return data;
    }

    @Override
    public List<Object> querySYSRolePageByBizOrderType(int start, int limit,
            SYSBizLog condition) {
        List<Object> resList = new ArrayList<Object>();

        Paginable<SYSBizLog> paginable = sysBizLogBO
            .getPaginableByBizOrderType(start, limit, condition);
        List<SYSBizLog> list = paginable.getList();
        if (condition.getBizOrderType().equals(EBizOrderType.C.getCode())) {
            for (SYSBizLog sysBizLog : list) {
                Credit credit = creditBO.getCredit(sysBizLog.getRefOrder());
                resList.add(credit);
            }
        }
        if (condition.getBizOrderType().equals(EBizOrderType.BO.getCode())) {
            for (SYSBizLog sysBizLog : list) {
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(sysBizLog.getRefOrder());
                resList.add(budgetOrder);
            }
        }
        if (condition.getBizOrderType().equals(EBizOrderType.RB.getCode())) {
            for (SYSBizLog sysBizLog : list) {
                RepayBiz repayBiz = repayBizBO.getRepayBiz(sysBizLog
                    .getRefOrder());
                resList.add(repayBiz);
            }
        }
        return resList;
    }

    @Override
    public Object querySYSRoleListByRefOrder(SYSBizLog condition) {
        return sysBizLogBO.querySYSBizLogList(condition);
    }

}
