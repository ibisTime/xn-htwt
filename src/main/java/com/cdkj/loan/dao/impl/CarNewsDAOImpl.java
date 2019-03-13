package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarNewsDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.CarNews;

//CHECK 。。。 
@Repository("carNewsDAOImpl")
public class CarNewsDAOImpl extends AMybatisTemplate implements ICarNewsDAO {

    @Override
    public int insert(CarNews data) {
        return super.insert(NAMESPACE.concat("insert_carNews"), data);
    }

    @Override
    public int delete(CarNews data) {
        return super.delete(NAMESPACE.concat("delete_carNews"), data);
    }

    @Override
    public CarNews select(CarNews condition) {
        return super.select(NAMESPACE.concat("select_carNews"), condition,
            CarNews.class);
    }

    @Override
    public long selectTotalCount(CarNews condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_carNews_count"),
            condition);
    }

    @Override
    public List<CarNews> selectList(CarNews condition) {
        return super.selectList(NAMESPACE.concat("select_carNews"), condition,
            CarNews.class);
    }

    @Override
    public List<CarNews> selectList(CarNews condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_carNews"), start,
            count, condition, CarNews.class);
    }

    @Override
    public int updateCarNews(CarNews data) {
        return super.update(NAMESPACE.concat("update_carNews"), data);
    }

    @Override
    public int updateStatus(CarNews data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

    @Override
    public int updateReadCounts(CarNews data) {
        return super.update(NAMESPACE.concat("update_read_count"), data);
    }

}
