package com.cdkj.loan.bo;

import java.util.List;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.CarCarconfig;

//CHECK ��鲢��ע�� 
public interface ICarCarconfigBO extends IPaginableBO<CarCarconfig> {

    public boolean isCarCarconfigExist(String code);

    public String saveCarCarconfig(String carCode, String configCode);

    public int removeCarCarconfig(String code);

    public List<CarCarconfig> queryCarCarconfigList(CarCarconfig condition);

    public CarCarconfig getCarCarconfig(String code);

}
