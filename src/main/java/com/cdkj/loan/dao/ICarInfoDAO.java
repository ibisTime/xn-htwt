package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarInfo;

//dao层 
public interface ICarInfoDAO extends IBaseDAO<CarInfo> {
    String NAMESPACE = ICarInfoDAO.class.getName().concat(".");

    public int updateEntryFbhInfo(CarInfo data);

    public int update(CarInfo data);
}
