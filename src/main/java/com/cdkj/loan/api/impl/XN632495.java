package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.dto.req.XN632495Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查征信流水
 *
 * @author: silver
 * @since: Apr 20, 2019 3:59:31 PM
 * @history:
 */
public class XN632495 extends AProcessor {

    private ICreditJourAO creditJourAO = SpringContextHolder
            .getBean(ICreditJourAO.class);

    private XN632495Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditJour condition = new CreditJour();
        EntityUtils.copyData(req, condition);

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return creditJourAO.queryCreditJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632495Req.class);
        ObjValidater.validateReq(req);
    }

}
