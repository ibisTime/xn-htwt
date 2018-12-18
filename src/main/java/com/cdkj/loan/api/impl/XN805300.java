/**
 * @Title XN805300.java 
 * @Package com.ogc.standard.api.impl 
 * @Description 
 * @author dl  
 * @date 2018年8月22日 下午3:07:39 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISmsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN805300Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 保存消息（草稿）
 * @author: dl 
 * @since: 2018年8月22日 下午3:07:39 
 * @history:
 */
public class XN805300 extends AProcessor {

    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN805300Req req = null;

    @Override
    public Object doBusiness() throws BizException {

        return smsAO.addSms(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805300Req.class);
        ObjValidater.validateReq(req);
    }

}
