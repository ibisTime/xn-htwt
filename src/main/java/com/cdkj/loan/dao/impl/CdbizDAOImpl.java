package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICdbizDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Cdbiz;

//CHECK 。。。 
@Repository("cdbizDAOImpl")
public class CdbizDAOImpl extends AMybatisTemplate implements ICdbizDAO {

    @Override
    public int insert(Cdbiz data) {
        return super.insert(NAMESPACE.concat("insert_cdbiz"), data);
    }

    @Override
    public int delete(Cdbiz data) {
        return super.delete(NAMESPACE.concat("delete_cdbiz"), data);
    }

    @Override
    public Cdbiz select(Cdbiz condition) {
        return super.select(NAMESPACE.concat("select_cdbiz"), condition,
            Cdbiz.class);
    }

    @Override
    public long selectTotalCount(Cdbiz condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_cdbiz_count"),
            condition);
    }

    @Override
    public List<Cdbiz> selectList(Cdbiz condition) {
        return super.selectList(NAMESPACE.concat("select_cdbiz"), condition,
            Cdbiz.class);
    }

    @Override
    public List<Cdbiz> selectList(Cdbiz condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_cdbiz"), start, count,
            condition, Cdbiz.class);
    }

    @Override
    public int updateStatus(Cdbiz data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

}
