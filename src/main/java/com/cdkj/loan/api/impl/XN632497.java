package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CreditJour;
import com.cdkj.loan.dto.req.XN632497Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 列表查征信流水
 *
 * @author: silver
 * @since: Apr 20, 2019 3:59:31 PM
 * @history:
 */
public class XN632497 extends AProcessor {

    private ICreditJourAO creditJourAO = SpringContextHolder
            .getBean(ICreditJourAO.class);

    private XN632497Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditJour condition = new CreditJour();
        EntityUtils.copyData(req, condition);

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        return creditJourAO.queryCreditJourList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632497Req.class);
        ObjValidater.validateReq(req);
    }

}
