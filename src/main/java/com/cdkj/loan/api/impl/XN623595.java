package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IMissionAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.EntityUtils;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Mission;
import com.cdkj.loan.dto.req.XN623595Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查任务
 *
 * @author: taojian
 * @since: 2019年4月15日 上午10:33:10
 * @history:
 */
public class XN623595 extends AProcessor {

    private IMissionAO missionAO = SpringContextHolder
            .getBean(IMissionAO.class);

    private XN623595Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Mission condition = new Mission();
        EntityUtils.copyData(req, condition);

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IMissionAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return missionAO.queryMissionPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN623595Req.class);
        ObjValidater.validateReq(req);
    }

}
