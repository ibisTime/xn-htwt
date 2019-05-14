package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.dto.req.XN632120Req;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.req.XN632492Req;
import java.util.List;

public interface ICreditJourBO extends IPaginableBO<CreditJour> {

    String saveCreditJour(XN632490Req req);

    void removeCreditJour(String code);

    void refreshCreditJour(XN632492Req req);

    List<CreditJour> queryCreditJourList(CreditJour condition);

    CreditJour getCreditJour(String code);

    void saveCreditJour(XN632120Req req);

    void removeBizJour(String bizCode);

    List<CreditJour> querCreditJoursByBizCode(String bizCode);

    CreditJour getCreditJourByCondition(String bizCode, String creditUserCode);

    /**
     * 批量新增
     */
    void saveCreditJourList(List<CreditJour> jourList);
}
