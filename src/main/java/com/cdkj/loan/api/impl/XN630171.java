package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ISYSBizLogAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.domain.SYSBizLog;
import com.cdkj.loan.dto.req.XN630171Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 查询流转日志列表
 * @author: jiafr 
 * @since: 2018年7月10日 下午5:27:20 
 * @history:
 */
public class XN630171 extends AProcessor {
    private ISYSBizLogAO sysBizLogAO = SpringContextHolder
        .getBean(ISYSBizLogAO.class);

    private XN630171Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SYSBizLog condition = new SYSBizLog();
        condition.setRefOrder(req.getCode());
        return sysBizLogAO.querySYSRoleListByRefOrder(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630171Req.class);
    }
}
