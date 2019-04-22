package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.FilePool;

public interface IFilePoolDAO extends IBaseDAO<FilePool> {
    String NAMESPACE = IFilePoolDAO.class.getName().concat(".");
}
