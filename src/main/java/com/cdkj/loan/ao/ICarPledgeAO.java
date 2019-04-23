package com.cdkj.loan.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632133Req;
import com.cdkj.loan.dto.req.XN632144Req;

@Component
public interface ICarPledgeAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    // 申请抵押
    public void pledgeApply(XN632144Req req);

    // 业务员确认抵押申请
    public void saleManConfirm(XN632124Req req);

    // 业务员录入抵押信息
    public void entryPledgeInfo(XN632133Req req);

    // 抵押提交银行
    public void pledgeCommitBank(String code, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote);

    // 抵押确认完成
    public void confirmDone(String code, String operator);

    public Paginable<CarPledge> queryCarPledgePage(int start, int limit,
            CarPledge condition);

    public List<CarPledge> queryCarPledgeList(CarPledge condition);

    public CarPledge getCarPledge(String code);

}
