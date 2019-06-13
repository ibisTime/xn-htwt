package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarPledgeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632539Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改入准入单-抵押信息
 *
 * @author : cyl
 * @since : 2019-05-02 21:38
 */
public class XN632539 extends AProcessor {

    private ICarPledgeAO carPledgeAO = SpringContextHolder
            .getBean(ICarPledgeAO.class);

    private XN632539Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carPledgeAO.inputPledgeInfo(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632539Req.class);
        ObjValidater.validateReq(req);
    }

}
