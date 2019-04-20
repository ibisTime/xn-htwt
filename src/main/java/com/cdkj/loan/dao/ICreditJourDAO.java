package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditJour;

public interface ICreditJourDAO extends IBaseDAO<CreditJour> {
    String NAMESPACE = ICreditJourDAO.class.getName().concat(".");

    int update(CreditJour creditJour);

}
