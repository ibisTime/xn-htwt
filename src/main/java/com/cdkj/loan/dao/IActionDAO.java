package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Action;

//dao层 
public interface IActionDAO extends IBaseDAO<Action> {
	String NAMESPACE = IActionDAO.class.getName().concat(".");
}