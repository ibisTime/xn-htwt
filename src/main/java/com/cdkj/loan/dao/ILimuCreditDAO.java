package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.LimuCredit;

//dao层 
public interface ILimuCreditDAO extends IBaseDAO<LimuCredit> {
    String NAMESPACE = ILimuCreditDAO.class.getName().concat(".");

    int update(LimuCredit data);
}
