package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632535Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 准入单-共同还款人
 *
 * @author : cyl
 * @since : 2019-05-02 21:38
 */
public class XN632535 extends AProcessor {

    private ICreditUserAO creditUserAO = SpringContextHolder.getBean(ICreditUserAO.class);

    private XN632535Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditUserAO.saveGhrInfo(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632535Req.class);
        ObjValidater.validateReq(req);
    }
}
