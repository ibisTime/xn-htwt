package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Cdbiz;

//dao层 
public interface ICdbizDAO extends IBaseDAO<Cdbiz> {
    String NAMESPACE = ICdbizDAO.class.getName().concat(".");

    public int updateStatus(Cdbiz data);

    public int updateMakeCardStatus(Cdbiz data);

    public int updateMqStatus(Cdbiz data);

    public int updateFbhgpsStatus(Cdbiz data);

    public int updateFircundangStatus(Cdbiz data);

    public int updateSeccundangStatus(Cdbiz data);

    public int updateZfStatus(Cdbiz data);

    public int updateCurNodeCode(Cdbiz data);

    public int updateYwy(Cdbiz data);

    public int updateInsideJob(Cdbiz data);
}
