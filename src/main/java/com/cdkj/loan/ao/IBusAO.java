package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Bus;
import com.cdkj.loan.dto.req.XN632780Req;
import com.cdkj.loan.dto.req.XN632782Req;

@Component
public interface IBusAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBus(XN632780Req req);

    public int dropBus(String code, String updater, String remark);

    public void editBus(XN632782Req req);

    public Paginable<Bus> queryBusPage(int start, int limit, Bus condition);

    public List<Bus> queryBusList(Bus condition);

    public Bus getBus(String code);

}
