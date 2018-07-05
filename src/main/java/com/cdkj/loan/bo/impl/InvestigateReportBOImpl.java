package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IInvestigateReportBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IInvestigateReportDAO;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class InvestigateReportBOImpl extends PaginableBOImpl<InvestigateReport>
        implements IInvestigateReportBO {

    @Autowired
    private IInvestigateReportDAO investigateReportDAO;

    public String saveInvestigateReport(InvestigateReport data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater
                .generate(EGeneratePrefix.INVESTIGATEREPORT.getCode());
            data.setCode(code);
            investigateReportDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshInvestigateReport(InvestigateReport data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = investigateReportDAO.update(data);
        }
        return count;
    }

    @Override
    public List<InvestigateReport> queryInvestigateReportList(
            InvestigateReport condition) {
        return investigateReportDAO.selectList(condition);
    }

    @Override
    public InvestigateReport getInvestigateReport(String code) {
        InvestigateReport data = null;
        if (StringUtils.isNotBlank(code)) {
            InvestigateReport condition = new InvestigateReport();
            condition.setCode(code);
            data = investigateReportDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
