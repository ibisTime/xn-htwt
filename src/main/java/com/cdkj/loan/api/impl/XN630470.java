package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICityListAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630470Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 城市列表刷新
 *
 * @author: CYL
 * @since: 2018年11月15日 下午6:56:58
 * @history:
 */
public class XN630470 extends AProcessor {

    private ICityListAO cityListAO = SpringContextHolder
            .getBean(ICityListAO.class);

    private XN630470Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        cityListAO.refreshCityList(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630470Req.class);
        ObjValidater.validateReq(req);
    }

}
