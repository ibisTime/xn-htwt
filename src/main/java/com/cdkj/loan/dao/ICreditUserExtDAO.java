package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditUserExt;

public interface ICreditUserExtDAO extends IBaseDAO<CreditUserExt> {
    String NAMESPACE = ICreditUserExtDAO.class.getName().concat(".");

    int update(CreditUserExt creditUserExt);
}
