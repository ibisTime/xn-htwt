package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.AdvanceCollectCard;
import java.util.List;
import org.springframework.stereotype.Component;


//CHECK
@Component
public interface IAdvanceCollectCardAO {

    static final String DEFAULT_ORDER_COLUMN = "code";


    public String addAdvanceCollectCard(AdvanceCollectCard data);

    public int dropAdvanceCollectCard(String code);

    public int editAdvanceCollectCard(AdvanceCollectCard data);

    public Paginable<AdvanceCollectCard> queryAdvanceCollectCardPage(int start, int limit,
            AdvanceCollectCard condition);

    public List<AdvanceCollectCard> queryAdvanceCollectCardList(AdvanceCollectCard condition);

    public AdvanceCollectCard getAdvanceCollectCard(String code);

}