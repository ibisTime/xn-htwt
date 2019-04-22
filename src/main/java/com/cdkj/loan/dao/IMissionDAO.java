package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Mission;

//dao层 
public interface IMissionDAO extends IBaseDAO<Mission> {
    String NAMESPACE = IMissionDAO.class.getName().concat(".");

    public int updateStatus(Mission data);

    public int updateFinish(Mission data);
}
