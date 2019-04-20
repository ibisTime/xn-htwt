package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Attachment;

public interface IAttachmentBO extends IPaginableBO<Attachment> {

    public String saveAttachment(String bizCode, String name,
            String attachType, String url);

    public void removeAttachmentByBiz(String bizCode, String attachType);

    public List<Attachment> queryAttachmentList(Attachment condition);

    public Attachment getAttachment(String code);

    public List<Attachment> queryBizAttachments(String bizCode);

    public void removeByName(String bizCode, String name);

    public void removeBizAttachments(String bizCode);

    public void refreshAttachment(String bizCode, String name, String url);

    public boolean isAttachmentExist(String bizCode, String attachName);

}
