package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IInvestigateReportAO;
import com.cdkj.loan.bo.IInvestigateReportBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InvestigateReport;

//CHECK ��鲢��ע�� 
@Service
public class InvestigateReportAOImpl implements IInvestigateReportAO {

    @Autowired
    private IInvestigateReportBO investigateReportBO;

    @Override
    public String addInvestigateReport(InvestigateReport data) {
        return investigateReportBO.saveInvestigateReport(data);
    }

    @Override
    public int editInvestigateReport(InvestigateReport data) {
        return investigateReportBO.refreshInvestigateReport(data);
    }

    @Override
    public Paginable<InvestigateReport> queryInvestigateReportPage(int start,
            int limit, InvestigateReport condition) {
        return investigateReportBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<InvestigateReport> queryInvestigateReportList(
            InvestigateReport condition) {
        return investigateReportBO.queryInvestigateReportList(condition);
    }

    @Override
    public InvestigateReport getInvestigateReport(String code) {
        return investigateReportBO.getInvestigateReport(code);
    }
}
