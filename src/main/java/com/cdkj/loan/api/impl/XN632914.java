package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632914Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 贷后统计
 * @author: jiafr 
 * @since: 2018年7月11日 下午8:14:40 
 * @history:
 */
public class XN632914 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632914Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return budgetOrderAO.queryBudgetOrderPageForLoanLater(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632914Req.class);
        ObjValidater.validateReq(req);
    }

}
