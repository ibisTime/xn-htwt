package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632916Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 团队报表
 * @author: jiafr 
 * @since: 2018年7月11日 下午2:01:04 
 * @history:
 */
public class XN632916 extends AProcessor {

    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632916Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setApplyUserNameForQuery(req.getApplyUserName());
        condition.setBizType(req.getBizType());
        condition.setLoanPeriod(req.getLoanPeriod());
        condition.setTeamCode(req.getTeamCode());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return budgetOrderAO.queryBudgetOrderPageByTeamCode(start, limit,
            condition, req.getUserId());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632916Req.class);
        ObjValidater.validateReq(req);
    }
}
