package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBusinessTripApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632692Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 出差申请财务主管审核
 * @author: jiafr 
 * @since: 2018年6月23日 下午4:29:19 
 * @history:
 */
public class XN632692 extends AProcessor {
    private IBusinessTripApplyAO businessTripApplyAO = SpringContextHolder
        .getBean(IBusinessTripApplyAO.class);

    private XN632692Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        businessTripApplyAO.financeAudit(req.getCode(), req.getOperator(),
            req.getApproveResult(), req.getApproveNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632692Req.class);
        ObjValidater.validateReq(req);
    }

}
