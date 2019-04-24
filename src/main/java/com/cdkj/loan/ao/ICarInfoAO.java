package com.cdkj.loan.ao;

import java.util.List;

import com.cdkj.loan.bo.base.Paginable;
import com.cdkj.loan.domain.CarInfo;



//CHECK ��鲢��ע�� 
@Component
public interface ICarInfoAO {
	static final String DEFAULT_ORDER_COLUMN = "code";


	public String addCarInfo(CarInfo data);

	public int dropCarInfo(String code);

	public int editCarInfo(CarInfo data);

	public Paginable<CarInfo> queryCarInfoPage(int start, int limit, CarInfo condition);

	public List<CarInfo> queryCarInfoList(CarInfo condition);

	public CarInfo getCarInfo(String code);

}