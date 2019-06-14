package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.AdvanceCollectCard;

//dao层 
public interface IAdvanceCollectCardDAO extends IBaseDAO<AdvanceCollectCard> {
	String NAMESPACE = IAdvanceCollectCardDAO.class.getName().concat(".");
}