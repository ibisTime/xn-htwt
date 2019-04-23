package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarPledge;

public interface ICarPledgeDAO extends IBaseDAO<CarPledge> {
    String NAMESPACE = ICarPledgeDAO.class.getName().concat(".");

    int update(CarPledge carPledge);

    int updateStatus(CarPledge carPledge);

}