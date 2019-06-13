package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointAccountAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.RepointAccount;
import com.cdkj.loan.dto.req.XN632318Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询返点账号列表
 *
 * @author : cyl
 * @since : 2019-05-27 16:39
 */
public class XN632318 extends AProcessor {

    private IRepointAccountAO repointAccountAO = SpringContextHolder
            .getBean(IRepointAccountAO.class);

    private XN632318Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepointAccount condition = new RepointAccount();
        condition.setRepointCode(req.getRepointCode());
        return repointAccountAO.queryRepointAccountList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632318Req.class);
    }
}
