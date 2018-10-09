package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.bo.IBudgetOrderBO;
import com.cdkj.loan.bo.IBusinessTripApplyBO;
import com.cdkj.loan.bo.ICreditBO;
import com.cdkj.loan.bo.IDepartmentBO;
import com.cdkj.loan.bo.IInvestigateReportBO;
import com.cdkj.loan.bo.ILogisticsBO;
import com.cdkj.loan.bo.IRepayBizBO;
import com.cdkj.loan.bo.IReqBudgetBO;
import com.cdkj.loan.bo.IRoleNodeBO;
import com.cdkj.loan.bo.ISYSBizLogBO;
import com.cdkj.loan.bo.ISYSUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.domain.BusinessTripApply;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.domain.Department;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.domain.RepayBiz;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.dto.res.XN632912Res;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.EBudgetOrderNode;
import com.cdkj.loan.enums.ELogisticsStatus;

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

    @Autowired
    private IBusinessTripApplyBO businessTripApplyBO;

    @Autowired
    private ILogisticsBO logisticsBO;

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
    public Object todoListAPP(SYSBizLog condition) {
        List<SYSBizLog> list = sysBizLogBO
            .querySYSBizLogListByRoleCode(condition);
        XN632912Res data = new XN632912Res(0, 0, 0, 0, 0, 0);
        for (SYSBizLog sysBizLog : list) {
            if (EBizLogType.CREDIT.getCode().equals(sysBizLog.getRefType())) {
                data.setCreditTodo(data.getCreditTodo() + 1);
            }
            if (EBudgetOrderNode.INTERVIEW.getCode()
                .equals(sysBizLog.getDealNode())
                    || EBudgetOrderNode.AGAIN_INTERVIEW.getCode()
                        .equals(sysBizLog.getDealNode())) {
                data.setInterviewTodo(data.getInterviewTodo() + 1);
            }
            if (EBudgetOrderNode.GPSAZ.getCode().equals(sysBizLog.getDealNode())
                    || EBudgetOrderNode.AGAINGPSAZ.getCode()
                        .equals(sysBizLog.getDealNode())) {
                data.setGpsInstallTodo(data.getGpsInstallTodo() + 1);
            }
            if (EBudgetOrderNode.CARSETTLE.getCode()
                .equals(sysBizLog.getDealNode())) {
                data.setCarSettleTodo(data.getCarSettleTodo() + 1);
            }
            if (EBudgetOrderNode.ENTRYMORTGAGE.getCode()
                .equals(sysBizLog.getDealNode())
                    || EBudgetOrderNode.ENTRYCOMMITBANK.getCode()
                        .equals(sysBizLog.getDealNode())
                    || EBudgetOrderNode.MORTGAGEFINISH.getCode()
                        .equals(sysBizLog.getDealNode())) {
                data.setEntryMortgageTodo(data.getEntryMortgageTodo() + 1);
            }
            if (ELogisticsStatus.SEND.getCode().equals(sysBizLog.getDealNode())
                    || ELogisticsStatus.RECEIVE.getCode()
                        .equals(sysBizLog.getDealNode())) {
                data.setLogisticsTodo(data.getLogisticsTodo() + 1);
            }
        }
        return data;
    }

    @Override
    public Paginable<SYSBizLog> todoListOSS(int start, int limit,
            SYSBizLog condition) {
        Paginable<SYSBizLog> paginable = sysBizLogBO
            .getPaginableByRoleCode(start, limit, condition);
        List<SYSBizLog> list = paginable.getList();
        for (SYSBizLog sysBizLog : list) {
            todoThing(sysBizLog);
        }
        return paginable;
    }

    private SYSBizLog todoThing(SYSBizLog data) {
        String userName = "";
        String loanBank = "";
        String bizType = "";
        String departmentName = "";
        String bizOrderType = "";
        /*
         * if ("L".equals(data.getRefOrder().substring(0, 1))) { Logistics
         * logistics = logisticsBO.getLogistics(data.getRefOrder());
         * data.setLogisticsStatus(logistics.getStatus()); BudgetOrder
         * budgetOrder = budgetOrderBO.getBudgetOrder(logistics .getBizCode());
         * Department department = departmentBO.getDepartment(budgetOrder
         * .getCompanyCode()); departmentName = department.getName(); userName =
         * budgetOrder.getApplyUserName(); bizOrderType = "资料传递"; }
         */
        if ("C".equals(data.getRefOrder().substring(0, 1))) {
            Credit credit = creditBO.getCredit(data.getRefOrder());
            userName = credit.getUserName();
            loanBank = credit.getLoanBankCode();
            bizType = credit.getBizType();
            Department department = departmentBO
                .getDepartment(credit.getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "征信单";
        } else if ("BO".equals(data.getRefOrder().substring(0, 2))) {
            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrder(data.getRefOrder());

            // if (budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.DHAPPROVEDATA.getCode())
            // || budgetOrder.getCurNodeCode()
            // .equals(EBudgetOrderNode.COMMITBANK3.getCode())
            // || budgetOrder.getCurNodeCode().equals(
            // EBudgetOrderNode.MORTGAGECOMMITBANK.getCode())) {
            // Logistics condition = new Logistics();
            // ArrayList<String> statusList = new ArrayList<String>();
            // statusList.add(ELogisticsStatus.TO_SEND.getCode());
            // statusList.add(ELogisticsStatus.TO_RECEIVE.getCode());
            // statusList.add(ELogisticsStatus.TO_SEND_AGAIN.getCode());
            // condition.setStatusList(statusList);
            // condition.setBizCode(budgetOrder.getCode());
            // condition.setToNodeCode(budgetOrder.getCurNodeCode());
            // List<Logistics> list = logisticsBO
            // .queryLogisticsList(condition);
            // if (list != null) {
            // Logistics logistics = list.get(0);
            // data.setRefOrder(logistics.getCode());
            // data.setLogisticsStatus(logistics.getStatus());
            // }
            // }

            userName = budgetOrder.getApplyUserName();
            loanBank = budgetOrder.getLoanBank();
            bizType = budgetOrder.getBizType();
            Department department = departmentBO
                .getDepartment(budgetOrder.getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "准入单";
        } else if ("RB".equals(data.getRefOrder().substring(0, 2))) {
            RepayBiz repayBiz = repayBizBO.getRepayBiz(data.getRefOrder());
            userName = repayBiz.getRealName();
            loanBank = repayBiz.getLoanBank();
            BudgetOrder budgetOrder = budgetOrderBO
                .getBudgetOrder(repayBiz.getRefCode());
            bizType = budgetOrder.getBizType();
            Department department = departmentBO
                .getDepartment(budgetOrder.getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "还款业务";
        } else if ("BTA".equals(data.getRefOrder().substring(0, 3))) {
            BusinessTripApply businessTripApply = businessTripApplyBO
                .getBusinessTripApply(data.getRefOrder());
            SYSUser user = sysUserBO
                .getUser(businessTripApply.getApplyUserCode());
            userName = user.getRealName();
            Department department = departmentBO
                .getDepartment(businessTripApply.getDepartmentCode());
            departmentName = department.getName();
            bizOrderType = "出差申请";
        } else if ("IR".equals(data.getRefOrder().substring(0, 2))) {
            InvestigateReport report = investigateReportBO
                .getInvestigateReport(data.getRefOrder());
            userName = report.getApplyUserName();
            loanBank = report.getLoanBank();
            bizType = report.getBizType();
            Department department = departmentBO
                .getDepartment(report.getCompanyCode());
            departmentName = department.getName();
            bizOrderType = "调查报告";
        }
        data.setUserName(userName);
        data.setLoanBank(loanBank);
        data.setBizType(bizType);
        data.setDepartmentName(departmentName);
        data.setBizOrderType(bizOrderType);
        return data;
    }

    private SYSBizLog init(SYSBizLog sysBizLog) {
        SYSUser user = sysUserBO.getUser(sysBizLog.getOperator());
        if (null != user) {
            sysBizLog.setOperatorName(user.getRealName());
        }
        return sysBizLog;
    }

}
