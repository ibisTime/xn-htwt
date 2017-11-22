package com.cdkj.coin.api.impl;

import com.cdkj.coin.ao.IUserRelationAO;
import com.cdkj.coin.api.AProcessor;
import com.cdkj.coin.common.JsonUtil;
import com.cdkj.coin.core.StringValidater;
import com.cdkj.coin.dto.req.XN805110Req;
import com.cdkj.coin.dto.res.BooleanRes;
import com.cdkj.coin.exception.BizException;
import com.cdkj.coin.exception.ParaException;
import com.cdkj.coin.spring.SpringContextHolder;

/**
 * 建立关注关系
 * @author: xieyj 
 * @since: 2016年8月31日 上午9:26:10 
 * @history:
 */
public class XN805110 extends AProcessor {
    private IUserRelationAO userRelationAO = SpringContextHolder
        .getBean(IUserRelationAO.class);

    private XN805110Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        userRelationAO.followUser(req.getUserId(), req.getToUser());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN805110Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getToUser());
    }
}