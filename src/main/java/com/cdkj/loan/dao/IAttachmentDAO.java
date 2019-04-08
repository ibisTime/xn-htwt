package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Attachment;

public interface IAttachmentDAO extends IBaseDAO<Attachment> {
    String NAMESPACE = IAttachmentDAO.class.getName().concat(".");

    int deleteByBiz(Attachment attachment);

}