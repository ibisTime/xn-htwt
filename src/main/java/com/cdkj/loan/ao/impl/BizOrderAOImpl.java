package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.IBizOrderAO;
import com.cdkj.loan.bo.IBizOrderBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.BizOrder;
import com.cdkj.loan.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class BizOrderAOImpl implements IBizOrderAO {

	@Autowired
	private IBizOrderBO bizOrderBO;

	@Override
	public String addBizOrder(BizOrder data) {
		return bizOrderBO.saveBizOrder(data);
	}

	@Override
	public int editBizOrder(BizOrder data) {
		if (!bizOrderBO.isBizOrderExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return bizOrderBO.refreshBizOrder(data);
	}

	@Override
	public int dropBizOrder(String code) {
		if (!bizOrderBO.isBizOrderExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return bizOrderBO.removeBizOrder(code);
	}

	@Override
	public Paginable<BizOrder> queryBizOrderPage(int start, int limit,
			BizOrder condition) {
		return bizOrderBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<BizOrder> queryBizOrderList(BizOrder condition) {
		return bizOrderBO.queryBizOrderList(condition);
	}

	@Override
	public BizOrder getBizOrder(String code) {
		return bizOrderBO.getBizOrder(code);
	}
}