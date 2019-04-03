package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN623536Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详细查操作日志
 * @author: silver 
 * @since: Apr 2, 2019 5:44:17 PM 
 * @history:
 */
public class XN623536 extends AProcessor {
    private IBizLogAO bizLogAO = SpringContextHolder.getBean(IBizLogAO.class);

    private XN623536Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return bizLogAO.getBizLog(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623536Req.class);
        ObjValidater.validateReq(req);
    }

}
