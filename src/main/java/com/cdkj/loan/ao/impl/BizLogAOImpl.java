package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBizLogAO;
import com.cdkj.loan.bo.IBizLogBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizLog;

@Service
public class BizLogAOImpl implements IBizLogAO {

    @Autowired
    private IBizLogBO bizLogBO;

    @Override
    public Paginable<BizLog> queryBizLogPage(int start, int limit,
            BizLog condition) {
        return bizLogBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<BizLog> queryBizLogList(BizLog condition) {
        return bizLogBO.queryBizLogList(condition);
    }

    @Override
    public BizLog getBizLog(String code) {
        return bizLogBO.getBizLog(code);
    }
}
