package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IAttachmentAO;
import com.cdkj.loan.bo.IAttachmentBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class AttachmentAOImpl implements IAttachmentAO {

	@Autowired
	private IAttachmentBO attachmentBO;

	@Override
	public String addAttachment(Attachment data) {
		return attachmentBO.saveAttachment(data);
	}

	@Override
	public int editAttachment(Attachment data) {
		if (!attachmentBO.isAttachmentExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return attachmentBO.refreshAttachment(data);
	}

	@Override
	public int dropAttachment(String code) {
		if (!attachmentBO.isAttachmentExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return attachmentBO.removeAttachment(code);
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