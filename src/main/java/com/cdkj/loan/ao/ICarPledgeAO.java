package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632144Req;

@Component
public interface ICarPledgeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 申请抵押
    public void pledgeApply(XN632144Req req);

    // 业务员确认抵押申请
    public void saleManConfirm(XN632124Req req);

    public Paginable<CarPledge> queryCarPledgePage(int start, int limit,
            CarPledge condition);

    public List<CarPledge> queryCarPledgeList(CarPledge condition);

    public CarPledge getCarPledge(String code);

}
