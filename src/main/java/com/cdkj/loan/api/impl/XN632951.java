package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInterviewVideoRoomAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632951Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面签视频：云端混流
 * @author: CYL 
 * @since: 2018年10月24日 下午3:55:57 
 * @history:
 */
public class XN632951 extends AProcessor {
    private IInterviewVideoRoomAO interviewVideoRoomAO = SpringContextHolder
        .getBean(IInterviewVideoRoomAO.class);

    private XN632951Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return interviewVideoRoomAO.hlInterviewVideo(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632951Req.class);
        ObjValidater.validateReq(req);
    }
}
