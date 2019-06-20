package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarOrderAO;
import com.cdkj.loan.ao.ISeriesAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Series;
import com.cdkj.loan.dto.req.XN630431Req;
import com.cdkj.loan.dto.req.XN630432Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 按车型条件分页查车系
 */

public class XN630432 extends AProcessor {

    private ISeriesAO seriesAO = SpringContextHolder
        .getBean(ISeriesAO.class);

    private XN630432Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Series condition= EntityUtils.copyData(req,Series.class);
        condition.setDisplacementStart(StringValidater.toDouble(req
                .getDisplacementStart()));
        condition.setDisplacementEnd(StringValidater.toDouble(req
                .getDisplacementEnd()));
        condition.setPriceEnd(StringValidater.toLong(req.getPriceEnd()));
        condition.setPriceStart(StringValidater.toLong(req.getPriceStart()));
        condition.setLevelList(req.getLevelList());
        condition.setStructureList(req.getStructureList());
        condition.setVersionList(req.getVersionList());
        int start= StringValidater.toInteger(req.getStart());
        int limit=StringValidater.toInteger(req.getLimit());
        return seriesAO.querySeriesPageByCarCondition(start,limit,condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630432Req.class);
        ObjValidater.validateReq(req);

    }

}
