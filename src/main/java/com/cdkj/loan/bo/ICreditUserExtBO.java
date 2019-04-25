package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.dto.req.XN632480Req;
import com.cdkj.loan.dto.req.XN632482Req;

public interface ICreditUserExtBO extends IPaginableBO<CreditUserExt> {

    public String saveCreditUserExt(XN632480Req req);

    public String saveCreditUserExt(CreditUserExt data, String bizCode);

    public void removeCreditUserExt(String code);

    public void refreshCreditUserExt(XN632482Req req);

    public List<CreditUserExt> queryCreditUserExtList(CreditUserExt condition);

    public CreditUserExt getCreditUserExt(String code);

    public CreditUserExt getCreditUserExtByBizCode(String bizCode);

    public void removeBizUserExt(String bizCode);

}
