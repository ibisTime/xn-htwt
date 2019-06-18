package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBrandAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Brand;
import com.cdkj.loan.dto.req.XN630406Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 列表查询
 *
 * @author: CYL
 * @since: 2018年4月24日 下午5:35:26
 * @history:
 */

public class XN630406 extends AProcessor {

    private IBrandAO brandAO = SpringContextHolder.getBean(IBrandAO.class);

    private XN630406Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Brand condition = new Brand();
        condition.setName(req.getName());
        condition.setLetter(req.getLetter());
        condition.setStatus(req.getStatus());
        condition.setLocation(req.getLocation());
        condition.setType(req.getType());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBrandAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return brandAO.queryBrandList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630406Req.class);

    }

}
