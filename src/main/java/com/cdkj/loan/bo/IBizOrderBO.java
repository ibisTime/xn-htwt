package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.BizOrder;



//CHECK ��鲢��ע�� 
public interface IBizOrderBO extends IPaginableBO<BizOrder> {


	public boolean isBizOrderExist(String code);


	public String saveBizOrder(BizOrder data);


	public int removeBizOrder(String code);


	public int refreshBizOrder(BizOrder data);


	public List<BizOrder> queryBizOrderList(BizOrder condition);


	public BizOrder getBizOrder(String code);


}