package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IAttachmentAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.dto.req.XN623540Req;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AttachmentAOImpl implements IAttachmentAO {

    @Autowired
    private IAttachmentBO attachmentBO;

    @Override
    @Transactional
    public String addAttachment(XN623540Req req) {
        return attachmentBO.saveAttachment(req.getBizCode(), null,
                req.getAttachType(), req.getUrl());
    }

    @Override
    public Paginable<Attachment> queryAttachmentPage(int start, int limit,
            Attachment condition) {
        return attachmentBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Attachment> queryAttachmentList(Attachment condition) {
        return attachmentBO.queryAttachmentList(condition);
    }

    @Override
    public Attachment getAttachment(String code) {
        return attachmentBO.getAttachment(code);
    }
}
