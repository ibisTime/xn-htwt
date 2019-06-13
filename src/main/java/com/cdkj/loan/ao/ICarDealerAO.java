package com.cdkj.loan.ao;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarDealer;
import com.cdkj.loan.dto.req.XN632060Req;
import com.cdkj.loan.dto.req.XN632061Req;
import com.cdkj.loan.dto.req.XN632062Req;
import java.util.List;

public interface ICarDealerAO {

    String DEFAULT_ORDER_COLUMN = "code";

    String addCarDealer(XN632060Req req);

    void dropCarDealer(XN632061Req req);

    void editCarDealer(XN632062Req req);

    Paginable<CarDealer> queryCarDealerPage(int start, int limit,
            CarDealer condition);

    List<CarDealer> queryCarDealerList(CarDealer condition);

    CarDealer getCarDealer(String code);
}
