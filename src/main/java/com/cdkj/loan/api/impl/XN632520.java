package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizTaskAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632520Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 添加待办事项
 * @author: silver 
 * @since: Apr 3, 2019 2:05:35 PM 
 * @history:
 */
public class XN632520 extends AProcessor {
    private IBizTaskAO bizTaskAO = SpringContextHolder
        .getBean(IBizTaskAO.class);

    private XN632520Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(bizTaskAO.addBizTask(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632520Req.class);
        ObjValidater.validateReq(req);
    }

}
