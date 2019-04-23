package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.dto.req.XN632124Req;

public interface ICarPledgeBO extends IPaginableBO<CarPledge> {

    // 添加抵押信息
    public String saveCarPledge(String bizCode, String supplementNoteg);

    // 业务员确认抵押申请
    public void saleManConfirm(String nextNodeCode, XN632124Req req);

    public List<CarPledge> queryCarPledgeList(CarPledge condition);

    public CarPledge getCarPledge(String code);

    public CarPledge getCarPledgeByBizCode(String bizCode);

}
