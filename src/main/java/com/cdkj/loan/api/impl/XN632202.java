package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInvestigateReportAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632202Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 驻行人员审核
 * @author: CYL 
 * @since: 2018年7月5日 下午6:47:35 
 * @history:
 */
public class XN632202 extends AProcessor {
    private IInvestigateReportAO investigateReportAO = SpringContextHolder
        .getBean(IInvestigateReportAO.class);

    private XN632202Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        investigateReportAO.approveByBankCheck(req.getCode(),
            req.getApproveResult(), req.getApproveNote(), req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632202Req.class);
        ObjValidater.validateReq(req);
    }

}
