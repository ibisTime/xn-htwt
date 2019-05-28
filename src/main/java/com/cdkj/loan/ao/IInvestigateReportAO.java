package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.dto.req.XN632200Req;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface IInvestigateReportAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addInvestigateReport(InvestigateReport data);

    // 调查报告申请
    public void approveInvestigateReport(XN632200Req req);

    public Paginable<InvestigateReport> queryInvestigateReportPage(int start,
            int limit, InvestigateReport condition, String userId);

    public List<InvestigateReport> queryInvestigateReportList(
            InvestigateReport condition);

    public InvestigateReport getInvestigateReport(String code);

    // 风控专员审核
    public void riskApprove(String code, String approveResult,
            String approveNote, String updater);

    // 驻行人员审核
    public void approveByBankCheck(String code, String approveResult,
            String approveNote, String updater);

}
