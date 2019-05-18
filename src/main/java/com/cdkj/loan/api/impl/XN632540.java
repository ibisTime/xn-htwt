package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632540Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 总公司审核
 * @author: taojian 
 * @since: 2019年5月18日 下午3:52:04 
 * @history:
 */
public class XN632540 extends AProcessor {
    private ICarInfoAO carInfoAO = SpringContextHolder
        .getBean(ICarInfoAO.class);

    private XN632540Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carInfoAO.headCompanyApprove(req.getCode(), req.getApproveResult(),
            req.getApproveNote(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632540Req.class);
        ObjValidater.validateReq(req);
    }

}
