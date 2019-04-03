package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.SYSUser;
import com.cdkj.loan.enums.EBizLogType;
import com.cdkj.loan.enums.ENode;

public interface IBizTaskBO extends IPaginableBO<BizTask> {

    public String saveBizTask(String bizCode, EBizLogType bizLogType,
            String refOrder, ENode curNode);

    public void operateBizTask(String code, SYSUser operator);

    public List<BizTask> queryBizTaskList(BizTask condition);

    public BizTask getBizTask(String code);

}
