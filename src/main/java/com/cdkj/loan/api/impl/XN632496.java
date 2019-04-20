package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditJourAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632496Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查征信流水
 * @author: silver 
 * @since: Apr 20, 2019 3:59:31 PM 
 * @history:
 */
public class XN632496 extends AProcessor {
    private ICreditJourAO creditJourAO = SpringContextHolder
        .getBean(ICreditJourAO.class);

    private XN632496Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return creditJourAO.getCreditJour(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632496Req.class);
        ObjValidater.validateReq(req);
    }

}
