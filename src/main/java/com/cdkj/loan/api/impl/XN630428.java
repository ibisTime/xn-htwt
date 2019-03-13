package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630428Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 车贷计算器
 * @author: CYL 
 * @since: 2018年4月23日 下午4:26:43 
 * @history:
 */

public class XN630428 extends AProcessor {

    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN630428Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return carAO.calculate(req.getCarCode(), req.getPeriod(),
            req.getIsTotal());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630428Req.class);
        ObjValidater.validateReq(req);
    }

}
