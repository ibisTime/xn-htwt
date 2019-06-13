package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.RepointAccount;

//dao层 
public interface IRepointAccountDAO extends IBaseDAO<RepointAccount> {

    String NAMESPACE = IRepointAccountDAO.class.getName().concat(".");

    /**
     * 批量删除
     */
    void deleteListByRepointCode(RepointAccount data);
}