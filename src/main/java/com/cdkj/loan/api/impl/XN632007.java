package com.cdkj.loan.api.impl;

import com.cdkj.loan.ao.ICollectBankcardAO;
import com.cdkj.loan.api.AProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.core.ObjValidater;
import com.cdkj.loan.domain.CollectBankcard;
import com.cdkj.loan.dto.req.XN632007Req;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import com.cdkj.loan.spring.SpringContextHolder;

/**
 * 列表查询收款账号
 *
 * @author: CYL
 * @since: 2018年5月25日 下午4:55:45
 * @history:
 */
public class XN632007 extends AProcessor {

    private ICollectBankcardAO collectBankcardAO = SpringContextHolder
            .getBean(ICollectBankcardAO.class);

    private XN632007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CollectBankcard condition = new CollectBankcard();
        condition.setType(req.getType());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setKeyword(req.getKeyword());
        condition.setAdvanceType(req.getAdvanceType());

        return collectBankcardAO.queryCollectBankcardList(condition);
    }

    @Override
    public void doCheck(String inputparams, String operator)
            throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN632007Req.class);
        ObjValidater.validateReq(req);
    }

}
