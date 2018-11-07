package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632149Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 驻行人员审核抵押材料
 * @author: CYL 
 * @since: 2018年11月7日 上午11:52:23 
 * @history:
 */
public class XN632149 extends AProcessor {

    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632149Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        budgetOrderAO.mortgageCommitbank(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632149Req.class);
        ObjValidater.validateReq(req);

    }

}
