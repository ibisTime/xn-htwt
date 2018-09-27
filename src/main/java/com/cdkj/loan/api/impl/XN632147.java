package com.cdkj.loan.api.impl;

import java.util.List;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632147Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据客户姓名查询预算单
 * @author: CYL 
 * @since: 2018年5月30日 下午10:08:03 
 * @history:
 */
public class XN632147 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632147Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setApplyUserName(req.getApplyUserName());
        List<BudgetOrder> budgetOrders = budgetOrderAO
            .queryBudgetOrderByApplyUserName(condition);
        BudgetOrder budgetOrder = budgetOrders.get(0);
        return budgetOrder;
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632147Req.class);
        ObjValidater.validateReq(req);
    }

}
