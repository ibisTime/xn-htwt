package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632121Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 风控一审
 * @author: CYL 
 * @since: 2018年5月30日 上午1:04:02 
 * @history:
 */
public class XN632121 extends AProcessor {
    private ICarInfoAO carInfoAO = SpringContextHolder
        .getBean(ICarInfoAO.class);

    private XN632121Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carInfoAO.riskOneApprove(req.getCode(), req.getApproveResult(),
            req.getApproveNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632121Req.class);
        ObjValidater.validateReq(req);
    }

}
