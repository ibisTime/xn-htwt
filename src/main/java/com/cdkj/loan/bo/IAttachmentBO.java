package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Attachment;

public interface IAttachmentBO extends IPaginableBO<Attachment> {

    public String saveAttachment(String bizCode, String attachType, String url);

    public void removeAttachmentByBiz(String bizCode, String attachType);

    public List<Attachment> queryAttachmentList(Attachment condition);

    public Attachment getAttachment(String code);

}