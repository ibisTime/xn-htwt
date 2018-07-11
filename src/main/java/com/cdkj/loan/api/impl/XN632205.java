package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IInvestigateReportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InvestigateReport;
import com.cdkj.loan.dto.req.XN632205Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 调查报告分页查
 * @author: CYL 
 * @since: 2018年7月5日 下午9:15:32 
 * @history:
 */
public class XN632205 extends AProcessor {
    private IInvestigateReportAO investigateReportAO = SpringContextHolder
        .getBean(IInvestigateReportAO.class);

    private XN632205Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InvestigateReport condition = new InvestigateReport();
        condition.setCode(req.getCode());
        condition.setRepayBizCode(req.getRepayBizCode());
        condition.setApplyUserName(req.getApplyUserName());
        condition.setIsAdvanceFund(req.getIsAdvanceFund());
        condition.setApplyDatetimeStart(DateUtil.strToDate(
            req.getApplyDatetimeStart(), DateUtil.FRONT_DATE_FORMAT_STRING));
        condition.setApplyDatetimeEnd(DateUtil.strToDate(
            req.getApplyDatetimeEnd(), DateUtil.FRONT_DATE_FORMAT_STRING));

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IInvestigateReportAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return investigateReportAO.queryInvestigateReportPage(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632205Req.class);
        ObjValidater.validateReq(req);
    }

}
