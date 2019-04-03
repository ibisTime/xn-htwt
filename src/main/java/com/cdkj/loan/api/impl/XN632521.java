package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizTaskAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632521Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 处理待办事项
 * @author: silver 
 * @since: Apr 3, 2019 2:05:35 PM 
 * @history:
 */
public class XN632521 extends AProcessor {
    private IBizTaskAO bizTaskAO = SpringContextHolder
        .getBean(IBizTaskAO.class);

    private XN632521Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bizTaskAO.handleBizTask(req.getCode(), req.getOperator());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632521Req.class);
        ObjValidater.validateReq(req);
    }

}
