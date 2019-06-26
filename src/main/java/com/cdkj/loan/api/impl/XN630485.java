package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBrandLogoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BrandLogo;
import com.cdkj.loan.dto.req.XN630485Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查询品牌logo
 *
 * @author : cyl
 * @since : 2019-06-26 10:37
 */

public class XN630485 extends AProcessor {

    private IBrandLogoAO brandLogoAO = SpringContextHolder.getBean(IBrandLogoAO.class);

    private XN630485Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BrandLogo condition = new BrandLogo();
        condition.setBrandName(req.getBrandName());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBrandLogoAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, "ase");
        return brandLogoAO.queryBrandLogoPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630485Req.class);
        ObjValidater.validateReq(req);
    }

}
