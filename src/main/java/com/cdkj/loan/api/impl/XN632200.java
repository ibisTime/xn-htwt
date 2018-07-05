package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInvestigateReportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632200Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 申请调查报告
 * @author: CYL 
 * @since: 2018年7月5日 下午6:00:56 
 * @history:
 */
public class XN632200 extends AProcessor {
    private IInvestigateReportAO investigateReportAO = SpringContextHolder
        .getBean(IInvestigateReportAO.class);

    private XN632200Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        investigateReportAO.approveInvestigateReport(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632200Req.class);
        ObjValidater.validateReq(req);
    }

}
