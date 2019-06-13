package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarDealerAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632061Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除经销商管理
 * @author: CYL
 * @since: 2018年5月25日 下午4:34:56 
 * @history:
 */
public class XN632061 extends AProcessor {
    private ICarDealerAO carDealerAO = SpringContextHolder
        .getBean(ICarDealerAO.class);

    private XN632061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carDealerAO.dropCarDealer(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632061Req.class);
        req.setUpdater(operator);
        ObjValidater.validateReq(req);
    }
}
