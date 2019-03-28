package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Attachment;

//dao层 
public interface IAttachmentDAO extends IBaseDAO<Attachment> {
    String NAMESPACE = IAttachmentDAO.class.getName().concat(".");

    public int update(Attachment data);
}
