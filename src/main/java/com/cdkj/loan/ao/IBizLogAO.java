package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizLog;

@Component
public interface IBizLogAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<BizLog> queryBizLogPage(int start, int limit,
            BizLog condition);

    public List<BizLog> queryBizLogList(BizLog condition);

    public BizLog getBizLog(String code);

}
