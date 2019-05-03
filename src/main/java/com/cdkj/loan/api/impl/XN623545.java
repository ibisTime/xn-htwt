package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAttachmentAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Attachment;
import com.cdkj.loan.dto.req.XN623545Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查附件
 *
 * @author: silver
 * @since: Apr 2, 2019 5:44:17 PM
 * @history:
 */
public class XN623545 extends AProcessor {

    private IAttachmentAO attachmentAO = SpringContextHolder
            .getBean(IAttachmentAO.class);

    private XN623545Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Attachment condition = new Attachment();
        EntityUtils.copyData(req, condition);

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IAttachmentAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return attachmentAO.queryAttachmentPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623545Req.class);
        ObjValidater.validateReq(req);
    }

}
