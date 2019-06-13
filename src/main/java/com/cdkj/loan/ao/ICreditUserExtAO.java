package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.dto.req.XN632480Req;
import com.cdkj.loan.dto.req.XN632482Req;

@Component
public interface ICreditUserExtAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addCreditUserExt(XN632480Req req);

    public void dropCreditUserExt(String code);

    public void editCreditUserExt(XN632482Req req);

    public Paginable<CreditUserExt> queryCreditUserExtPage(int start, int limit,
            CreditUserExt condition);

    public List<CreditUserExt> queryCreditUserExtList(CreditUserExt condition);

    public CreditUserExt getCreditUserExt(String code);

}
