package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632516Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查业务
 * @author: taojian 
 * @since: 2019年4月2日 下午7:47:52 
 * @history:
 */
public class XN632516 extends AProcessor {
    private ICdbizAO cdbizAO = SpringContextHolder.getBean(ICdbizAO.class);

    private XN632516Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return cdbizAO.getCdbiz(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632516Req.class);
        ObjValidater.validateReq(req);
    }
}
