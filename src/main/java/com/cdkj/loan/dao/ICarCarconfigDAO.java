package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.CarCarconfig;

//dao层 
public interface ICarCarconfigDAO extends IBaseDAO<CarCarconfig> {
	String NAMESPACE = ICarCarconfigDAO.class.getName().concat(".");
}