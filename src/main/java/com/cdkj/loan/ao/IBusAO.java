package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bus;

@Component
public interface IBusAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBus(Bus data);

    public Paginable<Bus> queryBusPage(int start, int limit, Bus condition);

    public List<Bus> queryBusList(Bus condition);

    public Bus getBus(String code);

}
