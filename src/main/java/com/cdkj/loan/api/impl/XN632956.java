package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInterviewVideoRoomAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632956Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面签视频：查询房间
 * @author: CYL 
 * @since: 2018年12月4日 下午1:00:30 
 * @history:
 */
public class XN632956 extends AProcessor {
    private IInterviewVideoRoomAO interviewVideoRoomAO = SpringContextHolder
        .getBean(IInterviewVideoRoomAO.class);

    private XN632956Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return interviewVideoRoomAO.getInterviewVideoRoom(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632956Req.class);
        ObjValidater.validateReq(req);
    }
}
