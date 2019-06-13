package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632490Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增征信流水
 * @author: silver 
 * @since: Apr 20, 2019 3:59:31 PM 
 * @history:
 */
public class XN632490 extends AProcessor {
    private ICreditJourAO creditJourAO = SpringContextHolder
        .getBean(ICreditJourAO.class);

    private XN632490Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditJourAO.addCreditJour(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632490Req.class);
        ObjValidater.validateReq(req);
    }

}
