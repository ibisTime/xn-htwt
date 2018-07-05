package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InvestigateReport;

@Component
public interface IInvestigateReportAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addInvestigateReport(InvestigateReport data);

    public int editInvestigateReport(InvestigateReport data);

    public Paginable<InvestigateReport> queryInvestigateReportPage(int start,
            int limit, InvestigateReport condition);

    public List<InvestigateReport> queryInvestigateReportList(
            InvestigateReport condition);

    public InvestigateReport getInvestigateReport(String code);

}
