package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ENode;
import java.util.List;

public interface IBizTaskBO extends IPaginableBO<BizTask> {

    // 审核的待办事项不传userId
    String saveBizTask(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode, String userId);

    //新增待处理待办
    String saveBizTaskNew(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode);

    // 处理前并产生后面的待办事项
    void handlePreAndAdd(EBizLogType bizLogType,
            String refOrder, String bizCode, String preNode, String curNode, String userId);

    //最后一步，处理之前的待办
    void handlePreBizTask(String bizCode, String refType, String refOrder, String preNode,
            String userId);

    void handleBizTask(String code, String userId);

    List<BizTask> queryBizTaskList(BizTask condition);

    BizTask getBizTask(String code);

    BizTask queryLastBizTask(String bizCode, String refType, String refOrder,
            String curNode);

    void removeUnhandleBizTask(String bizCode, String node, String operater);

    List<BizTask> queryBizTaskByBizCode(String bizCode);

    Paginable<BizTask> getPaginableByRole(int start, int limit, BizTask condition);
}
