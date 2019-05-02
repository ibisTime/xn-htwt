package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632533Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 家庭情况
 *
 * @author : cyl
 * @since : 2019-05-02 21:38
 */
public class XN632533 extends AProcessor {

    private ICreditUserAO creditUserAO = SpringContextHolder.getBean(ICreditUserAO.class);

    private XN632533Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditUserAO.saveSelfHomeInfo(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632533Req.class);
        ObjValidater.validateReq(req);
    }
}
