package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.dto.req.XN632520Req;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface IBizTaskAO {

    String DEFAULT_ORDER_COLUMN = "code";

    String addBizTask(XN632520Req req);

    void handleBizTask(String code, String operator);

    Paginable<BizTask> queryBizTaskPage(int start, int limit,
            BizTask condition);

    Paginable<BizTask> queryBizTaskPage(int start, int limit,
            BizTask condition, String userId);

    List<BizTask> queryBizTaskList(BizTask condition);

    BizTask getBizTask(String code);

}
