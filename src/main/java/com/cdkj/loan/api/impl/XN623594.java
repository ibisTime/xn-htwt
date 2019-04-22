package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMissionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN623594Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查资源
 * @author: silver 
 * @since: Apr 2, 2019 5:44:17 PM 
 * @history:
 */
public class XN623594 extends AProcessor {
    private IMissionAO missionAO = SpringContextHolder
        .getBean(IMissionAO.class);

    private XN623594Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        missionAO.finish(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623594Req.class);
        ObjValidater.validateReq(req);
    }

}
