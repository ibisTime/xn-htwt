package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IAddressAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Address;
import com.cdkj.loan.dto.req.XN805165Req;
import com.cdkj.loan.dto.req.XN805167Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 收件地址查询
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:48:10 
 * @history:
 */
public class XN805167 extends AProcessor {
    private IAddressAO addressAO = SpringContextHolder
        .getBean(IAddressAO.class);

    private XN805167Req req = null;

    /** 
     * @see com.xnjr.cpzc.service.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Address condition = new Address();
        condition.setUserId(req.getUserId());
        condition.setIsDefault(req.getIsDefault());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return addressAO.queryAddressPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.cpzc.service.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805167Req.class);
        ObjValidater.validateReq(req);
    }
}
