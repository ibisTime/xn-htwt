package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.cdkj.loan.ao.IFilePoolAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.FilePool;
import com.cdkj.loan.dto.req.XN623597Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查资源
 * @author: silver 
 * @since: Apr 2, 2019 5:44:17 PM 
 * @history:
 */
public class XN623597 extends AProcessor {
    private IFilePoolAO filePoolAO = SpringContextHolder
        .getBean(IFilePoolAO.class);

    private XN623597Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FilePool condition = new FilePool();
        BeanUtils.copyProperties(req, condition);

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFilePoolAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());

        return filePoolAO.queryFilePoolList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623597Req.class);
        ObjValidater.validateReq(req);
    }

}
