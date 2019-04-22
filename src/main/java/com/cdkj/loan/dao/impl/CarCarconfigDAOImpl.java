package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarCarconfigDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarCarconfig;

//CHECK 。。。 
@Repository("carCarconfigDAOImpl")
public class CarCarconfigDAOImpl extends AMybatisTemplate implements
        ICarCarconfigDAO {

    @Override
    public int insert(CarCarconfig data) {
        return super.insert(NAMESPACE.concat("insert_carCarconfig"), data);
    }

    @Override
    public int delete(CarCarconfig data) {
        return super.delete(NAMESPACE.concat("delete_carCarconfig"), data);
    }

    @Override
    public CarCarconfig select(CarCarconfig condition) {
        return super.select(NAMESPACE.concat("select_carCarconfig"), condition,
            CarCarconfig.class);
    }

    @Override
    public long selectTotalCount(CarCarconfig condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_carCarconfig_count"), condition);
    }

    @Override
    public List<CarCarconfig> selectList(CarCarconfig condition) {
        return super.selectList(NAMESPACE.concat("select_carCarconfig"),
            condition, CarCarconfig.class);
    }

    @Override
    public List<CarCarconfig> selectList(CarCarconfig condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_carCarconfig"), start,
            count, condition, CarCarconfig.class);
    }

}
