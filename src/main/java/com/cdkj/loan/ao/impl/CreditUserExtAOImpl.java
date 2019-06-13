package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICreditUserExtAO;
import com.cdkj.loan.bo.ICreditUserExtBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.dto.req.XN632480Req;
import com.cdkj.loan.dto.req.XN632482Req;

@Service
public class CreditUserExtAOImpl implements ICreditUserExtAO {

    @Autowired
    private ICreditUserExtBO creditUserExtBO;

    @Override
    public String addCreditUserExt(XN632480Req req) {
        return creditUserExtBO.saveCreditUserExt(req);
    }

    @Override
    public void editCreditUserExt(XN632482Req req) {
        creditUserExtBO.refreshCreditUserExt(req);
    }

    @Override
    public void dropCreditUserExt(String code) {
        creditUserExtBO.removeCreditUserExt(code);
    }

    @Override
    public Paginable<CreditUserExt> queryCreditUserExtPage(int start, int limit,
            CreditUserExt condition) {
        return creditUserExtBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<CreditUserExt> queryCreditUserExtList(CreditUserExt condition) {
        return creditUserExtBO.queryCreditUserExtList(condition);
    }

    @Override
    public CreditUserExt getCreditUserExt(String code) {
        return creditUserExtBO.getCreditUserExt(code);
    }
}
