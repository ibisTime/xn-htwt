package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632910Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 统计分析，垫资超过1天未放款客户
 * @author: CYL 
 * @since: 2018年6月12日 上午3:03:03 
 * @history:
 */
public class XN632910 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632910Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setCodeQuery(req.getBudgetCode());
        condition.setApplyUserName(req.getApplyUserName());
        condition.setLoanBank(req.getLoanBank());

        return budgetOrderAO.queryBudgetOrderPageByDz(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632910Req.class);
        ObjValidater.validateReq(req);
    }

}
