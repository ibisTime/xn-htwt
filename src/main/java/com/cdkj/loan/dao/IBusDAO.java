package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Bus;

//dao层 
public interface IBusDAO extends IBaseDAO<Bus> {
    String NAMESPACE = IBusDAO.class.getName().concat(".");

    void update(Bus condition);
}
