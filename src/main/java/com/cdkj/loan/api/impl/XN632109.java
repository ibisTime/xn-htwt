package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632109Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 主贷人和配偶一键互换
 * @author: CYL 
 * @since: 2018年11月6日 上午11:11:27 
 * @history:
 */
public class XN632109 extends AProcessor {

    private ICreditUserAO ICreditUserBO = SpringContextHolder
        .getBean(ICreditUserAO.class);

    private XN632109Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return ICreditUserBO.changeLender(req.getSelfCode(), req.getWifeCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632109Req.class);
        ObjValidater.validateReq(req);

    }

}
