package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IInvestigateReportDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.InvestigateReport;

@Repository("investigateReportDAOImpl")
public class InvestigateReportDAOImpl extends AMybatisTemplate
        implements IInvestigateReportDAO {

    @Override
    public int insert(InvestigateReport data) {
        return super.insert(NAMESPACE.concat("insert_investigateReport"), data);
    }

    @Override
    public int delete(InvestigateReport data) {
        return 0;
    }

    @Override
    public int update(InvestigateReport data) {
        return super.update(NAMESPACE.concat("update_investigateReport"), data);
    }

    @Override
    public void riskApprove(InvestigateReport data) {
        super.update(NAMESPACE.concat("update_riskApprove"), data);
    }

    @Override
    public InvestigateReport select(InvestigateReport condition) {
        return super.select(NAMESPACE.concat("select_investigateReport"),
            condition, InvestigateReport.class);
    }

    @Override
    public long selectTotalCount(InvestigateReport condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_investigateReport_count"), condition);
    }

    @Override
    public List<InvestigateReport> selectList(InvestigateReport condition) {
        return super.selectList(NAMESPACE.concat("select_investigateReport"),
            condition, InvestigateReport.class);
    }

    @Override
    public List<InvestigateReport> selectList(InvestigateReport condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_investigateReport"),
            start, count, condition, InvestigateReport.class);
    }

}
