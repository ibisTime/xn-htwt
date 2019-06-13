package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarPledgeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632144Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 驻行抵押申请
 * @author: CYL 
 * @since: 2018年11月7日 上午11:52:23 
 * @history:
 */
public class XN632144 extends AProcessor {

    private ICarPledgeAO carPledgeAO = SpringContextHolder
        .getBean(ICarPledgeAO.class);

    private XN632144Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carPledgeAO.pledgeApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632144Req.class);
        ObjValidater.validateReq(req);

    }

}
