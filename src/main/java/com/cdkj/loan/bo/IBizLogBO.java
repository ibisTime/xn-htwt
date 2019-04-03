package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizLog;
import com.cdkj.loan.domain.SYSUser;

public interface IBizLogBO extends IPaginableBO<BizLog> {

    public String saveBizLog(String bizCode, String refType, String refOrder,
            String dealNode, String dealNote, SYSUser operator);

    public List<BizLog> queryBizLogList(BizLog condition);

    public BizLog getBizLog(String code);

}
