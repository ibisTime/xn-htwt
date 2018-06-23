package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBusinessTripApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632696Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查询出差申请
 * @author: jiafr 
 * @since: 2018年6月23日 下午5:29:56 
 * @history:
 */
public class XN632696 extends AProcessor {
    private IBusinessTripApplyAO businessTripApplyAO = SpringContextHolder
        .getBean(IBusinessTripApplyAO.class);

    private XN632696Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return businessTripApplyAO.getBusinessTripApply(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632696Req.class);
        ObjValidater.validateReq(req);
    }

}
