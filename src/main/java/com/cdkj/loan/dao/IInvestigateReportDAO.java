package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.InvestigateReport;

//dao层 
public interface IInvestigateReportDAO extends IBaseDAO<InvestigateReport> {
    String NAMESPACE = IInvestigateReportDAO.class.getName().concat(".");

    int update(InvestigateReport data);

    // 风控专员审核
    void riskApprove(InvestigateReport data);
}
