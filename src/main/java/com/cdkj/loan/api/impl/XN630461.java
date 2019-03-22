package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IActionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630461Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 删除用户行为
 * @author: taojian 
 * @since: 2019年3月13日 下午2:15:08 
 * @history:
 */
public class XN630461 extends AProcessor {

    private IActionAO actionAO = SpringContextHolder.getBean(IActionAO.class);

    private XN630461Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        for (String code : req.getCodeList()) {
            actionAO.dropAction(code);
        }

        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630461Req.class);
        ObjValidater.validateReq(req);
    }

}
