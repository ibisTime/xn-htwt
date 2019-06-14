package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BasicValuation;
import java.util.List;

public interface IBasicValuationBO extends IPaginableBO<BasicValuation> {

    public void saveBasicValuation(BasicValuation data);

    public List<BasicValuation> queryBasicValuationList(
            BasicValuation condition);

    public BasicValuation getBasicValuation(int id);

}
