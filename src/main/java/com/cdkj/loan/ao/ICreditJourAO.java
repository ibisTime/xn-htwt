package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.req.XN632492Req;

@Component
public interface ICreditJourAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCreditJour(XN632490Req req);

    public void dropCreditJour(String code);

    public void editCreditJour(XN632492Req req);

    public Paginable<CreditJour> queryCreditJourPage(int start, int limit,
            CreditJour condition);

    public List<CreditJour> queryCreditJourList(CreditJour condition);

    public CreditJour getCreditJour(String code);

}
