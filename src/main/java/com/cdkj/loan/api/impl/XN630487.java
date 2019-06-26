package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBrandLogoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.BrandLogo;
import com.cdkj.loan.dto.req.XN630487Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查品牌logo
 *
 * @author : cyl
 * @since : 2019-06-26 10:37
 */

public class XN630487 extends AProcessor {

    private IBrandLogoAO brandLogoAO = SpringContextHolder.getBean(IBrandLogoAO.class);

    private XN630487Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BrandLogo condition = new BrandLogo();
        condition.setBrandName(req.getBrandName());
        return brandLogoAO.queryBrandLogoList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630487Req.class);
        ObjValidater.validateReq(req);
    }

}
