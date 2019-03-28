package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Attachment;



//CHECK ��鲢��ע�� 
public interface IAttachmentBO extends IPaginableBO<Attachment> {


	public boolean isAttachmentExist(String code);


	public String saveAttachment(Attachment data);


	public int removeAttachment(String code);


	public int refreshAttachment(Attachment data);


	public List<Attachment> queryAttachmentList(Attachment condition);


	public Attachment getAttachment(String code);


}