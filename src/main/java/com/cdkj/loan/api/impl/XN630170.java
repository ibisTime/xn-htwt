package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN630170Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 用户操作记录菜单列表查询
 * @author: jiafr 
 * @since: 2018年7月10日 下午3:51:44 
 * @history:
 */
public class XN630170 extends AProcessor {
    private ISYSBizLogAO sysBizLogAO = SpringContextHolder
        .getBean(ISYSBizLogAO.class);

    private XN630170Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSBizLog condition = new SYSBizLog();
        condition.setBizOrderType(req.getType());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = ISYSBizLogAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return sysBizLogAO.querySYSBizLogPageByBizOrderType(start, limit,
            condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630170Req.class);
        ObjValidater.validateReq(req);
    }

}
