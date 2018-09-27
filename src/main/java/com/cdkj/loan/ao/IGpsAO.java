package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.Gps;
import com.cdkj.loan.dto.req.XN632701Res;

@Component
public interface IGpsAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addGps(String gpsNo, String gpsType);

    public Paginable<Gps> queryGpsPage(int start, int limit, Gps condition);

    public List<Gps> queryGpsList(Gps condition);

    public Gps getGps(String code);

    public void addGpsList(List<XN632701Res> gpsList);

}
