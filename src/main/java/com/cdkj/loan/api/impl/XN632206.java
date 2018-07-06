package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInvestigateReportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632206Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 调查报告详情查
 * @author: CYL 
 * @since: 2018年7月5日 下午9:15:03 
 * @history:
 */
public class XN632206 extends AProcessor {
    private IInvestigateReportAO investigateReportAO = SpringContextHolder
        .getBean(IInvestigateReportAO.class);

    private XN632206Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return investigateReportAO.getInvestigateReport(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632206Req.class);
        ObjValidater.validateReq(req);
    }

}
