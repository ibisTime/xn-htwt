package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.dto.req.XN630426Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询
 * @author: CYL 
 * @since: 2018年4月24日 下午5:39:48 
 * @history:
 */

public class XN630426 extends AProcessor {

    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN630426Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Car condition = new Car();
        condition.setName(req.getName());
        condition.setBrandCode(req.getBrandCode());
        condition.setBrandName(req.getBrandName());
        condition.setSeriesCode(req.getSeriesCode());
        condition.setSeriesName(req.getSeriesName());
        condition.setQueryName(req.getQueryName());
        condition.setStatus(req.getStatus());
        condition.setIsReferee(req.getIsReferee());
        condition.setLocation(StringValidater.toInteger(req.getLocation()));
        condition.setDisplacementStart(StringValidater.toDouble(req
            .getDisplacementStart()));
        condition.setDisplacementEnd(StringValidater.toDouble(req
            .getDisplacementEnd()));
        condition.setPriceEnd(StringValidater.toLong(req.getPriceEnd()));
        condition.setPriceStart(StringValidater.toLong(req.getPriceStart()));
        condition.setLevelList(req.getLevelList());
        condition.setStructureList(req.getStructureList());
        condition.setVersionList(req.getVersionList());
        condition.setIsMore(req.getIsMore());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICarAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        return carAO.queryCarList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630426Req.class);
    }

}
