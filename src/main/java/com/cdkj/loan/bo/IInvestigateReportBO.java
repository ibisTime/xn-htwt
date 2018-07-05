package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.InvestigateReport;

public interface IInvestigateReportBO extends IPaginableBO<InvestigateReport> {

    public String saveInvestigateReport(InvestigateReport data);

    public int refreshInvestigateReport(InvestigateReport data);

    public List<InvestigateReport> queryInvestigateReportList(
            InvestigateReport condition);

    public InvestigateReport getInvestigateReport(String code);

}
