package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarDealer;
import java.util.List;

public interface ICarDealerBO extends IPaginableBO<CarDealer> {

    String saveCarDealer(CarDealer data);

    int refreshCarDealer(CarDealer data);

    List<CarDealer> queryCarDealerList(CarDealer condition);

    CarDealer getCarDealer(String code);

    // 更新节点
    int refreshCarDealerNode(CarDealer data);

}
