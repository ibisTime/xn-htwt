package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632123Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面签
 * @author: CYL 
 * @since: 2018年5月30日 下午2:00:57 
 * @history:
 */
public class XN632123 extends AProcessor {
    private ICdbizAO cdbizAO = SpringContextHolder.getBean(ICdbizAO.class);

    private XN632123Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        cdbizAO.interview(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632123Req.class);
        ObjValidater.validateReq(req);
    }

}
