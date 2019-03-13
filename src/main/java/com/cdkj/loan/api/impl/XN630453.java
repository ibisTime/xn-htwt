package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarNewsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630453Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 上架资讯
 * @author: taojian 
 * @since: 2019年3月13日 下午2:15:08 
 * @history:
 */
public class XN630453 extends AProcessor {

    private ICarNewsAO carNewsAO = SpringContextHolder
        .getBean(ICarNewsAO.class);

    private XN630453Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carNewsAO.putOn(req.getCode(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630453Req.class);
        ObjValidater.validateReq(req);

    }

}
