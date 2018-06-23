package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IBusBorrowAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.BusBorrow;
import com.cdkj.loan.dto.req.XN632795Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 公车使用分页查
 * @author: CYL 
 * @since: 2018年6月23日 下午2:50:36 
 * @history:
 */
public class XN632795 extends AProcessor {
    private IBusBorrowAO busBorrowAO = SpringContextHolder
        .getBean(IBusBorrowAO.class);

    private XN632795Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BusBorrow condition = new BusBorrow();
        condition.setBusCode(req.getBusCode());
        condition.setApplyUser(req.getApplyUser());
        condition.setDepartmentCode(req.getDepartmentCode());
        condition.setStatus(req.getStatus());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBusBorrowAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return busBorrowAO.queryBusBorrowPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632795Req.class);
        ObjValidater.validateReq(req);
    }

}
