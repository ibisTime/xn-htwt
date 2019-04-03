package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.BizTask;

public interface IBizTaskDAO extends IBaseDAO<BizTask> {
    String NAMESPACE = IBizTaskDAO.class.getName().concat(".");

    int updateOperate(BizTask bizTask);

}
