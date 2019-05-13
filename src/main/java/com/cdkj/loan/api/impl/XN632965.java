package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IInterviewVideoAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.InterviewVideo;
import com.cdkj.loan.dto.req.XN632965Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查视频
 * @author: taojian 
 * @since: 2019年5月13日 下午9:22:30 
 * @history:
 */
public class XN632965 extends AProcessor {
    private IInterviewVideoAO interviewVideoAO = SpringContextHolder
        .getBean(IInterviewVideoAO.class);

    private XN632965Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InterviewVideo condition = new InterviewVideo();
        condition.setBizCode(req.getBizCode());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return interviewVideoAO
            .queryInterviewVideoPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632965Req.class);
        ObjValidater.validateReq(req);
    }
}
