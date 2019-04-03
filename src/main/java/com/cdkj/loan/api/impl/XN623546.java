package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAttachmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN623546Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查附件
 * @author: silver 
 * @since: Apr 2, 2019 5:44:17 PM 
 * @history:
 */
public class XN623546 extends AProcessor {
    private IAttachmentAO attachmentAO = SpringContextHolder
        .getBean(IAttachmentAO.class);

    private XN623546Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return attachmentAO.getAttachment(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623546Req.class);
        ObjValidater.validateReq(req);
    }

}
