package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditJourAO;
import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.req.XN632492Req;

@Service
public class CreditJourAOImpl implements ICreditJourAO {

    @Autowired
    private ICreditJourBO creditJourBO;

    @Override
    public String addCreditJour(XN632490Req req) {
        return creditJourBO.saveCreditJour(req);
    }

    @Override
    public void editCreditJour(XN632492Req req) {
        creditJourBO.refreshCreditJour(req);
    }

    @Override
    public void dropCreditJour(String code) {
        creditJourBO.removeCreditJour(code);
    }

    @Override
    public Paginable<CreditJour> queryCreditJourPage(int start, int limit,
            CreditJour condition) {
        return creditJourBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CreditJour> queryCreditJourList(CreditJour condition) {
        return creditJourBO.queryCreditJourList(condition);
    }

    @Override
    public CreditJour getCreditJour(String code) {
        return creditJourBO.getCreditJour(code);
    }
}
