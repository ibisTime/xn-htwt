/**
 * @Title XN805145.java 
 * @Package com.ogc.standard.api.impl 
 * @Description 
 * @author dl  
 * @date 2018年8月20日 下午7:04:50 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISmsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Sms;
import com.cdkj.loan.dto.req.XN805306Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 列表查询消息
 * @author: dl 
 * @since: 2018年8月20日 下午7:04:50 
 * @history:
 */
public class XN805306 extends AProcessor {
    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN805306Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Sms condition = new Sms();
        condition.setTitle(req.getTitle());
        condition.setType(req.getType());
        condition.setUpdater(req.getUpdater());
        condition.setStatus(req.getStatus());
        return smsAO.querySmsList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805306Req.class);
        ObjValidater.validateReq(req);
    }

}
