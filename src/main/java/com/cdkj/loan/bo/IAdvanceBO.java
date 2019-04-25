package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Advance;

public interface IAdvanceBO extends IPaginableBO<Advance> {

    public String saveAdvance(String bizCode);

    // 确认用款单

    // 区域总经理审核

    // 省分公司总经理审核

    // 确认制单

    // 上传复核回单

    public List<Advance> queryAdvanceList(Advance condition);

    public Advance getAdvance(String code);

}
