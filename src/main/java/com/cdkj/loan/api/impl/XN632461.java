package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAdvanceAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632461Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 区域总经理审核
 * @author: silver 
 * @since: Apr 26, 2019 11:07:56 AM 
 * @history:
 */
public class XN632461 extends AProcessor {

    private IAdvanceAO advanceAO = SpringContextHolder
        .getBean(IAdvanceAO.class);

    private XN632461Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        advanceAO.areaManageApprove(req.getCode(), req.getOperator(),
            req.getApproveNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632461Req.class);
        ObjValidater.validateReq(req);

    }

}
