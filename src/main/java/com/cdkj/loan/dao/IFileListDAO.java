package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.FileList;

//dao层 
public interface IFileListDAO extends IBaseDAO<FileList> {
    String NAMESPACE = IFileListDAO.class.getName().concat(".");

    void update(FileList data);
}
