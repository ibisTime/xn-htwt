package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632140Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 准入单区域经理审核
 * @author: jiafr 
 * @since: 2018年7月4日 下午3:56:39 
 * @history:
 */
public class XN632140 extends AProcessor {
    private ICarInfoAO carInfoAO = SpringContextHolder
        .getBean(ICarInfoAO.class);

    private XN632140Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carInfoAO.areaApprove(req.getCode(), req.getApproveResult(),
            req.getApproveNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632140Req.class);
        ObjValidater.validateReq(req);
    }

}
