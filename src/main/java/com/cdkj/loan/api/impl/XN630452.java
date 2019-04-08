package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarNewsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.dto.req.XN630452Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改资讯
 * @author: taojian 
 * @since: 2019年3月13日 下午2:15:08 
 * @history:
 */
public class XN630452 extends AProcessor {

    private ICarNewsAO carNewsAO = SpringContextHolder
        .getBean(ICarNewsAO.class);

    private XN630452Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        carNewsAO.editCarNews(req.getCode(), req.getTitle(), req.getAdvPic(),
            StringValidater.toLong(req.getPicNumber()), req.getPic(),
            req.getContext(), req.getTag(), req.getUpdater(), req.getRemark(),
            req.getAuthor());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630452Req.class);
        ObjValidater.validateReq(req);

    }

}
