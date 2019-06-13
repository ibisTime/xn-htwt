package com.cdkj.loan.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.loan.ao.IFileListAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.core.StringValidater;
import com.cdkj.loan.domain.FileList;
import com.cdkj.loan.dto.req.XN632215Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 分页查材料清单
 * @author: CYL 
 * @since: 2018年9月27日 下午7:57:18 
 * @history:
 */
public class XN632215 extends AProcessor {
    private IFileListAO fileListAO = SpringContextHolder
        .getBean(IFileListAO.class);

    private XN632215Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FileList condition = new FileList();
        condition.setCategory(req.getCategory());
        condition.setId(StringValidater.toLong(req.getId()));
        condition.setAttachType(req.getAttachType());
        condition.setUpdater(req.getUpdater());
        condition.setVname(req.getVname());
        condition.setKname(req.getKname());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = fileListAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fileListAO.queryFileListPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632215Req.class);
        ObjValidater.validateReq(req);
    }

}
