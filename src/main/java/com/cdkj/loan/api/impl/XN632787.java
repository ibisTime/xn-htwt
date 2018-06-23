package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBusAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Bus;
import com.cdkj.loan.dto.req.XN632787Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 公车列表查
 * @author: CYL 
 * @since: 2018年6月23日 下午12:12:28 
 * @history:
 */
public class XN632787 extends AProcessor {
    private IBusAO busAO = SpringContextHolder.getBean(IBusAO.class);

    private XN632787Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Bus condition = new Bus();
        condition.setStatus(req.getStatus());

        return busAO.queryBusList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632787Req.class);
        ObjValidater.validateReq(req);
    }

}
