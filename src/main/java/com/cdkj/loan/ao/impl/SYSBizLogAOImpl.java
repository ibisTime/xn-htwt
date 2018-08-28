package com.cdkj.loan.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IInvestigateReportBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Page;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
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

    @Autowired
    private ICreditAO creditAO;

    @Autowired
    private IInvestigateReportBO investigateReportBO;

    @Autowired
    private ISYSUserBO sysUserBO;

    @Autowired
    private IRoleNodeBO roleNodeBO;

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
        Paginable<SYSBizLog> paginable = sysBizLogBO.getPaginable(start, limit,
            condition);
        List<SYSBizLog> list = paginable.getList();
        for (SYSBizLog sysBizLog : list) {
            init(sysBizLog);
        }
        return paginable;
    }

    @Override
    public Paginable<SYSBizLog> querySYSBizLogPageByRoleCode(int start,
            int limit, SYSBizLog condition) {
        Paginable<SYSBizLog> paginable = sysBizLogBO.getPaginableByRoleCode(
            start, limit, condition);
        List<SYSBizLog> list = paginable.getList();
        for (SYSBizLog sysBizLog : list) {
            todoThing(sysBizLog);// 赋值 转义
        }
        return paginable;
    }

    private SYSBizLog todoThing(SYSBizLog data) {
        String refOrder = data.getRefOrder().substring(0, 1);
        String userName = "";
        String loanBank = "";
        String bizType = "";
        String departmentName = "";
        String bizOrderType = "";
        if ("C".equals(refOrder)) {
            Credit credit = creditBO.getCredit(data.getRefOrder());
            userName = credit.getUserName();
            loanBank = credit.getLoanBankCode();
            bizType = credit.getBizType();
            Department department = departmentBO.getDepartment(credit
                .getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "征信单";
        }
        if ("B".equals(refOrder)) {
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(data
                .getRefOrder());
            userName = budgetOrder.getApplyUserName();
            loanBank = budgetOrder.getLoanBank();
            bizType = budgetOrder.getBizType();
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "准入单";
        }
        if ("I".equals(refOrder)) {
            InvestigateReport report = investigateReportBO
                .getInvestigateReport(data.getRefOrder());
            userName = report.getApplyUserName();
            loanBank = report.getLoanBank();
            bizType = report.getBizType();
            Department department = departmentBO.getDepartment(report
                .getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "调查报告";
        }
        if ("R".equals(refOrder)) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getRefOrder());
            userName = repayBiz.getRealName();
            loanBank = repayBiz.getLoanBank();
            BudgetOrder budgetOrder = budgetOrderBO.getBudgetOrder(repayBiz
                .getRefCode());
            bizType = budgetOrder.getBizType();
            Department department = departmentBO.getDepartment(budgetOrder
                .getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "还款业务";
        }
        data.setUserName(userName);
        data.setLoanBank(loanBank);
        data.setBizType(bizType);
        data.setDepartmentName(departmentName);
        data.setBizOrderType(bizOrderType);
        return data;
    }

    @Override
    public Object querySYSBizLogPageByBizOrderType(int start, int limit,
            SYSBizLog condition) {
        List<Object> resList = new ArrayList<Object>();

        Paginable<SYSBizLog> paginable = sysBizLogBO
            .getPaginableByBizOrderType(start, limit, condition);
        List<SYSBizLog> list = paginable.getList();
        if (condition.getBizOrderType().equals(EBizOrderType.C.getCode())) {
            for (SYSBizLog sysBizLog : list) {
                Credit credit = creditBO.getCredit(sysBizLog.getRefOrder());
                creditAO.initCredit(credit);
                resList.add(credit);
            }
        }
        if (condition.getBizOrderType().equals(EBizOrderType.BO.getCode())) {
            for (SYSBizLog sysBizLog : list) {// TODO init
                BudgetOrder budgetOrder = budgetOrderBO
                    .getBudgetOrder(sysBizLog.getRefOrder());
                resList.add(budgetOrder);
            }
        }
        if (condition.getBizOrderType().equals(EBizOrderType.RB.getCode())) {
            for (SYSBizLog sysBizLog : list) {// TODO init
                RepayBiz repayBiz = repayBizBO.getRepayBiz(sysBizLog
                    .getRefOrder());
                resList.add(repayBiz);
            }
        }
        Paginable<Object> page = new Page<Object>(start, limit,
            paginable.getTotalCount());
        page.setList(resList);
        return page;
    }

    @Override
    public Object querySYSRoleListByRefOrder(SYSBizLog condition) {
        List<SYSBizLog> list = sysBizLogBO.querySYSBizLogList(condition);
        for (SYSBizLog sysBizLog : list) {
            init(sysBizLog);
        }
        return list;
    }

    private SYSBizLog init(SYSBizLog sysBizLog) {
        SYSUser user = sysUserBO.getUser(sysBizLog.getOperator());
        sysBizLog.setOperatorName(user.getRealName());
        return sysBizLog;
    }

}
