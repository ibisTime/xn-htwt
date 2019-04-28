package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632460Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 确认用款单
 * @author: silver 
 * @since: Apr 26, 2019 11:07:56 AM 
 * @history:
 */
public class XN632460 extends AProcessor {

    private IAdvanceAO advanceAO = SpringContextHolder
        .getBean(IAdvanceAO.class);

    private XN632460Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        advanceAO.confirmApply(req.getCode(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632460Req.class);
        ObjValidater.validateReq(req);

    }

}
