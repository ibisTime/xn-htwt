package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICdbizAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Cdbiz;
import com.cdkj.loan.dto.req.XN632515Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页全部查业务
 *
 * @author : cyl
 * @since : 2019-05-25 15:50
 */
public class XN632519 extends AProcessor {

    private ICdbizAO cdbizAO = SpringContextHolder.getBean(ICdbizAO.class);

    private XN632515Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Cdbiz condition = new Cdbiz();
        EntityUtils.copyData(req, condition);
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ICdbizAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return cdbizAO.queryCdbizPageAll(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632515Req.class);
        ObjValidater.validateReq(req);
    }
}
