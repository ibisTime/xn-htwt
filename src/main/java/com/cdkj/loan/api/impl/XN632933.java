package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMobileReportDemoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632933Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 运营商归属地查询
 * @author: CYL 
 * @since: 2018年10月9日 下午5:05:01 
 * @history:
 */
public class XN632933 extends AProcessor {
    private IMobileReportDemoAO mobileReportDemoAO = SpringContextHolder
        .getBean(IMobileReportDemoAO.class);

    private XN632933Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return mobileReportDemoAO.mobileLocation(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632933Req.class);
        ObjValidater.validateReq(req);
    }
}
