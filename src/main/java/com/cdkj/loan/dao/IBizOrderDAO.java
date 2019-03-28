package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BizOrder;

//dao层 
public interface IBizOrderDAO extends IBaseDAO<BizOrder> {
    String NAMESPACE = IBizOrderDAO.class.getName().concat(".");

    public int update(BizOrder data);
}
