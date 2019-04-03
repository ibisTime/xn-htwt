package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Cdbiz;

//dao层 
public interface ICdbizDAO extends IBaseDAO<Cdbiz> {
    String NAMESPACE = ICdbizDAO.class.getName().concat(".");

    public int updateStatus(Cdbiz data);
}
