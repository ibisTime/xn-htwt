package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IActionDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Action;

//CHECK 。。。 
@Repository("actionDAOImpl")
public class ActionDAOImpl extends AMybatisTemplate implements IActionDAO {

    @Override
    public int insert(Action data) {
        return super.insert(NAMESPACE.concat("insert_action"), data);
    }

    @Override
    public int delete(Action data) {
        return super.delete(NAMESPACE.concat("delete_action"), data);
    }

    @Override
    public Action select(Action condition) {
        return super.select(NAMESPACE.concat("select_action"), condition,
            Action.class);
    }

    @Override
    public long selectTotalCount(Action condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_action_count"),
            condition);
    }

    @Override
    public List<Action> selectList(Action condition) {
        return super.selectList(NAMESPACE.concat("select_action"), condition,
            Action.class);
    }

    @Override
    public List<Action> selectList(Action condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_action"), start,
            count, condition, Action.class);
    }

}
