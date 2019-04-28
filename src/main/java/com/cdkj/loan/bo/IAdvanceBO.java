package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Advance;

public interface IAdvanceBO extends IPaginableBO<Advance> {

    public String saveAdvance(String bizCode);

    // 确认用款单
    public void confirmApply(String code, String curNodeCode, String status);

    // 区域总经理审核
    public void areaManageApprove(String code, String curNodeCode,
            String status, String approveNote);

    // 省分公司总经理审核
    public void provinceManageApprove(String code, String curNodeCode,
            String status);

    // 确认制单
    public void confirmMakeBill(String code, String curNodeCode, String status,
            String makeBillNote);

    // 上传复核回单

    public List<Advance> queryAdvanceList(Advance condition);

    public Advance getAdvance(String code);

}
