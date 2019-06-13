package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ILogisticsAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.Logistics;
import com.cdkj.loan.dto.req.XN632155Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

/**
 * 分页查询资料传递
 *
 * @author: silver
 * @since: 2018年5月30日 下午5:06:19
 * @history:
 */
public class XN632155 extends AProcessor {

    private ILogisticsAO logisticsAO = SpringContextHolder
            .getBean(ILogisticsAO.class);

    private XN632155Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Logistics condition = new Logistics();
        condition.setBizCode(req.getBizCode());
        condition.setUserId(req.getUserId());
        condition.setStatus(req.getStatus());
        condition.setStatusList(req.getStatusList());
        condition.setType(req.getType());
        condition.setTypeList(req.getTypeList());
        condition.setReceiver(req.getReceiver());
        condition.setBizCodeForQuery(req.getBizCodeForQuery());
        condition.setFromNodeList(req.getFromNodeList());
        condition.setToNodeList(req.getToNodeList());

        if ("RO201800000000000001".equals(req.getRoleCode())) {
            condition.setReceiver(null);
        }
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ILogisticsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, "desc");
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return logisticsAO.queryLogisticsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632155Req.class);
        ObjValidater.validateReq(req);
    }

}
