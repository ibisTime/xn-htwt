package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Advance;

@Component
public interface IAdvanceAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public Paginable<Advance> queryAdvancePage(int start, int limit,
            Advance condition);

    public List<Advance> queryAdvanceList(Advance condition);

    public Advance getAdvance(String code);

}
