package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMissionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN623593Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 任务作废
 *
 * @author: silver
 * @since: Apr 2, 2019 5:44:17 PM
 * @history:
 */
public class XN623593 extends AProcessor {

    private IMissionAO missionAO = SpringContextHolder
            .getBean(IMissionAO.class);

    private XN623593Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        missionAO.valid(req.getCode());

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623593Req.class);
        ObjValidater.validateReq(req);
    }

}
