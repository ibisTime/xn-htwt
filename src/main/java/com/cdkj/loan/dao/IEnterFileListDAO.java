package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.EnterFileList;

//dao层 
public interface IEnterFileListDAO extends IBaseDAO<EnterFileList> {

    String NAMESPACE = IEnterFileListDAO.class.getName().concat(".");

    int update(EnterFileList data);
}