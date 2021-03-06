package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICreditUserExtAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.CreditUserExt;
import com.cdkj.loan.dto.req.XN632485Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查征信人辅助资料
 *
 * @author: silver
 * @since: Apr 20, 2019 3:59:31 PM
 * @history:
 */
public class XN632485 extends AProcessor {

    private ICreditUserExtAO creditUserExtAO = SpringContextHolder
            .getBean(ICreditUserExtAO.class);

    private XN632485Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CreditUserExt condition = new CreditUserExt();
        EntityUtils.copyData(req, condition);

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICreditUserExtAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return creditUserExtAO.queryCreditUserExtPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632485Req.class);
        ObjValidater.validateReq(req);
    }

}
