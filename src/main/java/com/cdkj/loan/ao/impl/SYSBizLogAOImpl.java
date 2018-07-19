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
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.domain.Node;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizOrderType;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.EBusinessTripApplyNode;
import com.cdkj.loan.enums.ECreditNode;
import com.cdkj.loan.enums.EInvestigateReportNode;
import com.cdkj.loan.enums.ERepayBizNode;

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
        ArrayList<SYSBizLog> resList = new ArrayList<SYSBizLog>();
        for (SYSBizLog sysBizLog : list) {
            SYSBizLog latestOperateRecordByBizCode = sysBizLogBO
                .getLatestOperateRecordByBizCode(sysBizLog.getRefOrder());
            List<Node> nodeList = roleNodeBO.queryNodeListByRoleCode(condition
                .getRoleCode());
            for (Node node : nodeList) {
                if (latestOperateRecordByBizCode.getDealNode().equals(node)) {
                    if (ECreditNode.ACHIEVE.getCode().equals(
                        latestOperateRecordByBizCode.getDealNode())
                            || EBudgetOrderNode.ARCHIVE_END.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())
                            || ERepayBizNode.SETTLED.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())
                            || ERepayBizNode.BAD_DEBT.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())
                            || ERepayBizNode.TEAN_BUY_OUT.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())
                            || ERepayBizNode.TEAM_RENT.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())
                            || ERepayBizNode.RISK_MANAGER_CHECK_NO.getCode()
                                .equals(
                                    latestOperateRecordByBizCode.getDealNode())
                            || ERepayBizNode.FINANCE_MANAGER_CHECK_NO.getCode()
                                .equals(
                                    latestOperateRecordByBizCode.getDealNode())
                            || ERepayBizNode.REDEEM_SETTLED.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())
                            || EBudgetOrderNode.CANCEL_END.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())
                            || EBusinessTripApplyNode.AUDIT_PASS.getCode()
                                .equals(
                                    latestOperateRecordByBizCode.getDealNode())
                            || EInvestigateReportNode.FINISH.getCode().equals(
                                latestOperateRecordByBizCode.getDealNode())) {
                        // 每种流程最后一个节点的 去除调
                        continue;
                    }
                    todoThing(latestOperateRecordByBizCode);// 赋值 转义
                    resList.add(latestOperateRecordByBizCode);
                }
            }
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
        if ("IR".equals(refOrder)) {
            InvestigateReport report = investigateReportBO
                .getInvestigateReport(data.getRefOrder());
            Department department = departmentBO.getDepartment(report
                .getCompanyCode());
            data.setCompanyName(department.getName());
            data.setUserName(report.getApplyUserName());

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
