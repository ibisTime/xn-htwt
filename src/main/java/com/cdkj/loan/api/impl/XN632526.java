package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizTaskAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632526Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查待办事项
 * @author: silver 
 * @since: Apr 3, 2019 2:05:35 PM 
 * @history:
 */
public class XN632526 extends AProcessor {
    private IBizTaskAO bizTaskAO = SpringContextHolder
        .getBean(IBizTaskAO.class);

    private XN632526Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bizTaskAO.getBizTask(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632526Req.class);
        ObjValidater.validateReq(req);
    }

}
