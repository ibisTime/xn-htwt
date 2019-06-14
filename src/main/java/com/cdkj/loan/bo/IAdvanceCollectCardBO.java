package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.AdvanceCollectCard;
import java.util.List;

public interface IAdvanceCollectCardBO extends IPaginableBO<AdvanceCollectCard> {


    public String saveAdvanceCollectCard(AdvanceCollectCard data);


    public int removeAdvanceCollectCard(String code);


    public int refreshAdvanceCollectCard(AdvanceCollectCard data);


    public List<AdvanceCollectCard> queryAdvanceCollectCardList(AdvanceCollectCard condition);


    public AdvanceCollectCard getAdvanceCollectCard(String code);


}