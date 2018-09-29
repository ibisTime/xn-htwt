package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632702Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改gps
 * @author: CYL 
 * @since: 2018年9月29日 下午7:29:14 
 * @history:
 */
public class XN632702 extends AProcessor {
    private IGpsAO gpsAO = SpringContextHolder.getBean(IGpsAO.class);

    private XN632702Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gpsAO.editGps(req.getCode(), req.getGpsDevNo(), req.getGpsType());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632702Req.class);
        ObjValidater.validateReq(req);
    }

}
