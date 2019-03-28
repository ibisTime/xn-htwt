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

//CHECK ��鲢��ע�� 
@Component
public class AttachmentBOImpl extends PaginableBOImpl<Attachment> implements
        IAttachmentBO {

    @Autowired
    private IAttachmentDAO attachmentDAO;

    @Override
    public boolean isAttachmentExist(String code) {
        Attachment condition = new Attachment();
        condition.setCode(code);
        if (attachmentDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveAttachment(Attachment data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EGeneratePrefix.attachment
                .getCode());
            data.setCode(code);
            attachmentDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeAttachment(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Attachment data = new Attachment();
            data.setCode(code);
            count = attachmentDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAttachment(Attachment data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = attachmentDAO.update(data);
        }
        return count;
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
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
