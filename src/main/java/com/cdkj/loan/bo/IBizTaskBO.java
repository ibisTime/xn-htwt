package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ENode;
import java.util.List;

public interface IBizTaskBO extends IPaginableBO<BizTask> {

    // 审核的待办事项不传userId
    String saveBizTask(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode, String userId);

    // 处理前并产生后面的待办事项
    void handlePreAndAdd(EBizLogType bizLogType,
            String refOrder, String bizCode, String preNode, String curNode, String userId);

    void handlePreBizTask(String refType, String refOrder, ENode preNode);

    void handleBizTask(String code);

    List<BizTask> queryBizTaskList(BizTask condition);

    BizTask getBizTask(String code);

    List<BizTask> queryLastBizTask(String refType, String refOrder,
            ENode curNode);

    void removeUnhandleBizTask(String bizCode, String node, String operater);

    List<BizTask> queryBizTaskByBizCode(String bizCode);

}
