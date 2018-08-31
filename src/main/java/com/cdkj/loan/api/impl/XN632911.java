package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN632911Req;
import com.cdkj.loan.enums.ESYSBizLogStatus;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 待办事项(OSS)
 * @author: jiafr 
 * @since: 2018年7月6日 下午2:19:30 
 * @history:
 */
public class XN632911 extends AProcessor {

    private ISYSBizLogAO sysBizLogAO = SpringContextHolder
        .getBean(ISYSBizLogAO.class);

    private XN632911Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSBizLog condition = new SYSBizLog();
        condition.setRoleCode(req.getRoleCode());
        condition.setTeamCode(req.getTeamCode());
        condition.setRefType(req.getRefType());
        condition.setRefOrderForQuery(req.getRefOrder());
        condition.setStatus(ESYSBizLogStatus.WAIT_HANDLE.getCode());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSBizLogAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());

        return sysBizLogAO.todoListOSS(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632911Req.class);
        ObjValidater.validateReq(req);
    }
}
