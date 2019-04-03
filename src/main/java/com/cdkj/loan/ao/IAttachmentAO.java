package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.dto.req.XN623540Req;

public interface IAttachmentAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addAttachment(XN623540Req req);

    public Paginable<Attachment> queryAttachmentPage(int start, int limit,
            Attachment condition);

    public List<Attachment> queryAttachmentList(Attachment condition);

    public Attachment getAttachment(String code);

}
