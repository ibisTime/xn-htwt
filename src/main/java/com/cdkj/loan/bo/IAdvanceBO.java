package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Advance;

public interface IAdvanceBO extends IPaginableBO<Advance> {

    public String saveAdvance(String bizCode);

    public List<Advance> queryAdvanceList(Advance condition);

    public Advance getAdvance(String code);

}
