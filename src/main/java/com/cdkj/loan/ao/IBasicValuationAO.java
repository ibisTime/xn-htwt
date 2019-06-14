package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BasicValuation;
import com.cdkj.loan.dto.req.XN630479Req;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface IBasicValuationAO {

    static final String DEFAULT_ORDER_COLUMN = "id";

    void addBasicValuation(BasicValuation data);

    Paginable<BasicValuation> queryBasicValuationPage(int start,
            int limit, BasicValuation condition);

    List<BasicValuation> queryBasicValuationList(
            BasicValuation condition);

    BasicValuation getBasicValuation(int id);

    // 基础估值
    Object basicValuation(XN630479Req req);

}
