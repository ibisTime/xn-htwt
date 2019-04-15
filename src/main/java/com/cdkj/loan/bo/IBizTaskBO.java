package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ENode;

public interface IBizTaskBO extends IPaginableBO<BizTask> {

    // 审核的待办事项不传userId
    public String saveBizTask(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode, String userId);

    public void handlePreBizTask(String refType, String refOrder, ENode preNode);

    public void handleBizTask(String code);

    public List<BizTask> queryBizTaskList(BizTask condition);

    public BizTask getBizTask(String code);

    public List<BizTask> queryLastBizTask(String refType, String refOrder,
            ENode curNode);

    public void removeUnhandleBizTask(String bizCode, String node);

}
