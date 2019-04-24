package com.cdkj.loan.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdkj.loan.ao.ICarInfoAO;
import com.cdkj.loan.bo.ICarInfoBO;
import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarInfo;
import com.cdkj.loan.exception.BizException;



//CHECK ��鲢��ע�� 
@Service
public class CarInfoAOImpl implements ICarInfoAO {

	@Autowired
	private ICarInfoBO carInfoBO;

	@Override
	public String addCarInfo(CarInfo data) {
		return carInfoBO.saveCarInfo(data);
	}

	@Override
	public int editCarInfo(CarInfo data) {
		if (!carInfoBO.isCarInfoExist(data.getCode())) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return carInfoBO.refreshCarInfo(data);
	}

	@Override
	public int dropCarInfo(String code) {
		if (!carInfoBO.isCarInfoExist(code)) {
			throw new BizException("xn0000", "记录编号不存在");
		}
		return carInfoBO.removeCarInfo(code);
	}

	@Override
	public Paginable<CarInfo> queryCarInfoPage(int start, int limit,
			CarInfo condition) {
		return carInfoBO.getPaginable(start, limit, condition);
	}

	@Override
	public List<CarInfo> queryCarInfoList(CarInfo condition) {
		return carInfoBO.queryCarInfoList(condition);
	}

	@Override
	public CarInfo getCarInfo(String code) {
		return carInfoBO.getCarInfo(code);
	}
}