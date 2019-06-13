package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMissionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.Mission;
import com.cdkj.loan.dto.req.XN623597Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 列表查资源
 *
 * @author: silver
 * @since: Apr 2, 2019 5:44:17 PM
 * @history:
 */
public class XN623597 extends AProcessor {

    private IMissionAO missionAO = SpringContextHolder
            .getBean(IMissionAO.class);

    private XN623597Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Mission condition = new Mission();
        EntityUtils.copyData(req, condition);

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IMissionAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());

        return missionAO.queryMissionList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623597Req.class);
        ObjValidater.validateReq(req);
    }

}
