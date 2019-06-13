package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Advance;
import java.util.List;

public interface IAdvanceBO extends IPaginableBO<Advance> {

    String saveAdvance(String bizCode);

    // 确认用款单
    void confirmApply(String code, String curNodeCode, String status);

    // 区域总经理审核
    void areaManageApprove(Advance condition);

    // 省分公司总经理审核
    void provinceManageApprove(String code, String curNodeCode,
            String status);

    // 确认制单
    void confirmMakeBill(String code, String curNodeCode, String status,
            String makeBillNote);

    // 上传复核回单

    List<Advance> queryAdvanceList(Advance condition);

    Advance getAdvance(String code);

    /**
     * 通过业务编号查询垫资单
     */
    Advance getAdvanceByBizCode(String code);

    /**
     * 垫资回录入
     */
    void advanceBackUp(Advance advance);
}
