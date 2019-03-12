package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.ICarconfigDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Carconfig;

//CHECK 。。。 
@Repository("carconfigDAOImpl")
public class CarconfigDAOImpl extends AMybatisTemplate implements ICarconfigDAO {

    @Override
    public int insert(Carconfig data) {
        return super.insert(NAMESPACE.concat("insert_carconfig"), data);
    }

    @Override
    public int delete(Carconfig data) {
        return super.delete(NAMESPACE.concat("delete_carconfig"), data);
    }

    @Override
    public Carconfig select(Carconfig condition) {
        return super.select(NAMESPACE.concat("select_carconfig"), condition,
            Carconfig.class);
    }

    @Override
    public long selectTotalCount(Carconfig condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_carconfig_count"), condition);
    }

    @Override
    public List<Carconfig> selectList(Carconfig condition) {
        return super.selectList(NAMESPACE.concat("select_carconfig"),
            condition, Carconfig.class);
    }

    @Override
    public List<Carconfig> selectList(Carconfig condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_carconfig"), start,
            count, condition, Carconfig.class);
    }

    @Override
    public int updateConfig(Carconfig data) {
        return super.update(NAMESPACE.concat("update_carconfig"), data);
    }

}
