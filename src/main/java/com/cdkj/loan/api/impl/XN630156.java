package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.INodeFlowAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630156Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查节点流程
 * @author: CYL 
 * @since: 2018年5月23日 下午9:52:05 
 * @history:
 */
public class XN630156 extends AProcessor {

    private INodeFlowAO nodeFlowAO = SpringContextHolder
        .getBean(INodeFlowAO.class);

    private XN630156Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return nodeFlowAO.getNodeFlow(req.getId());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630156Req.class);
        ObjValidater.validateReq(req);
    }

}
