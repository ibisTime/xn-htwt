package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarInfoDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarInfo;

//CHECK 。。。 
@Repository("carInfoDAOImpl")
public class CarInfoDAOImpl extends AMybatisTemplate implements ICarInfoDAO {

    @Override
    public int insert(CarInfo data) {
        return super.insert(NAMESPACE.concat("insert_carInfo"), data);
    }

    @Override
    public int delete(CarInfo data) {
        return super.delete(NAMESPACE.concat("delete_carInfo"), data);
    }

    @Override
    public CarInfo select(CarInfo condition) {
        return super.select(NAMESPACE.concat("select_carInfo"), condition,
            CarInfo.class);
    }

    @Override
    public long selectTotalCount(CarInfo condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_carInfo_count"),
            condition);
    }

    @Override
    public List<CarInfo> selectList(CarInfo condition) {
        return super.selectList(NAMESPACE.concat("select_carInfo"), condition,
            CarInfo.class);
    }

    @Override
    public List<CarInfo> selectList(CarInfo condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_carInfo"), start,
            count, condition, CarInfo.class);
    }

    @Override
    public int update(CarInfo data) {
        return super.update(NAMESPACE.concat("update_carInfo"), data);
    }

}
