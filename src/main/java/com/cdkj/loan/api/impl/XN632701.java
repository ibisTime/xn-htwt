package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IGpsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632701Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * gps批量导入
 * @author: CYL 
 * @since: 2018年9月27日 下午9:49:57 
 * @history:
 */
public class XN632701 extends AProcessor {
    private IGpsAO gpsAO = SpringContextHolder.getBean(IGpsAO.class);

    private XN632701Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gpsAO.addGpsList(req.getGpsList());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632701Req.class);
        ObjValidater.validateReq(req);
    }

}
