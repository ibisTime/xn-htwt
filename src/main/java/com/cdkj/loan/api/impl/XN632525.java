package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IBizTaskAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.dto.req.XN632525Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查待办事项
 *
 * @author: silver
 * @since: Apr 3, 2019 2:05:35 PM
 * @history:
 */
public class XN632525 extends AProcessor {

    private IBizTaskAO bizTaskAO = SpringContextHolder
            .getBean(IBizTaskAO.class);

    private XN632525Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BizTask condition = new BizTask();
        EntityUtils.copyData(req, condition);

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBizTaskAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return bizTaskAO.queryBizTaskPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632525Req.class);
        ObjValidater.validateReq(req);
    }

}
