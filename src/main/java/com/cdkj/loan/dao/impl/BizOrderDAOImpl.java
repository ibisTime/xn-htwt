package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBizOrderDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BizOrder;

//CHECK 。。。 
@Repository("bizOrderDAOImpl")
public class BizOrderDAOImpl extends AMybatisTemplate implements IBizOrderDAO {

    @Override
    public int insert(BizOrder data) {
        return super.insert(NAMESPACE.concat("insert_bizOrder"), data);
    }

    @Override
    public int delete(BizOrder data) {
        return super.delete(NAMESPACE.concat("delete_bizOrder"), data);
    }

    @Override
    public BizOrder select(BizOrder condition) {
        return super.select(NAMESPACE.concat("select_bizOrder"), condition,
            BizOrder.class);
    }

    @Override
    public long selectTotalCount(BizOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_bizOrder_count"), condition);
    }

    @Override
    public List<BizOrder> selectList(BizOrder condition) {
        return super.selectList(NAMESPACE.concat("select_bizOrder"), condition,
            BizOrder.class);
    }

    @Override
    public List<BizOrder> selectList(BizOrder condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bizOrder"), start,
            count, condition, BizOrder.class);
    }

    @Override
    public int update(BizOrder data) {
        return super.update(NAMESPACE.concat("update_bizOrder"), data);
    }

}
