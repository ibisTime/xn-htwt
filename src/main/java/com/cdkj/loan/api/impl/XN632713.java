package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632713Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * GPS重新申领
 * @author: CYL 
 * @since: 2018年11月2日 上午10:22:17 
 * @history:
 */
public class XN632713 extends AProcessor {
    private IGpsApplyAO gpsApplyAO = SpringContextHolder
        .getBean(IGpsApplyAO.class);

    private XN632713Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gpsApplyAO.againGpsApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632713Req.class);
        ObjValidater.validateReq(req);
    }
}
