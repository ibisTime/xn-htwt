package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BizLog;

public interface IBizLogDAO extends IBaseDAO<BizLog> {
    String NAMESPACE = IBizLogDAO.class.getName().concat(".");
}
