package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.dto.req.XN632917Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 内勤主管分配情况
 * @author: CYL 
 * @since: 2018年12月11日 上午11:41:29 
 * @history:
 */
public class XN632917 extends AProcessor {

    private ICreditAO creditAO = SpringContextHolder.getBean(ICreditAO.class);

    private XN632917Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Credit condition = new Credit();
        condition.setUserName(req.getUserName());
        condition.setInsideJob(req.getInsideJob());
        return creditAO.queryCreditListByJob(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632917Req.class);
        ObjValidater.validateReq(req);
    }
}
