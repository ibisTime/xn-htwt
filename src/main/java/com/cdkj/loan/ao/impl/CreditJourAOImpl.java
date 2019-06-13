package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditJourAO;
import com.cdkj.loan.bo.ICreditJourBO;
import com.cdkj.loan.bo.ICreditUserBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.req.XN632492Req;

@Service
public class CreditJourAOImpl implements ICreditJourAO {

    @Autowired
    private ICreditJourBO creditJourBO;

    @Autowired
    private ICreditUserBO creditUserBO;

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
        Paginable<CreditJour> page = creditJourBO.getPaginable(start, limit,
            condition);
        for (CreditJour creditJour : page.getList()) {
            init(creditJour);
        }
        return page;
    }

    @Override
    public List<CreditJour> queryCreditJourList(CreditJour condition) {
        List<CreditJour> creditJours = creditJourBO
            .queryCreditJourList(condition);
        for (CreditJour creditJour : creditJours) {
            init(creditJour);
        }
        return creditJours;
    }

    @Override
    public CreditJour getCreditJour(String code) {
        CreditJour creditJour = creditJourBO.getCreditJour(code);
        init(creditJour);
        return creditJour;
    }

    private void init(CreditJour creditJour) {
        CreditUser creditUser = creditUserBO.getCreditUser(creditJour
            .getCreditUserCode());
        creditJour.setCreditUser(creditUser);
    }
}
