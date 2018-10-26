package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ILimuCreditAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.LimuCredit;
import com.cdkj.loan.dto.req.XN632947Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 立木征信详情查
 * @author: CYL 
 * @since: 2018年10月12日 下午4:41:52 
 * @history:
 */
public class XN632947 extends AProcessor {
    private ILimuCreditAO limuCreditAO = SpringContextHolder
        .getBean(ILimuCreditAO.class);

    private XN632947Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        LimuCredit condition = new LimuCredit();
        condition.setBizType(req.getBizType());
        condition.setUserId(req.getUserId());
        condition.setToken(req.getToken());
        condition.setUserName(req.getUserName());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ILimuCreditAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return limuCreditAO.queryLimuCreditPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632947Req.class);
        ObjValidater.validateReq(req);
    }

}
