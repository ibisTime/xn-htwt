package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarPledgeDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarPledge;

@Repository("carPledgeDAOImpl")
public class CarPledgeDAOImpl extends AMybatisTemplate
        implements ICarPledgeDAO {

    @Override
    public int insert(CarPledge data) {
        return super.insert(NAMESPACE.concat("insert_carPledge"), data);
    }

    @Override
    public int delete(CarPledge data) {
        return super.delete(NAMESPACE.concat("delete_carPledge"), data);
    }

    @Override
    public CarPledge select(CarPledge condition) {
        return super.select(NAMESPACE.concat("select_carPledge"), condition,
            CarPledge.class);
    }

    @Override
    public long selectTotalCount(CarPledge condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_carPledge_count"), condition);
    }

    @Override
    public List<CarPledge> selectList(CarPledge condition) {
        return super.selectList(NAMESPACE.concat("select_carPledge"), condition,
            CarPledge.class);
    }

    @Override
    public List<CarPledge> selectList(CarPledge condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_carPledge"), start,
            count, condition, CarPledge.class);
    }

    @Override
    public int update(CarPledge carPledge) {
        return super.update(NAMESPACE.concat("update_carPledge"), carPledge);
    }

    @Override
    public int updateStatus(CarPledge carPledge) {
        return super.update(NAMESPACE.concat("update_carPledgeStatus"),
            carPledge);
    }

}