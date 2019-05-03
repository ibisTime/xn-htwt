package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632538Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单准入申请提交
 *
 * @author : haiqingzheng
 * @since : 2019-05-03 19:57
 */
public class XN632538 extends AProcessor {

    private ICarInfoAO carInfoAO = SpringContextHolder.getBean(ICarInfoAO.class);

    private XN632538Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632538Req.class);
        ObjValidater.validateReq(req);
    }
}
