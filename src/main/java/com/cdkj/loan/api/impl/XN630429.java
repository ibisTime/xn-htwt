package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Car;
import com.cdkj.loan.dto.req.XN630429Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询
 *
 * @author: CYL
 * @since: 2018年4月24日 下午5:39:48
 * @history:
 */

public class XN630429 extends AProcessor {

    private ICarAO carAO = SpringContextHolder.getBean(ICarAO.class);

    private XN630429Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Car condition = new Car();
        EntityUtils.copyData(req, condition);

        return carAO.queryList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630429Req.class);
    }

}
