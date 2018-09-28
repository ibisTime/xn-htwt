package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.IFileListAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.dto.req.XN632217Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查材料清单
 * @author: CYL 
 * @since: 2018年9月27日 下午7:57:18 
 * @history:
 */
public class XN632217 extends AProcessor {
    private IFileListAO fileListAO = SpringContextHolder
        .getBean(IFileListAO.class);

    private XN632217Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FileList condition = new FileList();
        condition.setNumber(req.getNumber());
        condition.setName(req.getName());
        condition.setUpdater(req.getUpdater());
        return fileListAO.queryFileListList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632217Req.class);
        ObjValidater.validateReq(req);
    }

}
