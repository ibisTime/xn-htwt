package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarPledge;

public interface ICarPledgeBO extends IPaginableBO<CarPledge> {

    public String saveCarPledge(CarPledge data);

    public int refreshCarPledge(CarPledge data);

    public List<CarPledge> queryCarPledgeList(CarPledge condition);

    public CarPledge getCarPledge(String code);

}
