package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BusBorrow;

//dao层 
public interface IBusBorrowDAO extends IBaseDAO<BusBorrow> {
	String NAMESPACE = IBusBorrowDAO.class.getName().concat(".");
}