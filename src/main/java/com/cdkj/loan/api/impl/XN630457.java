package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarNewsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CarNews;
import com.cdkj.loan.dto.req.XN630457Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查资讯
 * @author: taojian 
 * @since: 2019年3月13日 下午2:15:08 
 * @history:
 */
public class XN630457 extends AProcessor {

    private ICarNewsAO carNewsAO = SpringContextHolder
        .getBean(ICarNewsAO.class);

    private XN630457Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CarNews condition = new CarNews();
        condition.setTitle(req.getTitle());
        condition.setTag(req.getTag());
        condition.setStatus(req.getStatus());

        return carNewsAO.queryCarNewsList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630457Req.class);
        ObjValidater.validateReq(req);

    }

}
