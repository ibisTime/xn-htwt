package com.cdkj.loan.bo.impl;

import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.IFileListBO;
import com.cdkj.loan.bo.base.PaginableBOImpl;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.FieldNameUtil;
import com.cdkj.loan.core.OrderNoGenerater;
import com.cdkj.loan.dao.IAttachmentDAO;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.enums.EAttachmentName;
import com.cdkj.loan.enums.EGeneratePrefix;
import com.cdkj.loan.exception.BizException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AttachmentBOImpl extends PaginableBOImpl<Attachment>
        implements IAttachmentBO {

    private final static Logger log = LoggerFactory
            .getLogger(IAttachmentBO.class);

    @Autowired
    private IAttachmentDAO attachmentDAO;

    @Autowired
    private IFileListBO fileListBO;

    @Override
    public String saveAttachment(String bizCode, String name, String attachType,
            String url) {
        String code = null;
        if (isAttachmentExist(bizCode, name)) {
            Attachment attachment = refreshAttachment(bizCode, name, url);
            code = attachment.getCode();
        } else {
            Attachment data = new Attachment();
            FileList fileList = fileListBO.getFileListByKname(name);
            code = OrderNoGenerater
                    .generate(EGeneratePrefix.attachment.getCode());
            data.setCode(code);
            data.setBizCode(bizCode);

            EntityUtils.copyData(fileList, data);
            data.setUrl(url);

            attachmentDAO.insert(data);
        }

        return code;
    }

    @Override
    @Transactional
    public <T> void saveAttachment(String bizCode, T clazz) {
        try {
            Field[] fields = clazz.getClass().getDeclaredFields();
            for (Field field : fields) {

                field.setAccessible(true);
                Object fieldValue = field.get(clazz);

                String fieldName = FieldNameUtil
                        .humpToUnderline(field.getName());

                FileList fileList = fileListBO.getFileListByKname(fieldName);

                if (null != fieldValue && null != fileList) {
                    saveAttachment(bizCode, fileList.getCategory(),
                            fileList.getKname(), fileList.getVname(),
                            fieldValue.toString());
                }

            }
        } catch (Exception e) {
            log.info("附件保存失败:{}", e.getMessage());
        }
    }

    public String saveAttachment(String bizCode, String category, String kName,
            String vName, String url) {
        Attachment data = new Attachment();

        String code = OrderNoGenerater
                .generate(EGeneratePrefix.attachment.getCode());
        data.setCode(code);
        data.setBizCode(bizCode);
        data.setCategory(category);

        data.setKname(kName);
        data.setVname(vName);
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

    @Override
    public Attachment getAttachment(String bizCode, String category,
            String kname) {
        Attachment data = null;
        Attachment condition = new Attachment();
        condition.setBizCode(bizCode);
        condition.setCategory(category);
        condition.setKname(kname);
        data = attachmentDAO.select(condition);
        return data;
    }

    @Override
    public <T> T parseAttachment(String bizCode, String category, T clazz) {

        try {
            Field[] fields = clazz.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];

                String fieldName = FieldNameUtil
                        .humpToUnderline(field.getName());

                if (null != EAttachmentName.matchCode(fieldName)) {

                    String setMethod = "set"
                            + field.getName().substring(0, 1).toUpperCase()
                            + field.getName().substring(1);
                    Method method = clazz.getClass().getMethod(setMethod,
                            String.class);

                    Attachment attachment = getAttachment(bizCode, category,
                            fieldName);

                    if (null != attachment) {
                        method.invoke(clazz, attachment.getUrl());
                    }

                }

            }
        } catch (Exception e) {
            log.info("附件转化失败:{}", e.getMessage());
        }

        return clazz;
    }

    @Override
    public List<Attachment> queryBizAttachments(String bizCode) {
        Attachment condition = new Attachment();
        condition.setBizCode(bizCode);
        List<Attachment> attachments = attachmentDAO.selectList(condition);
        // for (Attachment attachment : attachments) {
        // EAttachName attachName = EAttachName.getMap().get(
        // attachment.getName());
        // attachment.setNameString(attachName.getValue());
        // }
        return attachments;
    }

    @Override
    public void removeByKname(String bizCode, String name) {
        Attachment condition = new Attachment();

        condition.setBizCode(bizCode);
        condition.setKname(name);
        Attachment attachment = attachmentDAO.select(condition);
        attachmentDAO.deleteAttachment(attachment);

    }

    @Override
    public void removeBizAttachments(String bizCode) {
        Attachment condition = new Attachment();
        condition.setBizCode(bizCode);

        List<Attachment> attachments = attachmentDAO.selectList(condition);
        for (Attachment attachment : attachments) {
            attachmentDAO.deleteAttachment(attachment);
        }
    }

    @Override
    public Attachment refreshAttachment(String bizCode, String name, String url) {
        Attachment condition = new Attachment();
        condition.setBizCode(bizCode);
        condition.setKname(name);
        Attachment attachment = attachmentDAO.select(condition);
        attachment.setUrl(url);
        attachmentDAO.updateAttachment(attachment);

        return attachment;
    }

    @Override
    public boolean isAttachmentExist(String bizCode, String attachName) {
        Attachment condition = new Attachment();
        condition.setBizCode(bizCode);
        condition.setKname(attachName);
        if (attachmentDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void removeByCategory(String code, String category) {
        Attachment condition = new Attachment();
        condition.setBizCode(code);
        condition.setCategory(category);
        List<Attachment> attachmentList = attachmentDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(attachmentList)) {
            for (Attachment attachment : attachmentList) {
                attachmentDAO.deleteAttachment(attachment);
            }
        }
    }

}
