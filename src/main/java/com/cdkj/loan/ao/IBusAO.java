package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bus;
import com.cdkj.loan.dto.req.XN632690Req;
import com.cdkj.loan.dto.req.XN632692Req;

@Component
public interface IBusAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBus(XN632690Req req);

    public int dropBus(String code);

    public void editBus(XN632692Req req);

    public Paginable<Bus> queryBusPage(int start, int limit, Bus condition);

    public List<Bus> queryBusList(Bus condition);

    public Bus getBus(String code);

}
