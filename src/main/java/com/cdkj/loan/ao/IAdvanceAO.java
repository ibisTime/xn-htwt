package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Advance;

@Component
public interface IAdvanceAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 确认用款单

    // 区域总经理审核
    public void areaManageApprove();

    // 省分公司总经理审核
    public void provinceManageApprove();

    // 确认制单
    public void confirmMakeBill();

    // 上传复核回单

    public Paginable<Advance> queryAdvancePage(int start, int limit,
            Advance condition);

    public List<Advance> queryAdvanceList(Advance condition);

    public Advance getAdvance(String code);

}
