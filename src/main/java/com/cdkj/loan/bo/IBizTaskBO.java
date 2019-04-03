package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizTask;
import com.cdkj.loan.domain.SYSUser;

public interface IBizTaskBO extends IPaginableBO<BizTask> {

    public String saveBizTask(String bizCode, String refType, String refOrder,
            String content);

    public void operateBizTask(String code, SYSUser operator);

    public List<BizTask> queryBizTaskList(BizTask condition);

    public BizTask getBizTask(String code);

}
