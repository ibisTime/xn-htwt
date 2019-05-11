package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEnterFileListAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.EnterFileList;
import com.cdkj.loan.dto.req.XN632227Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 详情查入档清单
 *
 * @author : cyl
 * @since : 2019-05-11 14:38
 */
public class XN632227 extends AProcessor {

    private IEnterFileListAO enterFileListAO = SpringContextHolder
            .getBean(IEnterFileListAO.class);

    private XN632227Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        EnterFileList condition = new EnterFileList();
        condition.setBizCode(req.getBizCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IEnterFileListAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return enterFileListAO.queryEnterFileListList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632227Req.class);
        ObjValidater.validateReq(req);
    }

}
