package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632137Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面签内勤主管审核
 * @author: CYL 
 * @since: 2018年8月21日 上午10:45:12 
 * @history:
 */
public class XN632137 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632137Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.interviewInternalApprove(req.getCode(), req.getOperator(),
            req.getApproveResult(), req.getApproveNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632137Req.class);
        ObjValidater.validateReq(req);
    }

}
