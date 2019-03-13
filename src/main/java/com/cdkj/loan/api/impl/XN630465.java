package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IActionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Action;
import com.cdkj.loan.dto.req.XN630465Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增用户行为
 * @author: taojian 
 * @since: 2019年3月13日 下午2:15:08 
 * @history:
 */
public class XN630465 extends AProcessor {

    private IActionAO actionAO = SpringContextHolder.getBean(IActionAO.class);

    private XN630465Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Action condition = new Action();
        condition.setType(req.getType());
        condition.setToCode(req.getToCode());
        condition.setToType(req.getToType());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return actionAO.queryActionPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630465Req.class);
        ObjValidater.validateReq(req);

    }

}
