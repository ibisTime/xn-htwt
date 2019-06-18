package com.cdkj.loan.bo;

import com.cdkj.loan.bo.base.IPaginableBO;
import com.cdkj.loan.domain.Car;
import java.util.ArrayList;
import java.util.List;

public interface ICarBO extends IPaginableBO<Car> {

    String saveCar(Car data);

    Car getCar(String code);

    int editCar(Car data);

    List<Car> queryCar(Car condition);

    void removeCar(String code);

    Car getCarByModelId(String modelId);

    void removeByCondition(Car condition);

    void saveCarList(ArrayList<Car> carArrayList);
}
