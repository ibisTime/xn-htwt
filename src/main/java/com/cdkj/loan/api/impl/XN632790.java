package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBusBorrowAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632790Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 公车使用申请
 * @author: CYL 
 * @since: 2018年6月23日 下午2:50:36 
 * @history:
 */
public class XN632790 extends AProcessor {
    private IBusBorrowAO busBorrowAO = SpringContextHolder
        .getBean(IBusBorrowAO.class);

    private XN632790Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return new PKCodeRes(busBorrowAO.addBusBorrow(req));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632790Req.class);
        ObjValidater.validateReq(req);
    }

}
