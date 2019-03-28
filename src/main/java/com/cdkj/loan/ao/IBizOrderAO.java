package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizOrder;

//CHECK ��鲢��ע�� 
public interface IBizOrderAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBizOrder(BizOrder data);

    public int dropBizOrder(String code);

    public int editBizOrder(BizOrder data);

    public Paginable<BizOrder> queryBizOrderPage(int start, int limit,
            BizOrder condition);

    public List<BizOrder> queryBizOrderList(BizOrder condition);

    public BizOrder getBizOrder(String code);

}
