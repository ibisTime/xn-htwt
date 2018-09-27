package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IFileListAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.dto.req.XN632212Req;
import com.cdkj.loan.dto.res.BooleanRes;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 修改材料清单
 * @author: CYL 
 * @since: 2018年9月27日 下午7:57:18 
 * @history:
 */
public class XN632212 extends AProcessor {
    private IFileListAO fileListAO = SpringContextHolder
        .getBean(IFileListAO.class);

    private XN632212Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fileListAO.editFileList(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632212Req.class);
        ObjValidater.validateReq(req);
    }

}
