package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMissionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN623590Req;
import com.cdkj.loan.dto.res.PKCodeRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 新增任务
 * @author: taojian 
 * @since: 2019年4月15日 上午10:33:10 
 * @history:
 */
public class XN623590 extends AProcessor {
    private IMissionAO missionAO = SpringContextHolder
        .getBean(IMissionAO.class);

    private XN623590Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return new PKCodeRes(missionAO.addMission(req.getBizCode(),
            req.getName(), StringValidater.toLong(req.getTime()),
            req.getCreater(), req.getGetUser()));
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623590Req.class);
        ObjValidater.validateReq(req);
    }

}
