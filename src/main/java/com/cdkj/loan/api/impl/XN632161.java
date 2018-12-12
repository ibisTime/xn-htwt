package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632161Req;
import com.cdkj.loan.enums.ESysRole;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据角色查预算单客户
 * @author: CYL 
 * @since: 2018年12月12日 下午9:23:03 
 * @history:
 */
public class XN632161 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632161Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        if (ESysRole.YWNQ.getCode().equals(req.getRoleCode())) {
            condition.setInsideJob(req.getUserId());
        } else if (ESysRole.SALE.getCode().equals(req.getRoleCode())) {
            condition.setSaleUserId(req.getUserId());
        }
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return budgetOrderAO.queryBudgetOrderPageByUserId(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632161Req.class);
        ObjValidater.validateReq(req);
    }

}
