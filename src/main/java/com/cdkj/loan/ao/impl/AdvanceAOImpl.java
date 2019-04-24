package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IAdvanceAO;
import com.cdkj.loan.bo.IAdvanceBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Advance;

@Service
public class AdvanceAOImpl implements IAdvanceAO {

    @Autowired
    private IAdvanceBO advanceBO;

    @Override
    public Paginable<Advance> queryAdvancePage(int start, int limit,
            Advance condition) {
        return advanceBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Advance> queryAdvanceList(Advance condition) {
        return advanceBO.queryAdvanceList(condition);
    }

    @Override
    public Advance getAdvance(String code) {
        return advanceBO.getAdvance(code);
    }
}
