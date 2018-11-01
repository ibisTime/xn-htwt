package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInterviewVideoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632953Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面签视频：查询房间人数
 * @author: CYL 
 * @since: 2018年10月24日 下午3:55:57 
 * @history:
 */
public class XN632953 extends AProcessor {
    private IInterviewVideoAO interviewVideoAO = SpringContextHolder
        .getBean(IInterviewVideoAO.class);

    private XN632953Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return interviewVideoAO.foundRoomTotal(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632953Req.class);
        ObjValidater.validateReq(req);
    }
}
