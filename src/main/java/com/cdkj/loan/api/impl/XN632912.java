package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN632912Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 代办事项APP
 * @author: jiafr 
 * @since: 2018年8月29日 上午11:48:47 
 * @history:
 */
public class XN632912 extends AProcessor {
    private ISYSBizLogAO sysBizLogAO = SpringContextHolder
        .getBean(ISYSBizLogAO.class);

    private XN632912Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSBizLog condition = new SYSBizLog();
        condition.setRoleCode(req.getRoleCode());
        return sysBizLogAO.todoListAPP(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632912Req.class);
        ObjValidater.validateReq(req);
    }

}
