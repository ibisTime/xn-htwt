package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBankLoanAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632129Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 预算单-确认提交银行
 * @author: CYL 
 * @since: 2018年5月30日 下午2:40:12 
 * @history:
 */
public class XN632129 extends AProcessor {
    private IBankLoanAO bankLoanAO = SpringContextHolder
        .getBean(IBankLoanAO.class);

    private XN632129Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bankLoanAO.commitBank(req.getCode(), req.getOperator(),
            req.getBankCommitDatetime(), req.getBankCommitNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632129Req.class);
        ObjValidater.validateReq(req);
    }

}
