package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632139Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 业务总监审核
 * @author: CYL 
 * @since: 2018年5月30日 下午2:00:57 
 * @history:
 */
public class XN632139 extends AProcessor {
    private ICarInfoAO carInfoAO = SpringContextHolder
        .getBean(ICarInfoAO.class);

    private XN632139Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carInfoAO.yBizChargeApprove(req.getCode(), req.getOperator(),
            req.getApproveResult(), req.getApproveNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632139Req.class);
        ObjValidater.validateReq(req);
    }

}
