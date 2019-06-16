package com.cdkj.loan.api.impl;

import com.cdkj.loan.aliyun.IdOcrPicImpl;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN630092Req;
import com.cdkj.loan.enums.EIdSide;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 根据图片获取身份证正面信息
 *
 * @author: xieyj
 * @since: 2018年7月1日 下午2:24:15
 * @history:
 */
public class XN630092 extends AProcessor {

    private IdOcrPicImpl idOcrPicImpl = SpringContextHolder
            .getBean(IdOcrPicImpl.class);

    private XN630092Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return idOcrPicImpl.getIdInfo(req.getPicUrl(), EIdSide.FACE.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN630092Req.class);
        ObjValidater.validateReq(req);
    }
}
