package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Attachment;
import java.util.List;

public interface IAttachmentBO extends IPaginableBO<Attachment> {

    String saveAttachment(String bizCode, String name, String attachType,
            String url);

    <T> void saveAttachment(String bizCode, T clazz);

    void removeAttachmentByBiz(String bizCode, String attachType);

    List<Attachment> queryAttachmentList(Attachment condition);

    Attachment getAttachment(String code);

    Attachment getAttachment(String bizCode, String category,
            String kname);

    <T> T parseAttachment(String bizCode, String category, T clazz);

    List<Attachment> queryBizAttachments(String bizCode);

    void removeByKname(String bizCode, String name);

    void removeBizAttachments(String bizCode);

    Attachment refreshAttachment(String bizCode, String name, String url);

    boolean isAttachmentExist(String bizCode, String attachName);

    void removeByCategory(String code, String car_procedure);
}
