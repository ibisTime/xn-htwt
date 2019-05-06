package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Advance;
import com.cdkj.loan.dto.req.XN632462ReqMission;
import com.cdkj.loan.dto.req.XN632464Req;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface IAdvanceAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    // 确认用款单
    void confirmApply(String code, String operator, String isAdvanceFund);

    // 区域总经理审核
    void areaManageApprove(String code, String operator,
            String approveResult, String approveNote);

    // 省分公司总经理审核
    void provinceManageApprove(String code, String operator,
            String approveResult, String approveNote,
            List<XN632462ReqMission> missionList);

    // 确认制单
    void confirmMakeBill(String code, String operator,
            String makeBillNote);

    Paginable<Advance> queryAdvancePage(int start, int limit,
            Advance condition);

    List<Advance> queryAdvanceList(Advance condition);

    Advance getAdvance(String code);

    /**
     * 垫资回录
     */
    void advanceBackUp(XN632464Req req);
}
