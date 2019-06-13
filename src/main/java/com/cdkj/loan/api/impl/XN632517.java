package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632517Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查业务
 *
 * @author: taojian
 * @since: 2019年4月2日 下午7:47:52
 * @history:
 */
public class XN632517 extends AProcessor {

    private ICdbizAO cdbizAO = SpringContextHolder.getBean(ICdbizAO.class);

    private XN632517Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Cdbiz condition = new Cdbiz();
        condition.setBizType(req.getBizType());
        condition.setBizCode(req.getBizCode());
        condition.setLoanBank(req.getBankCode());
        condition.setStatus(req.getStatus());
        condition.setIntevStatus(req.getMqStatus());
        condition.setFbhgpsStatus(req.getFbhgpsStatus());
        condition.setEnterStatus(req.getEnterStatus());
        condition.setCancelStatus(req.getCancelStatus());
        condition.setSaleUserId(req.getYwyUser());
        condition.setTeamCode(req.getTeamCode());
        return cdbizAO.queryCdbizList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632517Req.class);
        ObjValidater.validateReq(req);
    }
}
