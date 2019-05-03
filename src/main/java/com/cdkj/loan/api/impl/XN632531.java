package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632531Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改入准入单-车辆信息
 *
 * @author : cyl
 * @since : 2019-05-02 21:38
 */
public class XN632531 extends AProcessor {

    private ICarInfoAO carInfoAO = SpringContextHolder
            .getBean(ICarInfoAO.class);

    private XN632531Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carInfoAO.inputCarInfo(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632531Req.class);
        ObjValidater.validateReq(req);
    }

}
