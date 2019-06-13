package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IRepointAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.Repoint;
import com.cdkj.loan.dto.req.XN632317Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询返点支付
 *
 * @author: jiafr
 * @since: 2018年6月9日 下午2:34:34
 * @history:
 */
public class XN632317 extends AProcessor {

    private IRepointAO repointAO = SpringContextHolder
            .getBean(IRepointAO.class);

    private XN632317Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Repoint condition = new Repoint();
        condition.setTeamCode(req.getTeamCode());
        condition.setStatus(req.getStatus());

        return repointAO.queryRepointList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632317Req.class);
    }
}
