package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBudgetOrderAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BudgetOrder;
import com.cdkj.loan.dto.req.XN632148Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单按角色分页查询
 * @author: CYL 
 * @since: 2018年5月24日 下午2:23:15 
 * @history:
 */
public class XN632148 extends AProcessor {
    private IBudgetOrderAO budgetOrderAO = SpringContextHolder
        .getBean(IBudgetOrderAO.class);

    private XN632148Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BudgetOrder condition = new BudgetOrder();
        condition.setCode(req.getCode());
        condition.setRepayBizCodeForQuery(req.getRepayBizCode());
        condition.setSaleUserId(req.getSaleUserId());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setApplyUserNameForQuery(req.getApplyUserName());
        condition.setEnterLocation(req.getEnterLocation());
        condition.setKeyword(req.getKeyword());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        if (StringUtils.isNotBlank(req.getCurNodeCode())) {
            boolean b = req.getCurNodeCodeList().contains(req.getCurNodeCode());
            if (b == false) {
                condition.setCurNodeCode("000_00");// 意为空
            } else {
                condition.setCurNodeCode(req.getCurNodeCode());
            }
        } else {
            condition.setCurNodeCodeList(req.getCurNodeCodeList());
        }
        if (StringUtils.isNotBlank(req.getIntevCurNodeCode())) {
            boolean b = req.getIntevCurNodeCodeList()
                .contains(req.getIntevCurNodeCode());
            if (b == false) {
                condition.setIntevCurNodeCode("000_00");// 意为空
            } else {
                condition.setIntevCurNodeCode(req.getIntevCurNodeCode());
            }
        } else {
            condition.setIntevCurNodeCodeList(req.getIntevCurNodeCodeList());
        }
        if (StringUtils.isNotBlank(req.getAdvanfCurNodeCode())) {
            boolean b = req.getAdvanfCurNodeCodeList()
                .contains(req.getAdvanfCurNodeCode());
            if (b == false) {
                condition.setAdvanfCurNodeCode("000_00");// 意为空
            } else {
                condition.setAdvanfCurNodeCode(req.getAdvanfCurNodeCode());
            }
        } else {
            condition.setAdvanfCurNodeCodeList(req.getAdvanfCurNodeCodeList());
        }
        condition.setRoleCode(req.getRoleCode());
        condition.setIsInterview(req.getIsInterview());
        condition.setIsEntryMortgage(req.getIsEntryMortgage());
        condition.setIsAdvanceFund(req.getIsAdvanceFund());
        condition.setIsMortgage(req.getIsMortgage());
        condition.setIsGpsAz(req.getIsGpsAz());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBudgetOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return budgetOrderAO.queryBudgetOrderPageByRoleCode(start, limit,
            condition, req.getUserId());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632148Req.class);
        ObjValidater.validateReq(req);
    }

}
