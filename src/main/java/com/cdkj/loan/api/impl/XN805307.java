/**
 * @Title XN805247.java 
 * @Package com.ogc.standard.api.impl 
 * @Description 
 * @author dl  
 * @date 2018年8月20日 下午1:36:41 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISmsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN805307Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 详情查询黑名单
 * @author: dl 
 * @since: 2018年8月20日 下午1:36:41 
 * @history:
 */
public class XN805307 extends AProcessor {
    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN805307Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return smsAO.getSms(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805307Req.class);
        ObjValidater.validateReq(req);

    }

}
