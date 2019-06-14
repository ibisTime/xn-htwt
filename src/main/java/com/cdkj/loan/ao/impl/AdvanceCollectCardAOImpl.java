package com.cdkj.loan.ao.impl;

import com.cdkj.loan.ao.IAdvanceCollectCardAO;
import com.cdkj.loan.bo.IAdvanceCollectCardBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AdvanceCollectCard;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdvanceCollectCardAOImpl implements IAdvanceCollectCardAO {

    @Autowired
    private IAdvanceCollectCardBO advanceCollectCardBO;

    @Override
    public String addAdvanceCollectCard(AdvanceCollectCard data) {
        return advanceCollectCardBO.saveAdvanceCollectCard(data);
    }

    @Override
    public int editAdvanceCollectCard(AdvanceCollectCard data) {
        return advanceCollectCardBO.refreshAdvanceCollectCard(data);
    }

    @Override
    public int dropAdvanceCollectCard(String code) {
        return advanceCollectCardBO.removeAdvanceCollectCard(code);
    }

    @Override
    public Paginable<AdvanceCollectCard> queryAdvanceCollectCardPage(int start, int limit,
            AdvanceCollectCard condition) {
        return advanceCollectCardBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<AdvanceCollectCard> queryAdvanceCollectCardList(AdvanceCollectCard condition) {
        return advanceCollectCardBO.queryAdvanceCollectCardList(condition);
    }

    @Override
    public AdvanceCollectCard getAdvanceCollectCard(String code) {
        return advanceCollectCardBO.getAdvanceCollectCard(code);
    }
}