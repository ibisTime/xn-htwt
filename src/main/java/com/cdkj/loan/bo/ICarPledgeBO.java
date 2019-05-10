package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632133Req;
import java.util.List;

public interface ICarPledgeBO extends IPaginableBO<CarPledge> {

    // 添加抵押信息
    public String saveCarPledge(String bizCode, String supplementNoteg);

    // 添加抵押信息
    public String saveCarPledge(String bizCode, String pledgeUser,
            String pledgeUserIdCardCopy, String pledgeAddress);

    // 业务员确认抵押申请
    public void saleManConfirm(CarPledge carPledge, XN632124Req req);

    // 业务员录入抵押信息
    public void entryPledgeInfo(String code, String nextNodeCode,
            XN632133Req req);

    // 抵押提交银行
    public void pledgeCommitBank(String code, String nextNodeCode,
            String operator, String pledgeBankCommitDatetime,
            String pledgeBankCommitNote);

    // 抵押确认完成
    public void confirmDone(String code, String nextNodeCode, String operator);

    public List<CarPledge> queryCarPledgeList(CarPledge condition);

    public CarPledge getCarPledge(String code);

    public CarPledge getCarPledgeByBizCode(String bizCode);

    public void removeCarpledge(String bizCode);
}
