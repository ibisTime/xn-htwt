package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBusinessTripApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632690Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 出差申请新增
 * @author: jiafr 
 * @since: 2018年6月23日 下午3:10:31 
 * @history:
 */
public class XN632690 extends AProcessor {
    private IBusinessTripApplyAO businessTripApplyAO = SpringContextHolder
        .getBean(IBusinessTripApplyAO.class);

    private XN632690Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return new PKCodeRes(businessTripApplyAO.addBusinessTripApply(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632690Req.class);
        ObjValidater.validateReq(req);
    }

}
