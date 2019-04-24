package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarInfo;

//CHECK ��鲢��ע�� 
public interface ICarInfoBO extends IPaginableBO<CarInfo> {

    public boolean isCarInfoExist(String code);

    public String saveCarInfo(String bizCode);

    public int removeCarInfo(String code);

    public int refreshCarInfo(CarInfo data);

    public List<CarInfo> queryCarInfoList(CarInfo condition);

    public CarInfo getCarInfo(String code);

    public CarInfo getCarInfoByBizCode(String bizCode);

}
