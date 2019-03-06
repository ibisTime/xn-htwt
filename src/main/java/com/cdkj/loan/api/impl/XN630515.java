package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepayBizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630515Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 提前还款申请
 * @author: CYL 
 * @since: 2018年5月8日 上午10:32:21 
 * @history:
 */
public class XN630515 extends AProcessor {
    private IRepayBizAO repayBizBO = SpringContextHolder
        .getBean(IRepayBizAO.class);

    private XN630515Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayBizBO.prepaymentApply(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630515Req.class);
        ObjValidater.validateReq(req);
    }

}
