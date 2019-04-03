package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.cdkj.loan.ao.IBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BizLog;
import com.cdkj.loan.dto.req.XN623535Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查操作日志
 * @author: silver 
 * @since: Apr 2, 2019 5:44:17 PM 
 * @history:
 */
public class XN623535 extends AProcessor {
    private IBizLogAO bizLogAO = SpringContextHolder.getBean(IBizLogAO.class);

    private XN623535Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BizLog condition = new BizLog();
        BeanUtils.copyProperties(req, condition);

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IBizLogAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return bizLogAO.queryBizLogPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623535Req.class);
        ObjValidater.validateReq(req);
    }

}
