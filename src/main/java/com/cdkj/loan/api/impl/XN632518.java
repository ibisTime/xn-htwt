package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditUser;
import com.cdkj.loan.dto.req.XN632518Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查工行征信业务
 * @author: taojian 
 * @since: 2019年4月2日 下午7:47:52 
 * @history:
 */
public class XN632518 extends AProcessor {
    private ICreditUserAO creditUserAO = SpringContextHolder
        .getBean(ICreditUserAO.class);

    private XN632518Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditUser condition = new CreditUser();
        condition.setBizCode(req.getBizCode());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return creditUserAO.queryCreditUserPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632518Req.class);
        ObjValidater.validateReq(req);
    }
}
