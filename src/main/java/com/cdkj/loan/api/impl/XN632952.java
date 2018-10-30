package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInterviewVideoRoomAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632952Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 面签视频：查询录制文件
 * @author: CYL 
 * @since: 2018年10月24日 下午3:55:57 
 * @history:
 */
public class XN632952 extends AProcessor {
    private IInterviewVideoRoomAO interviewVideoRoomAO = SpringContextHolder
        .getBean(IInterviewVideoRoomAO.class);

    private XN632952Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return interviewVideoRoomAO.foundHlVideo(req);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632952Req.class);
        ObjValidater.validateReq(req);
    }
}
