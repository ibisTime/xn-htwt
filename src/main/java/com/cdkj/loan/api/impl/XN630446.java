package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarconfigAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630446Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查配置
 * @author: taojian 
 * @since: 2019年3月12日 下午5:16:43 
 * @history:
 */
public class XN630446 extends AProcessor {
    private ICarconfigAO carconfigAO = SpringContextHolder
        .getBean(ICarconfigAO.class);

    private XN630446Req req;

    @Override
    public Object doBusiness() throws BizException {

        return carconfigAO.getCarconfig(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630446Req.class);
        ObjValidater.validateReq(req);
    }

}
