package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILimuCreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632949Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 立木征信详情查
 * @author: CYL 
 * @since: 2018年10月12日 下午4:41:52 
 * @history:
 */
public class XN632949 extends AProcessor {
    private ILimuCreditAO limuCreditAO = SpringContextHolder
        .getBean(ILimuCreditAO.class);

    private XN632949Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return limuCreditAO.getLimuCreditByType(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632949Req.class);
        ObjValidater.validateReq(req);
    }

}
