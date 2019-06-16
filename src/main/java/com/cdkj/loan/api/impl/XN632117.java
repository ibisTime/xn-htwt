package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditAO;
import com.cdkj.loan.ao.ICreditUserAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.DateUtil;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Credit;
import com.cdkj.loan.dto.req.XN632116Req;
import com.cdkj.loan.dto.req.XN632117Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 同盾报告
 * @author: jiafr 
 * @since: 2018年5月26日 上午10:57:21 
 * @history:
 */
public class XN632117 extends AProcessor {

    private ICreditUserAO creditUserAO = SpringContextHolder.getBean(ICreditUserAO.class);

    private XN632117Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return creditUserAO.getTongdunResult(req.getCreditUserCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632117Req.class);
        ObjValidater.validateReq(req);

    }

}
