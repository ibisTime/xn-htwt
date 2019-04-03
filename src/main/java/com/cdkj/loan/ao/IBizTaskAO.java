package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.dto.req.XN632520Req;

@Component
public interface IBizTaskAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBizTask(XN632520Req req);

    public void handleBizTask(String code, String operator);

    public Paginable<BizTask> queryBizTaskPage(int start, int limit,
            BizTask condition);

    public List<BizTask> queryBizTaskList(BizTask condition);

    public BizTask getBizTask(String code);

}
