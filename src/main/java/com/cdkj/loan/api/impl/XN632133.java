package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarPledgeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 录入抵押信息
 * @author: CYL 
 * @since: 2018年5月31日 上午3:35:03 
 * @history:
 */
public class XN632133 extends AProcessor {
    private ICarPledgeAO carPledgeAO = SpringContextHolder
        .getBean(ICarPledgeAO.class);

    private XN632133Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carPledgeAO.entryPledgeInfo(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632133Req.class);
        ObjValidater.validateReq(req);
    }

}
