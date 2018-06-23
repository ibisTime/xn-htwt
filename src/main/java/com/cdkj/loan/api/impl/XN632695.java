package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBusinessTripApplyAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BusinessTripApply;
import com.cdkj.loan.dto.req.XN632695Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 
 * @author: jiafr 
 * @since: 2018年6月23日 下午5:05:18 
 * @history:
 */
public class XN632695 extends AProcessor {

    private IBusinessTripApplyAO businessTripApplyAO = SpringContextHolder
        .getBean(IBusinessTripApplyAO.class);

    private XN632695Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BusinessTripApply condition = new BusinessTripApply();
        condition.setApplyUserCode(req.getApplyUserCode());
        condition.setJobNo(req.getJobNo());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setRoleCode(req.getRoleCode());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IBusinessTripApplyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return businessTripApplyAO.queryBusinessTripApplyPageByRoleCode(start,
            limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632695Req.class);
        ObjValidater.validateReq(req);
    }
}
