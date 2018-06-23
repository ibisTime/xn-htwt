package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Bus;

public interface IBusBO extends IPaginableBO<Bus> {

    public String saveBus(Bus data);

    public List<Bus> queryBusList(Bus condition);

    public Bus getBus(String code);

}
