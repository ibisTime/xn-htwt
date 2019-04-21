package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserExtAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632482Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改征信人辅助资料
 * @author: silver 
 * @since: Apr 20, 2019 3:59:31 PM 
 * @history:
 */
public class XN632482 extends AProcessor {
    private ICreditUserExtAO creditUserExtAO = SpringContextHolder
        .getBean(ICreditUserExtAO.class);

    private XN632482Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        creditUserExtAO.editCreditUserExt(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632482Req.class);
        ObjValidater.validateReq(req);
    }

}
