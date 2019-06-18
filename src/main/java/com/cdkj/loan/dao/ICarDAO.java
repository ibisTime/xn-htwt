package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.Car;
import java.util.List;

public interface ICarDAO extends IBaseDAO<Car> {

    String NAMESPACE = ICarDAO.class.getName().concat(".");

    void insertList(List<Car> carList);

    int deleteByCondition(Car data);

    public int update(Car data);

    public int updateUp(Car data);

    public int updateDown(Car data);

}
