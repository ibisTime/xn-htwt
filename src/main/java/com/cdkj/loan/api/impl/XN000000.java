package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICarPledgeAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.dto.req.XN000000Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 临时接口
 * @author: CYL 
 * @since: 2018年12月13日 下午8:47:36 
 * @history:
 */
public class XN000000 extends AProcessor {
    private ICarPledgeAO carPledgeAO = SpringContextHolder
        .getBean(ICarPledgeAO.class);

    private XN000000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN000000Req.class);
    }

}
