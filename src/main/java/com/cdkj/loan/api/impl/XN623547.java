package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.cdkj.loan.ao.IAttachmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.dto.req.XN623547Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查附件
 * @author: silver 
 * @since: Apr 2, 2019 5:44:17 PM 
 * @history:
 */
public class XN623547 extends AProcessor {
    private IAttachmentAO attachmentAO = SpringContextHolder
        .getBean(IAttachmentAO.class);

    private XN623547Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Attachment condition = new Attachment();
        BeanUtils.copyProperties(req, condition);

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IAttachmentAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());

        return attachmentAO.queryAttachmentList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623547Req.class);
        ObjValidater.validateReq(req);
    }

}
