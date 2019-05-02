package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CreditJour;
import java.util.List;

public interface ICreditJourDAO extends IBaseDAO<CreditJour> {

    String NAMESPACE = ICreditJourDAO.class.getName().concat(".");

    int update(CreditJour creditJour);

    void insertList(List<CreditJour> jourList);
}
