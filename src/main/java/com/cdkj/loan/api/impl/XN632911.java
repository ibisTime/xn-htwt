package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN632911Req;
import com.cdkj.loan.enums.EBoolean;
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
        condition.setApplyUserName(req.getApplyUserName());
        condition.setRoleCode(req.getRoleCode());
        condition.setRefType(req.getRefType());
        condition.setBizCode(req.getParentOrder());
        condition.setIsLogistics(EBoolean.NO.getCode());

        condition.setOrder("start_datetime", false);// 按开始时间倒序
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
