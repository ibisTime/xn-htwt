package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IFilePoolAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN623596Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查资源
 * @author: silver 
 * @since: Apr 2, 2019 5:44:17 PM 
 * @history:
 */
public class XN623596 extends AProcessor {
    private IFilePoolAO filePoolAO = SpringContextHolder
        .getBean(IFilePoolAO.class);

    private XN623596Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return filePoolAO.getFilePool(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623596Req.class);
        ObjValidater.validateReq(req);
    }

}
