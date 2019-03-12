package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Carconfig;

//dao层 
public interface ICarconfigDAO extends IBaseDAO<Carconfig> {
    String NAMESPACE = ICarconfigDAO.class.getName().concat(".");

    public int updateConfig(Carconfig data);
}
