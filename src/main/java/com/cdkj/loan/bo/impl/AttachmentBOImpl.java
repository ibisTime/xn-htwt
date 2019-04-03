package com.cdkj.loan.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAttachmentDAO;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;

@Component
public class AttachmentBOImpl extends PaginableBOImpl<Attachment>
        implements IAttachmentBO {

    @Autowired
    private IAttachmentDAO attachmentDAO;

    @Override
    public String saveAttachment(String bizCode, String attachType,
            String url) {
        Attachment data = new Attachment();

        String code = OrderNoGenerater
            .generate(EGeneratePrefix.attachment.getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        data.setAttachType(attachType);
        data.setUrl(url);

        attachmentDAO.insert(data);
        return code;
    }

    @Override
    public void removeAttachmentByBiz(String bizCode, String attachType) {
        Attachment attachment = new Attachment();

        attachment.setBizCode(bizCode);
        attachment.setAttachType(attachType);

        attachmentDAO.deleteByBiz(attachment);
    }

    @Override
    public List<Attachment> queryAttachmentList(Attachment condition) {
        return attachmentDAO.selectList(condition);
    }

    @Override
    public Attachment getAttachment(String code) {
        Attachment data = null;
        if (StringUtils.isNotBlank(code)) {
            Attachment condition = new Attachment();
            condition.setCode(code);
            data = attachmentDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "附件不存在");
            }
        }
        return data;
    }

}
