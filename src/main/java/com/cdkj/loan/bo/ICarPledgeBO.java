package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarPledge;
import com.cdkj.loan.dto.req.XN632124Req;
import com.cdkj.loan.dto.req.XN632133Req;

public interface ICarPledgeBO extends IPaginableBO<CarPledge> {

    // 添加抵押信息
    String saveCarPledge(String bizCode, String supplementNote,
            String pledgeUser, String pledgeUserIdCard, String pledgeAddress);

    // 添加抵押信息
    String saveCarPledge(String bizCode, String pledgeUser,
            String pledgeUserIdCard, String pledgeAddress);

    // 业务员确认抵押申请
    void saleManConfirm(CarPledge carPledge, XN632124Req req);

    // 业务员录入抵押信息
    void entryPledgeInfo(String code, String nextNodeCode, XN632133Req req);

    // 抵押提交银行
    void pledgeCommitBank(String code, String nextNodeCode, String operator,
            String pledgeBankCommitDatetime, String pledgeBankCommitNote);

    // 抵押确认完成
    void confirmDone(String code, String nextNodeCode, String operator);

    List<CarPledge> queryCarPledgeList(CarPledge condition);

    CarPledge getCarPledge(String code);

    CarPledge getCarPledgeByBizCode(String bizCode);

    void removeCarpledge(String bizCode);

    void refreshSupplementNote(CarPledge condition);
}
