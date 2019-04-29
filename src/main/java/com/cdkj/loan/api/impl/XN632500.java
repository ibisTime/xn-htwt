package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632500Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 准入单-修改准入单
 * @author: xieyj 
 * @since: 2018年5月26日 下午10:49:49 
 * @history:
 */
public class XN632500 extends AProcessor {
    private ICarInfoAO carInfoAO = SpringContextHolder
        .getBean(ICarInfoAO.class);

    private XN632500Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carInfoAO.inputBudgetOrder(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632500Req.class);
        ObjValidater.validateReq(req);
    }

}
