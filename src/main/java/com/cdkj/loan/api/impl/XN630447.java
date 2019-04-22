package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarconfigAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Carconfig;
import com.cdkj.loan.dto.req.XN630447Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查配置
 * @author: taojian 
 * @since: 2019年3月12日 下午5:16:43 
 * @history:
 */
public class XN630447 extends AProcessor {
    private ICarconfigAO carconfigAO = SpringContextHolder
        .getBean(ICarconfigAO.class);

    private XN630447Req req;

    @Override
    public Object doBusiness() throws BizException {
        Carconfig condition = new Carconfig();
        condition.setName(req.getName());
        return carconfigAO.queryCarconfigList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630447Req.class);
        ObjValidater.validateReq(req);
    }

}
