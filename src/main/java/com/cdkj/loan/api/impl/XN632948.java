package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILimuCreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN632948Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 立木征信详情查
 * @author: CYL 
 * @since: 2018年10月12日 下午4:41:52 
 * @history:
 */
public class XN632948 extends AProcessor {
    private ILimuCreditAO limuCreditAO = SpringContextHolder
        .getBean(ILimuCreditAO.class);

    private XN632948Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return limuCreditAO
            .getLimuCredit(StringValidater.toInteger(req.getId()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632948Req.class);
        ObjValidater.validateReq(req);
    }

}
