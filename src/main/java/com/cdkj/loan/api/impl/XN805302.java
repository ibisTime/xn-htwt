/**
 * @Title XN805300.java 
 * @Package com.ogc.standard.api.impl 
 * @Description 
 * @author dl  
 * @date 2018年8月22日 下午3:07:39 
 * @version V1.0   
 */
package com.cdkj.loan.api.impl;

import java.util.List;

import com.cdkj.loan.ao.ISmsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN805302Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/** 
 * 撤回消息
 * @author: dl 
 * @since: 2018年8月22日 下午3:07:39 
 * @history:
 */
public class XN805302 extends AProcessor {

    private ISmsAO smsAO = SpringContextHolder.getBean(ISmsAO.class);

    private XN805302Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        List<String> codeList = req.getCodeList();
        for (String code : codeList) {
            smsAO.editStatus(code, req.getUpdater(), req.getRemark());
        }
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805302Req.class);
        ObjValidater.validateReq(req);
    }

}
