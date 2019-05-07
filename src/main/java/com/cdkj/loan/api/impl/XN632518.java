package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632518Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查工行征信业务
 * @author: taojian 
 * @since: 2019年4月2日 下午7:47:52 
 * @history:
 */
public class XN632518 extends AProcessor {
    private ICdbizAO cdbizAO = SpringContextHolder.getBean(ICdbizAO.class);

    private XN632518Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return cdbizAO.queryIcbankCdbiz(start, limit, req.getUserId());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632518Req.class);
        ObjValidater.validateReq(req);
    }
}
