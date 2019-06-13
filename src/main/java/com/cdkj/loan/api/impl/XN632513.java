package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632512Req;
import com.cdkj.loan.dto.req.XN632513Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 工行制卡
 *
 * @author: taojian
 * @since: 2019年4月2日 下午7:47:52
 * @history:
 */
public class XN632513 extends AProcessor {

    private ICdbizAO cdbizAO = SpringContextHolder.getBean(ICdbizAO.class);

    private XN632513Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        cdbizAO.editRemark(req.getCode(),req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632513Req.class);
        ObjValidater.validateReq(req);
    }
}
