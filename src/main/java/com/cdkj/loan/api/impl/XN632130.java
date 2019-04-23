package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankLoanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632130Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单-确认收款
 * @author: CYL 
 * @since: 2018年5月31日 上午2:19:08 
 * @history:
 */
public class XN632130 extends AProcessor {
    private IBankLoanAO bankLoanAO = SpringContextHolder
        .getBean(IBankLoanAO.class);

    private XN632130Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankLoanAO.confirmSk(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632130Req.class);
        ObjValidater.validateReq(req);
    }

}
