package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Attachment;

//CHECK ��鲢��ע�� 
public interface IAttachmentAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addAttachment(Attachment data);

    public int dropAttachment(String code);

    public int editAttachment(Attachment data);

    public Paginable<Attachment> queryAttachmentPage(int start, int limit,
            Attachment condition);

    public List<Attachment> queryAttachmentList(Attachment condition);

    public Attachment getAttachment(String code);

}
