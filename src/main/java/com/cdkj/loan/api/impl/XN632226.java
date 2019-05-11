package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IEnterFileListAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632226Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 详情查入档清单
 *
 * @author : cyl
 * @since : 2019-05-11 14:38
 */
public class XN632226 extends AProcessor {

    private IEnterFileListAO enterFileListAO = SpringContextHolder
            .getBean(IEnterFileListAO.class);

    private XN632226Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return enterFileListAO.getEnterFileList(req.getCode());
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632226Req.class);
        ObjValidater.validateReq(req);
    }

}
