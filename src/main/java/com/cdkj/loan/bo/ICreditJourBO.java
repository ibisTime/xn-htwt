package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.req.XN632492Req;
import java.util.List;

public interface ICreditJourBO extends IPaginableBO<CreditJour> {

    public String saveCreditJour(XN632490Req req);

    public void removeCreditJour(String code);

    public void refreshCreditJour(XN632492Req req);

    public List<CreditJour> queryCreditJourList(CreditJour condition);

    public CreditJour getCreditJour(String code);

    public void saveCreditJour(XN632120Req req);

    public void removeBizJour(String bizCode);

    public List<CreditJour> querCreditJoursByBizCode(String bizCode);

    /**
     * 批量新增
     */
    void saveCreditJourList(List<CreditJour> jourList);
}
