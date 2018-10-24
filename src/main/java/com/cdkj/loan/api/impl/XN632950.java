package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInterviewVideoRoomAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632950Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面签视频：创建房间
 * @author: CYL 
 * @since: 2018年10月24日 下午3:55:57 
 * @history:
 */
public class XN632950 extends AProcessor {
    private IInterviewVideoRoomAO interviewVideoRoomAO = SpringContextHolder
        .getBean(IInterviewVideoRoomAO.class);

    private XN632950Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return interviewVideoRoomAO.addInterviewVideoRoom(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632950Req.class);
        ObjValidater.validateReq(req);
    }
}
