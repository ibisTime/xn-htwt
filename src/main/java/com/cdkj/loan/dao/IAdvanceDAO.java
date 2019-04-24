package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Advance;

public interface IAdvanceDAO extends IBaseDAO<Advance> {
    String NAMESPACE = IAdvanceDAO.class.getName().concat(".");
}
